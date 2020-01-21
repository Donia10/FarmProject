
package com.example.farmproject;
public class AmountOfMilk {
    private String milkFirstTime;
    private String milkSecondTime;
    private String milkThirdTime;
    private String fatPercentage;
    private String proteinRatio;

    public AmountOfMilk() {
    }

    public AmountOfMilk(String milkFirstTime, String milkSecondTime, String milkThirdTime, String fatPercentage, String proteinRatio) {
        this.milkFirstTime = milkFirstTime;
        this.milkSecondTime = milkSecondTime;
        this.milkThirdTime = milkThirdTime;
        this.fatPercentage = fatPercentage;
        this.proteinRatio = proteinRatio;
    }

    public String getMilkFirstTime() {
        return milkFirstTime;
    }

    public void setMilkFirstTime(String milkFirstTime) {
        this.milkFirstTime = milkFirstTime;
    }

    public String getMilkSecondTime() {
        return milkSecondTime;
    }

    public void setMilkSecondTime(String milkSecondTime) {
        this.milkSecondTime = milkSecondTime;
    }

    public String getMilkThirdTime() {
        return milkThirdTime;
    }

    public void setMilkThirdTime(String milkThirdTime) {
        this.milkThirdTime = milkThirdTime;
    }

    public String getFatPercentage() {
        return fatPercentage;
    }

    public void setFatPercentage(String fatPercentage) {
        this.fatPercentage = fatPercentage;
    }

    public String getProteinRatio() {
        return proteinRatio;
    }

    public void setProteinRatio(String proteinRatio) {
        this.proteinRatio = proteinRatio;
    }

}
 class AmoutOfMilk {

    private AmountOfMilk amountOfMilk;

     public AmoutOfMilk(AmountOfMilk amountOfMilk) {
         this.amountOfMilk = amountOfMilk;
     }

     public AmountOfMilk getAmountOfMilk() {
        return amountOfMilk;
    }

    public void setAmountOfMilk(AmountOfMilk amountOfMilk) {
        this.amountOfMilk = amountOfMilk;
    }

}