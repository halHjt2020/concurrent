package com.atguigu.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: TestYield
 * @Description:
 * @Author: hjt
 * @Date: Created in 2020/11/28
 * @Version 1.0
 */
@Slf4j(topic = "c.Test9")
public class TestYield {

    public static void main(String[] args) {
        Runnable task1 = () -> {
            int count = 0;
            for (;;) {
                System.out.println("---->1 " + count++);
            }
        };

        Runnable task2 = () -> {
            int count = 0;
            for (;;){
                Thread.yield();
                System.out.println("           ---->2 " + count++);
            }
        };

        Thread t1 = new Thread(task1,"t1");
        Thread t2 = new Thread(task2, "t2");

//        t1.setPriority(Thread.MIN_PRIORITY);
//        t1.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }
}
