package code;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TilesCreator {
	private List<String> _shuffledTiles;
	//the tiles are created, added to the list, and shuffled
    public TilesCreator(String tileLetters, String _curTile) {
    	if(tileLetters.equals("")){
    		List<String> coll = new java.util.LinkedList<String>();
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("A");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("B");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("C");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("D");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("E");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("F");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("G");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("H");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("I");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("J");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("K");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("L");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("M");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("N");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("O");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("P");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("Q");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("R");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("S");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("T");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("U");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("V");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("W");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("X");}

    		Collections.shuffle(coll);
    		java.util.Iterator<String> iterator = coll.iterator();

    		HashMap<String, String> tilesmap = new HashMap<String, String>();
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

    		_shuffledTiles = new java.util.LinkedList<String>();
    		while(iterator.hasNext()){
    			String tilerep = tilesmap.get(iterator.next());
    			_shuffledTiles.add(tilerep);
    		}
    	}
    	else{
    		List<String> coll = new java.util.LinkedList<String>();
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("A");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("B");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("C");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("D");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("E");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("F");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("G");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("H");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("I");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("J");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("K");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("L");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("M");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("N");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("O");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("P");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("Q");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("R");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("S");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("T");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("U");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("V");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("W");}
    		for(int pipina = 0; pipina<6; pipina++){
    			coll.add("X");}
    		
    		for(int i=0; i < tileLetters.length(); i++){
    			coll.remove(""+tileLetters.charAt(i));
    		}
    		
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
    		
    		coll.remove(tilesmap1.get(_curTile));
    		Collections.shuffle(coll);
    		java.util.Iterator<String> iterator = coll.iterator();

    		HashMap<String, String> tilesmap = new HashMap<String, String>();
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
    		
    		_shuffledTiles = new java.util.LinkedList<String>();
    		while(iterator.hasNext()){
    			String tilerep = tilesmap.get(iterator.next());
    			_shuffledTiles.add(tilerep);
    		}
    	}
    }
    //This method takes in a tile number and returns the current tile
    public String get(int tilenumber) {
		if(tilenumber <= 143){
			return _shuffledTiles.get(tilenumber);
		}
		return null;
	}
    //This method prints the current tile
	public void TileDisplay(int tilenumber){
		System.out.println(_shuffledTiles.get(tilenumber));
	}
}
