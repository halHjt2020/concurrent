package com.atguigu.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: TestRunAndStart2
 * @Description:
 * @Author: hjt
 * @Date: Created in 2020/11/27
 * @Version 1.0
 */
@Slf4j(topic = "c.TestRunAndStart2")
public class TestRunAndStart2 {

    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                log.debug("come in ... ");
                bar();
                log.debug("running ... ");
            }
        };

        t.run();
        log.debug("foo");
    }

    static void bar(){
        log.debug("bar");
    }
}
