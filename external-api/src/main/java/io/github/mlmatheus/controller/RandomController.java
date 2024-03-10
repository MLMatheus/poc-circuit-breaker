package io.github.mlmatheus.controller;

import io.github.mlmatheus.dto.RandomResponse;
import io.github.mlmatheus.service.RandomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/external-api")
@RequiredArgsConstructor
public class RandomController {

    private final RandomService randomService;

    @GetMapping
    public ResponseEntity<RandomResponse> randomResponse() {
        return new ResponseEntity<>(randomService.gerarStatusCodeAleatorio(), HttpStatus.OK);
    }
}
