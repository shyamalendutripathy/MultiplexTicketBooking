package counter;

import MovieBooking.MovieImpl;
import booking.ui.BookingUI;

public class CounterThread implements Runnable {
	private MovieImpl impl;
	private CounterObj counterObj;
	
	
	public CounterThread(CustomerObj obj,String operation,int counterId){
		counterObj=new CounterObj();
		counterObj.setCounterid(counterId);
		counterObj.setModuleName(operation);
		counterObj.setCustomerObj(obj);
		impl=MovieImpl.getInstance();
		impl.registerInstance(counterObj);
	}
	
	@Override
	public void run() {
		boolean flag=impl.operateBooking();
		BookingUI ui=new BookingUI();
		ui.notifyUI(flag);
		}
	
}
