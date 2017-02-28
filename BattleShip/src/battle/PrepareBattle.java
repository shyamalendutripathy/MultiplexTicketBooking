package battle;

import util.ReadPropFileAndConvert;
import util.ReturnIndex;

public class PrepareBattle {
	private ReadPropFileAndConvert readProps=new ReadPropFileAndConvert();
	private ReturnIndex utilIndex=new ReturnIndex();
	private ConstructBattleShip player1,player2;


	public PrepareBattle(){
		readProps.readProps();
	}

	public void prepareBattleMatrix(){
		int[] index=utilIndex.returnFirstIntIndex(readProps.getBoundaries());
		player1=new ConstructBattleShip(index[1], index[0]);
		player2=new ConstructBattleShip(index[1], index[0]);

	}

	public void setName(){
		player1.setName("Player 1");
		player2.setName("Player 2");
	}


	public  void prepareQShips(){
		int[] index=utilIndex.returnIndexInt(readProps.getDimension("1"));

		int[]  aBattleIndex=utilIndex.returnIndex(readProps.getLocOfBattleShipForPlayers("1", "A"));
		int[]  bBattleIndex=utilIndex.returnIndex(readProps.getLocOfBattleShipForPlayers("1", "B"));

		//		Indexes for rows and columns
		for (int i = 0; i < index[1]; i++) {
			for (int j = 0; j < index[0]; j++) {
				player1.setQType(aBattleIndex[0]+i, aBattleIndex[1]+j);
				player2.setQType(bBattleIndex[0]+i, bBattleIndex[1]+j);
			}
		}
	}

	public void preparePShips(){
		int[] index=utilIndex.returnIndexInt(readProps.getDimension("2"));

		int[]  aBattleIndex=utilIndex.returnIndex(readProps.getLocOfBattleShipForPlayers("2", "A"));
		int[]  bBattleIndex=utilIndex.returnIndex(readProps.getLocOfBattleShipForPlayers("2", "B"));

		for (int i = 0; i < index[1]; i++) {
			for (int j = 0; j < index[0]; j++) {
				player1.setPType(aBattleIndex[0]+i, aBattleIndex[1]+j);
				player2.setPType(bBattleIndex[0]+i, bBattleIndex[1]+j);
			}
		}
	}
	
	public void play(){
		String player1Arr=readProps.getListMoves("A");
		String player2Arr=readProps.getListMoves("B");
		
		player1.setMoves(player1Arr);
		player2.setMoves(player2Arr);
		
		PlayImpl play=new PlayImpl();
		play.playGame(player1, player2);
		
	}

	public void printMatrix(){
		player2.printMatrix();
	}
}
