package com.snailmann.aop.jdk;

/**
 * 大名鼎鼎的游戏以及工具发售平台Steam
 * 实现了游戏公司和工具公司的接口
 *
 */
public class SteamCompany implements GameConpany,ToolCompany{

    /**
     * 卖游戏，final方法，不可继承
     */
    @Override
    public final void sellGame() {
        System.out.println("sell game");
    }

    /**
     * 卖工具
     */
    @Override
    public void sellTools() {
        System.out.println("sell tools");
    }
}
