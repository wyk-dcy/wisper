package com.wyk.wisper.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author wuyongkang
 * @date 2021年07月13日 20:51
 */
public class TestSpinLock {
    public static void main(String[] args) throws InterruptedException {
        Spinlock spinlock = new Spinlock();

        new Thread(()->{
            spinlock.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                spinlock.myUnLock();
            }

        },"T1").start();


        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            spinlock.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                spinlock.myUnLock();
            }
        },"T2").start();

    }

}