package com.project;

public class CurrencyConverter {
    private final ExchangeRate exchangeRate;

    public CurrencyConverter(ExchangeRate exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public double convertMadToEur(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount cannot be negative");
        return amount * exchangeRate.getMadToEurRate();
    }

    public double convertEurToMad(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount cannot be negative");
        return amount * exchangeRate.getEurToMadRate();
    }
}
