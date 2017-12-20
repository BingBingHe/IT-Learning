package concurrency;

import java.util.concurrent.TimeUnit;

class ADaemon implements Runnable {
	public void run() {
		System.out.println("Starting ADaemon");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("This should always run ? ");
		}
		
	}
}

public class DaemonDontRunFinally {
	public static void main(String[] args) {
		Thread t = new Thread(new ADaemon());
		t.setDaemon(true);
		t.start();
	}
}
