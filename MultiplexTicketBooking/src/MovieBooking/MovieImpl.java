package MovieBooking;

import java.util.LinkedList;
import java.util.Queue;

import counter.CounterObj;

public class MovieImpl  {
	private Booking bookObj;
	private boolean isWindowAvailable;
	private boolean isTotalAvailable;
	private boolean isBooked;
	private Queue<CounterObj> queue=new  LinkedList<>();
	private String totalSeat;

	private static MovieImpl movieObj;

	public MovieImpl(){
		bookObj=new BookSeat();
	}

	public static MovieImpl getInstance(){
		if(movieObj==null){
			synchronized (MovieImpl.class) {
				movieObj=new MovieImpl();
				return movieObj;	
			}
		}

		return movieObj;
	}

	public void registerInstance(CounterObj obj){
		synchronized (queue) {
			queue.add(obj);
		}
	}

	public String getTotalSeat(){
		String str="";
		int matrix[][]=bookObj.getTotalSeatStatus();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				str+=matrix[i][j]+"   ";
			}
			str+="\n";
		}

		return str;
	}

	private boolean isWindowAvailable(int window){
		return bookObj.isWindowvailable(window);
	}

	private boolean isTotalSeatAvailable(int total){
		return bookObj.isSeatsvailable(total);
	}

	private void bookSeat(int window,int total){

			isWindowAvailable=bookObj.isWindowvailable(window);
			isTotalAvailable=bookObj.isSeatsvailable(total);
			if(isWindowAvailable && isTotalAvailable){
				isBooked= bookObj.bookSeat(window,total);
			}
			else{
				isBooked=false;
			}
	}

	public boolean operateBooking(){
		synchronized(queue){
			while(!queue.isEmpty()){
				CounterObj bean=queue.poll();
				bookSeat(bean.getCustObj().getWindowSeat(),bean.getCustObj().getTotalSeat());
			}
		}
		return isBooked;
	}

	public String retSeat(){
		return totalSeat;
	}



}
