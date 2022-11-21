package com.driver;

import java.net.SocketOption;
import java.net.SocketTimeoutException;
import java.sql.SQLOutput;

public class Pizza {

    private int price;
    int basePrice;
    private Boolean isVeg;
    private Boolean extraCheese;
    private Boolean extraToppings;
    private String bill;
    private int count = 0;
    private Boolean takeAway;


    public Pizza(Boolean isVeg){
        this.isVeg = isVeg;
        // your code goes here

        this.extraCheese=false;
        this.extraToppings=false;
        if(isVeg)
            this.price=300;
        else
            this.price=400;
        basePrice=price;
        takeAway = false;
    }

    public int getPrice(){
        return this.price;
    }

    public void addExtraCheese(){
        // your code goes here
        if(!extraCheese)
        {
            this.price += 80;
            extraCheese = true;
        }
    }

    public void addExtraToppings(){
        // your code goes here
        if(!extraToppings)
        {
            if(isVeg)
                this.price += 70;
            else
                this.price += 120;

            extraToppings = true;
        }
    }

    public void addTakeaway(){
        // your code goes here
        count++;
        this.price += 20;
        takeAway=true;
    }

    public void deluxPizza()
    {
        this.price += 80;
        if(isVeg)
            this.price += 70;
        else
            this.price += 120;
        basePrice = price;
    }
    public String getBill(){
        // your code goes here
        billStatement();
        bill = "Total Price :"+this.price;
        return this.bill;
    }

    private void billStatement()
    {
        System.out.println("Base Price of The Pizza: "+this.basePrice);
        if(extraCheese)
            System.out.println("Extra Cheese Added: "+80);
        if(extraToppings) {
            if (isVeg)
                System.out.println("Extra Toppings Added: " + 70);
            else
                System.out.println("Extra Toppings Added: " + 120);
        }
        if(takeAway)
            System.out.println("Paperbag added: "+count*20);

    }
}
