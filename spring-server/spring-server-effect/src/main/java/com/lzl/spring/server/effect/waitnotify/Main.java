package com.lzl.spring.server.effect.waitnotify;

public class Main {

	public static void main(String[] args) {
		Object lock = new Object();
		WaitThread wt = new WaitThread(lock);
		wt.start();
		NotifyThread nt = new NotifyThread(lock);
		nt.start();
	}
}
