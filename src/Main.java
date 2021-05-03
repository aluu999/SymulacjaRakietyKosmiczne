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

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel panel1;
	public ButtonPanel panel2;
	public FuelPanel panel3;
	public Obliczenia obliczenia;
	public int i, k;
	public double poczatkowaMasa;
	static double gz = 9.8;
	static double gm = 3.7;
	boolean isRunning; // domyslnie jest false

	public Main() throws HeadlessException {
		this.setSize(640, 480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());

		isRunning = false;

		panel1 = new JPanel();
		this.add(panel1, BorderLayout.CENTER);
		panel2 = new ButtonPanel();
		this.add(panel2, BorderLayout.LINE_END);

		panel3 = new FuelPanel();

		this.add(panel3, BorderLayout.PAGE_END);

		panel1.setBackground(Color.black); // to tylko do pomocy dla mnie, potem to usunê
		panel2.setBackground(Color.blue);
		panel3.setBackground(Color.green);

		panel3.reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isRunning = false;
				panel2.resetValues();
				panel3.resetValues();
			}
		});

		panel3.start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (isRunning == false) {
					if (panel2.wyborRakiety.getSelectedItem() == "Wybierz rakiete..."
							|| panel2.wyborPlanety.getSelectedItem() == "Wybierz planete...") {
						JOptionPane.showMessageDialog(null, "Nie wypełniono wymaganych pól", "Informacja",
								JOptionPane.WARNING_MESSAGE);
						return;
					}
					isRunning = true;
					// k++;
					i = 0; // jezeli klikam start, liczy od poczatku
					panel3.wskaznikPaliwa.setMaximum(panel2.getMasaPaliwa());
					ObliczeniaProgressBar();

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

				obliczenia = new Obliczenia();
				obliczenia.przerwijWatek(scheduler, isRunning); // przerywanie watku do reseta

				// obliczenia.sprawdzParzystosc(scheduler, k); //to mialo byc do "stop"

				Rakieta wybranaRakieta = (Rakieta) panel2.wyborRakiety.getSelectedItem();
				String planeta = (String) panel2.wyborPlanety.getSelectedItem();

				poczatkowaMasa = panel2.getMasaPaliwa();

				switch (planeta) {
				case ("Ziemia"):
					obliczenia.oblicz(poczatkowaMasa, wybranaRakieta.getMasaRakiety(), wybranaRakieta.getNGZ(),
							wybranaRakieta.getVGZ(), gz, scheduler, 7900, 11200, i, isRunning, k, panel3);
					i = i + 10;
					break;
				case ("Mars"):
					obliczenia.oblicz(poczatkowaMasa, wybranaRakieta.getMasaRakiety(), wybranaRakieta.getNGM(),
							wybranaRakieta.getVGM(), gm, scheduler, 3600, 5000, i, isRunning, k, panel3);
					i = i + 10;
					break;
				}

			}
		}), 0, 1, TimeUnit.SECONDS);

	}

}
