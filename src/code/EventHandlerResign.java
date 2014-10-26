package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class EventHandlerResign implements ActionListener {
	private int playerWhoResigned;
	private boolean _ableToResign;
	private int player1Score;
	private int player2Score;
	private int player3Score;
	private int player4Score;
	private int player5Score;
	private int player6Score;
	private int player7Score;
	private int player8Score;
	private ArrayList<String> playerNames;
	private JFrame frame;
	
	public EventHandlerResign(boolean ableToResign, int _numberOfPlayers,int _curTurn, int _playerOneScore, int _playerTwoScore, int _playerThreeScore, int _playerFourScore, int _playerFiveScore, int _playerSixScore, int _playerSevenScore, int _playerEightScore, ArrayList<String> _playerNames, JFrame _frame) {
		_ableToResign= ableToResign;
		player1Score = _playerOneScore;
		player2Score = _playerTwoScore;
		player3Score = _playerThreeScore;
		player4Score = _playerFourScore;
		player5Score = _playerFiveScore;
		player6Score = _playerSixScore;
		player7Score = _playerSevenScore;
		player8Score = _playerEightScore;
		playerNames = _playerNames;
		frame = _frame;
		if(ableToResign){
			if(_numberOfPlayers == 2){
				if(_curTurn % 2 == 0){
					playerWhoResigned = 1;
				}
				else{
					playerWhoResigned = 2;
				}
			}
			else if(_numberOfPlayers == 3){
				if(_curTurn % 3 == 0){
					playerWhoResigned = 1;
				}
				else if(_curTurn %3 == 1){
					playerWhoResigned = 2;
				}
				else{
					playerWhoResigned = 3;
				}	
			}
			else if(_numberOfPlayers == 4){
				if(_curTurn % 4 == 0){
					playerWhoResigned = 1;
				}
				else if(_curTurn %4 == 1){
					playerWhoResigned = 2;
				}
				else if(_curTurn%4 == 2){
					playerWhoResigned = 3;
				}
				else{
					playerWhoResigned = 4;
				}
			}
			else if(_numberOfPlayers == 5){
				if(_curTurn % 5 == 0){
					playerWhoResigned = 1;
				}
				else if(_curTurn %5 == 1){
					playerWhoResigned = 2;
				}
				else if(_curTurn%5 == 2){
					playerWhoResigned = 3;
				}
				else if(_curTurn%5 == 3){
					playerWhoResigned = 4;
				}
				else{
					playerWhoResigned = 5;
				}
			}
			else if(_numberOfPlayers == 6){
				if(_curTurn % 6 == 0){
					playerWhoResigned = 1;
				}
				else if(_curTurn %6 == 1){
					playerWhoResigned = 2;
				}
				else if(_curTurn%6 == 2){
					playerWhoResigned = 3;
				}
				else if(_curTurn%6 == 3){
					playerWhoResigned = 4;
				}
				else if(_curTurn%6 == 4){
					playerWhoResigned = 5;
				}
				else{
					playerWhoResigned = 6;
				}
			}
			else if(_numberOfPlayers == 7){
				if(_curTurn % 7 == 0){
					playerWhoResigned = 1;
				}
				else if(_curTurn %7 == 1){
					playerWhoResigned = 2;
				}
				else if(_curTurn%7 == 2){
					playerWhoResigned = 3;
				}
				else if(_curTurn%7 == 3){
					playerWhoResigned = 4;
				}
				else if(_curTurn%7 == 4){
					playerWhoResigned = 5;
				}
				else if(_curTurn%7 == 5){
					playerWhoResigned = 6;
				}
				else{
					playerWhoResigned = 7;
				}
			}
			else if(_numberOfPlayers == 8){
				if(_curTurn % 8 == 0){
					playerWhoResigned = 1;
				}
				else if(_curTurn %8 == 1){
					playerWhoResigned = 2;
				}
				else if(_curTurn%8 == 2){
					playerWhoResigned = 3;
				}
				else if(_curTurn%8 == 3){
					playerWhoResigned = 4;
				}
				else if(_curTurn%8 == 4){
					playerWhoResigned = 5;
				}
				else if(_curTurn%8 == 5){
					playerWhoResigned = 6;
				}
				else if(_curTurn%8 == 6){
					playerWhoResigned = 7;
				}
				else{
					playerWhoResigned = 8;
				}
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(_ableToResign){
			if(playerWhoResigned == 1){
				JLabel playres = new JLabel(playerNames.get(0) + " resigned from the game.");
				final JComponent[] inputs = new JComponent[]{
						playres
				};
				JOptionPane.showMessageDialog(null,inputs,"Resign",JOptionPane.PLAIN_MESSAGE);
			}
			if(playerWhoResigned == 2){
				JLabel playres = new JLabel(playerNames.get(1) + " resigned from the game.");
				final JComponent[] inputs = new JComponent[]{
						playres
				};
				JOptionPane.showMessageDialog(null,inputs,"Resign",JOptionPane.PLAIN_MESSAGE);
			}
			if(playerWhoResigned == 3){
				JLabel playres = new JLabel(playerNames.get(2) + " resigned from the game.");
				final JComponent[] inputs = new JComponent[]{
						playres
				};
				JOptionPane.showMessageDialog(null,inputs,"Resign",JOptionPane.PLAIN_MESSAGE);
			}
			if(playerWhoResigned == 4){
				JLabel playres = new JLabel(playerNames.get(3) + " resigned from the game.");
				final JComponent[] inputs = new JComponent[]{
						playres
				};
				JOptionPane.showMessageDialog(null,inputs,"Resign",JOptionPane.PLAIN_MESSAGE);
			}
			if(playerWhoResigned == 5){
				JLabel playres = new JLabel(playerNames.get(4) + " resigned from the game.");
				final JComponent[] inputs = new JComponent[]{
						playres
				};
				JOptionPane.showMessageDialog(null,inputs,"Resign",JOptionPane.PLAIN_MESSAGE);
			}
			if(playerWhoResigned == 6){
				JLabel playres = new JLabel(playerNames.get(5) + " resigned from the game.");
				final JComponent[] inputs = new JComponent[]{
						playres
				};
				JOptionPane.showMessageDialog(null,inputs,"Resign",JOptionPane.PLAIN_MESSAGE);
			}
			if(playerWhoResigned == 7){
				JLabel playres = new JLabel(playerNames.get(6) + " resigned from the game.");
				final JComponent[] inputs = new JComponent[]{
						playres
				};
				JOptionPane.showMessageDialog(null,inputs,"Resign",JOptionPane.PLAIN_MESSAGE);
			}
			if(playerWhoResigned == 8){
				JLabel playres = new JLabel(playerNames.get(7) + " resigned from the game.");
				final JComponent[] inputs = new JComponent[]{
						playres
				};
				JOptionPane.showMessageDialog(null,inputs,"Resign",JOptionPane.PLAIN_MESSAGE);
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
			JLabel winners = new JLabel("The Winner(s) is(are): ");
			final JComponent[] inputs = new JComponent[]{
					winners
			};
			JOptionPane.showMessageDialog(null,inputs,"Resign",JOptionPane.PLAIN_MESSAGE);
			
			if(largestScore == playersWithScores.get("Player 1") && playerWhoResigned != 1){
				JLabel name = new JLabel(playerNames.get(0));
				final JComponent[] inputs2 = new JComponent[]{
						name
				};
				JOptionPane.showMessageDialog(null,inputs2,"Resign",JOptionPane.PLAIN_MESSAGE);
			}
			if(largestScore == playersWithScores.get("Player 2") && playerWhoResigned != 2){
				JLabel name = new JLabel(playerNames.get(1));
				final JComponent[] inputs2 = new JComponent[]{
						name
				};
				JOptionPane.showMessageDialog(null,inputs2,"Resign",JOptionPane.PLAIN_MESSAGE);
			}
			if(largestScore == playersWithScores.get("Player 3") && playerWhoResigned != 3){
				JLabel name = new JLabel(playerNames.get(2));
				final JComponent[] inputs2 = new JComponent[]{
						name
				};
				JOptionPane.showMessageDialog(null,inputs2,"Resign",JOptionPane.PLAIN_MESSAGE);
			}
			if(largestScore == playersWithScores.get("Player 4") && playerWhoResigned != 4){
				JLabel name = new JLabel(playerNames.get(3));
				final JComponent[] inputs2 = new JComponent[]{
						name
				};
				JOptionPane.showMessageDialog(null,inputs2,"Resign",JOptionPane.PLAIN_MESSAGE);
			}
			if(largestScore == playersWithScores.get("Player 5") && playerWhoResigned != 5){
				JLabel name = new JLabel(playerNames.get(4));
				final JComponent[] inputs2 = new JComponent[]{
						name
				};
				JOptionPane.showMessageDialog(null,inputs2,"Resign",JOptionPane.PLAIN_MESSAGE);
			}
			if(largestScore == playersWithScores.get("Player 6") && playerWhoResigned != 6){
				JLabel name = new JLabel(playerNames.get(5));
				final JComponent[] inputs2 = new JComponent[]{
						name
				};
				JOptionPane.showMessageDialog(null,inputs2,"Resign",JOptionPane.PLAIN_MESSAGE);
			}
			if(largestScore == playersWithScores.get("Player 7") && playerWhoResigned != 7){
				JLabel name = new JLabel(playerNames.get(6));
				final JComponent[] inputs2 = new JComponent[]{
						name
				};
				JOptionPane.showMessageDialog(null,inputs2,"Resign",JOptionPane.PLAIN_MESSAGE);
			}
			if(largestScore == playersWithScores.get("Player 8") && playerWhoResigned != 8){
				JLabel name = new JLabel(playerNames.get(7));
				final JComponent[] inputs2 = new JComponent[]{
						name
				};
				JOptionPane.showMessageDialog(null,inputs2,"Resign",JOptionPane.PLAIN_MESSAGE);
			}
			JLabel gameOver = new JLabel("Game Over, Bye");
			final JComponent[] inputs2 = new JComponent[]{
					gameOver
			};
			JOptionPane.showMessageDialog(null,inputs2,"Resign",JOptionPane.PLAIN_MESSAGE);
			frame.dispose();
		}
		else{
			JLabel jlabel = new JLabel("Oh Come On! You Haven't Even Started The Game Yet");
			final JComponent[] inputs = new JComponent[]{
					jlabel
			};
			JOptionPane.showMessageDialog(null,inputs,"Resign",JOptionPane.PLAIN_MESSAGE);
		}
	}
	
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