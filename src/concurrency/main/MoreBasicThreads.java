package concurrency.main;

import concurrency.LiftOffRunnable;

public class MoreBasicThreads {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(new LiftOffRunnable()).start();
		}
		System.out.println("Waiting for LiftOff");
		
	}
}