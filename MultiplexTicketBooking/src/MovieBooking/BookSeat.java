package MovieBooking;

import MovieBooking.ISeatDistribution;

public class BookSeat extends Booking{

	private int [][] matrix;
	private int totalSeat=ISeatDistribution.TOTAL_SEATS;
	private int windowSeat=ISeatDistribution.rows*2;
	

	public BookSeat(){
		matrix=new int[ISeatDistribution.rows][ISeatDistribution.cols];
	}
	
	public int[][] getTotalSeatStatus(){
		return matrix;
	}
	
	@Override
	public boolean isSeatsvailable(int total) {
		int diff=totalSeat-total;
		if(diff<0){
			return false;
		}
		return true;
//		int cnt=0;
//		
//		for (int i = 0; i < matrix.length; i++) {
//			for (int j = 0; j < matrix[0].length; j++) {
//				if(cnt==total){
//					return true;
//				}
//				if(matrix[i][j]==0){
//					cnt++;
//				}
//			}
//		}
//		return false;
	}
	
	@Override
	public boolean isWindowvailable(int window) {
		int diff=windowSeat-window;
		if(diff<0){
			return false;
		}
		return true;
//		int cnt=0;
//		for (int i = 0; i < matrix.length; i++) {
//			if(cnt==window){
//				return true;
//			}
//			if(matrix[i][0]==0 || matrix[i][ISeatDistribution.cols-i]==0){
//				cnt++;
//			}
//		}
//		return false;
	}

	@Override
	public boolean bookSeat(int window,int total) {
	
		if(total<window){
			return false;
		}
		int cnt=0;
		for (int i = 0; i < matrix.length; i++) {
			if(matrix[i][0]==0 && cnt <window){
				matrix[i][0]=1;
				cnt++;
			}
			else if(cnt==window){
				windowSeat-=window;
				System.out.println("Remaining Window is" + windowSeat);
				break;
			}
			if(matrix[i%ISeatDistribution.rows][ISeatDistribution.cols-1]==0 && cnt<window){
				matrix[i%ISeatDistribution.rows][ISeatDistribution.cols-1]=1;
				cnt++;
			}
			else if(cnt==window){
				windowSeat-=window;
				System.out.println("Remaining Window is" + windowSeat);
				break;
			}
		}
		if(cnt<window){
			return false;
		}
		cnt=0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(cnt==total-window){
					totalSeat-=total;
					System.out.println("Remaining Total is" + totalSeat);
					return true;
				}
				if(matrix[i][j]==0){
					matrix[i][j]=1;
					cnt++;
				}
			}
		}
		
		if(cnt<window){
			return false;
		}
		
		return true;
		
		
	}
}
