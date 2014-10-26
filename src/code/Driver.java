package code;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//Asks how you want to play the game, tui or gui, then asks how many players will be playing, then starts Scannerman based on user's answers

public class Driver {
	private static boolean isSaved = false;
	private static int thenumber;
	private static boolean isGui = false;
	private static ArrayList<String> playerNames;
	private static int desiredInt;
	private static boolean selectedGame;
	public static void main(String[] args) {
		playerNames = new ArrayList<String>();
		System.out.println("Would You Like To Play GUI or TUI");
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String name;
			name = input.nextLine();
			if(name.equals("GUI") || name.equals("gui")){
				JTextField playerinput = new JTextField();
				final JComponent[] inputs = new JComponent[]{
						new JLabel("Enter Your Number of Players 2-8"),
						playerinput
				};
				JOptionPane.showMessageDialog(null,inputs,"Player Amount Selection",JOptionPane.PLAIN_MESSAGE);
				if(playerinput.getText().equals("2") || playerinput.getText().equals("3") || playerinput.getText().equals("4") || playerinput.getText().equals("5") || playerinput.getText().equals("6") || playerinput.getText().equals("7") || playerinput.getText().equals("8")){
					thenumber = Integer.parseInt(playerinput.getText());
					isGui = true;
				}
				else{
					System.out.println("You didn't enter a valid number of players!");
					System.out.println("");
					System.out.println("Would You Like To Play GUI or TUI");
				}
				if(isGui){
					for(int i = 1; i <= thenumber; i++){
						JTextField playerinput2 = new JTextField();
						final JComponent[] inputs2 = new JComponent[]{
								new JLabel("Please Enter Player " + i + "'s Name:"),
								playerinput2
						};
						JOptionPane.showMessageDialog(null,inputs2,"Player " + i + "'s Name Selection",JOptionPane.PLAIN_MESSAGE);
						playerNames.add(playerinput2.getText());
					}
					String filename = new String();
					for(int i = 0; i<playerNames.size(); i++){
						filename += playerNames.get(i) + "-";
					}
					int i = 1;
					while((new File("src/code/"+filename + i + ".txt")).exists()){
						i++;
					}
					JTextField playerinput3 = new JTextField();
					selectedGame = false;
					for(int j = 1; j < i; j++){
						final JComponent[] inputs3 = new JComponent[]{
								new JLabel("Load Game "+j+"?"),
								new JLabel("Y/N"),
								playerinput3
						};
						JOptionPane.showMessageDialog(null,inputs3,"Game Selection",JOptionPane.PLAIN_MESSAGE);
						if(playerinput3.getText().equals("Y")){
							selectedGame = true;
							desiredInt = j;
							break;
						}
						else if(playerinput3.getText().equals("N")){
						}
						else{
							j = j - 1;
						}
					}
					if(selectedGame == false){
						final JComponent[] inputs4 = new JComponent[]{
								new JLabel("Starting Up A New Game Because There Are No Saved Games Or You Didn't Load Up One"),
						};
						JOptionPane.showMessageDialog(null,inputs4,"Game Selection",JOptionPane.PLAIN_MESSAGE);
						desiredInt = i;
					}
					if(desiredInt > 0 && desiredInt < i){
						isSaved = true;
						break;
					}
					else if(desiredInt == i){
						break;
					}
				}
			}
			
			else if(name.equals("TUI") || name.equals("tui")){
				System.out.println("Enter Your Number of Players 2-8");
				while(input.hasNext()){
					String name2;
					name2 = input.nextLine();
					if(name2.equals("2")){
						thenumber = 2;
						break;
					}
					else if(name2.equals("3")){
						thenumber = 3;
						break;
					}
					else if(name2.equals("4")){
						thenumber = 4;
						break;
					}
					else if(name2.equals("5")){
						thenumber = 5;
						break;
					}
					else if(name2.equals("6")){
						thenumber = 6;
						break;
					}
					else if(name2.equals("7")){
						thenumber = 7;
						break;
					}
					else if(name2.equals("8")){
						thenumber = 8;
						break;
					}
					else{
						System.out.println("Please Enter Your Number of Players 2-8");
					}
				}
				for(int i = 1; i <= thenumber; i++){
					System.out.println("Please Enter Player " + i + "'s Name:");
					while(input.hasNext()){
						String name3;
						name3 = input.nextLine();
						playerNames.add(name3);
						break;
					}
				}
				String filename = new String();
				for(int i = 0; i<playerNames.size(); i++){
					filename += playerNames.get(i) + "-";
				}
				int i = 1;
				while((new File("src/code/"+filename + i + ".txt")).exists()){
					i++;
				}
				System.out.println("Select A Game:");
				for(int j = 1; j < i; j++){
					System.out.println(""+j+". Game "+j);
				}
				System.out.println(""+i+". New Game");
				while(input.hasNext()){
					try {
						desiredInt = Integer.parseInt(input.nextLine());
					} 
					catch(NumberFormatException e) {
						desiredInt = 0;
					}
					if(desiredInt > 0 && desiredInt < i){
						isSaved = true;
						break;
					}
					else if(desiredInt == i){
						break;
					}
					else{
						System.out.println("Please Type a Valid Number");
					}
				}
				break;
			}
			else{
				System.out.println("Please Select GUI or TUI");
			}
		}
		new ScannerMan(thenumber, isGui, playerNames, isSaved, desiredInt);
	}	
}