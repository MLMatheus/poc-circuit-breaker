package io.github.mlmatheus.user.service;

import io.github.mlmatheus.user.clients.ExternalApiClient;
import io.github.mlmatheus.user.model.User;
import io.github.mlmatheus.user.repository.UserRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    private final ExternalApiClient externalApiClient;

    @CircuitBreaker(name = "externalApiFailure", fallbackMethod = "externalApiFallback")
    public User create(User user) {
        var saveUser = userRepository.save(user);
        var random = externalApiClient.callExternalApi();
        log.info("Salvo com sucesso");

        return user;
    }

    private User externalApiFallback(User user, Throwable throwable) {
        log.info("Enviando para DLQ");

        return user;
    }
}
