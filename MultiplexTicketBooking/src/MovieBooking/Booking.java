package MovieBooking;

public abstract class Booking {

	public abstract boolean isWindowvailable(int window);
	public abstract boolean isSeatsvailable(int total);
	
	public abstract boolean bookSeat(int window,int total);
	public abstract int[][] getTotalSeatStatus();
	
	
}
