package com.lzl.spring.server.effect.blockingqueue;

import java.util.concurrent.*;

public class Main {
	public static void main(String[] args) {
		ExecutorService es= new ThreadPoolExecutor(2, 2,
				0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>(3), new RejectedExecutionHandler() {
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				if (!executor.isShutdown()) {
					try {
						executor.getQueue().put(r);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		for (int i = 0; i < 10; i++) {
			es.submit(new MyRunnable(i));
		}
	}

	public static class MyRunnable implements Runnable{

		private int i;

		public MyRunnable(int i) {
			this.i = i;
		}

		public void run() {
			try {
				System.out.println(i+" is running");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
