package io.github.mlmatheus.service;

import io.github.mlmatheus.dto.RandomResponse;
import io.github.mlmatheus.exception.ErrorException;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomService {

    public RandomResponse gerarStatusCodeAleatorio() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(0, 100);

        if (numeroAleatorio < 100
                && numeroAleatorio >= 40) {
            throw new ErrorException("Serviço indisponível");
        }

        return buildResponse();
    }

    private RandomResponse buildResponse() {
        return RandomResponse.builder()
                .disponivel(true)
                .build();
    }
}
