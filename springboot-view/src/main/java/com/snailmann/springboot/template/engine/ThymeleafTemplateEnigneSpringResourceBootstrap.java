package com.snailmann.springboot.template.engine;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Thymeleaf模板引擎引导类
 * 直接跑main方法就可以看到效果
 *
 * Thymeleaf和Spring资源进行整合的一个小实例
 *
 */
public class ThymeleafTemplateEnigneBootstrap2 {

    public static void main(String[] args) throws IOException {
        // 构建引擎
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        // 创建渲染上下文
        Context context = new Context();

        //读取内容
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:/templates/thymeleaf/hello.html");
        File templeteFile = resource.getFile();
        //文件流
        FileInputStream inputStream = new FileInputStream(templeteFile);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //输入流转换为输出流
        IOUtils.copy(inputStream,outputStream);
        inputStream.close();

        context.setVariable("message","hello，world");
        // 模板的内容
        String content = outputStream.toString("UTF-8");
        // 渲染(处理)结果
        String result = springTemplateEngine.process(content,context);
        // 输出渲染(处理)结果
        System.out.println(result);
    }
}
