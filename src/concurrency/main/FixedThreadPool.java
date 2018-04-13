package concurrency.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import concurrency.LiftOffRunnable;

public class FixedThreadPool {
	
//	With the FixedThreadPool, you do expensive thread allocation once, up front, and you
//	thus limit the number of threads. This saves time because you aren’t constantly paying for
//	thread creation overhead for every single task. 

	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for(int i = 0; i < 5; i++) {
			exec.execute(new LiftOffRunnable());
		}
		exec.shutdown();
	}
}
