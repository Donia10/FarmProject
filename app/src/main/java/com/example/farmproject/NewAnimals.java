package com.example.farmproject;

 class AnimalNew {

    private NewAnimals newAnimals;

     public AnimalNew(NewAnimals newAnimals) {
         this.newAnimals = newAnimals;
     }

     public NewAnimals getNewAnimals() {
        return newAnimals;
    }

    public void setNewAnimals(NewAnimals newAnimals) {
        this.newAnimals = newAnimals;
    }

}
public class NewAnimals {

    private String animalNumber;
    private String animalType;
    private String age;
    private String ageText;
    private String status;
    private String maleNumber;
    private String previousBirth;
    private String firstBirth;
    private String secondBirth;
    private String thirdBirth;
    private String fourthBirth;
    private String fifthBirth;

    public NewAnimals() {
    }

    public NewAnimals(String animalNumber, String animalType, String age, String ageText, String status, String maleNumber, String previousBirth, String firstBirth, String secondBirth, String thirdBirth, String fourthBirth, String fifthBirth) {
        this.animalNumber = animalNumber;
        this.animalType = animalType;
        this.age = age;
        this.ageText = ageText;
        this.status = status;
        this.maleNumber = maleNumber;
        this.previousBirth = previousBirth;
        this.firstBirth = firstBirth;
        this.secondBirth = secondBirth;
        this.thirdBirth = thirdBirth;
        this.fourthBirth = fourthBirth;
        this.fifthBirth = fifthBirth;
    }

    public String getAnimalNumber() {
        return animalNumber;
    }

    public void setAnimalNumber(String animalNumber) {
        this.animalNumber = animalNumber;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAgeText() {
        return ageText;
    }

    public void setAgeText(String ageText) {
        this.ageText = ageText;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMaleNumber() {
        return maleNumber;
    }

    public void setMaleNumber(String maleNumber) {
        this.maleNumber = maleNumber;
    }

    public String getPreviousBirth() {
        return previousBirth;
    }

    public void setPreviousBirth(String previousBirth) {
        this.previousBirth = previousBirth;
    }

    public String getFirstBirth() {
        return firstBirth;
    }

    public void setFirstBirth(String firstBirth) {
        this.firstBirth = firstBirth;
    }

    public String getSecondBirth() {
        return secondBirth;
    }

    public void setSecondBirth(String secondBirth) {
        this.secondBirth = secondBirth;
    }

    public String getThirdBirth() {
        return thirdBirth;
    }

    public void setThirdBirth(String thirdBirth) {
        this.thirdBirth = thirdBirth;
    }

    public String getFourthBirth() {
        return fourthBirth;
    }

    public void setFourthBirth(String fourthBirth) {
        this.fourthBirth = fourthBirth;
    }

    public String getFifthBirth() {
        return fifthBirth;
    }

    public void setFifthBirth(String fifthBirth) {
        this.fifthBirth = fifthBirth;
    }
}
