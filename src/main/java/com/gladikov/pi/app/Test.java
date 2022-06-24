package com.gladikov.pi.app;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test implements Runnable{
	public void run() {
        System.out.println("Hello from a thread!");
    }

	public static void main(String[] args) throws UnknownHostException {
			(new Thread(new Test())).start();

	}

}
