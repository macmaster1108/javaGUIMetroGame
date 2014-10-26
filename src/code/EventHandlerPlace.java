package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EventHandlerPlace implements ActionListener {
	private boolean _hasPlaced;
	private char[][] boardArray;
	private boolean _invalidPlacement;
	private String curtile;
	private JPanel _pan2;
	private ScannerMan _sm;
	private BufferedImage _guiTile;
	private static int _x;
	private static int _y;
	
	public EventHandlerPlace(boolean hasPlaced, char[][] _boardArray, boolean invalidPlacement, String _curtile, JPanel pan2, ScannerMan sm) {
		_hasPlaced = hasPlaced;
		boardArray = _boardArray;
		_invalidPlacement = invalidPlacement;
		curtile = _curtile;
		_pan2 = pan2;
		_sm = sm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int x = 0;
		boolean canSave = true;
		while(x == 0){
			JTextField inputx = new JTextField();
			JLabel xcoord = new JLabel("X Coordinate:");
			final JComponent[] xinput = new JComponent[]{
					xcoord,
					inputx
			};
			JOptionPane.showMessageDialog(null,xinput,"Place",JOptionPane.PLAIN_MESSAGE);
			if(inputx.getText().equals("1") || inputx.getText().equals("2") || inputx.getText().equals("3") || inputx.getText().equals("4") || inputx.getText().equals("5") || inputx.getText().equals("6") || inputx.getText().equals("7") || inputx.getText().equals("8") || inputx.getText().equals("9") || inputx.getText().equals("10") || inputx.getText().equals("11") || inputx.getText().equals("12")){
				x = Integer.parseInt(inputx.getText());
			}
			else{
				JLabel xwrong = new JLabel("Not a valid X Coordinate! (1-12 Are Valid)");
				final JComponent[] inputwrong = new JComponent[]{
						xwrong
				};
				JOptionPane.showMessageDialog(null,inputwrong,"Place",JOptionPane.PLAIN_MESSAGE);
			}
		}
		int y = 0;
		while(y == 0){
			JTextField inputy = new JTextField();
			JLabel ycoord = new JLabel("Y Coordinate:");
			final JComponent[] xinput = new JComponent[]{
					ycoord,
					inputy
			};
			JOptionPane.showMessageDialog(null,xinput,"Place",JOptionPane.PLAIN_MESSAGE);
			if(inputy.getText().equals("1") || inputy.getText().equals("2") || inputy.getText().equals("3") || inputy.getText().equals("4") || inputy.getText().equals("5") || inputy.getText().equals("6") || inputy.getText().equals("7") || inputy.getText().equals("8") || inputy.getText().equals("9") || inputy.getText().equals("10") || inputy.getText().equals("11") || inputy.getText().equals("12")){
				y = Integer.parseInt(inputy.getText());
			}
			else{
				JLabel ywrong = new JLabel("Not a valid Y Coordinate! (1-12 Are Valid)");
				final JComponent[] inputwrong = new JComponent[]{
						ywrong
				};
				JOptionPane.showMessageDialog(null,inputwrong,"Place",JOptionPane.PLAIN_MESSAGE);
			}
		}
		_x = x;
		_y = y;
		if(canSave){
			//does nothing, just want to get rid of the yellow line
		}
		if(_invalidPlacement){
			//does nothing, just want to get rid of the yellow line
		}
		if(placeIsName(x, y)){
			canSave = false;
		}
	}
	
	public boolean placeIsName(int xcord, int ycord) {
		if((xcord == 6 && ycord == 6) || (xcord == 6 && ycord == 7) || (xcord == 7 && ycord == 6)|| (xcord == 7 && ycord == 7)){
			JLabel station = new JLabel("You Can't Place This Tile Here, There Is A Station There");
			final JComponent[] inputwrong = new JComponent[]{
					station
			};
			JOptionPane.showMessageDialog(null,inputwrong,"Place",JOptionPane.PLAIN_MESSAGE);
			return true;
		}
		else{
			if (!_hasPlaced && isEmpty(xcord, ycord, boardArray)) {
				JLabel labelrem;
				labelrem = (JLabel) _pan2.getComponentAt(xcord*50, ycord*50);
				_pan2.remove(labelrem);
				new Block(stringToImage(curtile), xcord, ycord, xcord, ycord, 50, 50, _pan2, _sm);
				_pan2.repaint();
				if (TileTypeChecker(curtile, xcord, ycord,boardArray) == true) {
					_hasPlaced = true;
					_invalidPlacement = false;
				}
				else {
					JLabel cant = new JLabel("You Can't Place This Tile Here, Please remove it");
					final JComponent[] inputwrong = new JComponent[]{
							cant
					};
					JOptionPane.showMessageDialog(null,inputwrong,"Place",JOptionPane.PLAIN_MESSAGE);
					_hasPlaced = true;
					_invalidPlacement = true;
				}
			} 
			else {
				JLabel invalid = new JLabel("Sorry, invalid tile placement. Either Something's already here or you already placed your tile.");
				final JComponent[] inputwrong = new JComponent[]{
						invalid
				};
				JOptionPane.showMessageDialog(null,inputwrong,"Place",JOptionPane.PLAIN_MESSAGE);
			}
			return true;
		}
	}
	public boolean TileTypeChecker(String tilestring, int locx, int locy,char[][] boardArray) {
		if (tilestring.equals(" 31 2  24  4 31 ")) { //A
			return true;
		} 
		else if (tilestring.equals(" 32 3  24  1 41 ") || tilestring.equals(" 34 1  24  3 21 ")) { //B and C
			boolean allSpacesTaken = true;
			int[] xs1 = {2,3,4,5,8,9,10,11};
			for (int x : xs1) {
				for (int y=1; y<=12; y++) {
					allSpacesTaken &= !isEmpty(x,y,boardArray);
				}
			}
			int[] xs2 = {1,12};
			for (int x : xs2) {
				for (int y=2; y<=11; y++) {
					allSpacesTaken &= !isEmpty(x,y,boardArray);
				}
			}
			int[] xs3 = {6,7};
			for (int x : xs3) {
				for (int y=1; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,boardArray);
					allSpacesTaken &= !isEmpty(x,y+7,boardArray);
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
					allSpacesTaken &= !isEmpty(x,y,boardArray);
				}
			}
			int[] xs2 = {6,7};
			for (int x : xs2) {
				for (int y=2; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,boardArray);
					allSpacesTaken &= !isEmpty(x,y+6,boardArray);
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
					allSpacesTaken &= !isEmpty(x,y,boardArray);
				}
			}
			int[] xs2 = {6,7};
			for (int x : xs2) {
				for (int y=1; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,boardArray);
					allSpacesTaken &= !isEmpty(x,y+7,boardArray);
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
					allSpacesTaken &= !isEmpty(x,y,boardArray);
				}
			}
			int[] xs2 = {6,7};
			for (int x : xs2) {
				for (int y=2; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,boardArray);
					allSpacesTaken &= !isEmpty(x,y+6,boardArray);
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
					allSpacesTaken &= !isEmpty(x,y,boardArray);
				}
			}
			int[] xs2 = {6,7};
			for (int x : xs2) {
				for (int y=2; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,boardArray);
				}
			}
			int[] xs3 = {6,7};
			for (int x : xs3) {
				for (int y=8; y<=12; y++) {
					allSpacesTaken &= !isEmpty(x,y,boardArray);
				}
			}
			int[] xs4 = {1};
			for (int x : xs4) {
				for (int y=2; y<=11; y++) {
					allSpacesTaken &= !isEmpty(x,y,boardArray);
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
					allSpacesTaken &= !isEmpty(x,y,boardArray);
				}
			}
			int[] xs2 = {6,7};
			for (int x : xs2) {
				for (int y=2; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,boardArray);
				}
			}
			int[] xs3 = {6,7};
			for (int x : xs3) {
				for (int y=8; y<=12; y++) {
					allSpacesTaken &= !isEmpty(x,y,boardArray);
				}
			}
			int[] xs4 = {12};
			for (int x : xs4) {
				for (int y=2; y<=11; y++) {
					allSpacesTaken &= !isEmpty(x,y,boardArray);
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
					allSpacesTaken &= !isEmpty(x,y,boardArray);
				}
			}
			int[] xs2 = {6,7};
			for (int x : xs2) {
				for (int y=1; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,boardArray);
				}
			}
			int[] xs3 = {6,7};
			for (int x : xs3) {
				for (int y=8; y<=11; y++) {
					allSpacesTaken &= !isEmpty(x,y,boardArray);
				}
			}
			int[] xs4 = {12};
			for (int x : xs4) {
				for (int y=2; y<=11; y++) {
					allSpacesTaken &= !isEmpty(x,y,boardArray);
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
					allSpacesTaken &= !isEmpty(x,y,boardArray);
				}
			}
			int[] xs2 = {6,7};
			for (int x : xs2) {
				for (int y=1; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,boardArray);
				}
			}
			int[] xs3 = {6,7};
			for (int x : xs3) {
				for (int y=8; y<=11; y++) {
					allSpacesTaken &= !isEmpty(x,y,boardArray);
				}
			}
			int[] xs4 = {1};
			for (int x : xs4) {
				for (int y=2; y<=11; y++) {
					allSpacesTaken &= !isEmpty(x,y,boardArray);
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
					allSpacesTaken &= !isEmpty(x,y,boardArray);
				}
			}
			int[] xs2 = {6,7};
			for (int x : xs2) {
				for (int y=1; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,boardArray);
					allSpacesTaken &= !isEmpty(x,y+6,boardArray);
				}
			}
			for (int x=1; x<=11; x++) {
				allSpacesTaken &= !isEmpty(x,1,boardArray);
				allSpacesTaken &= !isEmpty(x+1,12,boardArray);
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
					allSpacesTaken &= !isEmpty(x,y,boardArray);
				}
			}
			int[] xs2 = {6,7};
			for (int x : xs2) {
				for (int y=1; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,boardArray);
					allSpacesTaken &= !isEmpty(x,y+6,boardArray);
				}
			}
			for (int x=2; x<=12; x++) {
				allSpacesTaken &= !isEmpty(x,1,boardArray);
				allSpacesTaken &= !isEmpty(x-1,12,boardArray);
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
					allSpacesTaken &= !isEmpty(x,y,boardArray);
				}
			}
			int[] xs2 = {6,7};
			for (int x : xs2) {
				for (int y=2; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,boardArray);
					allSpacesTaken &= !isEmpty(x,y+6,boardArray);
				}
			}
			for (int x=2; x<=11; x++) {
				allSpacesTaken &= !isEmpty(x,1,boardArray);
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
					allSpacesTaken &= !isEmpty(x,y,boardArray);
				}
			}
			int[] xs2 = {6,7};
			for (int x : xs2) {
				for (int y=2; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,boardArray);
					allSpacesTaken &= !isEmpty(x,y+6,boardArray);
				}
			}
			for (int x=2; x<=11; x++) {
				allSpacesTaken &= !isEmpty(x,12,boardArray);
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
					allSpacesTaken &= !isEmpty(x,y,boardArray);
				}
			}
			int[] xs2 = {6,7};
			for (int x : xs2) {
				for (int y=1; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,boardArray);
					allSpacesTaken &= !isEmpty(x,y+7,boardArray);
				}
			}
			for (int y=2; y<=11; y++) {
				allSpacesTaken &= !isEmpty(12,y,boardArray);
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
					allSpacesTaken &= !isEmpty(x,y,boardArray);
				}
			}
			int[] xs2 = {6,7};
			for (int x : xs2) {
				for (int y=1; y<=5; y++) {
					allSpacesTaken &= !isEmpty(x,y,boardArray);
					allSpacesTaken &= !isEmpty(x,y+7,boardArray);
				}
			}
			for (int y=2; y<=11; y++) {
				allSpacesTaken &= !isEmpty(1,y,boardArray);
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
	public boolean isEmpty(int x, int y, char[][] boardArray) {
		return (boardArray[4 * (y - 1) + 1][4 * (x - 1) + 2] == ' ');
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
	public static int getX(){
		return _x;
	}
	public static int getY(){
		return _y;
	}
}