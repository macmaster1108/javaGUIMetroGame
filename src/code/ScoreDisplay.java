package code;

import java.util.ArrayList;

public class ScoreDisplay {
	//This method gets passed in the number of players and each score, it then prints out the scores based on the amount of players
	public ScoreDisplay(int _numberofplayers, int _playeronecurscore, int _playertwocurscore, int _playerthreecurscore, int _playerfourcurscore, int _playerfivecurscore, int _playersixcurscore, int _playersevencurscore, int _playereightcurscore, ArrayList<String> playerNames) {
		if( _numberofplayers == 2){
			System.out.println(playerNames.get(0)+": "+_playeronecurscore+" points     "+playerNames.get(1)+": "+_playertwocurscore+" points");
		}
		else if( _numberofplayers == 3){
			System.out.println(playerNames.get(0)+": "+_playeronecurscore+" points     "+playerNames.get(1)+": "+_playertwocurscore+" points     "+playerNames.get(2)+": "+_playerthreecurscore+" points");
		}
		else if( _numberofplayers == 4){
			System.out.println(playerNames.get(0)+": "+_playeronecurscore+" points     "+playerNames.get(1)+": "+_playertwocurscore+" points     "+playerNames.get(2)+": "+_playerthreecurscore+" points     "+playerNames.get(3)+": "+_playerfourcurscore+" points");
		}
		else if( _numberofplayers == 5){
			System.out.println(playerNames.get(0)+": "+_playeronecurscore+" points     "+playerNames.get(1)+": "+_playertwocurscore+" points     "+playerNames.get(2)+": "+_playerthreecurscore+" points     "+playerNames.get(3)+": "+_playerfourcurscore+" points");
			System.out.println(playerNames.get(4)+": "+_playerfivecurscore+" points");
		}
		else if( _numberofplayers == 6){
			System.out.println(playerNames.get(0)+": "+_playeronecurscore+" points     "+playerNames.get(1)+": "+_playertwocurscore+" points     "+playerNames.get(2)+": "+_playerthreecurscore+" points     "+playerNames.get(3)+": "+_playerfourcurscore+" points");
			System.out.println(playerNames.get(4)+": "+_playerfivecurscore+" points     "+playerNames.get(5)+": "+_playersixcurscore+" points");
		}
		else if( _numberofplayers == 7){
			System.out.println(playerNames.get(0)+": "+_playeronecurscore+" points     "+playerNames.get(1)+": "+_playertwocurscore+" points     "+playerNames.get(2)+": "+_playerthreecurscore+" points     "+playerNames.get(3)+": "+_playerfourcurscore+" points");
			System.out.println(playerNames.get(4)+": "+_playerfivecurscore+" points     "+playerNames.get(5)+": "+_playersixcurscore+" points     "+playerNames.get(6)+": "+_playersevencurscore+" points");
		}
		else{
			System.out.println(playerNames.get(0)+": "+_playeronecurscore+" points     "+playerNames.get(1)+": "+_playertwocurscore+" points     "+playerNames.get(2)+": "+_playerthreecurscore+" points     "+playerNames.get(3)+": "+_playerfourcurscore+" points");
			System.out.println(playerNames.get(4)+": "+_playerfivecurscore+" points     "+playerNames.get(5)+": "+_playersixcurscore+" points     "+playerNames.get(6)+": "+_playersevencurscore+" points     "+playerNames.get(7)+": "+_playereightcurscore+" points");
		}
	}
}