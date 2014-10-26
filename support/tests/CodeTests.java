package tests;
/*
 * 
 * 
 * PLEASE MANUALLY ENTER THE FOLLOWING COMMANDS INTO THE CONSOLE TO RUN ALL JUNIT TESTS! THANK YOU FOR YOUR PATRONAGE!
 * place(3,3)
 * commit
 * resign
 
 
 
 * 
 */
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import code.*;





public class CodeTests {
	String topbordera;
	String bottombordere;
	String leftborderh;
	String rightborderd;
	ArrayList<String> names;



	@Test
	public void directionOutTest(){
		names = new ArrayList<String>();
		names.add("bob");
		names.add("bob2");
		ScannerMan lol = new ScannerMan(2, false, names, false, 1);
		char[][] _boardArray = new char[50][51];
		topbordera = "ABABABABABAB";
		bottombordere = "BABABABABABA";
		leftborderh = "BABABABABABA";
		rightborderd = "ABABABABABAB";
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
		int actual = lol.directionOut(1, 1, 3, _boardArray);


		int expected = 0;

		assertTrue("I expected the value to be "+expected+" but your code returned"+actual, actual == expected);
	}




	@Test
	public void isEmptyTestWithoutTile(){
		names = new ArrayList<String>();
		names.add("bob");
		names.add("bob2");
		ScannerMan lol = new ScannerMan(2, false, names, false, 1);
		char[][] _boardArray = new char[50][51];
		topbordera = "ABABABABABAB";
		bottombordere = "BABABABABABA";
		leftborderh = "BABABABABABA";
		rightborderd = "ABABABABABAB";
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


		boolean actual = lol.isEmpty(2,2,_boardArray);
		boolean expected = true;
		assertTrue("I expected the value to be "+expected+" but your code returned"+actual, actual == expected);
		//please manually type resign in the console

	}
	
	@Test
	public void isEmptyTestWithTile(){
		names = new ArrayList<String>();
		names.add("bob");
		names.add("bob2");
		ScannerMan lol = new ScannerMan(2, false, names, false, 1);
		char[][] _boardArray = new char[50][51];
		topbordera = "ABABABABABAB";
		bottombordere = "BABABABABABA";
		leftborderh = "BABABABABABA";
		rightborderd = "ABABABABABAB";
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
		_boardArray[5][6] = '3';


		boolean actual = lol.isEmpty(2,2,_boardArray);
		boolean expected = false;
		assertTrue("I expected the value to be "+expected+" but your code returned"+actual, actual == expected);
		//please manually type resign in the console

	}
	@Test
	public void scorePathTest(){
		names = new ArrayList<String>();
		names.add("bob");
		names.add("bob2");
		ScannerMan lol = new ScannerMan(2, false, names, false, 1);
		char[][] _boardArray = new char[50][51];
		topbordera = "ABABABABABAB";
		bottombordere = "BABABABABABA";
		leftborderh = "BABABABABABA";
		rightborderd = "ABABABABABAB";
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


		int actual = lol.scorePath(2,2, 3,_boardArray);
		int expected = 0;
		assertTrue("I expected the value to be "+expected+" but your code returned"+actual, actual == expected);

	}
	@Test
	public void TileTypeCheckerCanGoAnywhereTest(){
		names = new ArrayList<String>();
		names.add("bob");
		names.add("bob2");
		ScannerMan lol = new ScannerMan(2, false, names, false, 1);
		char[][] _boardArray = new char[50][51];
		topbordera = "ABABABABABAB";
		bottombordere = "BABABABABABA";
		leftborderh = "BABABABABABA";
		rightborderd = "ABABABABABAB";
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


		boolean actual = lol.TileTypeChecker(" 31 2  24  4 31 ",2, 3,_boardArray);
		boolean expected = true;
		assertTrue("I expected the value to be "+expected+" but your code returned"+actual, actual == expected);

	}
	@Test
	public void TileTypeCheckerTestCantGoInCornersLegalA(){
		names = new ArrayList<String>();
		names.add("bob");
		names.add("bob2");
		ScannerMan lol = new ScannerMan(2, false, names, false, 1);
		char[][] _boardArray = new char[50][51];
		topbordera = "ABABABABABAB";
		bottombordere = "BABABABABABA";
		leftborderh = "BABABABABABA";
		rightborderd = "ABABABABABAB";
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

		boolean actual = lol.TileTypeChecker(" 32 3  24  1 41 ",2, 3,_boardArray);
		boolean expected = true;
		assertTrue("I expected the value to be "+expected+" but your code returned"+actual, actual == expected);

	}
	@Test
	public void TileTypeCheckerCantGoInCornersIllegalTestA(){
		names = new ArrayList<String>();
		names.add("bob");
		names.add("bob2");
		ScannerMan lol = new ScannerMan(2, false, names, false, 1);
		char[][] _boardArray = new char[50][51];
		topbordera = "ABABABABABAB";
		bottombordere = "BABABABABABA";
		leftborderh = "BABABABABABA";
		rightborderd = "ABABABABABAB";
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


		boolean actual = lol.TileTypeChecker(" 32 3  24  1 41 ",1, 1,_boardArray);
		boolean expected = false;
		assertTrue("I expected the value to be "+expected+" but your code returned"+actual, actual == expected);

	}
	@Test
	public void TileTypeCheckerTestCantGoInCornersLegalB(){
		names = new ArrayList<String>();
		names.add("bob");
		names.add("bob2");
		ScannerMan lol = new ScannerMan(2, false, names, false, 1);
		char[][] _boardArray = new char[50][51];
		topbordera = "ABABABABABAB";
		bottombordere = "BABABABABABA";
		leftborderh = "BABABABABABA";
		rightborderd = "ABABABABABAB";
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
		boolean actual = lol.TileTypeChecker(" 34 1  24  3 21 ",2, 3,_boardArray);
		boolean expected = true;
		assertTrue("I expected the value to be "+expected+" but your code returned"+actual, actual == expected);

	}
	@Test
	public void TileTypeCheckerTestCantGoInCornersIlLegalB(){
		names = new ArrayList<String>();
		names.add("bob");
		names.add("bob2");
		ScannerMan lol = new ScannerMan(2, false, names, false, 1);
		char[][] _boardArray = new char[50][51];
		topbordera = "ABABABABABAB";
		bottombordere = "BABABABABABA";
		leftborderh = "BABABABABABA";
		rightborderd = "ABABABABABAB";
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

		boolean actual = lol.TileTypeChecker(" 34 1  24  3 21 ",1, 1,_boardArray);
		boolean expected = false;
		assertTrue("I expected the value to be "+expected+" but your code returned"+actual, actual == expected);

	}





