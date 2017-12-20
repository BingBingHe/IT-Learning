package concurrency;

import java.nio.channels.DatagramChannel;
import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread() + " " + this );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	public static void main(String[] args) throws InterruptedException {
		for(int i = 0; i < 10; i++){
			Thread daemon = new Thread(new SimpleDaemons());
			daemon.setDaemon(true);
			daemon.start();
		}
		
		System.out.println("All daemons started");
		TimeUnit.MILLISECONDS.sleep(170);
	}
}
