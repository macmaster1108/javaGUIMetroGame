package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class EventHandlerDisplayPlayer implements ActionListener {
	private int _numberOfPlayers;
	private ArrayList<String> playerNames;
	private int curTurn;
	
	public EventHandlerDisplayPlayer(int numberOfPlayers, ArrayList<String> _playerNames, int _curTurn) {
		_numberOfPlayers = numberOfPlayers;
		playerNames = _playerNames;
		curTurn = _curTurn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if( _numberOfPlayers == 2){
			if(curTurn % 2 == 0){
				JLabel player = new JLabel("It is "+playerNames.get(0)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else{
				JLabel player = new JLabel("It is "+playerNames.get(1)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
		}
		else if( _numberOfPlayers == 3){
			if(curTurn % 3 == 0){
				JLabel player = new JLabel("It is "+playerNames.get(0)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else if(curTurn %3 == 1){
				JLabel player = new JLabel("It is "+playerNames.get(1)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else{
				JLabel player = new JLabel("It is "+playerNames.get(2)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
		}
		else if( _numberOfPlayers == 4){
			if(curTurn % 4 == 0){
				JLabel player = new JLabel("It is "+playerNames.get(0)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else if(curTurn %4 == 1){
				JLabel player = new JLabel("It is "+playerNames.get(1)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else if(curTurn%4 == 2){
				JLabel player = new JLabel("It is "+playerNames.get(2)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else{
				JLabel player = new JLabel("It is "+playerNames.get(3)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
		}
		else if( _numberOfPlayers == 5){
			if(curTurn % 5 == 0){
				JLabel player = new JLabel("It is "+playerNames.get(0)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else if(curTurn %5 == 1){
				JLabel player = new JLabel("It is "+playerNames.get(1)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else if(curTurn%5 == 2){
				JLabel player = new JLabel("It is "+playerNames.get(2)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else if(curTurn%5 == 3){
				JLabel player = new JLabel("It is "+playerNames.get(3)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else{
				JLabel player = new JLabel("It is "+playerNames.get(4)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
		}
		else if( _numberOfPlayers == 6){
			if(curTurn % 6 == 0){
				JLabel player = new JLabel("It is "+playerNames.get(0)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else if(curTurn %6 == 1){
				JLabel player = new JLabel("It is "+playerNames.get(1)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else if(curTurn%6 == 2){
				JLabel player = new JLabel("It is "+playerNames.get(2)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else if(curTurn%6 == 3){
				JLabel player = new JLabel("It is "+playerNames.get(3)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else if(curTurn%6 == 4){
				JLabel player = new JLabel("It is "+playerNames.get(4)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else{
				JLabel player = new JLabel("It is "+playerNames.get(5)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
		}
		else if( _numberOfPlayers == 7){
			if(curTurn % 7 == 0){
				JLabel player = new JLabel("It is "+playerNames.get(0)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else if(curTurn %7 == 1){
				JLabel player = new JLabel("It is "+playerNames.get(1)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else if(curTurn%7 == 2){
				JLabel player = new JLabel("It is "+playerNames.get(2)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else if(curTurn%7 == 3){
				JLabel player = new JLabel("It is "+playerNames.get(3)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else if(curTurn%7 == 4){
				JLabel player = new JLabel("It is "+playerNames.get(4)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else if(curTurn%7 == 5){
				JLabel player = new JLabel("It is "+playerNames.get(5)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else{
				JLabel player = new JLabel("It is "+playerNames.get(6)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
		}
		else{
			if(curTurn % 8 == 0){
				JLabel player = new JLabel("It is "+playerNames.get(0)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else if(curTurn %8 == 1){
				JLabel player = new JLabel("It is "+playerNames.get(1)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else if(curTurn%8 == 2){
				JLabel player = new JLabel("It is "+playerNames.get(2)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else if(curTurn%8 == 3){
				JLabel player = new JLabel("It is "+playerNames.get(3)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else if(curTurn%8 == 4){
				JLabel player = new JLabel("It is "+playerNames.get(4)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else if(curTurn%8 == 5){
				JLabel player = new JLabel("It is "+playerNames.get(5)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else if(curTurn%8 == 6){
				JLabel player = new JLabel("It is "+playerNames.get(6)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
			else{
				JLabel player = new JLabel("It is "+playerNames.get(7)+"'s turn");
				final JComponent[] inputs = new JComponent[]{
						player
				};
				JOptionPane.showMessageDialog(null,inputs,"Display Player",JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
}