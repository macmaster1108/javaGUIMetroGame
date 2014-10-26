package code;

import java.util.ArrayList;
//This method takes in the the current turn number (starts at zero and increments with each commit), 
//(curTurn), then does a println of the current player, by dividing the curTurn by the 
//number of players (passed in as playerNumber) and utilizing the remainder

public class PlayerDisplay {
	public PlayerDisplay(int curTurn, int playerNumber, ArrayList<String> playerNames) {
		switch(playerNumber){
		case 2:
			if(curTurn % 2 == 0){
				System.out.println("It is "+playerNames.get(0)+"'s turn");
			}
			else{
				System.out.println("It is "+playerNames.get(1)+"'s turn");
			}
			break;
		case 3:
			if(curTurn % 3 == 0){
				System.out.println("It is "+playerNames.get(0)+"'s turn");
			}
			else if(curTurn %3 == 1){
				System.out.println("It is "+playerNames.get(1)+"'s turn");
			}
			else{
				System.out.println("It is "+playerNames.get(2)+"'s turn");
			}	
			break;	
		case 4:
			if(curTurn % 4 == 0){
				System.out.println("It is "+playerNames.get(0)+"'s turn");
			}
			else if(curTurn %4 == 1){
				System.out.println("It is "+playerNames.get(1)+"'s turn");
			}
			else if(curTurn%4 == 2){
				System.out.println("It's "+playerNames.get(2)+"'s turn");
			}
			else{
				System.out.println("It is "+playerNames.get(3)+"'s turn");
			}
			break;	
		case 5:
			if(curTurn % 5 == 0){
				System.out.println("It is "+playerNames.get(0)+"'s turn");
			}
			else if(curTurn %5 == 1){
				System.out.println("It is "+playerNames.get(1)+"'s turn");
			}
			else if(curTurn%5 == 2){
				System.out.println("It's "+playerNames.get(2)+"'s turn");
			}
			else if(curTurn%5 == 3){
				System.out.println("It's "+playerNames.get(3)+"'s turn");
			}
			else{
				System.out.println("It is "+playerNames.get(4)+"'s turn");
			}
			break;	
		case 6:
			if(curTurn % 6 == 0){
				System.out.println("It is "+playerNames.get(0)+"'s turn");
			}
			else if(curTurn %6 == 1){
				System.out.println("It is "+playerNames.get(1)+"'s turn");
			}
			else if(curTurn%6 == 2){
				System.out.println("It's "+playerNames.get(2)+"'s turn");
			}
			else if(curTurn%6 == 3){
				System.out.println("It's "+playerNames.get(3)+"'s turn");
			}
			else if(curTurn%6 == 4){
				System.out.println("It's "+playerNames.get(4)+"'s turn");
			}
			else{
				System.out.println("It is "+playerNames.get(5)+"'s turn");
			}
			break;
		case 7:
			if(curTurn % 7 == 0){
				System.out.println("It is "+playerNames.get(0)+"'s turn");
			}
			else if(curTurn %7 == 1){
				System.out.println("It is "+playerNames.get(1)+"'s turn");
			}
			else if(curTurn%7 == 2){
				System.out.println("It's "+playerNames.get(2)+"'s turn");
			}
			else if(curTurn%7 == 3){
				System.out.println("It's "+playerNames.get(3)+"'s turn");
			}
			else if(curTurn%7 == 4){
				System.out.println("It's "+playerNames.get(4)+"'s turn");
			}
			else if(curTurn%7 == 5){
				System.out.println("It's "+playerNames.get(5)+"'s turn");
			}
			else{
				System.out.println("It is "+playerNames.get(6)+"'s turn");
			}
			break;
		case 8:
			if(curTurn % 8 == 0){
				System.out.println("It is "+playerNames.get(0)+"'s turn");
			}
			else if(curTurn %8 == 1){
				System.out.println("It is "+playerNames.get(1)+"'s turn");
			}
			else if(curTurn%8 == 2){
				System.out.println("It's "+playerNames.get(2)+"'s turn");
			}
			else if(curTurn%8 == 3){
				System.out.println("It's "+playerNames.get(3)+"'s turn");
			}
			else if(curTurn%8 == 4){
				System.out.println("It's "+playerNames.get(4)+"'s turn");
			}
			else if(curTurn%8 == 5){
				System.out.println("It's "+playerNames.get(5)+"'s turn");
			}
			else if(curTurn%8 == 6){
				System.out.println("It's "+playerNames.get(6)+"'s turn");
			}
			else{
				System.out.println("It is "+playerNames.get(7)+"'s turn");
			}
			break;	
		}
	}
}