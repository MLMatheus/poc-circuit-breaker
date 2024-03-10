package io.github.mlmatheus.user.clients;

import io.github.mlmatheus.user.configuration.feign.FeignConfiguration;
import io.github.mlmatheus.user.dto.RandomResponse;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "external-api", url = "${external-api.url}", configuration = FeignConfiguration.class)
public interface ExternalApiClient {

    @Retry(name = "externalApiRetryer")
    @GetMapping("/external-api")
    public RandomResponse callExternalApi();
}
