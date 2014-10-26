package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
//The method for computing the winner of the game and disabling input (closing the game). The arguments passed in
// are each players scores

public class GameOver {
	public GameOver(int player1Score, int player2Score, int player3Score, int player4Score, int player5Score, int player6Score, int player7Score, int player8Score, ArrayList<String> playerNames){
		HashMap<String, Integer> playersWithScores = new HashMap<String, Integer>();
		playersWithScores.put("Player 1", player1Score);
		playersWithScores.put("Player 2", player2Score);
		playersWithScores.put("Player 3", player3Score);
		playersWithScores.put("Player 4", player4Score);
		playersWithScores.put("Player 5", player5Score);
		playersWithScores.put("Player 6", player6Score);
		playersWithScores.put("Player 7", player7Score);
		playersWithScores.put("Player 8", player8Score);

		List<Integer> allPlayersScores = new java.util.LinkedList<Integer>();
		allPlayersScores.add(playersWithScores.get("Player 1"));
		allPlayersScores.add(playersWithScores.get("Player 2"));
		allPlayersScores.add(playersWithScores.get("Player 3"));
		allPlayersScores.add(playersWithScores.get("Player 4"));
		allPlayersScores.add(playersWithScores.get("Player 5"));
		allPlayersScores.add(playersWithScores.get("Player 6"));
		allPlayersScores.add(playersWithScores.get("Player 7"));
		allPlayersScores.add(playersWithScores.get("Player 8"));

		int largestScore = findLargest(allPlayersScores);
		String winners = "The Winner(s) is(are): ";

		if(largestScore == playersWithScores.get("Player 1")){
			winners = winners + playerNames.get(0) + " ";
		}
		if(largestScore == playersWithScores.get("Player 2")){
			winners = winners + playerNames.get(1) + " ";
		}
		if(largestScore == playersWithScores.get("Player 3")){
			winners = winners + playerNames.get(2) + " ";
		}
		if(largestScore == playersWithScores.get("Player 4")){
			winners = winners + playerNames.get(3) + " ";
		}
		if(largestScore == playersWithScores.get("Player 5")){
			winners = winners + playerNames.get(4) + " ";
		}
		if(largestScore == playersWithScores.get("Player 6")){
			winners = winners + playerNames.get(5) + " ";
		}
		if(largestScore == playersWithScores.get("Player 7")){
			winners = winners + playerNames.get(6) + " ";
		}
		if(largestScore == playersWithScores.get("Player 8")){
			winners = winners + playerNames.get(7) + " ";
		}
  
		System.out.println(winners);
		System.out.print("with a score of "+largestScore);
		Scanner input = new Scanner(System.in);
		System.out.println("");
		System.out.println("Game Over, Bye");
		input.close();
	}
	//This finds and returns the highest score
	private int findLargest(List<Integer> allPlayersScores) {
		java.util.Iterator<Integer> iterator = allPlayersScores.iterator();
		int theScore = 0;
		while(iterator.hasNext()){
			int curScore = iterator.next();
			if(curScore>theScore){
				theScore = curScore;
			}
		}
		return theScore;
	}
}