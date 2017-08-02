package com.lzl.spring.server.effect.waitnotify;

public class Service {

    public void waitMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName()+" begin wait()");
                lock.wait();
                
                System.out.println(Thread.currentThread().getName()+" end wait() ,begin to do something");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void notifyMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName()+" begin notify()"
                        + System.currentTimeMillis());
                lock.notify();
                System.out.println(Thread.currentThread().getName()+"还没有释放锁");
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName()+" end notify()"
                        + System.currentTimeMillis());
                System.out.println(Thread.currentThread().getName()+" 5秒过后，释放锁");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
