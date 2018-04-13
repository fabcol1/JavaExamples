package concurrency.volatilexample;

import java.util.concurrent.TimeUnit;

import concurrency.main.VolatileDemo;

public class CounterRunnable implements Runnable {

	public void run() {
		// Thread1 increment count of the sharedObject
		while(VolatileDemo.sharedCounter++ < 5) {
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("counter " + VolatileDemo.sharedCounter);
	}

}
