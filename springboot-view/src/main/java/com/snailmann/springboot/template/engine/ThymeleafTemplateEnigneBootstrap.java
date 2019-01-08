package com.snailmann.springboot.template.engine;

import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

/**
 * Thymeleaf模板引擎引导类
 * 直接跑main方法就可以看到效果
 */
public class ThymeleafTemplateEnigneBootstrap {

    public static void main(String[] args) {
        // 构建引擎
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        // 创建渲染上下文
        Context context = new Context();

        context.setVariable("message","hello，world");

        // 模板的内容
        String content = "<p th:text=\"${message}\">!!!</p>";
        // 渲染(处理)结果
        String result = springTemplateEngine.process(content,context);
        // 输出渲染(处理)结果
        System.out.println(result);
    }
}
