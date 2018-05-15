package com.lzl.spring.server.effect.blockingqueue;

import java.util.concurrent.LinkedBlockingQueue;

public class Main {
	public static void main(String[] args) {
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();

		for (int i = 0; i < 10; i++) {
			Thread p = new Thread(new Productor(queue));
			p.start();
		}

		for (int i = 0; i < 10; i++) {
			Thread c = new Thread(new Conusumer(queue));
			c.start();
		}
		new Thread(new Monitor(queue)).start();
		synchronized (Main.class) {
			try {
				Main.class.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
