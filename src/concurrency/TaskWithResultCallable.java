package concurrency;

import java.util.concurrent.Callable;

public class TaskWithResultCallable implements Callable<String> {
	private int id;

	public TaskWithResultCallable(int id) {
		this.id = id;
	}

	public String call() {
		System.out.println("call " + id);
		
		if(id==1) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return "result of TaskWithResult " + id;
	}
}
