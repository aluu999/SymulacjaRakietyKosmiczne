
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FuelPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public float vgz, vgm, ngz, ngm, masaRakiety;
	public float predkoscValue, czasValue, paliwoValue;
	public JButton start;
	public JButton reset;
	public JLabel predkosc;
	public JLabel czas;
	public JLabel paliwo;
	public JProgressBar wskaznikPaliwa;
	public RakietaComboBoxListener panel;

	public FuelPanel(float vgz) { 

		panel = new RakietaComboBoxListener(); //tworze sobie obiekt klasy
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		start = new JButton("Start/Stop");

		ActionListener start_l = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg) {
				System.out.println(panel.get()); //w listenerze wylapuje tylko zero zamiast naszej wartosci z innej klasy
			}
		};
		start.addActionListener(start_l);

		reset = new JButton("Reset");
		predkosc = new JLabel();
		czas = new JLabel();
		paliwo = new JLabel();
		updateLabels();
		wskaznikPaliwa = new JProgressBar(0, 10);
		wskaznikPaliwa.setValue(6);
		wskaznikPaliwa.setForeground(Color.YELLOW);

		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(wskaznikPaliwa)
						.addComponent(predkosc).addComponent(czas).addComponent(paliwo))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(reset)
						.addComponent(start)));

		layout.linkSize(SwingConstants.HORIZONTAL, start, reset);

		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(wskaznikPaliwa)
						.addComponent(reset))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(predkosc))
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(czas))
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(paliwo)))
						.addComponent(start)));
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
//nie wykorzystuje tej metody
	public float set(float vgz) {
		return this.vgz = vgz;
	}
	
	public void resetValues() {
		wskaznikPaliwa.setValue(wskaznikPaliwa.getMaximum());
		predkoscValue = 0;
		czasValue = 0;
		paliwoValue = 0;	
		updateLabels();
	}
	
	private void updateLabels() {
		predkosc.setText("Pr??dko????: " + predkoscValue + " km/h");
		czas.setText("Czas: " + czasValue + " h");
		paliwo.setText("Zosta??o paliwa: " + paliwoValue + " kg");
	}

}
