package com.example.farmproject;

class AnimalPollination {

    private Pllinations pllinations;

    public AnimalPollination(Pllinations pllinations) {
        this.pllinations = pllinations;
    }

    public Pllinations getPllinations() {
        return pllinations;
    }

    public void setPllinations(Pllinations pllinations) {
        this.pllinations = pllinations;
    }

}

public class Pllinations {


    private String pollinationNumber;

    private String result;

    public Pllinations(String pollinationNumber, String result) {
        this.pollinationNumber = pollinationNumber;
        this.result = result;
    }

    public String getPollinationNumber() {
        return pollinationNumber;
    }

    public void setPollinationNumber(String pollinationNumber) {
        this.pollinationNumber = pollinationNumber;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
