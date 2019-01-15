package com.snailmann.aop.cglib;

/**
 * 食品店
 */
public class FoodStop {

    public static void hello(){
        System.out.println("hello");
    }
    /**
     * 卖食物,final类，不可被继承
     */
    public final void sellFood(){
        System.out.println("selling food");
    }

    /**
     * 卖果汁
     */
    public void sellJuice(){
        System.out.println("selling juice");
    }

    /**
     * 卖某物
     * @param something
     */
    public void sellSomething(String something){
    }


}
