package code;
//This block class takes in cordinates, a piece of the current game board for gui and pastes it on its own jLabel and put
//it in its proper place
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Block {
	private JLabel _label;
	int _x;
	int _y;
	public Block(BufferedImage im,int x, int y, int i, int g, int width, int height, JPanel pan2,ScannerMan fp) {
		_x =x;
		_y =y;
		ImageIcon icon = new ImageIcon(im);
		_label = new JLabel(icon);
		_label.setBounds((i*width), (g*height), width, height);
		pan2.add(_label);
	}
	
	public int getX(){
		return _x;
	}

	public int getY(){
		return _y;
	}

	public void setX(int x){
		_x = x;
	}

	public void setY(int y){
		_y = y;
	}
}	

