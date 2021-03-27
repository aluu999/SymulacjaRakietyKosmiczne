import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel panel1;
	public ButtonPanel panel2;
	public FuelPanel panel3;
	

	public Main() throws HeadlessException {
		this.setSize(640, 480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());

		// pierwszy panel centralny to bêdzie animacja
		// drugi panel to przyciski wyborów
		// trzeci to wskanik paliwa, labelki ilepaliwa i predkoœæ oraz buttony start/stop, reset
		
		panel1 = new JPanel();
		this.add(panel1, BorderLayout.CENTER);
		panel2 = new ButtonPanel();
		this.add(panel2, BorderLayout.LINE_END);
		panel3 = new FuelPanel();
		this.add(panel3, BorderLayout.PAGE_END);

		panel1.setBackground(Color.black); // to tylko do pomocy dla mnie, potem to usunê
		panel2.setBackground(Color.blue);
		panel3.setBackground(Color.green);
		
	
	}

	public Main(GraphicsConfiguration gc) {
		super(gc);
		this.setSize(640, 480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public Main(String title) throws HeadlessException {
		super(title);
		this.setSize(640, 480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public Main(String title, GraphicsConfiguration gc) {
		super(title, gc);
		this.setSize(640, 480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		Main frame = new Main();
		frame.setVisible(true);

	}

}
