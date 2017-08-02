package com.lzl.spring.server.effect.waitnotify;

public class WaitMethodThread extends Thread {
    private Object lock;

    public WaitMethodThread(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.waitMethod(lock);
    }
}

