package com.company;

public class Main {

    public static void main(String[] args) {

        Pizza pizza = new Pizza("thicc crust", "tomato", "mozarella", "peperonni");

        System.out.println("Here are the ingredients of your pizza: ");
        System.out.println(pizza.bread);
        System.out.println(pizza.sauce);
        System.out.println(pizza.cheese);
        System.out.println(pizza.topping);

    }
}
