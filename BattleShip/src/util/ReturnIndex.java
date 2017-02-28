package util;

public class ReturnIndex {
	public int returnIndex(char ch){
		return ch%65;
	}
	
	public int[] returnIndex(String iStr){
		String str=iStr.replaceAll(" ", "");
		int  [] tempArr=new int[2];
		char ch=str.charAt(0);
		tempArr[0]=ch%65;
		tempArr[1]=str.charAt(1)%49;
		return tempArr;
	}
	
	public int[] returnFirstIntIndex(String  iStr){
		String str=iStr.replaceAll(" ", "");
		int  [] tempArr=new int[2];
		char ch=str.charAt(0);
		tempArr[0]=ch%48;
		tempArr[1]=(str.charAt(1)%65)+1;
//		System.out.println("ttt"+tempArr[0]+"\t"+tempArr[1]);
		return tempArr;
	}
	
	public int[] returnIndexInt(String iStr){
		String str=iStr.replaceAll(" ", "");
		int  [] tempArr=new int[2];
		char ch=str.charAt(0);
		tempArr[0]=ch%48;
		tempArr[1]=str.charAt(1)%48;
		
//		System.out.println(tempArr[0]+"\t"+tempArr[1]);
		return tempArr;
	}
	
	
	
	public static void main(String[] args) {
		new ReturnIndex().returnIndexInt("1 1");
	}
}
