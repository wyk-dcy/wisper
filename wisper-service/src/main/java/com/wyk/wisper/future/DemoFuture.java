package com.wyk.wisper.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author wuyongkang
 * @date 2021年07月07日 22:04
 */
public class DemoFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("吴永康最帅" + Thread.currentThread());
        });
        System.out.println("00000");
        System.out.println(voidCompletableFuture.get());
    }

    private static void test() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            int i = 10 / 0;
            return 32;
        });
        Integer integer = integerCompletableFuture.whenComplete((t, u) -> {
            System.out.println(t);
            System.out.println(u);

        }).exceptionally((e) -> {
            System.out.println(e.getMessage());
            return 233;
        }).get();
        System.out.println(integer);
    }

}