package code;
//displays boardArray, Scannerman passes in our boardArray, then displays it
public class BoardDisplay {
	public BoardDisplay(char[][] boardArray){
		for(int i = 0; i < 50; i++){
			for(int j = 0; j < 51; j++){
				System.out.print(boardArray[i][j]);
			}
		}
	}
}