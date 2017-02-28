package main;

import battle.PrepareBattle;

public class Execute {

	public static void main(String[] args) {
		PrepareBattle prepBattle=new PrepareBattle();
		
		prepBattle.prepareBattleMatrix();
		prepBattle.setName();
		prepBattle.prepareQShips();
		prepBattle.preparePShips();
		prepBattle.play();
	}
}
