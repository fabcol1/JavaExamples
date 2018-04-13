package concurrency.main;

import concurrency.LiftOffRunnable;

public class BasicThreads {
	public static void main(String[] args) {
		Thread t = new Thread(new LiftOffRunnable());
		t.start();
		System.out.println("Waiting for LiftOff");
	}
}