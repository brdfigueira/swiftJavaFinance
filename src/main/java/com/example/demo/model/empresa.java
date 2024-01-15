package main.java.com.example.demo.model;

import javax.validation.constraints.Pattern;

public class empresa {
    @Pattern(regexp = "\\d{14}", message = "CNPJ deve conter 14 dígitos numéricos")
    private String CNPJ;
    private double saldo;
    private double taxa;

    // Construtor, getters, setters, etc.

    public void depositar(double valor) {
        this.saldo += valor;
        aplicarTaxa();
    }

    public void sacar(double valor) {
        this.saldo -= valor;
        aplicarTaxa();
    }

    private void aplicarTaxa() {
        this.saldo -= this.taxa;
    }
}
