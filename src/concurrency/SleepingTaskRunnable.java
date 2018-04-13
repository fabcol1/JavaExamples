package concurrency;

import java.util.concurrent.TimeUnit;

public class SleepingTaskRunnable extends LiftOffRunnable {
	public void run() {
		try {
			while (countDown-- > 0) {
				System.out.print(status());
				
				// Old-style:
				// Thread.sleep(100);
				
				// Java SE5/6-style:
				TimeUnit.MILLISECONDS.sleep(500);
			}
		} catch (InterruptedException e) {
			System.err.println("Interrupted");
		}
	}
}
