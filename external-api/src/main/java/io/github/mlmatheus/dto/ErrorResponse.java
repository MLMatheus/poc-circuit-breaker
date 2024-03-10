package io.github.mlmatheus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {

    @JsonProperty("path")
    private String path;

    @JsonProperty("error_message")
    private String errorMessage;

    @JsonProperty("http_status")
    private Integer httpStatus;
}
