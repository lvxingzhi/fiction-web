package com.note.fictionweb;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by Administrator on 2017/2/8.
 */
public class MainTest {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
        context.start();
        TestAction testAction = (TestAction) context.getBean("testAction");
        testAction.test();
        System.in.read(); // 按任意键退出
    }
}
