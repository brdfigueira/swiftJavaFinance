package com.example.demo.model;

import javax.validation.constraints.Pattern;

public class empresa {
    @Pattern(regexp = "\\d{14}", message = "CNPJ deve conter 14 dígitos numéricos")
    private String CNPJ;
}