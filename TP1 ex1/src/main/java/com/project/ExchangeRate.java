package com.project;

public class ExchangeRate {
    private double madToEurRate = 0.09;
    private double eurToMadRate = 11.11;

    public double getMadToEurRate() { return madToEurRate; }
    public double getEurToMadRate() { return eurToMadRate; }

    public void setMadToEurRate(double rate) {
        if (rate <= 0) throw new IllegalArgumentException("Rate must be positive");
        this.madToEurRate = rate;
    }
}
