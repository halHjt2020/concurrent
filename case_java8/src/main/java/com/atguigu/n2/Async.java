package com.atguigu.n2;

import com.atguigu.Constants;
import com.atguigu.n2.util.FileReader;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: Async
 * @Description: 异步不等待
 * @Author: hjt
 * @Date: Created in 2020/11/18
 * @Version 1.0
 */
@Slf4j(topic = "c.Async")
public class Async {

    public static void main(String[] args) {
        new Thread(() -> FileReader.read(Constants.MP4_FULL_PATH)).start(); // 异步调用
        log.debug("do other thing ... ");
    }
}
