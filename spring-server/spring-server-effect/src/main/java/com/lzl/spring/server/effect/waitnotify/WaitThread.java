package com.lzl.spring.server.effect.waitnotify;

import com.lzl.spring.server.effect.utils.StaticUtils;

public class WaitThread extends Thread {
	private volatile Object lock;

	public WaitThread(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			System.out.println(StaticUtils.getThreadName("waitThread") + "加入等待队列");
			try {
				lock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(StaticUtils.getThreadName("waitThread") + "在做等待后的任务");
			System.out.println(StaticUtils.getThreadName("waitThread") + "在做等待后的任务，.............结束啦");
		}
	}

}
