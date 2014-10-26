/* This class holds the core structure of our game.  It creates the board as a  2d array, 
scans the console for user inputed commands, checks if tile placements can be made and if
they are legal, and calculates the scores of completed tracks.
 */

package code;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import util.general.CharacterFromFileReader;
import code.HelpfulImageMethods;

public class ScannerMan {
	private TilesCreator _tiles;
	char[][] _boardArray;
	private String _curTile;
	private int _curTurn;
	private int _locx;
	private int _locy;
	private boolean _hasPlaced;
	private boolean _invalidPlacement;
	private int _playerOneScore;
	private int _playerTwoScore;
	private int _playerThreeScore;
	private int _playerFourScore;
	private int _playerFiveScore;
	private int _playerSixScore;
	private int _playerSevenScore;
	private int _playerEightScore;
	private int _numberOfPlayers;
	private boolean ableToResign;
	private JFrame _frame;
	private int _width;
	private int _height;
	private JPanel _panel2;
	private String _boardrepresentation;
	private boolean canSave;
	public boolean _isGui;
	public String _fileName;
	public int _desiredInt;
	public String _tileLetters;
	public ArrayList<String> _playerNames;
	BufferedImage _guiTile;
	String topbordera;
	String bottombordere;
	String leftborderh;
	String rightborderd;//BORDER LETTER STRINGS

