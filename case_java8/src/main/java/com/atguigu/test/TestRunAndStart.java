package com.atguigu.test;

import com.atguigu.Constants;
import com.atguigu.n2.util.FileReader;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: Test4
 * @Description: 启动线程如果用run方法
 * @Author: hjt
 * @Date: Created in 2020/11/27
 * @Version 1.0
 */
@Slf4j(topic = "c.TestRunAndStart")
public class TestRunAndStart {

    public static void main(String[] args) {
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                log.debug(" running ...... ");
                FileReader.read(Constants.MP4_FULL_PATH);
            }
        };

        t1.run();
        //t1.start();
    }
}
