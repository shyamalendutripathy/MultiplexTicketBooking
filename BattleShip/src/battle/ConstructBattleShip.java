package battle;

import java.util.HashSet;
import java.util.Iterator;

import util.ReturnIndex;

public class ConstructBattleShip {
	private int battleMatrix[][];
	private String battleShipName;
	private String moves;
	private int cnt=0;
	private ReturnIndex index;
	private HashSet<Integer[]> hset=new HashSet<Integer[]>();
	private boolean winFlag;
	
	public ConstructBattleShip(int m,int n){
		battleMatrix=new int[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				battleMatrix[i][j]=-1;
			}
		}
		index=new ReturnIndex();
	}
	
	public void printMatrix(){
		for (int i = 0; i < battleMatrix.length; i++) {
			for (int j = 0; j < battleMatrix[0].length; j++) {
				System.out.print(battleMatrix[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public void setQType(int i,int j){
		battleMatrix[i][j]=2;
		Integer[] temp=new Integer[2];
		temp[0]=i;
		temp[1]=j;
		hset.add(temp);
	}
	
	public void setPType(int i,int j){
		battleMatrix[i][j]=1;
		Integer[] temp=new Integer[2];
		temp[0]=i;
		temp[1]=j;
		hset.add(temp);
	}
	
	public boolean hit(int i,int j){
		if(battleMatrix[i][j]==0 || battleMatrix[i][j]==-1){
			return false;
		}
		else{
			return  true;
		}
	}
	
	public  boolean killShip(int i,int j){
		boolean hitVal=hit(i,j);
		if(hitVal){
			battleMatrix[i][j]--;
		}
		
		return hitVal;
	}
	
	public  void setMoves(String moves){
		this.moves=moves;
	}
	
	public String getMoves(){
		int  prevCnt=cnt-1;
		return moves.split("\\s+")[prevCnt];
	}
	
	public int getMoveLength(){
		return moves.split("\\s+").length;
	}
	
	public  int[] getIntMoves(){
		return  index.returnIndex(getMoves());
	}
	
	public boolean incrCnt(){
		if(cnt<getMoveLength()){
			cnt++;	
			return true;
		}
		return false;
		
	}
	
	public void setName(String name){
		battleShipName=name;
	}
	
	public String getName(){
		return battleShipName;
	}
	
	public boolean hasWon(){
		winFlag=true;
		Iterator<Integer[]> iterator=hset.iterator();
		while(iterator.hasNext()){
			Integer[] val=iterator.next();
			if(battleMatrix[val[0]][val[1]]>0){
				winFlag=false;
			}
		}
		
		return winFlag;
		
	}
	
	public boolean retWinFlag(){
		return winFlag;
	}
	
	
}
