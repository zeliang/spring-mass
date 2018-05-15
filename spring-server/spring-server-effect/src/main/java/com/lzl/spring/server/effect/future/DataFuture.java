package com.lzl.spring.server.effect.future;

public class DataFuture<T> implements Data<T> {

	private T t;
	private boolean isFinish = false;

	public void setData(T t) {
		this.t = t;
		this.isFinish = true;
		synchronized (this) {
			notify();
		}
	}

	@Override
	public T getData() {
		if (this.isFinish) {
			return t;
		} else {
			while (!this.isFinish) {
				synchronized (this) {
					try {
						wait();
					} catch (InterruptedException e) {
					}
				}
			}
			return getData();
		}
	}

}
