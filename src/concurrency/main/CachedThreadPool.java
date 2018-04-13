package concurrency.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import concurrency.LiftOffRunnable;

public class CachedThreadPool {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < 5; i++) {
			exec.execute(new LiftOffRunnable());
		}
		System.out.println("PRE SHUTDOWN");
		exec.shutdown(); // IMPEDISCE LA CREAZIONE DI NUOVI RUNNABLE DOPO LO SHUTDOWN...
		System.out.println("POST SHUTDOWN");
	}
}