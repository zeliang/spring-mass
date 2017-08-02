package com.lzl.spring.server.effect.waitnotify;

public class NotifyMethodThread extends Thread {
    private Object lock;

    public NotifyMethodThread(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.notifyMethod(lock);
    }
}