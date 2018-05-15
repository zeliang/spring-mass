package com.lzl.spring.server.effect.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadEchoServer {
	private static ExecutorService es = Executors.newFixedThreadPool(1);

	public static class EchoHanderRunnable implements Runnable {

		private Socket socket = null;

		public EchoHanderRunnable(Socket socket) {
			super();
			this.socket = socket;
		}

		@Override
		public void run() {
			BufferedReader br = null;
			try {
				br = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				String line = null;
				while ((line = br.readLine()) != null) {
					System.out.println("Server accept msg:" + line);
				}
			} catch (Exception e) {
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
					}
				}
			}
		}

	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(20000);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		while (true) {
			try {
				Socket socket = server.accept();
				es.submit(new EchoHanderRunnable(socket));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
