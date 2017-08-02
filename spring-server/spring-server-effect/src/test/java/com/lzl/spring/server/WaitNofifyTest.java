package com.lzl.spring.server;

import org.junit.Test;

import com.lzl.spring.server.effect.waitnotify.NotifyMethodThread;
import com.lzl.spring.server.effect.waitnotify.WaitMethodThread;

public class WaitNofifyTest {

	
	@Test
	public void testWaitNot(){
        Object lock = new Object();
        for (int i= 0;i<10;i++) {
        	 WaitMethodThread a = new WaitMethodThread(lock);
        	 a.setName("ThreadA"+i);
             a.start();
		}
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.out.println("开始唤醒------");
        NotifyMethodThread c = new NotifyMethodThread(lock);
        c.start();
	}
}
