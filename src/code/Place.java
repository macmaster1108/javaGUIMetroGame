package code;
//The place method is passed in integers from Scannerman and converts them to the Array placement rules.
//This converts the input and the passed in tile into the board array for user viewing.

public class Place {
	public Place(int col, int row, String curTile, char[][] boardArray){
		int x = (4*(col - 1)+1);
		int y = (4*(row - 1)+1);
		int k = 0;
		for(int i = 0; i <= 3; i++){
			for(int j = 0; j <= 3; j ++){
				boardArray[y+i][x+j] = curTile.charAt(k);
				k++;
			}
		}
	}
}