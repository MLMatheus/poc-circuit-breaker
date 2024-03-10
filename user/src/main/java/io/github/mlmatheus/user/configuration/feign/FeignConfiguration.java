package io.github.mlmatheus.user.configuration.feign;

import feign.Logger;
import feign.RetryableException;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static feign.Logger.Level;

@Configuration
public class FeignConfiguration {

    @Bean
    public Logger logger() {
        return new CustomLogger();
    }

    @Bean
    public Level logLevel() {
        return Level.FULL;
    }
}
