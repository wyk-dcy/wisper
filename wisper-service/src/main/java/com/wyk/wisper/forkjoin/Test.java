package com.wyk.wisper.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @author wuyongkang
 * @date 2021年07月06日 22:59
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        test1();
        test2();
        test3();
    }

    public static void test1() {
        long sum = 0L;
        long l = System.currentTimeMillis();
        for (long i = 1L; i <= 1000000000L; i++) {
            sum = sum + i;
        }
        long l1 = System.currentTimeMillis();
        System.out.println(sum+"       "+(l1-l));
    }

    public static void test2() throws ExecutionException, InterruptedException {
        long l = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> forkJoinDemo = new ForkJoinDemo(0L, 1000000000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(forkJoinDemo);
        Long aLong = submit.get();
        long pp = System.currentTimeMillis();
        System.out.println(aLong + "        " + (pp - l));

    }
    public static void test3(){
        long l = System.currentTimeMillis();
        long reduce = LongStream.rangeClosed(0L, 1000000000L).parallel().reduce(0, Long::sum);
        long pp = System.currentTimeMillis();
        System.out.println(reduce + "        " + (pp - l));

    }


}