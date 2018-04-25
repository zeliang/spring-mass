package com.lzl.spring.server.effect.utils;

import java.util.Random;

public class StaticUtils {

	public static void sleep(int seed) {
		Random ran = new Random();
		try {
			Thread.sleep(ran.nextInt(seed));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void sleepFix(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String getThreadName(String tag) {
		return tag + ":" + Thread.currentThread().toString();
	}
}
