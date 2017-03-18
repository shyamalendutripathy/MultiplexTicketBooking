package main;

import MovieBooking.MovieImpl;
import counter.CounterThread;
import counter.CustomerObj;

public class Execute {


	public static void main(String[] args) {

		MovieImpl impl=new MovieImpl();
		CustomerObj beanObj=new CustomerObj();
		beanObj.setWindowSeat(15);
		beanObj.setTotalSeat(20);

		CounterThread counterthread1=new CounterThread(beanObj, "book", 1);
		beanObj=new CustomerObj();
		beanObj.setWindowSeat(25);
		beanObj.setTotalSeat(45);
		
		counterthread1=new CounterThread(beanObj, "book", 1);
		beanObj=new CustomerObj();
		beanObj.setWindowSeat(10);
		beanObj.setTotalSeat(35);

		CounterThread counterthread2=new CounterThread(beanObj, "book", 1);

		Thread thread= new Thread(counterthread1);
		thread.start();
		
		thread= new Thread(counterthread2);
		thread.start();
		
		thread= new Thread(counterthread1);
		thread.start();
		
	}

}
