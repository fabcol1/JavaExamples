package concurrency.volatilexample;

import java.util.concurrent.TimeUnit;

import concurrency.main.VolatileDemo;

public class ReaderRunnable implements Runnable {

	public void run() {
		System.out.println("reader " + VolatileDemo.sharedCounter);
		try {
			TimeUnit.MILLISECONDS.sleep(1200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("reader " + VolatileDemo.sharedCounter);
	}
}
