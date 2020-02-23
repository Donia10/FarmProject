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

    public NewAnimals(String animalNumber, String animalType, String age, String ageText, String status1, String status2, String status3) {
        this.animalNumber = animalNumber;
        this.animalType = animalType;
        this.age = age;
        this.ageText = ageText;
        this.status1 = status1;
        this.status2 = status2;
        this.status3 = status3;
    }

    private String animalNumber;

    private String animalType;

    private String age;

    private String ageText;

    private String status1;

    private String status2;

    private String status3;

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

    public String getStatus1() { return status1; }

    public void setStatus1(String status1) { this.status1 = status1; }

    public String getStatus2() { return status2; }

    public void setStatus2(String status2) { this.status2 = status2; }

    public String getStatus3() { return status3;}

    public void setStatus3(String status3) { this.status3 = status3;}

}
