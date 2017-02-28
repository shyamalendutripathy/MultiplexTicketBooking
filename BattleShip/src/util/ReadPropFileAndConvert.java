package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

public class ReadPropFileAndConvert {
	private HashMap<String,String> hMap;
	
	public ReadPropFileAndConvert(){
		hMap=new HashMap<String,String>();
	}
	
	public void readProps(){
		InputStream input = null;
		BufferedReader reader=null;
		try {
			input = new FileInputStream("battle.properties");
			reader= new BufferedReader(new InputStreamReader(input));
			String  line;
			while((line=reader.readLine())!=null){
				if(line.isEmpty()){
					continue;
				}
				String  str[]=line.split(":");
				hMap.put(str[0], str[1]);
			}
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
//	public static void main(String[] args) {
//		ReadPropFileAndConvert object=new ReadPropFileAndConvert();
//		object.readProps();
//		System.out.println(object.getBoundaries());
//		
//	}
	
	public String getBoundaries(){
		return hMap.get("Enter area boundaries").trim();
	}
	
	public String getName(String player){
		String constructStr="Type for battleship "+player;
		return hMap.get(constructStr).trim();
	}
	
	public String getDimension(String  typeOfBattleShip){
		String constructStr="Dimension for battleship "+typeOfBattleShip;
		return hMap.get(constructStr).trim();
	}
	
	public String getLocOfBattleShipForPlayers(String type,String playerName){
		String constructStr="Location of battleship "+type +" for player "+playerName;
		return hMap.get(constructStr).trim();
	}
	
	public String getListMoves(String playerName){
		String constructStr="Missile targets for player "+playerName;
		String val=hMap.get(constructStr).trim();
		return val;
	}
	
}
