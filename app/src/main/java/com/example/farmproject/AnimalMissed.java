package com.example.farmproject;


  public  class AnimalMissed {
        private String missedType;

      public AnimalMissed() {
      }

      public AnimalMissed(String missedType) {
            this.missedType = missedType;
        }

        public String getMissedType() {
            return missedType;
        }

        public void setMissedType(String missedType) {
            this.missedType = missedType;
        }
    }

class animalmissed {
    private AnimalMissed animalMissed;

    public AnimalMissed getAnimalMissed() {
        return animalMissed;
    }

    public void setAnimalmissed(AnimalMissed animalMissed) {
        this.animalMissed = animalMissed;
    }

}


