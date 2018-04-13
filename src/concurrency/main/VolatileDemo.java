package concurrency.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import concurrency.volatilexample.CounterRunnable;
import concurrency.volatilexample.ReaderRunnable;

public class VolatileDemo {
	
	// ESEMPIO NON CHIARO ....

	public static volatile int sharedCounter = 0;

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		
		exec.execute(new CounterRunnable());
		exec.execute(new ReaderRunnable());
		
		exec.shutdown();
		
	}
}
