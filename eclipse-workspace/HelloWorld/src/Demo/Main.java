package Demo;

import java.util.concurrent.CountDownLatch;

class MyThread extends Thread {
	private final CountDownLatch latch;

	public MyThread(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(1000);
			System.out.println("current thread name :" + Thread.currentThread().getName());
			latch.countDown();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

public class Main {

	public static void main(String[] args) throws InterruptedException {

		CountDownLatch latch = new CountDownLatch(3);

		for(int i=0; i<3; i++)
		{
			MyThread thread = new MyThread(latch);
			thread.start();
			
		}

		latch.await();
		System.out.println("All tasks are completed");

	}

}
