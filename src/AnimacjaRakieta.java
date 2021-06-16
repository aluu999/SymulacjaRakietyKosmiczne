import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class AnimacjaRakieta {
	private static final int INCREMENT = 5;

	int x, y,wsx,wsy;

	public AnimacjaRakieta(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void drawRakieta(Graphics g) {

		for (int i = 0; i < 50; i++) {
			wsx = (int) (500 * Math.random());
			wsy = (int) (500 * Math.random());
			g.setColor(Color.white);
			g.fillOval(wsx, wsy, 2, 3);
		}

		g.setColor(new Color(229, 223, 223));
		g.fillRect(x, y, 30, 90);

		// dach
		int xPoints[] = { x - 5, x + 15, x + 35 };
		int yPoints[] = { y, y - 30, y };
		g.setColor(new Color(229, 223, 223));
		g.fillPolygon(xPoints, yPoints, 3);

		// skrzydla
		int xPoints1[] = { x - 5, x, x, x - 5 };
		int yPoints1[] = { y + 110, y + 90, y + 60, y + 80 };
		g.setColor(new Color(220, 191, 191));
		g.fillPolygon(xPoints1, yPoints1, 4);

		int xPoints2[] = { x + 35, x + 30, x + 30, x + 35 };
		int yPoints2[] = { y + 110, y + 90, y + 60, y + 80 };
		g.setColor(new Color(220, 191, 191));
		g.fillPolygon(xPoints2, yPoints2, 4);

		for(int j=0; j<10; j++)
		{
			int x1 =  (int) (30*Math.random());
			int x2 = (int)  (30*Math.random());
			int y1 =  (int)  (10*Math.random());
			int y2 = (int) (Math.random()*(50-10)+10);
			g.setColor(new Color(255,177,18));
			
			g.drawLine(x+x1, y+90+y1, x+x2, y+90+y2);
		}

	}

	public void move() {
		if (y == 400) {
			y = 400;
		}
		if (y == 0) {
			y = 400;
		} else {
			y -= INCREMENT;
		}
	}
}