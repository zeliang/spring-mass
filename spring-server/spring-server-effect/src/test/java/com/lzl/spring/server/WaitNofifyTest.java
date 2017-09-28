package com.lzl.spring.server;

import org.junit.Test;

import com.lzl.spring.server.effect.waitnotify.NotifyMethodThread;

public class WaitNofifyTest {

	@Test
	public void testWaitNot() {
		Object lock = new Object();
		for (int i = 0; i < 10; i++) {
			System.out.println("开始唤醒------");
			NotifyMethodThread c = new NotifyMethodThread(lock);
			c.start();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
