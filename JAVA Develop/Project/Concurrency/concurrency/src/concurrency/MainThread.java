package concurrency;

import java.util.concurrent.Executor;

public class MainThread {
	public static void main(String[] args) {
		LiftOff lauch = new LiftOff();
		LiftOff lauch2 = new LiftOff();
		new Thread(lauch).start();
		new Thread(lauch2).start();
		
	}
}
