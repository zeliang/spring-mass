package com.lzl.spring.server.effect.unsafe;

import com.lzl.spring.server.effect.utils.StaticUtils;

public class Main {
	public static void main(String[] args) {
		UserObj user = new UserObj();
		ReadThread r = new ReadThread(user);
		r.start();
		while (true) {
			ChangeThread t = new ChangeThread(user);
			t.start();
			StaticUtils.sleep(500);
			t.stop();
			t.stopThread();
		}
	}
}
