package com.wyk.wisper.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wuyongkang
 * @date 2021年07月13日 20:45
 */
public class Spinlock {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"==》myLock");
        while(!atomicReference.compareAndSet(null,thread));

    }
    public void myUnLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"==》myUnLock");
        while(atomicReference.compareAndSet(thread,null));

    }
}