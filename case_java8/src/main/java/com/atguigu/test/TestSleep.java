package com.atguigu.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: TestSleep
 * @Description: 模拟睡眠线程被唤醒的过程（中途用interrupt打断）
 * @Author: hjt
 * @Date: Created in 2020/11/27
 * @Version 1.0
 */
@Slf4j(topic = "c.TestSleep")
public class TestSleep {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                log.debug("enter sleep ... ");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    log.debug("wake up...");
                    e.printStackTrace();
                }
            }
        };

        t1.start();

        // sleep方法写在哪个线程中，就是让哪个线程睡几秒
        TimeUnit.SECONDS.sleep(1);
        log.debug("interrupt...");
        t1.interrupt();
    }

}
