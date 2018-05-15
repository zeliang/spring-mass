package com.lzl.spring.server.effect.future;


public class Main {

	public static void main(String[] args) {
		Driver<String> driver = new Driver<String>();
		Data<String> result = driver.submit("参数");
		String result1 = result.getData();
		System.out.println(result1);
	}
}
