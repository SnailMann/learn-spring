package com.snailmann.aop.cglib;

public class Main {

    public static void main(String[] args) {
        ProxyFoodStop proxyFoodStop = new ProxyFoodStop();
        FoodStop foodStop = (FoodStop) proxyFoodStop.createProxyFoodStop(new FoodStop());
        foodStop.sellSomething("apple");
        foodStop.sellFood();
        foodStop.sellJuice();
        FoodStop.sell();


    }
}