	@Test
	public void TileTypeCheckerCantGoInCornersLegalTestC(){
		names = new ArrayList<String>();
		names.add("bob");
		names.add("bob2");
		ScannerMan lol = new ScannerMan(2, false, names, false, 1);
		char[][] _boardArray = new char[50][51];
		topbordera = "ABABABABABAB";
		bottombordere = "BABABABABABA";
		leftborderh = "BABABABABABA";
		rightborderd = "ABABABABABAB";
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


		boolean actual = lol.TileTypeChecker(" 33 4  24  2 11 ",2, 3,_boardArray);
		boolean expected = true;
		assertTrue("I expected the value to be "+expected+" but your code returned"+actual, actual == expected);

	}
	@Test
	public void TileTypeCheckerCantGoInCornersIllegalTestC(){
		names = new ArrayList<String>();
		names.add("bob");
		names.add("bob2");
		ScannerMan lol = new ScannerMan(2, false, names, false, 1);
		char[][] _boardArray = new char[50][51];
		topbordera = "ABABABABABAB";
		bottombordere = "BABABABABABA";
		leftborderh = "BABABABABABA";
		rightborderd = "ABABABABABAB";
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


		boolean actual = lol.TileTypeChecker(" 33 4  24  2 11 ",1, 1,_boardArray);
		boolean expected = false;
		assertTrue("I expected the value to be "+expected+" but your code returned"+actual, actual == expected);

	}
	@Test
	public void TileTypeCheckerIllegalOnBorderTest(){
		names = new ArrayList<String>();
		names.add("bob");
		names.add("bob2");
		ScannerMan lol = new ScannerMan(2, false, names, false, 1);
		char[][] _boardArray = new char[50][51];
		topbordera = "ABABABABABAB";
		bottombordere = "BABABABABABA";
		leftborderh = "BABABABABABA";
		rightborderd = "ABABABABABAB";
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
		boolean actual = lol.TileTypeChecker(" 33 4  24  2 11 ",1, 1,_boardArray);
		boolean expected = false;
		assertTrue("I expected the value to be "+expected+" but your code returned"+actual, actual == expected);

	}








}
