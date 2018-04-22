package com.lzl.spring.server.effect.join;

public class JoinTest {

	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		try {
			t.start();
			System.out.println("wait thread-----");
			t.join();
			System.out.println("thread 终止-------");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
