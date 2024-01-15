package com.example.demo.model;

import javax.validation.constraints.Pattern;

public class cliente {
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos numéricos")
    private String CPF;
}