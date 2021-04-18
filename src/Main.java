import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel panel1;
	public ButtonPanel panel2;
	public FuelPanel panel3;
	public float vgz;
	public RakietaComboBoxListener panel;
	public SaturnV saturnV;
	public BigFalconRocket BFR;
	public int wsk;
	public int i = 0;
	public int poczatkowaMasa;



	public Main() throws HeadlessException {
		this.setSize(640, 480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());

		saturnV = new SaturnV();
		BFR = new BigFalconRocket();

		panel1 = new JPanel();
		this.add(panel1, BorderLayout.CENTER);
		panel2 = new ButtonPanel();
		this.add(panel2, BorderLayout.LINE_END);

		panel = new RakietaComboBoxListener();
		panel3 = new FuelPanel();
		
		
		
		

		this.add(panel3, BorderLayout.PAGE_END);

		panel1.setBackground(Color.black); // to tylko do pomocy dla mnie, potem to usunê
		panel2.setBackground(Color.blue);
		panel3.setBackground(Color.green);

		panel3.reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel2.resetValues();
				panel3.resetValues();
			}
		});

		panel3.start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (true) {
					panel3.wskaznikPaliwa.setMaximum(panel2.getMasaPaliwa());
					ObliczeniaProgressBar();
					// funkcja obliczania prêdkoœci
					// ewentualna funkcja uruchomienia animacji

				}
			}
		});
		
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

	void ObliczeniaProgressBar() {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

		scheduler.scheduleWithFixedDelay((new Runnable() {

			@Override
			public void run() {

				String rakieta = (String) panel2.wyborRakiety.getSelectedItem();
				String planeta = (String) panel2.wyborPlanety.getSelectedItem();
				poczatkowaMasa = panel2.getMasaPaliwa();
				
				switch (rakieta) {
				case ("Saturn V"):

					switch (planeta) {
					
					case ("Ziemia"):
						if (poczatkowaMasa > saturnV.ngz) {
							poczatkowaMasa = poczatkowaMasa - (saturnV.ngz * i);
							
						} else {
							JOptionPane.showMessageDialog(null, "Zbyt ma³a masa pliwa", "Anulowano",
									JOptionPane.WARNING_MESSAGE);
							
							//jak zakonczyæ w¹tek?!?!!!?!?!?!?!?!
							// czy tu powinno byæ jakieœ wyjœcie z runa?
						}

						break;
						
					case ("Mars"):
						if (poczatkowaMasa > saturnV.ngm) {
							poczatkowaMasa = poczatkowaMasa - (saturnV.ngm * i);
						} else {
							JOptionPane.showMessageDialog(null, "Zbyt ma³a masa pliwa", "Anulowano",
									JOptionPane.WARNING_MESSAGE);
						}
						break;
					}

					break;
				case ("Big Falcon Rocket"):

					switch (planeta) {
					
					case ("Ziemia"):
						if (poczatkowaMasa > BFR.ngz) {
							poczatkowaMasa = poczatkowaMasa - (BFR.ngz * i);
						} else {
							JOptionPane.showMessageDialog(null, "Zbyt ma³a masa pliwa", "Anulowano",
									JOptionPane.WARNING_MESSAGE);
						}
						break;
						
					case ("Mars"):
						if (poczatkowaMasa > BFR.ngm) {
							poczatkowaMasa = poczatkowaMasa - (BFR.ngm * i);

						} else {
							JOptionPane.showMessageDialog(null, "Zbyt ma³a masa pliwa", "Anulowano",
									JOptionPane.WARNING_MESSAGE);
						}
						break;
					}
					break;
				}

				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						panel3.wskaznikPaliwa.setValue(poczatkowaMasa);
						i++;
						
					}

				});

				

			}
		}), 0, 1, TimeUnit.SECONDS);

	}

}
