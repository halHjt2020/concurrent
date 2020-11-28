package com.atguigu.n2;

import com.atguigu.Constants;
import com.atguigu.n2.util.FileReader;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: Sync
 * @Description: 同步等待
 * @Author: hjt
 * @Date: Created in 2020/11/18
 * @Version 1.0
 */
@Slf4j(topic = "c.Sync")
public class Sync {

    public static void main(String[] args) {
        FileReader.read(Constants.MP4_FULL_PATH); // 同步调用
        log.debug("do other things...");
    }
}
