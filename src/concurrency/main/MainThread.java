package concurrency.main;

import concurrency.LiftOffRunnable;

public class MainThread {
	public static void main(String[] args) {
		LiftOffRunnable launch = new LiftOffRunnable();
		launch.run();
	}
}
