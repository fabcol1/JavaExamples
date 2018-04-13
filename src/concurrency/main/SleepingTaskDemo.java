package concurrency.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import concurrency.SleepingTaskRunnable;

public class SleepingTaskDemo {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < 5; i++) {
			exec.execute(new SleepingTaskRunnable());
		}
		exec.shutdown();
	}
}
