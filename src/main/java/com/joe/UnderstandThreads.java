package main.java.com.joe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class UnderstandThreads implements Runnable {
	
	public static void main(String args[])
	{
		System.out.println("Main Thread");
		Thread t = new Thread(new UnderstandThreads());
		t.start();
		System.out.println("Returned to main thread");
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		Future fut = service.submit(new UnderstandThreads());
		System.out.println("Returned to main thread after executor service");
		service.shutdown();

		try {
		    if (!service.awaitTermination(800, TimeUnit.MILLISECONDS)) {
		    	service.shutdownNow();
		    } 
		} catch (InterruptedException e) {
			service.shutdownNow();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("Hi Thread1");
		
		try {
			Thread.sleep(4000);
			System.out.println("Hi Thread2");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

	
}
