package com.atguigu;

/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.concurrent.FutureTask;

/**
 * @ClassName: MyBenchmark
 * @Description:
 * @Author: hjt
 * @Date: Created in 2020/11/20
 * @Version 1.0
 */
@Fork(1)
@BenchmarkMode(Mode.AverageTime) // Benchmark测试模式：统计程序运行的平均时间
@Warmup(iterations = 3) // 热身次数：3次
@Measurement(iterations = 5) // 5轮测试
public class MyBenchmark {

    // 1亿个数 求和
    static int[] ARRAY = new int[1000_000_00];
    static {
        Arrays.fill(ARRAY, 1);
    }

    @Benchmark
    public int c() throws Exception{
        int[] array = ARRAY;
        // 4个线程，每个线程计算2500,0000个数
        FutureTask<Integer> t1 = new FutureTask<Integer>(() -> {
            int sum = 0;
            for (int i = 0; i < 250_000_00; i++) {
                sum += array[0+i];
            }
            return sum;
        });

        FutureTask<Integer> t2 = new FutureTask<>(()->{
            int sum = 0;
            for(int i = 0; i < 250_000_00;i++) {
                sum += array[250_000_00+i];
            }
            return sum;
        });

        FutureTask<Integer> t3 = new FutureTask<>(()->{
            int sum = 0;
            for(int i = 0; i < 250_000_00;i++) {
                sum += array[500_000_00+i];
            }
            return sum;
        });

        FutureTask<Integer> t4 = new FutureTask<>(()->{
            int sum = 0;
            for(int i = 0; i < 250_000_00;i++) {
                sum += array[750_000_00+i];
            }
            return sum;
        });

        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
        new Thread(t4).start();

        return t1.get() + t2.get() + t3.get() + t4.get();
    }

    // 一个线程计算 1亿 个数
    @Benchmark
    public int d() throws Exception {
        int[] array = ARRAY;
        FutureTask<Integer> t1 = new FutureTask<>(()->{
            int sum = 0;
            for(int i = 0; i < 1000_000_00;i++) {
                sum += array[0+i];
            }
            return sum;
        });
        new Thread(t1).start();
        return t1.get();
    }
}
