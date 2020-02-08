package com.example.farmproject;

public class missedAnimal_jason {

    private MissedAnimal missedAnimal;

    public missedAnimal_jason(MissedAnimal missedAnimal) { this.missedAnimal = missedAnimal; }



        public MissedAnimal getMissedAnimal() { return missedAnimal;}

        public void setMissedAnimal(MissedAnimal missedAnimal) { this.missedAnimal = missedAnimal;}


    public class MissedAnimal {

        private String missedType;

        public String getMissedType() { return missedType; }

        public void setMissedType(String missedType) { this.missedType = missedType;}

    }
}
