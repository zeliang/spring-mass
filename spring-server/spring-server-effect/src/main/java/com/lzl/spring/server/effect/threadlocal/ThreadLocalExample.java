package com.lzl.spring.server.effect.threadlocal;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadLocalExample {

	private static ExecutorService es = Executors.newFixedThreadPool(20);

	public static class MyCallable implements Callable<String> {

		private ThreadLocal<String> threadLocal = new ThreadLocal<String>() {

			@Override
			protected String initialValue() {
				return "default";
			}
		};

		@Override
		public String call() {
			String def = threadLocal.get();
			System.out.println("所有线程默认值->" + def);
			Integer bb = null;
			BlockingQueue bbc = null;
			threadLocal.set(Thread.currentThread() + "-name");
			String key = threadLocal.get();
			System.out.println(key);
			return key;
		}
	}

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		MyCallable task = new MyCallable();
		for (int i = 0; i < 20; i++) {
			Future<String> f = es.submit(task);
		}
	}
}