	/*This is the constructor method of the ScannerMan class.  When it is called, it creates the board and starts scanning the
	 *  console for input.  When it receives a valid command, it sets the appropriate variables (_locx and _locy) and runs 
	 *  the appropriate methods.
	 */
	public ScannerMan(int numberOfPlayers, boolean isGui, ArrayList<String> playerNames, boolean isSaved, int desiredInt) {
		_numberOfPlayers = numberOfPlayers;
		_playerNames = playerNames;
		_desiredInt = desiredInt;
		_isGui = isGui;
		canSave = true;
		ableToResign = false;
		if(isSaved){
			if(isGui){//Saved GUI, Just prints out a line of code right now
				System.out.println("GUI");
			}
			else{//Saved TUI
				_boardArray = new char[50][51];
				switch(_numberOfPlayers){
				case 2:
					topbordera = "ABABABABABAB";
					bottombordere = "BABABABABABA";
					leftborderh = "BABABABABABA";
					rightborderd = "ABABABABABAB";
					break;
				case 3:
					topbordera = "ABCABCABCABC";
					bottombordere = "CBACBACBACBA";
					leftborderh = "CBACBABCABCA";
					rightborderd = "ABCABCABCABC";
					break;
				case 4:
					topbordera = "ABCDABCDABCD";
					bottombordere = "DCBADCBADCBADCBA";
					leftborderh = "DCBADCBADCBA";
					rightborderd = "ABCDABCDABCD";
					break;
				case 5:
					topbordera = "ABCDEABCDEAB";
					bottombordere = "AEDCBAEDCBAE";
					leftborderh = "###EDCBAEDCB";
					rightborderd = "CDEABCDEABCD";
					break;
				case 6:
					topbordera = "ABCDEFABCDEF";
					bottombordere = "FEDCBAFEDCBA";
					leftborderh = "FEDCBAFEDCBA";
					rightborderd = "ABCDEFABCDEF";
					break;
				case 7:
					topbordera = "ABCDEFGABCDE";
					bottombordere = "AGFEDCBAGFED";
					leftborderh = "######GFEDCB";
					rightborderd = "FGABCDEFGABC";
					break;
				case 8:
					topbordera = "ABCDEFGHABCD";
					bottombordere = "DCBAHGFEDCBA";
					leftborderh = "HGFEDCBAHGFE";
					rightborderd = "EFGHABCDEFGH";
					break;
				}
				String topborderb = "^^^^^^^^^^^^";
				String bottomborderf = "vvvvvvvvvvvv";
				String leftborderg = "<<<<<<<<<<<<";
				String rightborderc = ">>>>>>>>>>>>";
				String topcenter = " v#  v# ";
				String bottomcenter = " #^  #^ ";
				String leftcenter = "#>  #> ";
				String rightcenter = "<#  <# ";
				for(int i = 0; i<50; i++){
					for(int j = 0; j<51; j++){
						_boardArray[i][j] = ' ';
					}
				}
				for(int k = 0; k<50;k++){
					_boardArray[k][50]= '\n';
				}
				for(int t1 = 2; t1 < 48; t1 = t1 + 4){
					_boardArray[0][t1] = topbordera.charAt((t1-2) / 4);
					_boardArray[49][t1] = bottomborderf.charAt((t1-2) / 4);
				}	
				for(int t2 = 3; t2 < 48; t2 = t2 + 4){
					_boardArray[0][t2] = topborderb.charAt((t2-3) / 4);
					_boardArray[49][t2] = bottombordere.charAt((t2-3)/4);
				}
				for(int l1 = 2; l1<48; l1 = l1+4){
					_boardArray[l1][0] = leftborderg.charAt((l1-2)/4);
					_boardArray[l1][49] = rightborderd.charAt((l1-2)/4);
				}
				for(int l2 = 3; l2 < 48; l2 = l2 + 4){
					_boardArray[l2][0] = leftborderh.charAt((l2-3) / 4);
					_boardArray[l2][49] = rightborderc.charAt((l2-3)/4);
				}
				for(int midtandb = 21; midtandb<29;midtandb++){
					_boardArray[21][midtandb] = topcenter.charAt(midtandb-21);
					_boardArray[28][midtandb] = bottomcenter.charAt(midtandb-21);;
				}
				for(int midlandr = 22; midlandr <28;midlandr++){
					_boardArray[midlandr][21] = leftcenter.charAt(midlandr-22);
					_boardArray[midlandr][28] = rightcenter.charAt(midlandr-22);;
				}
				String filename = new String();
				for(int i = 0; i<playerNames.size(); i++){
					filename += playerNames.get(i) + "-";
				}
				_fileName = filename;
				CharacterFromFileReader c = new CharacterFromFileReader("src/code/"+filename+ desiredInt + ".txt");
				String contentString = new String();
				int state = 1;
				while(c.hasNext()){
					char ch = c.next();
					switch(state){
					case 1:
						if(ch == '\n'){
							state = 2;
						}
						else{
							state = 1;
						}
						break;
					case 2:
						if(ch == '\n'){
							_curTile = contentString;
							contentString = "";
							state = 3;
						}
						else{
							contentString = contentString + ch;
							state = 2;
						}
						break;
					case 3:
						if(ch == '\n'){
							state = 4;
						}
						break;
					case 4:
						if(ch == '\n'){
							int contentInt = Integer.parseInt(contentString);
							_curTurn = contentInt;
							contentString = "";
							state = 5;
						}
						else{
							contentString = contentString + ch;
							state = 4;
						}
						break;
					case 5:
						if(ch == '\n'){
							state = 6;
						}
						break;
					case 6:
						if(ch == '\n'){
							int contentInt = Integer.parseInt(contentString);
							_playerOneScore = contentInt;
							contentString = "";
							state = 7;
						}
						else{
							contentString = contentString + ch;
							state = 6;
						}
						break;
					case 7:
						if(ch == '\n'){
							int contentInt = Integer.parseInt(contentString);
							_playerTwoScore = contentInt;
							contentString = "";
							state = 8;
						}
						else{
							contentString = contentString + ch;
							state = 7;
						}
						break;
					case 8:
						if(ch == '\n'){
							int contentInt = Integer.parseInt(contentString);
							_playerThreeScore = contentInt;
							contentString = "";
							state = 9;
						}
						else{
							contentString = contentString + ch;
							state = 8;
						}
						break;
					case 9:
						if(ch == '\n'){
							int contentInt = Integer.parseInt(contentString);
							_playerFourScore = contentInt;
							contentString = "";
							state = 10;
						}
						else{
							contentString = contentString + ch;
							state = 9;
						}
						break;
					case 10:
						if(ch == '\n'){
							int contentInt = Integer.parseInt(contentString);
							_playerFiveScore = contentInt;
							contentString = "";
							state = 11;
						}
						else{
							contentString = contentString + ch;
							state = 10;
						}
						break;
					case 11:
						if(ch == '\n'){
							int contentInt = Integer.parseInt(contentString);
							_playerSixScore = contentInt;
							contentString = "";
							state = 12;
						}
						else{
							contentString = contentString + ch;
							state = 11;
						}
						break;
					case 12:
						if(ch == '\n'){
							int contentInt = Integer.parseInt(contentString);
							_playerSevenScore = contentInt;
							contentString = "";
							state = 13;
						}
						else{
							contentString = contentString + ch;
							state = 12;
						}
						break;
					case 13:
						if(ch == '\n'){
							int contentInt = Integer.parseInt(contentString);
							_playerEightScore = contentInt;
							contentString = "";
							state = 14;
						}
						else{
							contentString = contentString + ch;
							state = 13;
						}
						break;
					case 14:
						if(ch == '\n'){
							state = 15;
						}
						break;
					case 15:
						if(ch == '\n'){
							_boardrepresentation = contentString;
						}
						else{
							contentString = contentString + ch;
							state = 15;
						}
						break;
					}
				}
				HashMap<String, String> tilesmap = new HashMap<String,String>();
				tilesmap.put("A", " 31 2  24  4 31 ");
				tilesmap.put("B", " 32 3  24  1 41 ");
				tilesmap.put("C", " 34 1  24  3 21 ");
				tilesmap.put("D", " 33 4  24  2 11 ");
				tilesmap.put("E", " 31 4  24  2 31 ");
				tilesmap.put("F", " 33 2  24  4 11 ");
				tilesmap.put("G", " 33 1  24  2 41 ");
				tilesmap.put("H", " 33 4  24  1 21 ");
				tilesmap.put("I", " 32 4  24  3 11 ");
				tilesmap.put("J", " 34 3  24  2 11 ");
				tilesmap.put("K", " 32 1  24  3 41 ");
				tilesmap.put("L", " 34 3  24  1 21 ");
				tilesmap.put("M", " 32 3  24  4 11 ");
				tilesmap.put("N", " 33 2  24  1 41 ");
				tilesmap.put("O", " 32 4  24  1 31 ");
				tilesmap.put("P", " 31 3  24  2 41 ");
				tilesmap.put("Q", " 34 1  24  2 31 ");
				tilesmap.put("R", " 33 1  24  4 21 ");
				tilesmap.put("S", " 34 2  24  3 11 ");
				tilesmap.put("T", " 31 4  24  3 21 ");
				tilesmap.put("U", " 32 1  24  4 31 ");
				tilesmap.put("V", " 34 2  24  1 31 ");
				tilesmap.put("W", " 31 3  24  4 21 ");
				tilesmap.put("X", " 31 2  24  3 41 ");
				int look = 0;
				String tileLetters = new String();
				for(int spoty = 1; spoty < 13; spoty++){
					for(int spotx = 1; spotx<13; spotx++){
						char tileLetter = _boardrepresentation.charAt(look++);
						String tileLetter2 = new String();
						tileLetter2 = tileLetter2 + tileLetter;
						if(tilesmap.containsKey(tileLetter2)){
							tileLetters = tileLetters + tileLetter2;
							new Place(spotx, spoty, tilesmap.get(tileLetter2), _boardArray);
							_tileLetters = tileLetters;
						}
					}
				}
				_tiles = new TilesCreator(tileLetters, _curTile);
				new ScoreDisplay(_numberOfPlayers, _playerOneScore, _playerTwoScore, _playerThreeScore, _playerFourScore, _playerFiveScore, _playerSixScore, _playerSevenScore, _playerEightScore, playerNames);
				new PlayerDisplay(_curTurn, _numberOfPlayers, playerNames);
				new TileDisplay(_curTile);
				new BoardDisplay(_boardArray);
				String name;
				Scanner input = new Scanner(System.in);
				while (input.hasNext()) {
					name = input.nextLine();
					if(placeIsName(name, _boardArray)){
						canSave = false;
					}
					/////////////////////////////////////////////////////////////////////////////////////////////////////divider for organization		
					else if (name.equals("display score")) {
						new ScoreDisplay(_numberOfPlayers, _playerOneScore, _playerTwoScore, _playerThreeScore, _playerFourScore, _playerFiveScore, _playerSixScore, _playerSevenScore, _playerEightScore, playerNames);
					}
					/////////////////////////////////////////////////////////////////////////////////////////////////////divider for organization			
					else if (name.equals("display player")) {
						new PlayerDisplay(_curTurn,_numberOfPlayers, playerNames);
					}	
					/////////////////////////////////////////////////////////////////////////////////////////////////////divider for organization			
					else if (name.equals("resign")) {
						if(ableToResign){
							int playerwhoresigned = 0;
							if(_numberOfPlayers == 2){
								if(_curTurn % 2 == 0){
									playerwhoresigned = 1;
								}
								else{
									playerwhoresigned = 2;
								}
							}
							else if(_numberOfPlayers == 3){
								if(_curTurn % 3 == 0){
									playerwhoresigned = 1;
								}
								else if(_curTurn %3 == 1){
									playerwhoresigned = 2;
								}
								else{
									playerwhoresigned = 3;
								}	
							}
							else if(_numberOfPlayers == 4){
								if(_curTurn % 4 == 0){
									playerwhoresigned = 1;
								}
								else if(_curTurn %4 == 1){
									playerwhoresigned = 2;
								}
								else if(_curTurn%4 == 2){
									playerwhoresigned = 3;
								}
								else{
									playerwhoresigned = 4;
								}
							}
							else if(_numberOfPlayers == 5){
								if(_curTurn % 5 == 0){
									playerwhoresigned = 1;
								}
								else if(_curTurn %5 == 1){
									playerwhoresigned = 2;
								}
								else if(_curTurn%5 == 2){
									playerwhoresigned = 3;
								}
								else if(_curTurn%5 == 3){
									playerwhoresigned = 4;
								}
								else{
									playerwhoresigned = 5;
								}
							}
							else if(_numberOfPlayers == 6){
								if(_curTurn % 6 == 0){
									playerwhoresigned = 1;
								}
								else if(_curTurn %6 == 1){
									playerwhoresigned = 2;
								}
								else if(_curTurn%6 == 2){
									playerwhoresigned = 3;
								}
								else if(_curTurn%6 == 3){
									playerwhoresigned = 4;
								}
								else if(_curTurn%6 == 4){
									playerwhoresigned = 5;
								}
								else{
									playerwhoresigned = 6;
								}
							}
							else if(_numberOfPlayers == 7){
								if(_curTurn % 7 == 0){
									playerwhoresigned = 1;
								}
								else if(_curTurn %7 == 1){
									playerwhoresigned = 2;
								}
								else if(_curTurn%7 == 2){
									playerwhoresigned = 3;
								}
								else if(_curTurn%7 == 3){
									playerwhoresigned = 4;
								}
								else if(_curTurn%7 == 4){
									playerwhoresigned = 5;
								}
								else if(_curTurn%7 == 5){
									playerwhoresigned = 6;
								}
								else{
									playerwhoresigned = 7;
								}
							}
							else if(_numberOfPlayers == 8){
								if(_curTurn % 8 == 0){
									playerwhoresigned = 1;
								}
								else if(_curTurn %8 == 1){
									playerwhoresigned = 2;
								}
								else if(_curTurn%8 == 2){
									playerwhoresigned = 3;
								}
								else if(_curTurn%8 == 3){
									playerwhoresigned = 4;
								}
								else if(_curTurn%8 == 4){
									playerwhoresigned = 5;
								}
								else if(_curTurn%8 == 5){
									playerwhoresigned = 6;
								}
								else if(_curTurn%8 == 6){
									playerwhoresigned = 7;
								}
								else{
									playerwhoresigned = 8;
								}
							}	
							new Resign(playerwhoresigned, _playerOneScore, _playerTwoScore, _playerThreeScore, _playerFourScore, _playerFiveScore, _playerSixScore, _playerSevenScore, _playerEightScore, playerNames);
						}
						else{
							System.out.println("Oh Come On! You Haven't Even Started The Game Yet");
						}
					}
					/////////////////////////////////////////////////////////////////////////////////////////////////////divider for organization			
					else if (name.equals("remove")) {
						if(_hasPlaced){
							new Place(_locx, _locy, "                ", _boardArray);
							canSave = true;
							_hasPlaced = false;
						}
						else{
							System.out.println("You cannot remove; you have not placed your tile yet");
						}
					}
					/////////////////////////////////////////////////////////////////////////////////////////////////////divider for organization			
					else if (name.equals("commit")) {
						if(_hasPlaced == true){
							if(_invalidPlacement == false){
								ableToResign = true;
								canSave = true;
								// 1 = North         2 = East                  3 = South               4 = West
								if(_numberOfPlayers == 2){
									_playerOneScore = scorePath(1, 1, 3, _boardArray) + scorePath(9, 1, 3, _boardArray) + scorePath(17, 1, 3, _boardArray) + scorePath(25, 1, 3, _boardArray) + scorePath(33, 1, 3, _boardArray) + scorePath(41, 1, 3, _boardArray) + scorePath(45, 1, 4, _boardArray) + scorePath(45, 9, 4, _boardArray) + scorePath(45, 17, 4, _boardArray) + scorePath(45, 25, 4, _boardArray) + scorePath(45, 33, 4, _boardArray) + scorePath(45, 41, 4, _boardArray) + scorePath(45, 45, 1, _boardArray) + scorePath(37, 45, 1, _boardArray) + scorePath(29, 45, 1, _boardArray) + scorePath(21, 45, 1, _boardArray) + scorePath(13, 45, 1, _boardArray) + scorePath(5, 45, 1, _boardArray) + scorePath(1, 45, 2, _boardArray) + scorePath(1, 37, 2, _boardArray) + scorePath(1, 29, 2, _boardArray) + scorePath(1, 21, 2, _boardArray) + scorePath(1, 13, 2, _boardArray) + scorePath(1, 5, 2, _boardArray);
									_playerTwoScore = scorePath(5, 1, 3, _boardArray) + scorePath(13, 1, 3, _boardArray) + scorePath(21, 1, 3, _boardArray) + scorePath(29, 1, 3, _boardArray) + scorePath(37, 1, 3, _boardArray) + scorePath(45, 1, 3, _boardArray) + scorePath(45, 5, 4, _boardArray) + scorePath(45, 13, 4, _boardArray) + scorePath(45, 21, 4, _boardArray) + scorePath(45, 29, 4, _boardArray) + scorePath(45, 37, 4, _boardArray) + scorePath(45, 45, 4, _boardArray) + scorePath(41, 45, 1, _boardArray) + scorePath(33, 45, 1, _boardArray) + scorePath(25, 45, 1, _boardArray) + scorePath(17, 45, 1, _boardArray) + scorePath(9, 45, 1, _boardArray) + scorePath(1, 45, 1, _boardArray) + scorePath(1, 41, 2, _boardArray) + scorePath(1, 33, 2, _boardArray) + scorePath(1, 25, 2, _boardArray) + scorePath(1, 17, 2, _boardArray) + scorePath(1, 9, 2, _boardArray) + scorePath(1, 1, 2, _boardArray);
									_playerThreeScore = -1;
									_playerFourScore = -1;
									_playerFiveScore = -1;
									_playerSixScore = -1;
									_playerSevenScore = -1;
									_playerEightScore = -1;
								}
								else if(_numberOfPlayers == 3){
									_playerOneScore = scorePath(1, 1, 3, _boardArray) + scorePath(13, 1, 3, _boardArray) + scorePath(25, 1, 3, _boardArray) + scorePath(37, 1, 3, _boardArray) + scorePath(45, 1, 4, _boardArray) + scorePath(45, 13, 4, _boardArray) + scorePath(45, 25, 4, _boardArray) + scorePath(45, 37, 4, _boardArray) + scorePath(45, 45, 1, _boardArray) + scorePath(33, 45, 1, _boardArray) + scorePath(21, 45, 1, _boardArray) + scorePath(9, 45, 1, _boardArray) + scorePath(1, 45, 2, _boardArray) + scorePath(1, 33, 2, _boardArray) + scorePath(1, 21, 2, _boardArray) + scorePath(1, 9, 2, _boardArray);
									_playerTwoScore = scorePath(5, 1, 3, _boardArray) + scorePath(17, 1, 3, _boardArray) + scorePath(29, 1, 3, _boardArray) + scorePath(41, 1, 3, _boardArray) + scorePath(45, 5, 4, _boardArray) + scorePath(45, 17, 4, _boardArray) + scorePath(45, 29, 4, _boardArray) + scorePath(45, 41, 4, _boardArray) + scorePath(41, 45, 1, _boardArray) + scorePath(29, 45, 1, _boardArray) + scorePath(17, 45, 1, _boardArray) + scorePath(5, 45, 1, _boardArray) + scorePath(1, 41, 2, _boardArray) + scorePath(1, 29, 2, _boardArray) + scorePath(1, 17, 2, _boardArray) + scorePath(1, 5, 2, _boardArray);
									_playerThreeScore = scorePath(9, 1, 3, _boardArray) + scorePath(21, 1, 3, _boardArray) + scorePath(33, 1, 3, _boardArray) + scorePath(45, 1, 3, _boardArray) + scorePath(45, 9, 4, _boardArray) + scorePath(45, 21, 4, _boardArray) + scorePath(45, 33, 4, _boardArray) + scorePath(45, 45, 4, _boardArray) + scorePath(37, 45, 1, _boardArray) + scorePath(25, 45, 1, _boardArray) + scorePath(13, 45, 1, _boardArray) + scorePath(1, 45, 1, _boardArray) + scorePath(1, 37, 2, _boardArray) + scorePath(1, 25, 2, _boardArray) + scorePath(1, 13, 2, _boardArray) + scorePath(1, 1, 2, _boardArray);
									_playerFourScore = -1;
									_playerFiveScore = -1;
									_playerSixScore = -1;
									_playerSevenScore = -1;
									_playerEightScore = -1;
								}
								else if(_numberOfPlayers == 4){
									_playerOneScore = scorePath(1, 1, 3, _boardArray) + scorePath(17, 1, 3, _boardArray) + scorePath(33, 1, 3, _boardArray) + scorePath(45, 1, 4, _boardArray) + scorePath(45, 17, 4, _boardArray) + scorePath(45, 33, 4, _boardArray) + scorePath(45, 45, 1, _boardArray) + scorePath(29, 45, 1, _boardArray) + scorePath(13, 45, 1, _boardArray) + scorePath(1, 45, 2, _boardArray) + scorePath(1, 29, 2, _boardArray) + scorePath(1, 13, 2, _boardArray);
									_playerTwoScore = scorePath(5, 1, 3, _boardArray) + scorePath(21, 1, 3, _boardArray) + scorePath(37, 1, 3, _boardArray) + scorePath(45, 5, 4, _boardArray) + scorePath(45, 21, 4, _boardArray) + scorePath(45, 37, 4, _boardArray) + scorePath(41, 45, 1, _boardArray) + scorePath(25, 45, 1, _boardArray) + scorePath(9, 45, 1, _boardArray) + scorePath(1, 41, 2, _boardArray) + scorePath(1, 25, 2, _boardArray) + scorePath(1, 9, 2, _boardArray);
									_playerThreeScore = scorePath(9, 1, 3, _boardArray) + scorePath(25, 1, 3, _boardArray) + scorePath(41, 1, 3, _boardArray) + scorePath(45, 9, 4, _boardArray) + scorePath(45, 25, 4, _boardArray) + scorePath(45, 41, 4, _boardArray) + scorePath(37, 45, 1, _boardArray) + scorePath(21, 45, 1, _boardArray) + scorePath(5, 45, 1, _boardArray) + scorePath(1, 37, 2, _boardArray) + scorePath(1, 21, 2, _boardArray) + scorePath(1, 5, 2, _boardArray);
									_playerFourScore = scorePath(13, 1, 3, _boardArray) + scorePath(29, 1, 3, _boardArray) + scorePath(45, 1, 3, _boardArray) + scorePath(45, 13, 4, _boardArray) + scorePath(45, 29, 4, _boardArray) + scorePath(45, 45, 4, _boardArray) + scorePath(33, 45, 1, _boardArray) + scorePath(17, 45, 1, _boardArray) + scorePath(1, 45, 1, _boardArray) + scorePath(1, 33, 2, _boardArray) + scorePath(1, 17, 2, _boardArray) + scorePath(1, 1, 2, _boardArray);
									_playerFiveScore = -1;
									_playerSixScore = -1;
									_playerSevenScore = -1;
									_playerEightScore = -1;
								}
								else if(_numberOfPlayers == 5){
									_playerOneScore = scorePath(1, 1, 3, _boardArray) + scorePath(21, 1, 3, _boardArray) + scorePath(41, 1, 3, _boardArray) + scorePath(45, 13, 4, _boardArray) + scorePath(45, 33, 4, _boardArray) + scorePath(41, 45, 1, _boardArray) + scorePath(21, 45, 1, _boardArray) + scorePath(1, 45, 1, _boardArray) + scorePath(1, 29, 2, _boardArray);
									_playerTwoScore = scorePath(5, 1, 3, _boardArray) + scorePath(25, 1, 3, _boardArray) + scorePath(45, 1, 3, _boardArray) + scorePath(45, 17, 4, _boardArray) + scorePath(45, 37, 4, _boardArray) + scorePath(37, 45, 1, _boardArray) + scorePath(17, 45, 1, _boardArray) + scorePath(1, 45, 2, _boardArray) + scorePath(1, 25, 2, _boardArray);
									_playerThreeScore = scorePath(9, 1, 3, _boardArray) + scorePath(29, 1, 3, _boardArray) + scorePath(45, 1, 4, _boardArray) + scorePath(45, 21, 4, _boardArray) + scorePath(45, 41, 4, _boardArray) + scorePath(33, 45, 1, _boardArray) + scorePath(13, 45, 1, _boardArray) + scorePath(1, 41, 2, _boardArray) + scorePath(1, 21, 2, _boardArray);
									_playerFourScore = scorePath(13, 1, 3, _boardArray) + scorePath(33, 1, 3, _boardArray) + scorePath(45, 5, 4, _boardArray) + scorePath(45, 25, 4, _boardArray) + scorePath(45, 45, 4, _boardArray) + scorePath(29, 45, 1, _boardArray) + scorePath(9, 45, 1, _boardArray) + scorePath(1, 37, 2, _boardArray) + scorePath(1, 17, 2, _boardArray);
									_playerFiveScore = scorePath(17, 1, 3, _boardArray) + scorePath(37, 1, 3, _boardArray) + scorePath(45, 9, 4, _boardArray) + scorePath(45, 29, 4, _boardArray) + scorePath(45, 45, 1, _boardArray) + scorePath(25, 45, 1, _boardArray) + scorePath(5, 45, 1, _boardArray) + scorePath(1, 33, 2, _boardArray) + scorePath(1, 13, 2, _boardArray);
									_playerSixScore = -1;
									_playerSevenScore = -1;
									_playerEightScore = -1;
								}
								else if(_numberOfPlayers == 6){
									_playerOneScore = scorePath(1, 1, 3, _boardArray) + scorePath(25, 1, 3, _boardArray) + scorePath(45, 1, 4, _boardArray) + scorePath(45, 25, 4, _boardArray) + scorePath(45, 45, 1, _boardArray) + scorePath(21, 45, 1, _boardArray) + scorePath(1, 45, 2, _boardArray) + scorePath(1, 21, 2, _boardArray);
									_playerTwoScore = scorePath(5, 1, 3, _boardArray) + scorePath(29, 1, 3, _boardArray) + scorePath(45, 5, 4, _boardArray) + scorePath(45, 29, 4, _boardArray) + scorePath(41, 45, 1, _boardArray) + scorePath(17, 45, 1, _boardArray) + scorePath(1, 41, 2, _boardArray) + scorePath(1, 17, 2, _boardArray);
									_playerThreeScore = scorePath(9, 1, 3, _boardArray) + scorePath(33, 1, 3, _boardArray) + scorePath(45, 9, 4, _boardArray) + scorePath(45, 33, 4, _boardArray) + scorePath(37, 45, 1, _boardArray) + scorePath(13, 45, 1, _boardArray) + scorePath(1, 37, 2, _boardArray) + scorePath(1, 13, 2, _boardArray);
									_playerFourScore = scorePath(13, 1, 3, _boardArray) + scorePath(37, 1, 3, _boardArray) + scorePath(45, 13, 4, _boardArray) + scorePath(45, 37, 4, _boardArray) + scorePath(33, 45, 1, _boardArray) + scorePath(9, 45, 1, _boardArray) + scorePath(1, 33, 2, _boardArray) + scorePath(1, 9, 2, _boardArray);
									_playerFiveScore = scorePath(17, 1, 3, _boardArray) + scorePath(41, 1, 3, _boardArray) + scorePath(45, 17, 4, _boardArray) + scorePath(45, 41, 4, _boardArray) + scorePath(29, 45, 1, _boardArray) + scorePath(5, 45, 1, _boardArray) + scorePath(1, 29, 2, _boardArray) + scorePath(1, 5, 2, _boardArray);
									_playerSixScore = scorePath(21, 1, 3, _boardArray) + scorePath(45, 1, 3, _boardArray) + scorePath(45, 21, 4, _boardArray) + scorePath(45, 45, 4, _boardArray) + scorePath(25, 45, 1, _boardArray) + scorePath(1, 45, 1, _boardArray) + scorePath(1, 25, 2, _boardArray) + scorePath(1, 1, 2, _boardArray);
									_playerSevenScore = -1;
									_playerEightScore = -1;
								}
								else if(_numberOfPlayers == 7){
									_playerOneScore = scorePath(1, 1, 3, _boardArray) + scorePath(29, 1, 3, _boardArray) + scorePath(45, 9, 4, _boardArray) + scorePath(45, 37, 4, _boardArray) + scorePath(29, 45, 1, _boardArray) + scorePath(1, 45, 1, _boardArray);
									_playerTwoScore = scorePath(5, 1, 3, _boardArray) + scorePath(33, 1, 3, _boardArray) + scorePath(45, 13, 4, _boardArray) + scorePath(45, 41, 4, _boardArray) + scorePath(25, 45, 1, _boardArray) + scorePath(1, 45, 2, _boardArray);
									_playerThreeScore = scorePath(9, 1, 3, _boardArray) + scorePath(37, 1, 3, _boardArray) + scorePath(45, 17, 4, _boardArray) + scorePath(45, 45, 4, _boardArray) + scorePath(21, 45, 1, _boardArray) + scorePath(1, 41, 2, _boardArray);
									_playerFourScore = scorePath(13, 1, 3, _boardArray) + scorePath(41, 1, 3, _boardArray) + scorePath(45, 21, 4, _boardArray) + scorePath(45, 45, 1, _boardArray) + scorePath(17, 45, 1, _boardArray) + scorePath(1, 37, 2, _boardArray);
									_playerFiveScore = scorePath(17, 1, 3, _boardArray) + scorePath(45, 1, 3, _boardArray) + scorePath(45, 25, 4, _boardArray) + scorePath(41, 45, 1, _boardArray) + scorePath(13, 45, 1, _boardArray) + scorePath(1, 33, 2, _boardArray);
									_playerSixScore = scorePath(21, 1, 3, _boardArray) + scorePath(45, 1, 4, _boardArray) + scorePath(45, 29, 4, _boardArray) + scorePath(37, 45, 1, _boardArray) + scorePath(9, 45, 1, _boardArray) + scorePath(1, 29, 2, _boardArray);
									_playerSevenScore = scorePath(25, 1, 3, _boardArray) + scorePath(45, 5, 4, _boardArray) + scorePath(45, 33, 4, _boardArray) + scorePath(33, 45, 1, _boardArray) + scorePath(5, 45, 1, _boardArray) + scorePath(1, 25, 2, _boardArray);
									_playerEightScore = -1;
								}
								else{
									_playerOneScore = scorePath(1, 1, 3, _boardArray) + scorePath(33, 1, 3, _boardArray) + scorePath(45, 17, 4, _boardArray) + scorePath(45, 45, 1, _boardArray) + scorePath(13, 45, 1, _boardArray) + scorePath(1, 29, 2, _boardArray);
									_playerTwoScore = scorePath(5, 1, 3, _boardArray) + scorePath(37, 1, 3, _boardArray) + scorePath(45, 21, 4, _boardArray) + scorePath(41, 45, 1, _boardArray) + scorePath(9, 45, 1, _boardArray) + scorePath(1, 25, 2, _boardArray);
									_playerThreeScore = scorePath(9, 1, 3, _boardArray) + scorePath(41, 1, 3, _boardArray) + scorePath(45, 25, 4, _boardArray) + scorePath(37, 45, 1, _boardArray) + scorePath(5, 45, 1, _boardArray) + scorePath(1, 21, 2, _boardArray);
									_playerFourScore = scorePath(13, 1, 3, _boardArray) + scorePath(45, 1, 3, _boardArray) + scorePath(45, 29, 4, _boardArray) + scorePath(33, 45, 1, _boardArray) + scorePath(1, 45, 1, _boardArray) + scorePath(1, 17, 2, _boardArray);
									_playerFiveScore = scorePath(17, 1, 3, _boardArray) + scorePath(45, 1, 4, _boardArray) + scorePath(45, 33, 4, _boardArray) + scorePath(29, 45, 1, _boardArray) + scorePath(1, 45, 2, _boardArray) + scorePath(1, 13, 2, _boardArray);
									_playerSixScore = scorePath(21, 1, 3, _boardArray) + scorePath(45, 5, 4, _boardArray) + scorePath(45, 37, 4, _boardArray) + scorePath(25, 45, 1, _boardArray) + scorePath(1, 41, 2, _boardArray) + scorePath(1, 9, 2, _boardArray);
									_playerSevenScore = scorePath(25, 1, 3, _boardArray) + scorePath(45, 9, 4, _boardArray) + scorePath(45, 41, 4, _boardArray) + scorePath(21, 45, 1, _boardArray) + scorePath(1, 37, 2, _boardArray) + scorePath(1, 5, 2, _boardArray);
									_playerEightScore = scorePath(29, 1, 3, _boardArray) + scorePath(45, 13, 4, _boardArray) + scorePath(45, 45, 4, _boardArray) + scorePath(17, 45, 1, _boardArray) + scorePath(1, 33, 2, _boardArray) + scorePath(1, 1, 2, _boardArray);
								}
								_curTurn++;
								if(_curTurn == 140){
									File savedGame = new File("src/code/"+filename+ desiredInt + ".txt");
									savedGame.delete();
									int i = 1;
									while((new File("src/code/"+filename + (desiredInt + i) + ".txt")).exists()){
										File toBeRenamed = new File("src/code/"+filename + (desiredInt + i) + ".txt");
										File newFile = new File("src/code/"+filename + ((desiredInt + i)-1) + ".txt");
										toBeRenamed.renameTo(newFile);
										i++;
									}
									new ScoreDisplay(_numberOfPlayers, _playerOneScore, _playerTwoScore, _playerThreeScore, _playerFourScore, _playerFiveScore, _playerSixScore, _playerSevenScore, _playerEightScore, playerNames);
									new BoardDisplay(_boardArray);
									new GameOver(_playerOneScore, _playerTwoScore, _playerThreeScore, _playerFourScore, _playerFiveScore, _playerSixScore, _playerSevenScore, _playerEightScore, playerNames);
								}
								else{
									_curTile = _tiles.get(_curTurn - (tileLetters.length()+1));
									_hasPlaced = false;
									new ScoreDisplay(_numberOfPlayers, _playerOneScore, _playerTwoScore, _playerThreeScore, _playerFourScore, _playerFiveScore, _playerSixScore, _playerSevenScore, _playerEightScore, playerNames);
									new PlayerDisplay(_curTurn,_numberOfPlayers, playerNames);
									new TileDisplay(_curTile);
									new BoardDisplay(_boardArray);
								}
							}
							else{
								System.out.println("You still have an invalid placement, please remove your tile");
							}
						}
					}
					/////////////////////////////////////////////////////////////////////////////////////////////////////divider for organization			
					else if (name.equals("display tile")) {
						new TileDisplay(_curTile);
					}

					/////////////////////////////////////////////////////////////////////////////////////////////////////divider for organization			
					else if (name.equals("display board")) {
						new BoardDisplay(_boardArray);
					}
					/////////////////////////////////////////////////////////////////////////////////////////////////////divider for organization			
					else if (name.equals("save")) {
						if(canSave){
							String allTiles = new String();
							HashMap<String, String> tilesmap1 = new HashMap<String, String>();
							tilesmap1.put(" 31 2  24  4 31 ", "A");
							tilesmap1.put(" 32 3  24  1 41 ", "B");
							tilesmap1.put(" 34 1  24  3 21 ", "C");
							tilesmap1.put(" 33 4  24  2 11 ", "D");
							tilesmap1.put(" 31 4  24  2 31 ", "E");
							tilesmap1.put(" 33 2  24  4 11 ", "F");
							tilesmap1.put(" 33 1  24  2 41 ", "G");
							tilesmap1.put(" 33 4  24  1 21 ", "H");
							tilesmap1.put(" 32 4  24  3 11 ", "I");
							tilesmap1.put(" 34 3  24  2 11 ", "J");
							tilesmap1.put(" 32 1  24  3 41 ", "K");
							tilesmap1.put(" 34 3  24  1 21 ", "L");
							tilesmap1.put(" 32 3  24  4 11 ", "M");
							tilesmap1.put(" 33 2  24  1 41 ", "N");
							tilesmap1.put(" 32 4  24  1 31 ", "O");
							tilesmap1.put(" 31 3  24  2 41 ", "P");
							tilesmap1.put(" 34 1  24  2 31 ", "Q");
							tilesmap1.put(" 33 1  24  4 21 ", "R");
							tilesmap1.put(" 34 2  24  3 11 ", "S");
							tilesmap1.put(" 31 4  24  3 21 ", "T");
							tilesmap1.put(" 32 1  24  4 31 ", "U");
							tilesmap1.put(" 34 2  24  1 31 ", "V");
							tilesmap1.put(" 31 3  24  4 21 ", "W");
							tilesmap1.put(" 31 2  24  3 41 ", "X");
							tilesmap1.put(" v# #   >       ", "#");
							tilesmap1.put(" v#    <   #    ", "#");
							tilesmap1.put("    #   >    #^ ", "#");
							tilesmap1.put("       <   # #^ ", "#");
							for(int row = 1; row < 13; row++){
								for(int col = 1; col < 13; col++){
									String tile = new String();
									int x = (4*(col - 1) +1);
									int y = (4*(row - 1) +1);
									for(int spacey = 0; spacey <= 3; spacey++){
										for(int spacex = 0; spacex <= 3; spacex++){
											tile = tile + _boardArray[y + spacey][x + spacex];
										}
									}
									if(tilesmap1.containsKey(tile)){
										allTiles = allTiles + tilesmap1.get(tile);
									}
									else{
										allTiles = allTiles + "-";
									}
								}
							}
							File f = new File("src/code/"+filename+ desiredInt + ".txt");
							f.delete();
							try { f.createNewFile(); } catch(Exception e) {}
							try{
								PrintWriter out = new PrintWriter(new FileWriter("src/code/"+filename+ desiredInt + ".txt"));
								out.println("Saved Tile:");
								out.println(_curTile);
								out.println("Saved Turn:");
								out.println(_curTurn);
								out.println("Saved Scores:");
								out.println(_playerOneScore);
								out.println(_playerTwoScore);
								out.println(_playerThreeScore);
								out.println(_playerFourScore);
								out.println(_playerFiveScore);
								out.println(_playerSixScore);
								out.println(_playerSevenScore);
								out.println(_playerEightScore);
								out.println("Saved Board:");
								out.println(allTiles);
								out.close();
							}
							catch(Exception e){}
							System.out.println("Your Game Saved Successfully");
							input.close();
							break;
						}
						else{
							System.out.println("You Can't Save A Game During The Middle Of A Move");
						}
					}
					/////////////////////////////////////////////////////////////////////////////////////////////////////divider for organization			
					else {
						System.out.println("I'm sorry, I didn't quite catch that. Try again!");
					}
				}
			}
		}
		
		
///////////////////////////////////////////////////////////////NOT   vv    SAVED//////////////////////////////////////////		
		
		
		else{//Not Saved, new Game
				String s = new String();
				String str = new String();
				_tiles = new TilesCreator(s, str);
				_curTile = _tiles.get(0);
				_curTurn = 0;
				_locx = 0;
				_locy = 0;
				_hasPlaced = false;
				_invalidPlacement = false;
				_numberOfPlayers = numberOfPlayers;
				_boardArray = new char[50][51];
				switch(_numberOfPlayers){
				case 2:
					topbordera = "ABABABABABAB";
					bottombordere = "BABABABABABA";
					leftborderh = "BABABABABABA";
					rightborderd = "ABABABABABAB";
					break;
				case 3:
					topbordera = "ABCABCABCABC";
					bottombordere = "CBACBACBACBA";
					leftborderh = "CBACBABCABCA";
					rightborderd = "ABCABCABCABC";
					break;
				case 4:
					topbordera = "ABCDABCDABCD";
					bottombordere = "DCBADCBADCBADCBA";
					leftborderh = "DCBADCBADCBA";
					rightborderd = "ABCDABCDABCD";
					break;
				case 5:
					topbordera = "ABCDEABCDEAB";
					bottombordere = "AEDCBAEDCBAE";
					leftborderh = "###EDCBAEDCB";
					rightborderd = "CDEABCDEABCD";
					break;
				case 6:
					topbordera = "ABCDEFABCDEF";
					bottombordere = "FEDCBAFEDCBA";
					leftborderh = "FEDCBAFEDCBA";
					rightborderd = "ABCDEFABCDEF";
					break;
				case 7:
					topbordera = "ABCDEFGABCDE";
					bottombordere = "AGFEDCBAGFED";
					leftborderh = "######GFEDCB";
					rightborderd = "FGABCDEFGABC";
					break;
				case 8:
					topbordera = "ABCDEFGHABCD";
					bottombordere = "DCBAHGFEDCBA";
					leftborderh = "HGFEDCBAHGFE";
					rightborderd = "EFGHABCDEFGH";
					break;
				}
				String topborderb = "^^^^^^^^^^^^";
				String bottomborderf = "vvvvvvvvvvvv";
				String leftborderg = "<<<<<<<<<<<<";
				String rightborderc = ">>>>>>>>>>>>";
				String topcenter = " v#  v# ";
				String bottomcenter = " #^  #^ ";
				String leftcenter = "#>  #> ";
				String rightcenter = "<#  <# ";
				for(int i = 0; i<50; i++){
					for(int j = 0; j<51; j++){
						_boardArray[i][j] = ' ';
					}
				}
				for(int k = 0; k<50;k++){
					_boardArray[k][50]= '\n';
				}
				for(int t1 = 2; t1 < 48; t1 = t1 + 4){
					_boardArray[0][t1] = topbordera.charAt((t1-2) / 4);
					_boardArray[49][t1] = bottomborderf.charAt((t1-2) / 4);
				}	
				for(int t2 = 3; t2 < 48; t2 = t2 + 4){
					_boardArray[0][t2] = topborderb.charAt((t2-3) / 4);
					_boardArray[49][t2] = bottombordere.charAt((t2-3)/4);
				}
				for(int l1 = 2; l1<48; l1 = l1+4){
					_boardArray[l1][0] = leftborderg.charAt((l1-2)/4);
					_boardArray[l1][49] = rightborderd.charAt((l1-2)/4);
				}
				for(int l2 = 3; l2 < 48; l2 = l2 + 4){
					_boardArray[l2][0] = leftborderh.charAt((l2-3) / 4);
					_boardArray[l2][49] = rightborderc.charAt((l2-3)/4);
				}
				for(int midtandb = 21; midtandb<29;midtandb++){
					_boardArray[21][midtandb] = topcenter.charAt(midtandb-21);
					_boardArray[28][midtandb] = bottomcenter.charAt(midtandb-21);;
				}
				for(int midlandr = 22; midlandr <28;midlandr++){
					_boardArray[midlandr][21] = leftcenter.charAt(midlandr-22);
					_boardArray[midlandr][28] = rightcenter.charAt(midlandr-22);;
				}
				new ScoreDisplay(_numberOfPlayers, _playerOneScore, _playerTwoScore, _playerThreeScore, _playerFourScore, _playerFiveScore, _playerSixScore, _playerSevenScore, _playerEightScore, playerNames);
				new PlayerDisplay(_curTurn, _numberOfPlayers, playerNames);
				new TileDisplay(_curTile);
				new BoardDisplay(_boardArray);
				String name;
				Scanner input = new Scanner(System.in);
				if(isGui){
					stringToImage(_curTile);
					createAndShowGUI("tileGUIPictures/" + _numberOfPlayers +" players.png", _playerOneScore, _playerTwoScore, _playerThreeScore, _playerFourScore, _playerFiveScore, _playerSixScore, _playerSevenScore, _playerEightScore, playerNames, _curTurn);
				}
				while (input.hasNext()) {
					name = input.nextLine();
					if(placeIsName(name, _boardArray)){
						canSave = false;
					}
					/////////////////////////////////////////////////////////////////////////////////////////////////////divider for organization		
					else if (name.equals("display score")) {
						new ScoreDisplay(_numberOfPlayers, _playerOneScore, _playerTwoScore, _playerThreeScore, _playerFourScore, _playerFiveScore, _playerSixScore, _playerSevenScore, _playerEightScore, playerNames);
					}
					/////////////////////////////////////////////////////////////////////////////////////////////////////divider for organization			
					else if (name.equals("display player")) {
						new PlayerDisplay(_curTurn,_numberOfPlayers, playerNames);
					}	
					/////////////////////////////////////////////////////////////////////////////////////////////////////divider for organization			
					else if (name.equals("resign")) {
						if(ableToResign){
							int playerwhoresigned = 0;
							if(_numberOfPlayers == 2){
								if(_curTurn % 2 == 0){
									playerwhoresigned = 1;
								}
								else{
									playerwhoresigned = 2;
								}
							}
							else if(_numberOfPlayers == 3){
								if(_curTurn % 3 == 0){
									playerwhoresigned = 1;
								}
								else if(_curTurn %3 == 1){
									playerwhoresigned = 2;
								}
								else{
									playerwhoresigned = 3;
								}	
							}
							else if(_numberOfPlayers == 4){
								if(_curTurn % 4 == 0){
									playerwhoresigned = 1;
								}
								else if(_curTurn %4 == 1){
									playerwhoresigned = 2;
								}
								else if(_curTurn%4 == 2){
									playerwhoresigned = 3;
								}
								else{
									playerwhoresigned = 4;
								}
							}
							else if(_numberOfPlayers == 5){
								if(_curTurn % 5 == 0){
									playerwhoresigned = 1;
								}
								else if(_curTurn %5 == 1){
									playerwhoresigned = 2;
								}
								else if(_curTurn%5 == 2){
									playerwhoresigned = 3;
								}
								else if(_curTurn%5 == 3){
									playerwhoresigned = 4;
								}
								else{
									playerwhoresigned = 5;
								}
							}
							else if(_numberOfPlayers == 6){
								if(_curTurn % 6 == 0){
									playerwhoresigned = 1;
								}
								else if(_curTurn %6 == 1){
									playerwhoresigned = 2;
								}
								else if(_curTurn%6 == 2){
									playerwhoresigned = 3;
								}
								else if(_curTurn%6 == 3){
									playerwhoresigned = 4;
								}
								else if(_curTurn%6 == 4){
									playerwhoresigned = 5;
								}
								else{
									playerwhoresigned = 6;
								}
							}
							else if(_numberOfPlayers == 7){
								if(_curTurn % 7 == 0){
									playerwhoresigned = 1;
								}
								else if(_curTurn %7 == 1){
									playerwhoresigned = 2;
								}
								else if(_curTurn%7 == 2){
									playerwhoresigned = 3;
								}
								else if(_curTurn%7 == 3){
									playerwhoresigned = 4;
								}
								else if(_curTurn%7 == 4){
									playerwhoresigned = 5;
								}
								else if(_curTurn%7 == 5){
									playerwhoresigned = 6;
								}
								else{
									playerwhoresigned = 7;
								}
							}
							else if(_numberOfPlayers == 8){
								if(_curTurn % 8 == 0){
									playerwhoresigned = 1;
								}
								else if(_curTurn %8 == 1){
									playerwhoresigned = 2;
								}
								else if(_curTurn%8 == 2){
									playerwhoresigned = 3;
								}
								else if(_curTurn%8 == 3){
									playerwhoresigned = 4;
								}
								else if(_curTurn%8 == 4){
									playerwhoresigned = 5;
								}
								else if(_curTurn%8 == 5){
									playerwhoresigned = 6;
								}
								else if(_curTurn%8 == 6){
									playerwhoresigned = 7;
								}
								else{
									playerwhoresigned = 8;
								}
							}	
							new Resign(playerwhoresigned, _playerOneScore, _playerTwoScore, _playerThreeScore, _playerFourScore, _playerFiveScore, _playerSixScore, _playerSevenScore, _playerEightScore, playerNames);
						}
						else{
							System.out.println("Oh Come On! You Haven't Even Started The Game Yet");
						}
					}
					/////////////////////////////////////////////////////////////////////////////////////////////////////divider for organization			
					else if (name.equals("remove")) {
						if(_hasPlaced){
							new Place(_locx, _locy, "                ", _boardArray);
							canSave = true;
							_hasPlaced = false;
						}
						else{
							System.out.println("You cannot remove; you have not placed your tile yet");
						}
					}
					/////////////////////////////////////////////////////////////////////////////////////////////////////divider for organization			
					else if (name.equals("commit")) {
						if(_hasPlaced == true){
							if(_invalidPlacement == false){
								ableToResign = true;
								canSave = true;
								// 1 = North         2 = East                  3 = South               4 = West
								if(_numberOfPlayers == 2){
									_playerOneScore = scorePath(1, 1, 3, _boardArray) + scorePath(9, 1, 3, _boardArray) + scorePath(17, 1, 3, _boardArray) + scorePath(25, 1, 3, _boardArray) + scorePath(33, 1, 3, _boardArray) + scorePath(41, 1, 3, _boardArray) + scorePath(45, 1, 4, _boardArray) + scorePath(45, 9, 4, _boardArray) + scorePath(45, 17, 4, _boardArray) + scorePath(45, 25, 4, _boardArray) + scorePath(45, 33, 4, _boardArray) + scorePath(45, 41, 4, _boardArray) + scorePath(45, 45, 1, _boardArray) + scorePath(37, 45, 1, _boardArray) + scorePath(29, 45, 1, _boardArray) + scorePath(21, 45, 1, _boardArray) + scorePath(13, 45, 1, _boardArray) + scorePath(5, 45, 1, _boardArray) + scorePath(1, 45, 2, _boardArray) + scorePath(1, 37, 2, _boardArray) + scorePath(1, 29, 2, _boardArray) + scorePath(1, 21, 2, _boardArray) + scorePath(1, 13, 2, _boardArray) + scorePath(1, 5, 2, _boardArray);
									_playerTwoScore = scorePath(5, 1, 3, _boardArray) + scorePath(13, 1, 3, _boardArray) + scorePath(21, 1, 3, _boardArray) + scorePath(29, 1, 3, _boardArray) + scorePath(37, 1, 3, _boardArray) + scorePath(45, 1, 3, _boardArray) + scorePath(45, 5, 4, _boardArray) + scorePath(45, 13, 4, _boardArray) + scorePath(45, 21, 4, _boardArray) + scorePath(45, 29, 4, _boardArray) + scorePath(45, 37, 4, _boardArray) + scorePath(45, 45, 4, _boardArray) + scorePath(41, 45, 1, _boardArray) + scorePath(33, 45, 1, _boardArray) + scorePath(25, 45, 1, _boardArray) + scorePath(17, 45, 1, _boardArray) + scorePath(9, 45, 1, _boardArray) + scorePath(1, 45, 1, _boardArray) + scorePath(1, 41, 2, _boardArray) + scorePath(1, 33, 2, _boardArray) + scorePath(1, 25, 2, _boardArray) + scorePath(1, 17, 2, _boardArray) + scorePath(1, 9, 2, _boardArray) + scorePath(1, 1, 2, _boardArray);
									_playerThreeScore = -1;
									_playerFourScore = -1;
									_playerFiveScore = -1;
									_playerSixScore = -1;
									_playerSevenScore = -1;
									_playerEightScore = -1;
								}
								else if(_numberOfPlayers == 3){
									_playerOneScore = scorePath(1, 1, 3, _boardArray) + scorePath(13, 1, 3, _boardArray) + scorePath(25, 1, 3, _boardArray) + scorePath(37, 1, 3, _boardArray) + scorePath(45, 1, 4, _boardArray) + scorePath(45, 13, 4, _boardArray) + scorePath(45, 25, 4, _boardArray) + scorePath(45, 37, 4, _boardArray) + scorePath(45, 45, 1, _boardArray) + scorePath(33, 45, 1, _boardArray) + scorePath(21, 45, 1, _boardArray) + scorePath(9, 45, 1, _boardArray) + scorePath(1, 45, 2, _boardArray) + scorePath(1, 33, 2, _boardArray) + scorePath(1, 21, 2, _boardArray) + scorePath(1, 9, 2, _boardArray);
									_playerTwoScore = scorePath(5, 1, 3, _boardArray) + scorePath(17, 1, 3, _boardArray) + scorePath(29, 1, 3, _boardArray) + scorePath(41, 1, 3, _boardArray) + scorePath(45, 5, 4, _boardArray) + scorePath(45, 17, 4, _boardArray) + scorePath(45, 29, 4, _boardArray) + scorePath(45, 41, 4, _boardArray) + scorePath(41, 45, 1, _boardArray) + scorePath(29, 45, 1, _boardArray) + scorePath(17, 45, 1, _boardArray) + scorePath(5, 45, 1, _boardArray) + scorePath(1, 41, 2, _boardArray) + scorePath(1, 29, 2, _boardArray) + scorePath(1, 17, 2, _boardArray) + scorePath(1, 5, 2, _boardArray);
									_playerThreeScore = scorePath(9, 1, 3, _boardArray) + scorePath(21, 1, 3, _boardArray) + scorePath(33, 1, 3, _boardArray) + scorePath(45, 1, 3, _boardArray) + scorePath(45, 9, 4, _boardArray) + scorePath(45, 21, 4, _boardArray) + scorePath(45, 33, 4, _boardArray) + scorePath(45, 45, 4, _boardArray) + scorePath(37, 45, 1, _boardArray) + scorePath(25, 45, 1, _boardArray) + scorePath(13, 45, 1, _boardArray) + scorePath(1, 45, 1, _boardArray) + scorePath(1, 37, 2, _boardArray) + scorePath(1, 25, 2, _boardArray) + scorePath(1, 13, 2, _boardArray) + scorePath(1, 1, 2, _boardArray);
									_playerFourScore = -1;
									_playerFiveScore = -1;
									_playerSixScore = -1;
									_playerSevenScore = -1;
									_playerEightScore = -1;
								}
								else if(_numberOfPlayers == 4){
									_playerOneScore = scorePath(1, 1, 3, _boardArray) + scorePath(17, 1, 3, _boardArray) + scorePath(33, 1, 3, _boardArray) + scorePath(45, 1, 4, _boardArray) + scorePath(45, 17, 4, _boardArray) + scorePath(45, 33, 4, _boardArray) + scorePath(45, 45, 1, _boardArray) + scorePath(29, 45, 1, _boardArray) + scorePath(13, 45, 1, _boardArray) + scorePath(1, 45, 2, _boardArray) + scorePath(1, 29, 2, _boardArray) + scorePath(1, 13, 2, _boardArray);
									_playerTwoScore = scorePath(5, 1, 3, _boardArray) + scorePath(21, 1, 3, _boardArray) + scorePath(37, 1, 3, _boardArray) + scorePath(45, 5, 4, _boardArray) + scorePath(45, 21, 4, _boardArray) + scorePath(45, 37, 4, _boardArray) + scorePath(41, 45, 1, _boardArray) + scorePath(25, 45, 1, _boardArray) + scorePath(9, 45, 1, _boardArray) + scorePath(1, 41, 2, _boardArray) + scorePath(1, 25, 2, _boardArray) + scorePath(1, 9, 2, _boardArray);
									_playerThreeScore = scorePath(9, 1, 3, _boardArray) + scorePath(25, 1, 3, _boardArray) + scorePath(41, 1, 3, _boardArray) + scorePath(45, 9, 4, _boardArray) + scorePath(45, 25, 4, _boardArray) + scorePath(45, 41, 4, _boardArray) + scorePath(37, 45, 1, _boardArray) + scorePath(21, 45, 1, _boardArray) + scorePath(5, 45, 1, _boardArray) + scorePath(1, 37, 2, _boardArray) + scorePath(1, 21, 2, _boardArray) + scorePath(1, 5, 2, _boardArray);
									_playerFourScore = scorePath(13, 1, 3, _boardArray) + scorePath(29, 1, 3, _boardArray) + scorePath(45, 1, 3, _boardArray) + scorePath(45, 13, 4, _boardArray) + scorePath(45, 29, 4, _boardArray) + scorePath(45, 45, 4, _boardArray) + scorePath(33, 45, 1, _boardArray) + scorePath(17, 45, 1, _boardArray) + scorePath(1, 45, 1, _boardArray) + scorePath(1, 33, 2, _boardArray) + scorePath(1, 17, 2, _boardArray) + scorePath(1, 1, 2, _boardArray);
									_playerFiveScore = -1;
									_playerSixScore = -1;
									_playerSevenScore = -1;
									_playerEightScore = -1;
								}
								else if(_numberOfPlayers == 5){
									_playerOneScore = scorePath(1, 1, 3, _boardArray) + scorePath(21, 1, 3, _boardArray) + scorePath(41, 1, 3, _boardArray) + scorePath(45, 13, 4, _boardArray) + scorePath(45, 33, 4, _boardArray) + scorePath(41, 45, 1, _boardArray) + scorePath(21, 45, 1, _boardArray) + scorePath(1, 45, 1, _boardArray) + scorePath(1, 29, 2, _boardArray);
									_playerTwoScore = scorePath(5, 1, 3, _boardArray) + scorePath(25, 1, 3, _boardArray) + scorePath(45, 1, 3, _boardArray) + scorePath(45, 17, 4, _boardArray) + scorePath(45, 37, 4, _boardArray) + scorePath(37, 45, 1, _boardArray) + scorePath(17, 45, 1, _boardArray) + scorePath(1, 45, 2, _boardArray) + scorePath(1, 25, 2, _boardArray);
									_playerThreeScore = scorePath(9, 1, 3, _boardArray) + scorePath(29, 1, 3, _boardArray) + scorePath(45, 1, 4, _boardArray) + scorePath(45, 21, 4, _boardArray) + scorePath(45, 41, 4, _boardArray) + scorePath(33, 45, 1, _boardArray) + scorePath(13, 45, 1, _boardArray) + scorePath(1, 41, 2, _boardArray) + scorePath(1, 21, 2, _boardArray);
									_playerFourScore = scorePath(13, 1, 3, _boardArray) + scorePath(33, 1, 3, _boardArray) + scorePath(45, 5, 4, _boardArray) + scorePath(45, 25, 4, _boardArray) + scorePath(45, 45, 4, _boardArray) + scorePath(29, 45, 1, _boardArray) + scorePath(9, 45, 1, _boardArray) + scorePath(1, 37, 2, _boardArray) + scorePath(1, 17, 2, _boardArray);
									_playerFiveScore = scorePath(17, 1, 3, _boardArray) + scorePath(37, 1, 3, _boardArray) + scorePath(45, 9, 4, _boardArray) + scorePath(45, 29, 4, _boardArray) + scorePath(45, 45, 1, _boardArray) + scorePath(25, 45, 1, _boardArray) + scorePath(5, 45, 1, _boardArray) + scorePath(1, 33, 2, _boardArray) + scorePath(1, 13, 2, _boardArray);
									_playerSixScore = -1;
									_playerSevenScore = -1;
									_playerEightScore = -1;
								}
								else if(_numberOfPlayers == 6){
									_playerOneScore = scorePath(1, 1, 3, _boardArray) + scorePath(25, 1, 3, _boardArray) + scorePath(45, 1, 4, _boardArray) + scorePath(45, 25, 4, _boardArray) + scorePath(45, 45, 1, _boardArray) + scorePath(21, 45, 1, _boardArray) + scorePath(1, 45, 2, _boardArray) + scorePath(1, 21, 2, _boardArray);
									_playerTwoScore = scorePath(5, 1, 3, _boardArray) + scorePath(29, 1, 3, _boardArray) + scorePath(45, 5, 4, _boardArray) + scorePath(45, 29, 4, _boardArray) + scorePath(41, 45, 1, _boardArray) + scorePath(17, 45, 1, _boardArray) + scorePath(1, 41, 2, _boardArray) + scorePath(1, 17, 2, _boardArray);
									_playerThreeScore = scorePath(9, 1, 3, _boardArray) + scorePath(33, 1, 3, _boardArray) + scorePath(45, 9, 4, _boardArray) + scorePath(45, 33, 4, _boardArray) + scorePath(37, 45, 1, _boardArray) + scorePath(13, 45, 1, _boardArray) + scorePath(1, 37, 2, _boardArray) + scorePath(1, 13, 2, _boardArray);
									_playerFourScore = scorePath(13, 1, 3, _boardArray) + scorePath(37, 1, 3, _boardArray) + scorePath(45, 13, 4, _boardArray) + scorePath(45, 37, 4, _boardArray) + scorePath(33, 45, 1, _boardArray) + scorePath(9, 45, 1, _boardArray) + scorePath(1, 33, 2, _boardArray) + scorePath(1, 9, 2, _boardArray);
									_playerFiveScore = scorePath(17, 1, 3, _boardArray) + scorePath(41, 1, 3, _boardArray) + scorePath(45, 17, 4, _boardArray) + scorePath(45, 41, 4, _boardArray) + scorePath(29, 45, 1, _boardArray) + scorePath(5, 45, 1, _boardArray) + scorePath(1, 29, 2, _boardArray) + scorePath(1, 5, 2, _boardArray);
									_playerSixScore = scorePath(21, 1, 3, _boardArray) + scorePath(45, 1, 3, _boardArray) + scorePath(45, 21, 4, _boardArray) + scorePath(45, 45, 4, _boardArray) + scorePath(25, 45, 1, _boardArray) + scorePath(1, 45, 1, _boardArray) + scorePath(1, 25, 2, _boardArray) + scorePath(1, 1, 2, _boardArray);
									_playerSevenScore = -1;
									_playerEightScore = -1;
								}
								else if(_numberOfPlayers == 7){
									_playerOneScore = scorePath(1, 1, 3, _boardArray) + scorePath(29, 1, 3, _boardArray) + scorePath(45, 9, 4, _boardArray) + scorePath(45, 37, 4, _boardArray) + scorePath(29, 45, 1, _boardArray) + scorePath(1, 45, 1, _boardArray);
									_playerTwoScore = scorePath(5, 1, 3, _boardArray) + scorePath(33, 1, 3, _boardArray) + scorePath(45, 13, 4, _boardArray) + scorePath(45, 41, 4, _boardArray) + scorePath(25, 45, 1, _boardArray) + scorePath(1, 45, 2, _boardArray);
									_playerThreeScore = scorePath(9, 1, 3, _boardArray) + scorePath(37, 1, 3, _boardArray) + scorePath(45, 17, 4, _boardArray) + scorePath(45, 45, 4, _boardArray) + scorePath(21, 45, 1, _boardArray) + scorePath(1, 41, 2, _boardArray);
									_playerFourScore = scorePath(13, 1, 3, _boardArray) + scorePath(41, 1, 3, _boardArray) + scorePath(45, 21, 4, _boardArray) + scorePath(45, 45, 1, _boardArray) + scorePath(17, 45, 1, _boardArray) + scorePath(1, 37, 2, _boardArray);
									_playerFiveScore = scorePath(17, 1, 3, _boardArray) + scorePath(45, 1, 3, _boardArray) + scorePath(45, 25, 4, _boardArray) + scorePath(41, 45, 1, _boardArray) + scorePath(13, 45, 1, _boardArray) + scorePath(1, 33, 2, _boardArray);
									_playerSixScore = scorePath(21, 1, 3, _boardArray) + scorePath(45, 1, 4, _boardArray) + scorePath(45, 29, 4, _boardArray) + scorePath(37, 45, 1, _boardArray) + scorePath(9, 45, 1, _boardArray) + scorePath(1, 29, 2, _boardArray);
									_playerSevenScore = scorePath(25, 1, 3, _boardArray) + scorePath(45, 5, 4, _boardArray) + scorePath(45, 33, 4, _boardArray) + scorePath(33, 45, 1, _boardArray) + scorePath(5, 45, 1, _boardArray) + scorePath(1, 25, 2, _boardArray);
									_playerEightScore = -1;
								}
								else{
									_playerOneScore = scorePath(1, 1, 3, _boardArray) + scorePath(33, 1, 3, _boardArray) + scorePath(45, 17, 4, _boardArray) + scorePath(45, 45, 1, _boardArray) + scorePath(13, 45, 1, _boardArray) + scorePath(1, 29, 2, _boardArray);
									_playerTwoScore = scorePath(5, 1, 3, _boardArray) + scorePath(37, 1, 3, _boardArray) + scorePath(45, 21, 4, _boardArray) + scorePath(41, 45, 1, _boardArray) + scorePath(9, 45, 1, _boardArray) + scorePath(1, 25, 2, _boardArray);
									_playerThreeScore = scorePath(9, 1, 3, _boardArray) + scorePath(41, 1, 3, _boardArray) + scorePath(45, 25, 4, _boardArray) + scorePath(37, 45, 1, _boardArray) + scorePath(5, 45, 1, _boardArray) + scorePath(1, 21, 2, _boardArray);
									_playerFourScore = scorePath(13, 1, 3, _boardArray) + scorePath(45, 1, 3, _boardArray) + scorePath(45, 29, 4, _boardArray) + scorePath(33, 45, 1, _boardArray) + scorePath(1, 45, 1, _boardArray) + scorePath(1, 17, 2, _boardArray);
									_playerFiveScore = scorePath(17, 1, 3, _boardArray) + scorePath(45, 1, 4, _boardArray) + scorePath(45, 33, 4, _boardArray) + scorePath(29, 45, 1, _boardArray) + scorePath(1, 45, 2, _boardArray) + scorePath(1, 13, 2, _boardArray);
									_playerSixScore = scorePath(21, 1, 3, _boardArray) + scorePath(45, 5, 4, _boardArray) + scorePath(45, 37, 4, _boardArray) + scorePath(25, 45, 1, _boardArray) + scorePath(1, 41, 2, _boardArray) + scorePath(1, 9, 2, _boardArray);
									_playerSevenScore = scorePath(25, 1, 3, _boardArray) + scorePath(45, 9, 4, _boardArray) + scorePath(45, 41, 4, _boardArray) + scorePath(21, 45, 1, _boardArray) + scorePath(1, 37, 2, _boardArray) + scorePath(1, 5, 2, _boardArray);
									_playerEightScore = scorePath(29, 1, 3, _boardArray) + scorePath(45, 13, 4, _boardArray) + scorePath(45, 45, 4, _boardArray) + scorePath(17, 45, 1, _boardArray) + scorePath(1, 33, 2, _boardArray) + scorePath(1, 1, 2, _boardArray);
								}
								_curTurn++;
								if(_curTurn == 140){
									new ScoreDisplay(_numberOfPlayers, _playerOneScore, _playerTwoScore, _playerThreeScore, _playerFourScore, _playerFiveScore, _playerSixScore, _playerSevenScore, _playerEightScore, playerNames);
									new BoardDisplay(_boardArray);
									new GameOver(_playerOneScore, _playerTwoScore, _playerThreeScore, _playerFourScore, _playerFiveScore, _playerSixScore, _playerSevenScore, _playerEightScore, playerNames);
								}
								else{
									_curTile = _tiles.get(_curTurn);
									stringToImage(_curTile);
									_hasPlaced = false;
									new ScoreDisplay(_numberOfPlayers, _playerOneScore, _playerTwoScore, _playerThreeScore, _playerFourScore, _playerFiveScore, _playerSixScore, _playerSevenScore, _playerEightScore, playerNames);
									new PlayerDisplay(_curTurn,_numberOfPlayers, playerNames);
									new TileDisplay(_curTile);
									new BoardDisplay(_boardArray);
								}
							}
							else{
								System.out.println("You still have an invalid placement, please remove your tile");
							}
						}
						else{
							System.out.println("You have not placed a tile yet");
						}
					}
					/////////////////////////////////////////////////////////////////////////////////////////////////////divider for organization			
					else if (name.equals("display tile")) {
						new TileDisplay(_curTile);
					}
					/////////////////////////////////////////////////////////////////////////////////////////////////////divider for organization			
					else if (name.equals("display board")) {
						new BoardDisplay(_boardArray);
					}
					/////////////////////////////////////////////////////////////////////////////////////////////////////divider for organization			
					else if (name.equals("save")) {
						if(canSave){
							String allTiles = new String();
							HashMap<String, String> tilesmap = new HashMap<String, String>();
							tilesmap.put(" 31 2  24  4 31 ", "A");
							tilesmap.put(" 32 3  24  1 41 ", "B");
							tilesmap.put(" 34 1  24  3 21 ", "C");
							tilesmap.put(" 33 4  24  2 11 ", "D");
							tilesmap.put(" 31 4  24  2 31 ", "E");
							tilesmap.put(" 33 2  24  4 11 ", "F");
							tilesmap.put(" 33 1  24  2 41 ", "G");
							tilesmap.put(" 33 4  24  1 21 ", "H");
							tilesmap.put(" 32 4  24  3 11 ", "I");
							tilesmap.put(" 34 3  24  2 11 ", "J");
							tilesmap.put(" 32 1  24  3 41 ", "K");
							tilesmap.put(" 34 3  24  1 21 ", "L");
							tilesmap.put(" 32 3  24  4 11 ", "M");
							tilesmap.put(" 33 2  24  1 41 ", "N");
							tilesmap.put(" 32 4  24  1 31 ", "O");
							tilesmap.put(" 31 3  24  2 41 ", "P");
							tilesmap.put(" 34 1  24  2 31 ", "Q");
							tilesmap.put(" 33 1  24  4 21 ", "R");
							tilesmap.put(" 34 2  24  3 11 ", "S");
							tilesmap.put(" 31 4  24  3 21 ", "T");
							tilesmap.put(" 32 1  24  4 31 ", "U");
							tilesmap.put(" 34 2  24  1 31 ", "V");
							tilesmap.put(" 31 3  24  4 21 ", "W");
							tilesmap.put(" 31 2  24  3 41 ", "X");
							tilesmap.put(" v# #   >       ", "#");
							tilesmap.put(" v#    <   #    ", "#");
							tilesmap.put("    #   >    #^ ", "#");
							tilesmap.put("       <   # #^ ", "#");
							for(int row = 1; row < 13; row++){
								for(int col = 1; col < 13; col++){
									String tile = new String();
									int x = (4*(col - 1) +1);
									int y = (4*(row - 1) +1);
									for(int spacey = 0; spacey <= 3; spacey++){
										for(int spacex = 0; spacex <= 3; spacex++){
											tile = tile + _boardArray[y + spacey][x + spacex];
										}
									}
									if(tilesmap.containsKey(tile)){
										allTiles = allTiles + tilesmap.get(tile);
									}
									else{
										allTiles = allTiles + "-";
									}
								}
							}
							String filename = new String();
							for(int i = 0; i<playerNames.size(); i++){
								filename += playerNames.get(i) + "-";
							}
							int i = 1;
							while((new File("src/code/"+filename+ i + ".txt")).exists()){
								i++;
							}
							File f = new File("src/code/"+filename+ i + ".txt");
							try { f.createNewFile(); } catch(Exception e) {}
							try{
								PrintWriter out = new PrintWriter(new FileWriter("src/code/"+filename+ i + ".txt"));
								out.println("Saved Tile:");
								out.println(_curTile);
								out.println("Saved Turn:");
								out.println(_curTurn);
								out.println("Saved Scores:");
								out.println(_playerOneScore);
								out.println(_playerTwoScore);
								out.println(_playerThreeScore);
								out.println(_playerFourScore);
								out.println(_playerFiveScore);
								out.println(_playerSixScore);
								out.println(_playerSevenScore);
								out.println(_playerEightScore);
								out.println("Saved Board:");
								out.println(allTiles);
								out.close();
							}
							catch(Exception e){}
							System.out.println("Your Game Saved Successfully");
							input.close();
							break;
						}
						else{
							System.out.println("You Can't Save A Game During The Middle Of A Move");
						}
					}
					/////////////////////////////////////////////////////////////////////////////////////////////////////divider for organization			
					else {
						System.out.println("I'm sorry, I didn't quite catch that. Try again!");
					}
				}
		}
	}//ScannerMan public constructor

