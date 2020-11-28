package com.atguigu.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName: Test2
 * @Description:
 * @Author: hjt
 * @Date: Created in 2020/11/20
 * @Version 1.0
 */
@Slf4j(topic = "c.Test2")
public class Test2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.debug("running ... ");
                Thread.sleep(2000);
                return 100;
            }
        });

        Thread t1 = new Thread(task, "t1");
        t1.start();

        log.debug("结果是:{}", task.get()); // "{}" 表示占位符，来自于后边方法的第二个参数，有多个参数就有多个占位符
    }
}
