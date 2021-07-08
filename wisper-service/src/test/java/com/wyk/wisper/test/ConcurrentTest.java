package com.wyk.wisper.test;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @author wuyongkang
 * @date 2021年07月08日 9:14
 */
public class ConcurrentTest {
    @Test
    public void test() throws InterruptedException {
        LinkedBlockingDeque<Object> deque = new LinkedBlockingDeque<>();
        deque.put(null);


    }

    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<String> deque = new LinkedBlockingDeque<String>(4);

        deque.addFirst("1");
        deque.addFirst("2");
        deque.addFirst("3");
        deque.addFirst("4");
        System.out.println("dwrwrf");
        deque.offerFirst("5",3, TimeUnit.SECONDS);
        System.out.println("dwrwrf");
        System.out.println(Arrays.toString(deque.toArray()));

    }
}