	private void createAndShowGUI(String filePath, int _playeronecurscore, int _playertwocurscore, int _playerthreecurscore, int _playerfourcurscore, int _playerfivecurscore, int _playersixcurscore, int _playersevencurscore, int _playereightcurscore, ArrayList<String> playerNames, int curTurn) {
		_frame = new JFrame("Metro " + _numberOfPlayers + " player game");
		_frame.setBackground(java.awt.Color.BLUE);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setResizable(false);
		Container p = _frame.getContentPane();
		_frame.getContentPane().setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
		BufferedImage bi = HelpfulImageMethods.loadImage(filePath);
		_width = bi.getWidth()/14;
		_height = bi.getHeight()/14;
		int rows = 14;
		int colum = 14;
		java.util.List<BufferedImage> coll; 
		coll = new java.util.LinkedList<BufferedImage>();
		for(int a = 0; a<14; a++) {
			for(int b = 0; b<14; b++){
				BufferedImage bl1 = HelpfulImageMethods.createSubImage(bi, a*_width, b*_height,_width, _height);
				coll.add(bl1);
			}
		}
		java.util.Iterator<BufferedImage> it = coll.iterator();
		_panel2 = new JPanel();
		_panel2.setLayout(null);
		_panel2.setBackground(java.awt.Color.BLUE);
		_panel2.setPreferredSize(new Dimension (700,700));
		p.add(_panel2);
		for(int i=0; i<rows; i++) {
			for(int g=0; g<colum; g++) {
				if(it.hasNext()){
					BufferedImage im = it.next();
					new Block(im, i, g, i, g, _width, _height, _panel2, this);
				}
				else{ 
				} 
			}
		}
		Container p2 = new Container();
		p2.setLayout(new BoxLayout(p2,BoxLayout.Y_AXIS));
		_frame.add(p2);
		if( _numberOfPlayers == 2){
			JLabel score1 = new JLabel(playerNames.get(0)+": "+_playeronecurscore+" points");
			JLabel score2 = new JLabel(playerNames.get(1)+": "+_playertwocurscore+" points");
			p2.add(score1);
			p2.add(score2);
		}
		else if( _numberOfPlayers == 3){
			JLabel score1 = new JLabel(playerNames.get(0)+": "+_playeronecurscore+" points");
			JLabel score2 = new JLabel(playerNames.get(1)+": "+_playertwocurscore+" points");
			JLabel score3 = new JLabel(playerNames.get(2)+": "+_playerthreecurscore+" points");
			p2.add(score1);
			p2.add(score2);
			p2.add(score3);
		}
		else if( _numberOfPlayers == 4){
			JLabel score1 = new JLabel(playerNames.get(0)+": "+_playeronecurscore+" points");
			JLabel score2 = new JLabel(playerNames.get(1)+": "+_playertwocurscore+" points");
			JLabel score3 = new JLabel(playerNames.get(2)+": "+_playerthreecurscore+" points");
			JLabel score4 = new JLabel(playerNames.get(3)+": "+_playerfourcurscore+" points");
			p2.add(score1);
			p2.add(score2);
			p2.add(score3);
			p2.add(score4);
		}
		else if( _numberOfPlayers == 5){
			JLabel score1 = new JLabel(playerNames.get(0)+": "+_playeronecurscore+" points");
			JLabel score2 = new JLabel(playerNames.get(1)+": "+_playertwocurscore+" points");
			JLabel score3 = new JLabel(playerNames.get(2)+": "+_playerthreecurscore+" points");
			JLabel score4 = new JLabel(playerNames.get(3)+": "+_playerfourcurscore+" points");
			JLabel score5 = new JLabel(playerNames.get(4)+": "+_playerfivecurscore+" points");
			p2.add(score1);
			p2.add(score2);
			p2.add(score3);
			p2.add(score4);
			p2.add(score5);
		}
		else if( _numberOfPlayers == 6){
			JLabel score1 = new JLabel(playerNames.get(0)+": "+_playeronecurscore+" points");
			JLabel score2 = new JLabel(playerNames.get(1)+": "+_playertwocurscore+" points");
			JLabel score3 = new JLabel(playerNames.get(2)+": "+_playerthreecurscore+" points");
			JLabel score4 = new JLabel(playerNames.get(3)+": "+_playerfourcurscore+" points");
			JLabel score5 = new JLabel(playerNames.get(4)+": "+_playerfivecurscore+" points");
			JLabel score6 = new JLabel(playerNames.get(5)+": "+_playersixcurscore+" points");
			p2.add(score1);
			p2.add(score2);
			p2.add(score3);
			p2.add(score4);
			p2.add(score5);
			p2.add(score6);
		}
		else if( _numberOfPlayers == 7){
			JLabel score1 = new JLabel(playerNames.get(0)+": "+_playeronecurscore+" points");
			JLabel score2 = new JLabel(playerNames.get(1)+": "+_playertwocurscore+" points");
			JLabel score3 = new JLabel(playerNames.get(2)+": "+_playerthreecurscore+" points");
			JLabel score4 = new JLabel(playerNames.get(3)+": "+_playerfourcurscore+" points");
			JLabel score5 = new JLabel(playerNames.get(4)+": "+_playerfivecurscore+" points");
			JLabel score6 = new JLabel(playerNames.get(5)+": "+_playersixcurscore+" points");
			JLabel score7 = new JLabel(playerNames.get(6)+": "+_playersevencurscore+" points");
			p2.add(score1);
			p2.add(score2);
			p2.add(score3);
			p2.add(score4);
			p2.add(score5);
			p2.add(score6);
			p2.add(score7);
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
			p2.add(score1);
			p2.add(score2);
			p2.add(score3);
			p2.add(score4);
			p2.add(score5);
			p2.add(score6);
			p2.add(score7);
			p2.add(score8);
		}
		
		if( _numberOfPlayers == 2){
			if(curTurn % 2 == 0){
				JLabel player = new JLabel("It is "+playerNames.get(0)+"'s turn");
				p2.add(player);
			}
			else{
				JLabel player = new JLabel("It is "+playerNames.get(1)+"'s turn");
				p2.add(player);
			}
		}
		else if( _numberOfPlayers == 3){
			if(curTurn % 3 == 0){
				JLabel player = new JLabel("It is "+playerNames.get(0)+"'s turn");
				p2.add(player);
			}
			else if(curTurn %3 == 1){
				JLabel player = new JLabel("It is "+playerNames.get(1)+"'s turn");
				p2.add(player);
			}
			else{
				JLabel player = new JLabel("It is "+playerNames.get(2)+"'s turn");
				p2.add(player);
			}
		}
		else if( _numberOfPlayers == 4){
			if(curTurn % 4 == 0){
				JLabel player = new JLabel("It is "+playerNames.get(0)+"'s turn");
				p2.add(player);
			}
			else if(curTurn %4 == 1){
				JLabel player = new JLabel("It is "+playerNames.get(1)+"'s turn");
				p2.add(player);
			}
			else if(curTurn%4 == 2){
				JLabel player = new JLabel("It is "+playerNames.get(2)+"'s turn");
				p2.add(player);
			}
			else{
				JLabel player = new JLabel("It is "+playerNames.get(3)+"'s turn");
				p2.add(player);
			}
		}
		else if( _numberOfPlayers == 5){
			if(curTurn % 5 == 0){
				JLabel player = new JLabel("It is "+playerNames.get(0)+"'s turn");
				p2.add(player);
			}
			else if(curTurn %5 == 1){
				JLabel player = new JLabel("It is "+playerNames.get(1)+"'s turn");
				p2.add(player);
			}
			else if(curTurn%5 == 2){
				JLabel player = new JLabel("It is "+playerNames.get(2)+"'s turn");
				p2.add(player);
			}
			else if(curTurn%5 == 3){
				JLabel player = new JLabel("It is "+playerNames.get(3)+"'s turn");
				p2.add(player);
			}
			else{
				JLabel player = new JLabel("It is "+playerNames.get(4)+"'s turn");
				p2.add(player);
			}
		}
		else if( _numberOfPlayers == 6){
			if(curTurn % 6 == 0){
				JLabel player = new JLabel("It is "+playerNames.get(0)+"'s turn");
				p2.add(player);
			}
			else if(curTurn %6 == 1){
				JLabel player = new JLabel("It is "+playerNames.get(1)+"'s turn");
				p2.add(player);
			}
			else if(curTurn%6 == 2){
				JLabel player = new JLabel("It is "+playerNames.get(2)+"'s turn");
				p2.add(player);
			}
			else if(curTurn%6 == 3){
				JLabel player = new JLabel("It is "+playerNames.get(3)+"'s turn");
				p2.add(player);
			}
			else if(curTurn%6 == 4){
				JLabel player = new JLabel("It is "+playerNames.get(4)+"'s turn");
				p2.add(player);
			}
			else{
				JLabel player = new JLabel("It is "+playerNames.get(5)+"'s turn");
				p2.add(player);
			}
		}
		else if( _numberOfPlayers == 7){
			if(curTurn % 7 == 0){
				JLabel player = new JLabel("It is "+playerNames.get(0)+"'s turn");
				p2.add(player);
			}
			else if(curTurn %7 == 1){
				JLabel player = new JLabel("It is "+playerNames.get(1)+"'s turn");
				p2.add(player);
			}
			else if(curTurn%7 == 2){
				JLabel player = new JLabel("It is "+playerNames.get(2)+"'s turn");
				p2.add(player);
			}
			else if(curTurn%7 == 3){
				JLabel player = new JLabel("It is "+playerNames.get(3)+"'s turn");
				p2.add(player);
			}
			else if(curTurn%7 == 4){
				JLabel player = new JLabel("It is "+playerNames.get(4)+"'s turn");
				p2.add(player);
			}
			else if(curTurn%7 == 5){
				JLabel player = new JLabel("It is "+playerNames.get(5)+"'s turn");
				p2.add(player);
			}
			else{
				JLabel player = new JLabel("It is "+playerNames.get(6)+"'s turn");
				p2.add(player);
			}
		}
		else{
			if(curTurn % 8 == 0){
				JLabel player = new JLabel("It is "+playerNames.get(0)+"'s turn");
				p2.add(player);
			}
			else if(curTurn %8 == 1){
				JLabel player = new JLabel("It is "+playerNames.get(1)+"'s turn");
				p2.add(player);
			}
			else if(curTurn%8 == 2){
				JLabel player = new JLabel("It is "+playerNames.get(2)+"'s turn");
				p2.add(player);
			}
			else if(curTurn%8 == 3){
				JLabel player = new JLabel("It is "+playerNames.get(3)+"'s turn");
				p2.add(player);
			}
			else if(curTurn%8 == 4){
				JLabel player = new JLabel("It is "+playerNames.get(4)+"'s turn");
				p2.add(player);
			}
			else if(curTurn%8 == 5){
				JLabel player = new JLabel("It is "+playerNames.get(5)+"'s turn");
				p2.add(player);
			}
			else if(curTurn%8 == 6){
				JLabel player = new JLabel("It is "+playerNames.get(6)+"'s turn");
				p2.add(player);
			}
			else{
				JLabel player = new JLabel("It is "+playerNames.get(7)+"'s turn");
				p2.add(player);
			}
		}
		ImageIcon icon = new ImageIcon(_guiTile);
		JLabel tileViewer = new JLabel("Current Tile:");
		tileViewer.setHorizontalTextPosition(SwingConstants.LEADING);
		tileViewer.setHorizontalAlignment(SwingConstants.LEADING);
		tileViewer.setIcon(icon);
		p2.add(tileViewer);
		
		JButton placeButton = new JButton("Place Tile");
		placeButton.addActionListener(new EventHandlerPlace(_hasPlaced, _boardArray, _invalidPlacement, _curTile, _panel2, this));
		placeButton.setMinimumSize(new Dimension(150,50));
		placeButton.setPreferredSize(new Dimension(150,50));
		placeButton.setMaximumSize(new Dimension(150,50));
		p2.add(placeButton);
		
		JButton removeButton = new JButton("Remove  Tile");


		removeButton.addActionListener(new EventHandlerRemoveTile(_panel2, this));

		removeButton.setMinimumSize(new Dimension(150,50));
		removeButton.setPreferredSize(new Dimension(150,50));
		removeButton.setMaximumSize(new Dimension(150,50));
		p2.add(removeButton);
		
		JButton commitButton = new JButton("Commit");
		commitButton.addActionListener(new EventHandlerCommit());
		commitButton.setMinimumSize(new Dimension(150,50));
		commitButton.setPreferredSize(new Dimension(150,50));
		commitButton.setMaximumSize(new Dimension(150,50));
		p2.add(commitButton);
		
		JButton saveButton = new JButton("Save Game");
		saveButton.addActionListener(new EventHandlerSaveGame());
		saveButton.setMinimumSize(new Dimension(150,50));
		saveButton.setPreferredSize(new Dimension(150,50));
		saveButton.setMaximumSize(new Dimension(150,50));
		p2.add(saveButton);
		
		JButton resignButton = new JButton("Resign");
		resignButton.addActionListener(new EventHandlerResign(ableToResign, _numberOfPlayers, _curTurn, _playerOneScore, _playerTwoScore, _playerThreeScore, _playerFourScore, _playerFiveScore, _playerSixScore, _playerSevenScore, _playerEightScore, playerNames, _frame));
		resignButton.setMinimumSize(new Dimension(150,50));
		resignButton.setPreferredSize(new Dimension(150,50));
		resignButton.setMaximumSize(new Dimension(150,50));
		p2.add(resignButton);
		
		JButton scoreButton = new JButton("Display Score");
		scoreButton.addActionListener(new EventHandlerDisplayScore(_numberOfPlayers, _playerOneScore, _playerTwoScore, _playerThreeScore, _playerFourScore, _playerFiveScore, _playerSixScore, _playerSevenScore, _playerEightScore, playerNames));
		scoreButton.setMinimumSize(new Dimension(150,50));
		scoreButton.setPreferredSize(new Dimension(150,50));
		scoreButton.setMaximumSize(new Dimension(150,50));
		p2.add(scoreButton);
		
		JButton playerButton = new JButton("Display Player");
		playerButton.addActionListener(new EventHandlerDisplayPlayer(_numberOfPlayers, _playerNames, _curTurn));
		playerButton.setMinimumSize(new Dimension(150,50));
		playerButton.setPreferredSize(new Dimension(150,50));
		playerButton.setMaximumSize(new Dimension(150,50));
		p2.add(playerButton);
		
		JButton tileButton = new JButton("Display Tile");
		tileButton.addActionListener(new EventHandlerDisplayTile(_guiTile));
		tileButton.setMinimumSize(new Dimension(150,50));
		tileButton.setPreferredSize(new Dimension(150,50));
		tileButton.setMaximumSize(new Dimension(150,50));
		p2.add(tileButton);

		_frame.pack();
		_frame.setVisible(true);		
	}


