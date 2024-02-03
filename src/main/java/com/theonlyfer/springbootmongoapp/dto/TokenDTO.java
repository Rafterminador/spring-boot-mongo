package com.theonlyfer.springbootmongoapp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenDTO {
    private String token;
}
