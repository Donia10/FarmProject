package com.example.farmproject;

import java.util.List;

public class BabyAnimal_Json {
    public BabyAnimal_Json(String toString) {
    }                  //jason baby animal class

    public class Baby {            // type of baby

        private String type1;

        public Baby(String type1) {
            this.type1 = type1;
        }

        public String getType() {
            return type1;
        }

        public void setType(String type) {
            this.type1 = type;
        }

    }


    public class BabyAnimal {


        private NewBabyAnimal newBabyAnimal;

        public BabyAnimal(NewBabyAnimal newBabyAnimal) {
            this.newBabyAnimal = newBabyAnimal;
        }

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

        public NewBabyAnimal(String birthDay, String fatherId, String motherId, String babyId, List<Operation> operation, List<Baby> baby) {
            this.birthDay = birthDay;
            this.fatherId = fatherId;
            this.motherId = motherId;
            this.babyId = babyId;
            this.operation = operation;
            this.baby = baby;
        }

        private String motherId;

        private String babyId;

        private List<Operation> operation = null;

        private List<Baby> baby = null;

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

        public List<Operation> getOperation() {
            return operation;
        }

        public void setOperation(List<Operation> operation) {
            this.operation = operation;
        }

        public List<Baby> getBaby() {
            return baby;
        }

        public void setBaby(List<Baby> baby) {
            this.baby = baby;
        }

    }


    public class Operation {                // type of operation


        private String type2;

        public String getType() {
            return type2;
        }

        public Operation(String type2) {
            this.type2 = type2;
        }

        public void setType(String type) {
            this.type2 = type;
        }

    }

}

