package com.atguigu.n3;

/**
 * @ClassName: TestFrames
 * @Description:
 * @Author: hjt
 * @Date: Created in 2020/11/20
 * @Version 1.0
 */
public class TestFrames {
    public static void main(String[] args) {// 主线程
        Thread t1 = new Thread(){ // t1线程
            @Override
            public void run() {
                method1(20);
            }
        };
        t1.setName("t1");
        t1.start();
        method1(10);
    }

    private static void method1(int x) {
        int y = x + 1;
        Object m = method2();
        System.out.println(m);
    }

    private static Object method2() {
        Object n = new Object();
        return n;
    }
}
