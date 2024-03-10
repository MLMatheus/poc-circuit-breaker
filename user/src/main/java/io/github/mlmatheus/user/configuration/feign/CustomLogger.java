package io.github.mlmatheus.user.configuration.feign;

import feign.Logger;
import feign.Request;
import feign.Response;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static java.lang.String.*;

@Slf4j
public class CustomLogger extends Logger {

    @Override
    protected void logRequest(String configKey, Level logLevel, Request request) {
        var methodName = methodTag(configKey);
        String format = "%s %s";
        log(format, "", methodName, request.httpMethod().name());
    }

    @Override
    protected Response logAndRebufferResponse(String configKey, Level logLevel, Response response, long elapsedTime) throws IOException {
        var methodName = methodTag(configKey);
        log.info(format("HTTP/1.1 %d %s (%dms)", response.status(), methodName, elapsedTime));

        return response;
    }

    @Override
    protected void logRetry(String configKey, Level logLevel) {
        var methodName = methodTag(configKey);
        log.info(format("%s Tentando chamada a API", methodName));
    }

    @Override
    protected void log(String s, String s1, Object... objects) {
        log.info(format(s, objects));
    }
}
