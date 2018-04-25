package com.lzl.spring.server.effect.unsafe;

import com.lzl.spring.server.effect.utils.StaticUtils;

public class ChangeThread extends Thread {

	private UserObj userObj;
	private boolean isStop = true;

	public ChangeThread(UserObj userObj) {
		super();
		this.userObj = userObj;
	}

	@Override
	public void run() {
		while (isStop) {
			synchronized (userObj) {
				System.out.println("change:" + userObj);
				long cur = System.currentTimeMillis();
				userObj.setId(cur + "");
				StaticUtils.sleep(1000);
				userObj.setUsername(cur + "");
			}
		}
	}

	public void stopThread() {
		this.isStop = false;
	}

}
