package com.atguigu.synchronizedtest;

// 新建类实现runnable接口
//class MyThread implements Runnable{
//
//    @Override
//    public void run() {
//        System.out.println("Runnable...");
//    }
//}

import java.util.concurrent.locks.ReentrantLock;

// 卖票类 - 资源类
class SaleTicket{

    // 声明一些火车票/飞机票
    private int number = 30;

    private final ReentrantLock lock = new ReentrantLock();

    // 编写卖票的方法 --- 加了synchronized 变成同步方法
    public void sale(){
        // Object --- 所有的线程都使用同一把锁，指Object类的字节码文件！
        //synchronized(this){

        // 上锁
        lock.lock();
        try {
            // 业务逻辑判断
            if(number > 0){
                // 可以卖票
                System.out.println(Thread.currentThread().getName() +"卖出第："+(--number)+"票，还剩：、\t" +number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 解锁
            lock.unlock();
        }
    }
}

/**
 * @ClassName: SaleTicket
 * @Description:
 * @Author: hjt
 * @Date: Created in 2020/11/19
 * @Version 1.0
 */
public class TestSaleTicket {

    // 测试
    public static void main(String[] args) {

        SaleTicket saleTicket = new SaleTicket();

        // 1、线程操作资源类：创建线程有几种方式？
        // 2、Thread
//        Thread thread = new Thread(new MyThread());
//        thread.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 开始卖票
                for (int i = 1; i <= 30; i++) {
                    saleTicket.sale();
                }
            }
        },"AA").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 开始卖票
                for (int i = 1; i <= 30; i++) {
                    saleTicket.sale();
                }
            }
        },"BB").start();
    }
}
