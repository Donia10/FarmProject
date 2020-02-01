package com.example.farmproject;
public class Fortification {
    private Fortification_ fortification;

    public Fortification_ getFortification() {
        return fortification;
    }

    public void setFortification(Fortification_ fortification) {
        this.fortification = fortification;
    }

}
 class Fortification_ {
    private String typeFortification;
    private String dateOfNextDose;

     public Fortification_(String typeFortification, String dateOfNextDose) {
         this.typeFortification = typeFortification;
         this.dateOfNextDose = dateOfNextDose;
     }

     public String getTypeFortification() {
        return typeFortification;
    }

    public void setTypeFortification(String typeFortification) {
        this.typeFortification = typeFortification;
    }

    public String getDateOfNextDose() {
        return dateOfNextDose;
    }

    public void setDateOfNextDose(String dateOfNextDose) {
        this.dateOfNextDose = dateOfNextDose;
    }

}