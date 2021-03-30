
import java.awt.LayoutManager;


import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FuelPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public JButton start;
	public JButton reset;
	public JLabel predkosc;
	public JLabel czas;
	public JLabel paliwo;
	public JTextField wskaznikPaliwa;//to ma być progress bar

	public FuelPanel() {
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		start = new JButton("Start/Stop");
		reset = new JButton("Reset");
		predkosc = new JLabel("Prędkość:");
		czas = new JLabel("Czas:");
		paliwo = new JLabel("Zostało paliwa: ");
		wskaznikPaliwa = new JTextField("to będzie progress bar");

		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(wskaznikPaliwa)
						.addComponent(predkosc)
						.addComponent(czas)
						.addComponent(paliwo))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(reset)
						.addComponent(start))
				);

		layout.linkSize(SwingConstants.HORIZONTAL, start, reset);

		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(wskaznikPaliwa)
				        .addComponent(reset))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
					            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					            		.addComponent(predkosc))
					            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(czas))
					            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(paliwo)))
						.addComponent(start))
				);
	}

	public FuelPanel(LayoutManager layout) {
		super(layout);

	}

	public FuelPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);

	}

	public FuelPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);

	}
}
