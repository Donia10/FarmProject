package com.example.farmproject;

public class Fortification {
    private String typeOfFortification;
    private String dateOfNextDose;

    public String getTypeOfFortification() {
        return typeOfFortification;
    }

    public void setTypeOfFortification(String typeOfFortification) {
        this.typeOfFortification = typeOfFortification;
    }

    public String getDateOfNextDose() {
        return dateOfNextDose;
    }

    public void setDateOfNextDose(String dateOfNextDose) {
        this.dateOfNextDose = dateOfNextDose;
    }

    public Fortification() {
    }

    public Fortification(String typeOfFortification, String dateOfNextDose) {
        this.typeOfFortification = typeOfFortification;
        this.dateOfNextDose = dateOfNextDose;
    }

}
class forti{
    private Fortification fortification;

    public Fortification getFortification() {
        return fortification;
    }

    public void setFortification(Fortification fortification) {
        this.fortification = fortification;
    }

    public forti(Fortification fortification) {
        this.fortification = fortification;
    }
}