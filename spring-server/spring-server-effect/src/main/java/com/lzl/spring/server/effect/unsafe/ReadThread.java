package com.lzl.spring.server.effect.unsafe;

import com.lzl.spring.server.effect.utils.StaticUtils;

public class ReadThread extends Thread {

	private UserObj userObj;

	@Override
	public void run() {
		while (true) {
			synchronized (userObj) {
				System.out.println("read:" + userObj);
				StaticUtils.sleep(50);
				if (!userObj.getId().equals(userObj.getUsername())) {
					System.out.println("不同的：" + userObj);
				}
			}
		}
	}

	public ReadThread(UserObj userObj) {
		super();
		this.userObj = userObj;
	}

}
