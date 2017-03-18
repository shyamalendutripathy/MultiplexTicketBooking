package counter;

public class CounterObj {
	private int counterid;
	private String moduleName;
	private CustomerObj custObj; 
	
	public CustomerObj getCustObj() {
		return custObj;
	}
	public void setCustomerObj(CustomerObj customer) {
		this.custObj=customer;
	}
	
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public int getCounterid() {
		return counterid;
	}
	public void setCounterid(int counterid) {
		this.counterid = counterid;
	}
}
