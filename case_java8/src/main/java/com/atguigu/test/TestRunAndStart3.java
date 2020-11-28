package com.atguigu.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: TestRunAndStart3
 * @Description:
 * @Author: hjt
 * @Date: Created in 2020/11/27
 * @Version 1.0
 */
@Slf4j(topic = "c.TestRunAndStart3")
public class TestRunAndStart3 {

    public static void main(String[] args) {
        Thread t = new Thread("t"){
            @Override
            public void run() {
                log.debug("running ... ");
            }
        };

        System.out.println(t.getState());
        t.start();
        t.start();
        System.out.println(t.getState());
    }
}
