import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Animacja extends JPanel {
	AnimacjaRakieta rakieta;
	private static final int D_W = 400;
	private static final int D_H = 400;

	public Animacja() {
		rakieta = new AnimacjaRakieta(235, 200);
		setBackground(Color.black);
		Timer timer = new Timer(50, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rakieta.move();
				repaint();
			}
		});
		timer.start();
		
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(D_W, D_H);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		rakieta.drawRakieta(g);

	}

	

}