	//-------------------------------------------------------------------------------------------/method divider for organization	
	/*This method resets the currentTile in GUI
	 */
	public void resetTileViewer(JLabel j){
		ImageIcon curGuiTile = new ImageIcon(_guiTile);
		j.setIcon(curGuiTile);
	}
	//-------------------------------------------------------------------------------------------/method divider for organization	
	/*This method places your tile on the board and returns true if you typed place(x,y) and false if you didn't, so that way it continues to look
	 * for other commands you typed in
	 */
	public boolean placeIsName(String name, char[][] _boardArray) {
		for(int xcord = 1; xcord < 13; xcord++){
			for(int ycord = 1; ycord < 13; ycord++){
				if (name.equals("place("+xcord+","+ycord+")")) {
					if((xcord == 6 && ycord == 6) || (xcord == 6 && ycord == 7) || (xcord == 7 && ycord == 6)|| (xcord == 7 && ycord == 7)){
						System.out.println("You Can't Place This Tile Here, There Is A Station There");
						return true;
					}
					else{
						if (!_hasPlaced && isEmpty(xcord, ycord, _boardArray)) {
							new Place(xcord, ycord, _curTile, _boardArray);
							_locx = xcord;
							_locy = ycord;
							if (TileTypeChecker(_curTile, _locx, _locy,_boardArray) == true) {
								_hasPlaced = true;
								_invalidPlacement = false;
							} 
							else {
								System.out.println("You Can't Place This Tile Here, Please remove it");
								_hasPlaced =true;
								_invalidPlacement = true;
							}
						} 
						else {
							System.out.println("Sorry, invalid tile placement. Either Something's already here or you already placed your tile.");
						}
						return true;
					}
				}
			}
		}
		return false;
	}
	//-------------------------------------------------------------------------------------------/method divider for organization	
	/*This little method checks if a coordinate spot on the board is empty or not, returning a boolean of true if the spot 
	 * is empty.  It takes in the integer x and y location of the placement desired by the player as well as the current 
	 * board in 2d Array format
	 */
	public boolean isEmpty(int x, int y, char[][] _boardArray) {
		return (_boardArray[4 * (y - 1) + 1][4 * (x - 1) + 2] == ' ');
	}
	//-------------------------------------------------------------------------------------------/method divider for organization	
	/*this method takes in the position of the board, the direction that the station is going (look below for number to direction
	conversions) and the board itself. It then figures out what tile is there, and based on that, determines and returns which way
	the track is going out.
	 */
	public int directionOut(int x, int y, int direction, char[][] _boardArray){
		// 1 = North         2 = East                  3 = South               4 = West
		int dout = 0;
		String tilestring = "";
		for(int tempY=0; tempY < 4; tempY++) {
			for(int tempX=0; tempX < 4; tempX++) {
				tilestring += _boardArray[y+tempY][x+tempX];
			}
		}
		if(direction == 1){
			if(tilestring.equals(" 31 2  24  4 31 ") || tilestring.equals(" 31 4  24  2 31 ") || tilestring.equals(" 31 3  24  2 41 ") || tilestring.equals(" 31 4  24  3 21 ") || tilestring.equals(" 31 3  24  4 21 ") || tilestring.equals(" 31 2  24  3 41 ")){ //A and E and P and T and W and X
				dout = 1;
			}
			else if(tilestring.equals(" 32 3  24  1 41 ") || tilestring.equals(" 33 4  24  1 21 ") || tilestring.equals(" 34 3  24  1 21 ") || tilestring.equals(" 33 2  24  1 41 ") || tilestring.equals(" 32 4  24  1 31 ") || tilestring.equals(" 34 2  24  1 31 ")){ //B and H and L and N and O and V
				dout = 2;
			}
			else if(tilestring.equals(" 33 4  24  2 11 ") || tilestring.equals(" 33 2  24  4 11 ") || tilestring.equals(" 32 4  24  3 11 ") || tilestring.equals(" 34 3  24  2 11 ") || tilestring.equals(" 32 3  24  4 11 ") || tilestring.equals(" 34 2  24  3 11 ")){ //D and F and I and J and M and S
				dout = 3;
			}
			else if(tilestring.equals(" 34 1  24  3 21 ") || tilestring.equals(" 33 1  24  2 41 ") || tilestring.equals(" 32 1  24  3 41 ") || tilestring.equals(" 34 1  24  2 31 ") || tilestring.equals(" 33 1  24  4 21 ") || tilestring.equals(" 32 1  24  4 31 ")){ //C and G and K and Q and R and U
				dout = 4;
			}
			else{
				dout = 0;
			}
		}
		else if(direction == 2){
			if(tilestring.equals(" 34 1  24  3 21 ") || tilestring.equals(" 34 3  24  2 11 ") || tilestring.equals(" 34 3  24  1 21 ") || tilestring.equals(" 34 1  24  2 31 ") || tilestring.equals(" 34 2  24  3 11 ") || tilestring.equals(" 34 2  24  1 31 ")){ //C and J and L and Q and S and V
				dout = 1;
			}
			else if(tilestring.equals(" 31 2  24  4 31 ") || tilestring.equals(" 33 2  24  4 11 ") || tilestring.equals(" 32 3  24  4 11 ") || tilestring.equals(" 33 1  24  4 21 ") || tilestring.equals(" 32 1  24  4 31 ") || tilestring.equals(" 31 3  24  4 21 ")){ //A and F and M and R and U and W
				dout = 2;
			}
			else if(tilestring.equals(" 32 3  24  1 41 ") || tilestring.equals(" 33 1  24  2 41 ") || tilestring.equals(" 32 1  24  3 41 ") || tilestring.equals(" 33 2  24  1 41 ") || tilestring.equals(" 31 3  24  2 41 ") || tilestring.equals(" 31 2  24  3 41 ")){ //B and G and K and N and P and X
				dout = 3;
			}
			else if(tilestring.equals(" 33 4  24  2 11 ") || tilestring.equals(" 31 4  24  2 31 ") || tilestring.equals(" 33 4  24  1 21 ") || tilestring.equals(" 32 4  24  3 11 ") || tilestring.equals(" 32 4  24  1 31 ") || tilestring.equals(" 31 4  24  3 21 ")){ //D and E and H and I and O and T
				dout = 4;
			}
			else{
				dout = 0;
			}
		}
		else if(direction == 3){
			if(tilestring.equals(" 33 4  24  2 11 ") || tilestring.equals(" 33 2  24  4 11 ") || tilestring.equals(" 33 1  24  2 41 ") || tilestring.equals(" 33 4  24  1 21 ") || tilestring.equals(" 33 2  24  1 41 ") || tilestring.equals(" 33 1  24  4 21 ")){ //D and F and G and H and N and R
				dout = 1;
			}
			else if(tilestring.equals(" 34 1  24  3 21 ") || tilestring.equals(" 32 4  24  3 11 ") || tilestring.equals(" 32 1  24  3 41 ") || tilestring.equals(" 34 2  24  3 11 ") || tilestring.equals(" 31 4  24  3 21 ") || tilestring.equals(" 31 2  24  3 41 ")){ //C and I and K and S and T and X
				dout = 2;
			}
			else if(tilestring.equals(" 31 2  24  4 31 ") || tilestring.equals(" 31 4  24  2 31 ") || tilestring.equals(" 32 4  24  1 31 ") || tilestring.equals(" 34 1  24  2 31 ") || tilestring.equals(" 32 1  24  4 31 ") || tilestring.equals(" 34 2  24  1 31 ")){ //A and E and O and Q and U and V
				dout = 3;
			}
			else if(tilestring.equals(" 32 3  24  1 41 ") || tilestring.equals(" 34 3  24  2 11 ") || tilestring.equals(" 34 3  24  1 21 ") || tilestring.equals(" 32 3  24  4 11 ") || tilestring.equals(" 31 3  24  2 41 ")|| tilestring.equals(" 31 3  24  4 21 ")){ //B and J and L and M and P and W
				dout = 4;
			}
			else{
				dout = 0;
			}
		}
		else if(direction == 4){
			if(tilestring.equals(" 32 3  24  1 41 ") || tilestring.equals(" 32 4  24  3 11 ") || tilestring.equals(" 32 1  24  3 41 ") || tilestring.equals(" 32 3  24  4 11 ") || tilestring.equals(" 32 4  24  1 31 ") || tilestring.equals(" 32 1  24  4 31 ")){ //B and I and K and M and O and U
				dout = 1;
			}
			else if(tilestring.equals(" 33 4  24  2 11 ") || tilestring.equals(" 31 4  24  2 31 ") || tilestring.equals(" 33 1  24  2 41 ") || tilestring.equals(" 34 3  24  2 11 ") || tilestring.equals(" 31 3  24  2 41 ") || tilestring.equals(" 34 1  24  2 31 ")){ //D and E and G and J and P and Q
				dout = 2;
			}
			else if(tilestring.equals(" 34 1  24  3 21 ") || tilestring.equals(" 33 4  24  1 21 ") || tilestring.equals(" 34 3  24  1 21 ") || tilestring.equals(" 33 1  24  4 21 ") || tilestring.equals(" 31 4  24  3 21 ") || tilestring.equals(" 31 3  24  4 21 ")){ //C and H and L and R and T and W
				dout = 3;
			}
			else if(tilestring.equals(" 31 2  24  4 31 ") || tilestring.equals(" 33 2  24  4 11 ") || tilestring.equals(" 33 2  24  1 41 ") || tilestring.equals(" 34 2  24  3 11 ") || tilestring.equals(" 34 2  24  1 31 ") || tilestring.equals(" 31 2  24  3 41 ")){ //A and F and N and S and V and X
				dout = 4;
			}
			else{
				dout = 0;
			}
		}
		return dout;
	}
	//-------------------------------------------------------------------------------------------/method divider for organization	
	/*This method again takes in the position, direction of the track, and the board, passes that into the directionOut method
	 * to figure out which tile to look at next (where the track connects). If it hits the edge of the board, return the points
	 * (which is being incremented while it runs), if it hits a center station, it multiplies the score by 2 and then returns it,
	 * if it doesn't hit the border or a center station, return 0
	 */
	public int scorePath(int x, int y, int direction, char[][] _boardArray){
		int count = 0;
		while(directionOut(x, y, direction, _boardArray)!= 0){
			count++;
			direction = directionOut(x,y,direction, _boardArray);
			switch(direction){
			case 1:
				y = y - 4;
				break;
			case 2:
				x = x + 4;
				break;
			case 3:
				y = y + 4;
				break;
			case 4:
				x = x - 4;
				break;
			}
			if ( x < 1 || y < 1 || x > 47 || y > 47){
				return count;
			}
			if (x >= 21 && x <= 30 && y >= 21 && y <=30 ) {
				return 2*count;
			}

		}
		return 0;
	}
	//-------------------------------------------------------------------------------------------/method divider for organization	
	//This method takes in the string representing the current tile, the location it was desired to be placed at, and the 
	//current board in 2d array format.  It returns a boolean of true if the tile can be legally placed in the desired location.	
	public boolean TileTypeChecker(String tilestring, int locx, int locy,char [][] _boardArray) {

		if (tilestring.equals(" 31 2  24  4 31 ")) { //A
			return true;
		} 
		else if (tilestring.equals(" 32 3  24  1 41 ") || tilestring.equals(" 34 1  24  3 21 ")) { //B and C
			boolean allSpacesTaken = true;
			int[] xs1 = {2,3,4,5,8,9,10,11};
			for (int x : xs1) {
				for (int y=1; y<=12; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			int[] xs2 = {1,12};
			for (int x : xs2) {
				for (int y=2; y<=11; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			int[] xs3 = {6,7};
			for (int x : xs3) {
				for (int y=1; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
					allSpacesTaken &= !isEmpty(x,y+7,_boardArray);
				}
			}
			if(allSpacesTaken){
				return true;
			}
			else{
				return !((locx==1 || locx==12)&&(locy==1 || locy==12)); 
			}
		}
		else if (tilestring.equals(" 33 4  24  2 11 ")) { //D
			boolean allSpacesTaken = true;
			int[] xs1 = {2,3,4,5,8,9,10,11};
			for (int x : xs1) {
				for (int y=2; y<=11; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			int[] xs2 = {6,7};
			for (int x : xs2) {
				for (int y=2; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
					allSpacesTaken &= !isEmpty(x,y+6,_boardArray);
				}
			}
			if(allSpacesTaken){
				return true;
			}
			else{
				return !((locx==1 || locx==12 || locy==1 || locy==12)); 
			}
		}
		else if (tilestring.equals(" 31 4  24  2 31 ")) { //E
			boolean allSpacesTaken = true;
			int[] xs1 = {2,3,4,5,8,9,10,11};
			for (int x : xs1) {
				for (int y=1; y<=12; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			int[] xs2 = {6,7};
			for (int x : xs2) {
				for (int y=1; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
					allSpacesTaken &= !isEmpty(x,y+7,_boardArray);
				}
			}
			if(allSpacesTaken){
				return true;
			}
			else{
				return !((locx==1 || locx==12)); 
			}
		}
		else if (tilestring.equals(" 33 2  24  4 11 ")) { //F
			boolean allSpacesTaken = true;
			int[] xs1 = {1,2,3,4,5,8,9,10,11,12};
			for (int x : xs1) {
				for (int y=2; y<=11; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			int[] xs2 = {6,7};
			for (int x : xs2) {
				for (int y=2; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
					allSpacesTaken &= !isEmpty(x,y+6,_boardArray);
				}
			}
			if(allSpacesTaken){
				return true;
			}
			else{
				return !((locy==1 || locy==12)); 
			}
		}
		else if (tilestring.equals(" 33 1  24  2 41 ")) { //G
			boolean allSpacesTaken = true;
			int[] xs1 = {2,3,4,5,8,9,10,11};
			for (int x : xs1) {
				for (int y=2; y<=12; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			int[] xs2 = {6,7};
			for (int x : xs2) {
				for (int y=2; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			int[] xs3 = {6,7};
			for (int x : xs3) {
				for (int y=8; y<=12; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			int[] xs4 = {1};
			for (int x : xs4) {
				for (int y=2; y<=11; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			if(allSpacesTaken){
				return true;
			}
			else{
				return !((locx==12 || locy==1) || (locx==1 && locy==12)); 
			}
		}
		else if (tilestring.equals(" 33 4  24  1 21 ")) { //H
			boolean allSpacesTaken = true;
			int[] xs1 = {2,3,4,5,8,9,10,11};
			for (int x : xs1) {
				for (int y=2; y<=12; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			int[] xs2 = {6,7};
			for (int x : xs2) {
				for (int y=2; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			int[] xs3 = {6,7};
			for (int x : xs3) {
				for (int y=8; y<=12; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			int[] xs4 = {12};
			for (int x : xs4) {
				for (int y=2; y<=11; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			if(allSpacesTaken){
				return true;
			}
			else{
				return !((locx==1 || locy==1) || (locx==12 && locy==12)); 
			}
		}
		else if (tilestring.equals(" 32 4  24  3 11 ")) { //I
			boolean allSpacesTaken = true;
			int[] xs1 = {2,3,4,5,8,9,10,11};
			for (int x : xs1) {
				for (int y=1; y<=11; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			int[] xs2 = {6,7};
			for (int x : xs2) {
				for (int y=1; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			int[] xs3 = {6,7};
			for (int x : xs3) {
				for (int y=8; y<=11; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			int[] xs4 = {12};
			for (int x : xs4) {
				for (int y=2; y<=11; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			if(allSpacesTaken){
				return true;
			}
			else{
				return !((locx==1 || locy==12) || (locx==12 && locy==1)); 
			}
		}
		else if (tilestring.equals(" 34 3  24  2 11 ")) { //J
			boolean allSpacesTaken = true;
			int[] xs1 = {2,3,4,5,8,9,10,11};
			for (int x : xs1) {
				for (int y=1; y<=11; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			int[] xs2 = {6,7};
			for (int x : xs2) {
				for (int y=1; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			int[] xs3 = {6,7};
			for (int x : xs3) {
				for (int y=8; y<=11; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			int[] xs4 = {1};
			for (int x : xs4) {
				for (int y=2; y<=11; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			if(allSpacesTaken){
				return true;
			}
			else{
				return !((locx==12 || locy==12) || (locx==1 && locy==1)); 
			}
		}
		else if (tilestring.equals(" 32 1  24  3 41 ") || tilestring.equals(" 32 1  24  4 31 ") || tilestring.equals(" 31 2  24  3 41 ")) { //K and U and X
			boolean allSpacesTaken = true;
			int[] xs1 = {1,2,3,4,5,8,9,10,11,12};
			for (int x : xs1) {
				for (int y=2; y<=11; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			int[] xs2 = {6,7};
			for (int x : xs2) {
				for (int y=1; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
					allSpacesTaken &= !isEmpty(x,y+6,_boardArray);
				}
			}
			for (int x=1; x<=11; x++) {
				allSpacesTaken &= !isEmpty(x,1,_boardArray);
				allSpacesTaken &= !isEmpty(x+1,12,_boardArray);
			}
			if(allSpacesTaken){
				return true;
			}
			else{
				return !((locx==1 && locy==12) || (locx==12 && locy==1)); 
			}
		}
		else if (tilestring.equals(" 34 3  24  1 21 ") || tilestring.equals(" 34 2  24  1 31 ") || tilestring.equals(" 31 3  24  4 21 ")) { //L and V and W
			boolean allSpacesTaken = true;
			int[] xs1 = {1,2,3,4,5,8,9,10,11,12};
			for (int x : xs1) {
				for (int y=2; y<=11; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			int[] xs2 = {6,7};
			for (int x : xs2) {
				for (int y=1; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
					allSpacesTaken &= !isEmpty(x,y+6,_boardArray);
				}
			}
			for (int x=2; x<=12; x++) {
				allSpacesTaken &= !isEmpty(x,1,_boardArray);
				allSpacesTaken &= !isEmpty(x-1,12,_boardArray);
			}
			if(allSpacesTaken){
				return true;
			}
			else{
				return !((locx==1 && locy==1) || (locx==12 && locy==12)); 
			}
		}
		else if (tilestring.equals(" 32 3  24  4 11 ") || tilestring.equals(" 34 2  24  3 11 ")) { //M and S
			boolean allSpacesTaken = true;
			int[] xs1 = {1,2,3,4,5,8,9,10,11,12};
			for (int x : xs1) {
				for (int y=2; y<=11; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			int[] xs2 = {6,7};
			for (int x : xs2) {
				for (int y=2; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
					allSpacesTaken &= !isEmpty(x,y+6,_boardArray);
				}
			}
			for (int x=2; x<=11; x++) {
				allSpacesTaken &= !isEmpty(x,1,_boardArray);
			}
			if(allSpacesTaken){
				return true;
			}
			else{
				return !((locy==12)||(locx==1 && locy==1)||(locx==12 && locy==1)); 
			}
		}
		else if (tilestring.equals(" 33 2  24  1 41 ") || tilestring.equals(" 33 1  24  4 21 ")) { //N and R
			boolean allSpacesTaken = true;
			int[] xs1 = {1,2,3,4,5,8,9,10,11,12};
			for (int x : xs1) {
				for (int y=2; y<=11; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			int[] xs2 = {6,7};
			for (int x : xs2) {
				for (int y=2; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
					allSpacesTaken &= !isEmpty(x,y+6,_boardArray);
				}
			}
			for (int x=2; x<=11; x++) {
				allSpacesTaken &= !isEmpty(x,12,_boardArray);
			}
			if(allSpacesTaken){
				return true;
			}
			else{
				return !((locy==1)||(locx==1 && locy==12)||(locx==12 && locy==12)); 
			}
		}
		else if (tilestring.equals(" 32 4  24  1 31 ") || tilestring.equals(" 31 4  24  3 21 ")) { //O and T
			boolean allSpacesTaken = true;
			int[] xs1 = {2,3,4,5,8,9,10,11};
			for (int x : xs1) {
				for (int y=1; y<=12; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			int[] xs2 = {6,7};
			for (int x : xs2) {
				for (int y=1; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
					allSpacesTaken &= !isEmpty(x,y+7,_boardArray);
				}
			}
			for (int y=2; y<=11; y++) {
				allSpacesTaken &= !isEmpty(12,y,_boardArray);
			}
			if(allSpacesTaken){
				return true;
			}
			else{
				return !((locx==1)||(locx==12 && locy==1)||(locx==12 && locy==12)); 
			}
		}
		else if (tilestring.equals(" 31 3  24  2 41 ") || tilestring.equals(" 34 1  24  2 31 ")) { //P and Q
			boolean allSpacesTaken = true;
			int[] xs1 = {2,3,4,5,8,9,10,11};
			for (int x : xs1) {
				for (int y=1; y<=12; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
				}
			}
			int[] xs2 = {6,7};
			for (int x : xs2) {
				for (int y=1; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,_boardArray);
					allSpacesTaken &= !isEmpty(x,y+7,_boardArray);
				}
			}
			for (int y=2; y<=11; y++) {
				allSpacesTaken &= !isEmpty(1,y,_boardArray);
			}
			if(allSpacesTaken){
				return true;
			}
			else{
				return !((locx==12)||(locx==11 && locy==1)||(locx==1 && locy==12)); 
			}
		}
		else{
			return true; //never should execute here
		}
	}
	private BufferedImage stringToImage(String curTile){
		if(curTile.equals(" 31 2  24  4 31 ")){
			_guiTile = HelpfulImageMethods.loadImage("tileGUIPictures/TILEA.png");
		}
		else if(curTile.equals(" 32 3  24  1 41 ")){
			_guiTile = HelpfulImageMethods.loadImage("tileGUIPictures/TILEB.png");
		}
		else if(curTile.equals(" 34 1  24  3 21 ")){
			_guiTile = HelpfulImageMethods.loadImage("tileGUIPictures/TILEC.png");
		}
		else if(curTile.equals(" 33 4  24  2 11 ")){
			_guiTile = HelpfulImageMethods.loadImage("tileGUIPictures/TILED.png");
		}
		else if(curTile.equals(" 31 4  24  2 31 ")){
			_guiTile = HelpfulImageMethods.loadImage("tileGUIPictures/TILEE.png");
		}
		else if(curTile.equals(" 33 2  24  4 11 ")){
			_guiTile = HelpfulImageMethods.loadImage("tileGUIPictures/TILEF.png");
		}
		else if(curTile.equals(" 33 1  24  2 41 ")){
			_guiTile = HelpfulImageMethods.loadImage("tileGUIPictures/TILEG.png");
		}
		else if(curTile.equals(" 33 4  24  1 21 ")){
			_guiTile = HelpfulImageMethods.loadImage("tileGUIPictures/TILEH.png");
		}
		else if(curTile.equals(" 32 4  24  3 11 ")){
			_guiTile = HelpfulImageMethods.loadImage("tileGUIPictures/TILEI.png");
		}
		else if(curTile.equals(" 34 3  24  2 11 ")){
			_guiTile = HelpfulImageMethods.loadImage("tileGUIPictures/TILEJ.png");
		}
		else if(curTile.equals(" 32 1  24  3 41 ")){
			_guiTile = HelpfulImageMethods.loadImage("tileGUIPictures/TILEK.png");
		}
		else if(curTile.equals(" 34 3  24  1 21 ")){
			_guiTile = HelpfulImageMethods.loadImage("tileGUIPictures/TILEL.png");
		}
		else if(curTile.equals(" 32 3  24  4 11 ")){
			_guiTile = HelpfulImageMethods.loadImage("tileGUIPictures/TILEM.png");
		}
		else if(curTile.equals(" 33 2  24  1 41 ")){
			_guiTile = HelpfulImageMethods.loadImage("tileGUIPictures/TILEN.png");
		}
		else if(curTile.equals(" 32 4  24  1 31 ")){
			_guiTile = HelpfulImageMethods.loadImage("tileGUIPictures/TILEO.png");
		}
		else if(curTile.equals(" 31 3  24  2 41 ")){
			_guiTile = HelpfulImageMethods.loadImage("tileGUIPictures/TILEP.png");
		}
		else if(curTile.equals(" 34 1  24  2 31 ")){
			_guiTile = HelpfulImageMethods.loadImage("tileGUIPictures/TILEQ.png");
		}
		else if(curTile.equals(" 33 1  24  4 21 ")){
			_guiTile = HelpfulImageMethods.loadImage("tileGUIPictures/TILER.png");
		}
		else if(curTile.equals(" 34 2  24  3 11 ")){
			_guiTile = HelpfulImageMethods.loadImage("tileGUIPictures/TILES.png");
		}
		else if(curTile.equals(" 31 4  24  3 21 ")){
			_guiTile = HelpfulImageMethods.loadImage("tileGUIPictures/TILET.png");
		}
		else if(curTile.equals(" 32 1  24  4 31 ")){
			_guiTile = HelpfulImageMethods.loadImage("tileGUIPictures/TILEU.png");
		}
		else if(curTile.equals(" 34 2  24  1 31 ")){
			_guiTile = HelpfulImageMethods.loadImage("tileGUIPictures/TILEV.png");
		}
		else if(curTile.equals(" 31 3  24  4 21 ")){
			_guiTile = HelpfulImageMethods.loadImage("tileGUIPictures/TILEW.png");
		}
		else if(curTile.equals(" 31 2  24  3 41 ")){
			_guiTile = HelpfulImageMethods.loadImage("tileGUIPictures/TILEX.png");
		}
		return _guiTile;
	}
	public void tileClicked(Block t){
		int tx = t.getX();
		int ty = t.getY();
		JLabel labelrem;
		labelrem = (JLabel) _panel2.getComponentAt(_width*tx, _height*ty);
		_panel2.remove(labelrem);
		t.setX(tx);
		t.setY(ty);
		new Block(stringToImage(_curTile), tx, ty, tx, ty, _width, _height, _panel2, this);
		_panel2.repaint();
	}
}