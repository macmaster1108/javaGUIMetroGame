package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class EventHandlerDisplayScore implements ActionListener {
	private int _numberOfPlayers;
	private int _playeronecurscore;
	private int _playertwocurscore;
	private int _playerthreecurscore;
	private int _playerfourcurscore;
	private int _playerfivecurscore;
	private int _playersixcurscore;
	private int _playersevencurscore;
	private int _playereightcurscore;
	private ArrayList<String> playerNames;
	
	public EventHandlerDisplayScore(int numberOfPlayers, int _playerOneScore,int _playerTwoScore, int _playerThreeScore, int _playerFourScore,int _playerFiveScore, int _playerSixScore, int _playerSevenScore,int _playerEightScore, ArrayList<String> _playerNames) {
		_numberOfPlayers = numberOfPlayers;
		_playeronecurscore = _playerOneScore;
		_playertwocurscore = _playerTwoScore;
		_playerthreecurscore = _playerThreeScore;
		_playerfourcurscore = _playerFourScore;
		_playerfivecurscore = _playerFiveScore;;
		_playersixcurscore = _playerSixScore;;
		_playersevencurscore = _playerSevenScore;;
		_playereightcurscore = _playerEightScore;;
		playerNames = _playerNames;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if( _numberOfPlayers == 2){
			JLabel score1 = new JLabel(playerNames.get(0)+": "+_playeronecurscore+" points");
			JLabel score2 = new JLabel(playerNames.get(1)+": "+_playertwocurscore+" points");
			final JComponent[] inputs = new JComponent[]{
					score1,
					score2
			};
			JOptionPane.showMessageDialog(null,inputs,"Display Score",JOptionPane.PLAIN_MESSAGE);
		}
		else if( _numberOfPlayers == 3){
			JLabel score1 = new JLabel(playerNames.get(0)+": "+_playeronecurscore+" points");
			JLabel score2 = new JLabel(playerNames.get(1)+": "+_playertwocurscore+" points");
			JLabel score3 = new JLabel(playerNames.get(2)+": "+_playerthreecurscore+" points");
			final JComponent[] inputs = new JComponent[]{
					score1,
					score2,
					score3
			};
			JOptionPane.showMessageDialog(null,inputs,"Display Score",JOptionPane.PLAIN_MESSAGE);
		}
		else if( _numberOfPlayers == 4){
			JLabel score1 = new JLabel(playerNames.get(0)+": "+_playeronecurscore+" points");
			JLabel score2 = new JLabel(playerNames.get(1)+": "+_playertwocurscore+" points");
			JLabel score3 = new JLabel(playerNames.get(2)+": "+_playerthreecurscore+" points");
			JLabel score4 = new JLabel(playerNames.get(3)+": "+_playerfourcurscore+" points");
			final JComponent[] inputs = new JComponent[]{
					score1,
					score2,
					score3,
					score4
			};
			JOptionPane.showMessageDialog(null,inputs,"Display Score",JOptionPane.PLAIN_MESSAGE);
		}
		else if( _numberOfPlayers == 5){
			JLabel score1 = new JLabel(playerNames.get(0)+": "+_playeronecurscore+" points");
			JLabel score2 = new JLabel(playerNames.get(1)+": "+_playertwocurscore+" points");
			JLabel score3 = new JLabel(playerNames.get(2)+": "+_playerthreecurscore+" points");
			JLabel score4 = new JLabel(playerNames.get(3)+": "+_playerfourcurscore+" points");
			JLabel score5 = new JLabel(playerNames.get(4)+": "+_playerfivecurscore+" points");
			final JComponent[] inputs = new JComponent[]{
					score1,
					score2,
					score3,
					score4,
					score5
			};
			JOptionPane.showMessageDialog(null,inputs,"Display Score",JOptionPane.PLAIN_MESSAGE);
		}
		else if( _numberOfPlayers == 6){
			JLabel score1 = new JLabel(playerNames.get(0)+": "+_playeronecurscore+" points");
			JLabel score2 = new JLabel(playerNames.get(1)+": "+_playertwocurscore+" points");
			JLabel score3 = new JLabel(playerNames.get(2)+": "+_playerthreecurscore+" points");
			JLabel score4 = new JLabel(playerNames.get(3)+": "+_playerfourcurscore+" points");
			JLabel score5 = new JLabel(playerNames.get(4)+": "+_playerfivecurscore+" points");
			JLabel score6 = new JLabel(playerNames.get(5)+": "+_playersixcurscore+" points");
			final JComponent[] inputs = new JComponent[]{
					score1,
					score2,
					score3,
					score4,
					score5,
					score6
			};
			JOptionPane.showMessageDialog(null,inputs,"Display Score",JOptionPane.PLAIN_MESSAGE);
		}
		else if( _numberOfPlayers == 7){
			JLabel score1 = new JLabel(playerNames.get(0)+": "+_playeronecurscore+" points");
			JLabel score2 = new JLabel(playerNames.get(1)+": "+_playertwocurscore+" points");
			JLabel score3 = new JLabel(playerNames.get(2)+": "+_playerthreecurscore+" points");
			JLabel score4 = new JLabel(playerNames.get(3)+": "+_playerfourcurscore+" points");
			JLabel score5 = new JLabel(playerNames.get(4)+": "+_playerfivecurscore+" points");
			JLabel score6 = new JLabel(playerNames.get(5)+": "+_playersixcurscore+" points");
			JLabel score7 = new JLabel(playerNames.get(6)+": "+_playersevencurscore+" points");
			final JComponent[] inputs = new JComponent[]{
					score1,
					score2,
					score3,
					score4,
					score5,
					score6,
					score7
			};
			JOptionPane.showMessageDialog(null,inputs,"Display Score",JOptionPane.PLAIN_MESSAGE);
		}
		else{
			JLabel score1 = new JLabel(playerNames.get(0)+": "+_playeronecurscore+" points");
			JLabel score2 = new JLabel(playerNames.get(1)+": "+_playertwocurscore+" points");
			JLabel score3 = new JLabel(playerNames.get(2)+": "+_playerthreecurscore+" points");
			JLabel score4 = new JLabel(playerNames.get(3)+": "+_playerfourcurscore+" points");
			JLabel score5 = new JLabel(playerNames.get(4)+": "+_playerfivecurscore+" points");
			JLabel score6 = new JLabel(playerNames.get(5)+": "+_playersixcurscore+" points");
			JLabel score7 = new JLabel(playerNames.get(6)+": "+_playersevencurscore+" points");
			JLabel score8 = new JLabel(playerNames.get(7)+": "+_playereightcurscore+" points");
			final JComponent[] inputs = new JComponent[]{
					score1,
					score2,
					score3,
					score4,
					score5,
					score6,
					score7,
					score8
			};
			JOptionPane.showMessageDialog(null,inputs,"Display Score",JOptionPane.PLAIN_MESSAGE);
		}
	}
}