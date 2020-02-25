package com.example.farmproject;

 class All {

    private NewBabyAnimal newBabyAnimal;

    public NewBabyAnimal getNewBabyAnimal() {
        return newBabyAnimal;
    }

    public void setNewBabyAnimal(NewBabyAnimal newBabyAnimal) {
        this.newBabyAnimal = newBabyAnimal;
    }

}

public class NewBabyAnimal {

    private String birthDay;
    private String fatherId;
    private String motherId;
    private String babyId;
    private String typeOperation;
    private String typeOfBaby;
    private String babyWeight;

    public NewBabyAnimal() {
    }

    public NewBabyAnimal(String birthDay, String fatherId, String motherId, String babyId, String typeOperation, String typeOfBaby, String babyWeight) {
        this.birthDay = birthDay;
        this.fatherId = fatherId;
        this.motherId = motherId;
        this.babyId = babyId;
        this.typeOperation = typeOperation;
        this.typeOfBaby = typeOfBaby;
        this.babyWeight = babyWeight;
    }


    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getFatherId() {
        return fatherId;
    }

    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }

    public String getMotherId() {
        return motherId;
    }

    public void setMotherId(String motherId) {
        this.motherId = motherId;
    }

    public String getBabyId() {
        return babyId;
    }

    public void setBabyId(String babyId) {
        this.babyId = babyId;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    public String getTypeOfBaby() {
        return typeOfBaby;
    }

    public void setTypeOfBaby(String typeOfBaby) {
        this.typeOfBaby = typeOfBaby;
    }

    public String getBabyWeight() {
        return babyWeight;
    }

    public void setBabyWeight(String babyWeight) {
        this.babyWeight = babyWeight;
    }

}