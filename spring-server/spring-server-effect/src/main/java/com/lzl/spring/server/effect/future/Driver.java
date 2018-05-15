package com.lzl.spring.server.effect.future;

import com.lzl.spring.server.effect.utils.StaticUtils;

public class Driver<T> {

	public Data<T> submit(final T params) {
		final DataFuture<T> f = new DataFuture<T>();
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("执行任务");
				StaticUtils.sleepFix(10000);
				System.out.println("执行任务完成");
				f.setData(params);
			}
		});
		t.start();
		return f;
	}
}
