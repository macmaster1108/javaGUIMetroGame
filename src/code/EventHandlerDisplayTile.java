package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class EventHandlerDisplayTile implements ActionListener {
	private BufferedImage _guiTile;
	
	public EventHandlerDisplayTile(BufferedImage guiTile) {
		_guiTile = guiTile;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ImageIcon icon = new ImageIcon(_guiTile);
		JLabel tileViewer = new JLabel("Current Tile:");
		tileViewer.setHorizontalTextPosition(SwingConstants.LEADING);
		tileViewer.setHorizontalAlignment(SwingConstants.LEADING);
		tileViewer.setIcon(icon);
		final JComponent[] inputs = new JComponent[]{
				tileViewer
		};
		JOptionPane.showMessageDialog(null,inputs,"Display Tile",JOptionPane.PLAIN_MESSAGE);
	}
}