package com.snailmann.aop.jdk;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        ProxyCompany proxyCompany = new ProxyCompany();
        //因为JDK动态代理是基于接口的，如果一个要代理的目标对象有多个接口，强转是需要人为的转为想要的接口
        GameConpany gameConpany = (GameConpany) proxyCompany.createProxyCompany(new SteamCompany());
        ToolCompany toolCompany = (ToolCompany) proxyCompany.createProxyCompany(new SteamCompany());
        gameConpany.sellGame();
        toolCompany.sellTools();
        

    }

}

