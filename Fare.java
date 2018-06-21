package com.java.Zensar.HBMS;

public class Fare {
    static int deluxRate = 1000, luxuryRate = 1500, PartyHallRate=500, lunchbill=150,

    breakfastbill=80,dinnerbill=180,drinksbill=70,totalbill=0;

    int deluxFare=0, luxuryFare=0, hallFare=0, foodFare=0;

    int calculateDeluxFare(int days, int rooms) {
         deluxFare=deluxRate * days * rooms;
        return deluxFare;
    }

    int calculateLuxuryFare(int days, int rooms) {
        luxuryFare=luxuryRate * days * rooms;
        return luxuryFare;

    }
    
    int calculatePartyHallFare(int hours) {
        hallFare=PartyHallRate * hours;
        return hallFare;
    }
        

    public int calculateFood(int quantity, int price) {
        foodFare=quantity*price;
        return foodFare;
    }

    public int calculateTotalFare()
    {
    totalbill=deluxFare+luxuryFare+hallFare+foodFare;
    return totalbill;
    }

}
