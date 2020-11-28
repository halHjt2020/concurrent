package com.atguigu.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: Test1
 * @Description:
 * @Author: hjt
 * @Date: Created in 2020/11/20
 * @Version 1.0
 */
@Slf4j(topic = "c.Test1")
public class Test1 {
    public static void main(String[] args) {
        test2();
    }

    private static void test2(){

        Runnable runnable = () -> {
            log.debug("running ... ");
        };

        Thread t = new Thread(runnable);

        t.start();
    }

    private static void test1(){

        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
            }
        };

        thread.start();
    }
}
