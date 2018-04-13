package concurrency.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import concurrency.SimplePrioritiesRunnable;

public class SimplePrioritiesDemo {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new SimplePrioritiesRunnable(Thread.MIN_PRIORITY));
		}
		exec.execute(new SimplePrioritiesRunnable(Thread.MAX_PRIORITY));
		exec.shutdown();
	}
}
