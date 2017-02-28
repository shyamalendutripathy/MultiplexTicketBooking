package battle;

import util.ReturnIndex;

public class PlayImpl {
	ReturnIndex index;

	public PlayImpl(){
		index=new  ReturnIndex();
	}
	public void playGame(ConstructBattleShip player1,ConstructBattleShip  player2){
		int  size =Math.max(player1.getMoveLength(), player2.getMoveLength());
		
		for (int i = 0; i < size; i++) {
			if(!player2.retWinFlag()){
				play(player1,player2);
			}
			if(!player1.retWinFlag()){
				play(player2,player1);
			}
			
			if(player1.retWinFlag() || player2.retWinFlag()){
				break;
			}
			
		}
	}
	
	private  void play(ConstructBattleShip player,ConstructBattleShip oppPlayer){
		if(player.incrCnt()){
			int  retArr[]=player.getIntMoves();
			if(oppPlayer.killShip(retArr[0],retArr[1])){
				System.out.println(player.getName()+ " fires a missile with Target "+player.getMoves()+ " which hit");
				if(oppPlayer.hasWon()){
					System.out.println(player.getName()+ " won the battle");
					return;
				}
				play(player,oppPlayer);
			}
			else{
				System.out.println(player.getName()+ " fires a missile with Target "+player.getMoves()+ " which missed");
			}
		}
		else{
			System.out.println(player.getName()+ " Has No missile left");
		}
	}
}
