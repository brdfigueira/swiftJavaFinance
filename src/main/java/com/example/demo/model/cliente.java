package main.java.com.example.demo.model;

import javax.validation.constraints.Pattern;

public class cliente {
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos numéricos")
    private String CPF;
    private double saldo;

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void sacar(double valor) {
        this.saldo -= valor;
    }
}
