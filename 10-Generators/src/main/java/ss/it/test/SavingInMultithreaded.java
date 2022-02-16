package ss.it.test;

import ss.it.thread.MultiThread;

public class SavingInMultithreaded {
	public static void main(String[] args) {
		System.out.println("from Multi thread Environment");
		MultiThread mt = new MultiThread();
		Thread th1 = new Thread(mt);
		th1.run();
		Thread th2 = new Thread(mt);
		th2.run();
		Thread th3 = new Thread(mt);
		th3.run();
	}// main
}// class
