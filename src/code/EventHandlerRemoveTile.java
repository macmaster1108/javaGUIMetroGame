package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import code.EventHandlerPlace;

public class EventHandlerRemoveTile implements ActionListener {
	private JPanel _pan2;
	private ScannerMan _sm;
	
	public EventHandlerRemoveTile(JPanel _panel2, ScannerMan scannerMan) {
		_sm = scannerMan;
		_pan2 = _panel2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int x = EventHandlerPlace.getX();
		int y = EventHandlerPlace.getY();
		JLabel labelrem;
		labelrem = (JLabel) _pan2.getComponentAt(x*50, y*50);
		_pan2.remove(labelrem);
		new Block(HelpfulImageMethods.loadImage("tileGUIPictures/Tile0.png"), x, y, x, y, 50, 50, _pan2, _sm);
		_pan2.repaint();
	}
}