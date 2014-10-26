package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
//This method ends the game when ScannerMan passes in "playerWhoResigned". This method outputs the player
//who resigned, figures out the largest score, matches up the largest score with the player(s) who had that score
//and declares the player or players with the highest score the winner. This also ends the game similar to the GameOver class

public class Resign {
	public Resign(int playerWhoResigned, int player1Score, int player2Score, int player3Score, int player4Score, int player5Score, int player6Score, int player7Score, int player8Score, ArrayList<String> playerNames){
		if(playerWhoResigned == 1){
			System.out.println(playerNames.get(0) + " resigned from the game.");
		}
		if(playerWhoResigned == 2){
			System.out.println(playerNames.get(1) + " resigned from the game.");
		}
		if(playerWhoResigned == 3){
			System.out.println(playerNames.get(2) + " resigned from the game.");
		}
		if(playerWhoResigned == 4){
			System.out.println(playerNames.get(3) + " resigned from the game.");
		}
		if(playerWhoResigned == 5){
			System.out.println(playerNames.get(4) + " resigned from the game.");
		}
		if(playerWhoResigned == 6){
			System.out.println(playerNames.get(5) + " resigned from the game.");
		}
		if(playerWhoResigned == 7){
			System.out.println(playerNames.get(6) + " resigned from the game.");
		}
		if(playerWhoResigned == 8){
			System.out.println(playerNames.get(7) + " resigned from the game.");
		}
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
		
		if(largestScore == playersWithScores.get("Player 1") && playerWhoResigned != 1){
			winners = winners + playerNames.get(0) + " ";
		}
		if(largestScore == playersWithScores.get("Player 2") && playerWhoResigned != 2){
			winners = winners + playerNames.get(1) + " ";
		}
		if(largestScore == playersWithScores.get("Player 3") && playerWhoResigned != 3){
			winners = winners + playerNames.get(2) + " ";
		}
		if(largestScore == playersWithScores.get("Player 4") && playerWhoResigned != 4){
			winners = winners + playerNames.get(3) + " ";
		}
		if(largestScore == playersWithScores.get("Player 5") && playerWhoResigned != 5){
			winners = winners + playerNames.get(4) + " ";
		}
		if(largestScore == playersWithScores.get("Player 6") && playerWhoResigned != 6){
			winners = winners + playerNames.get(5) + " ";
		}
		if(largestScore == playersWithScores.get("Player 7") && playerWhoResigned != 7){
			winners = winners + playerNames.get(6) + " ";
		}
		if(largestScore == playersWithScores.get("Player 8") && playerWhoResigned != 8){
			winners = winners + playerNames.get(7) + " ";
		}
		
		System.out.println(winners +"with a score of "+largestScore);
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