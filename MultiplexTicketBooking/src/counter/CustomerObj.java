package counter;

import java.util.UUID;

public class CustomerObj {
	private String uid;
	private String firstName;
	private String lastName;
	
	private int windowSeat;
	private int totalSeat;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid=UUID.randomUUID().toString();
	}
	public String getFirstName() {
		return firstName+uid;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName+uid;
	}
	public int getWindowSeat() {
		return windowSeat;
	}
	public void setWindowSeat(int windowSeat) {
		this.windowSeat = windowSeat;
	}
	public int getTotalSeat() {
		return totalSeat;
	}
	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}
	
	
}
