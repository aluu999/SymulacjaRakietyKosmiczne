import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ButtonPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public JTextField text;
	public JButton info;
	public JButton wykres;
	public JComboBox<Object> wyborRakiety;
	public JLabel wR;
	public JComboBox<Object> wyborPlanety;
	public JLabel wP, dane, labelImg, label;
	public JTextArea opis;
	public JDialog okno;
	public JPanel panelImg, panelText;
	public GridBagConstraints c, d;
	public ImageIcon img;
	public double mass;

	public ButtonPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		// ustalenie odstep�w od granicy panelu

		wR = new JLabel("Wybór rakiety:");
		wR.setAlignmentX(Component.CENTER_ALIGNMENT); // wycentrowanie komponentu
		this.add(wR);
		String[] listaRakiet = { "Big Falcon Rocket", "Saturn V" };
		wyborRakiety = new JComboBox<Object>(listaRakiet);
		wyborRakiety.setMaximumSize(wyborRakiety.getPreferredSize()); // zmiana rozmiaru comboboxa
		this.add(wyborRakiety);

		this.add(Box.createRigidArea(new Dimension(0, 10))); // utworzenie wolnej przestrzeni miedzy komponentaami

		text = new JTextField("Masa paliwa [kg]");
		text.setMaximumSize(text.getPreferredSize());
		this.add(text);
		//mass=Double.parseDouble(text.getText());
		this.add(Box.createRigidArea(new Dimension(0, 10)));

		wP = new JLabel("Wybór planety:");
		wP.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(wP);
		String[] listaPlanet = { "Ziemia", "Mars" };
		wyborPlanety = new JComboBox<Object>(listaPlanet);
		wyborPlanety.setMaximumSize(wyborPlanety.getPreferredSize());
		this.add(wyborPlanety);

		this.add(Box.createRigidArea(new Dimension(0, 10)));

		info = new JButton("Informacje o rakiecie");
		info.setAlignmentX(Component.CENTER_ALIGNMENT);

		ActionListener info_l = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg) {
				String item = (String) wyborRakiety.getSelectedItem();
				okno = new JDialog();
				panelImg = new JPanel();
				okno.add(panelImg, BorderLayout.LINE_END);
				panelText = new JPanel();
				okno.add(panelText, BorderLayout.LINE_START);
				
				switch (item) {
				case "Big Falcon Rocket":
					dane = new JLabel("Big Falcon Rocket (Starship)");
					dane.setFont(new Font("Serif", Font.ITALIC, 30));
					panelText.add(dane);
					opis = new JTextArea(
							"Rakieta nośna wraz ze statkiem kosmicznym opracowywana przez amerykańskie przedsiębiorstwo przemysłu kosmicznego SpaceX. "
									+ "W pierwotnej wersji nazywana Big Falcon Rocket.Rakieta posiada dwa stopnie - pierwszy Super Heavy i drugi Starship. "
									+ " W 2018 roku założyciel SpaceX Elon Musk ogłosił na Twitterze zmianę nazwy całej rakiety na 'Starship'. "
									+ "Główynym celem pojazdu kosmiczengo ma być zabranie ludzi na Marsa. "
									+ "Wyróżnia ją również niski koszt wynoszenia ładunku w kosmos. "
									+ "Pojazd kosmiczny ma łączną wysokość 120 m i średnicę 9 m. "
									+ "Do budowy obu stopni pojazdu zamiast włókna węglowego używana jest stal nierdzewna. "
									+ "Wykorzystywany do wyniesienia rakiety silnik Raptor napędzany jest ciekłym metanem. "
									+ "W symulacji przyjmujemy, iż korzystamy z jednego tego typu silnika. "
									+ "Dane wykorzystane w symulacji: " + "masa (bez paliwa): 100 000kg, "
									+ "siła ciągu=3000kN," + "impuls właściwy=334s, "
									+ "spalanie na Ziemii=900kg/s, na Marsie=2400kg/s, "
									+ "prędkość gazów wylotowych na Ziemii=3300m/s, na Marsie=1240m/s. ",
							10, 40);
					
					break;

				case "Saturn V":
					dane = new JLabel("Saturn V");
					dane.setFont(new Font("Serif", Font.ITALIC, 30));
					panelText.add(dane);
					opis = new JTextArea(
							"Rakieta wykorzystywana przez NASA w programach kosmicznych takich jak Skylab i Apollo. "
									+ "Celem zbudowania rakiety było zabranie ludzi na Księżyc. "
									+ "Rakieta miała wysokość 110m i i 10m średnicy. "
									+ "Satrun V składał się z trzech członów (wszystkie napędzane paliwem ciekłym): S-IC, S-II oraz S-IVB. "
									+ "Pierwszy stopień S-IC, który przyjmujemy w symulacji, napędzany był mieszaniną węglowodorów. "
									+ "Dane wykorzystane w symulacji: " + "masa (bez paliwa): 140 000kg, "
									+ "siła ciągu=34 000kN," + "impuls właściwy=263s, "
									+ "spalanie na Ziemii=13 000 kg/s, na Marsie=35 000 kg/s, "
									+ "prędkość gazów wylotowych na Ziemii=2580 m/s, na Marsie=970 m/s. ",
							10, 40);
					break;
				}
				panelText.add(opis);
				opis.setLineWrap(true);
				opis.setWrapStyleWord(true);
				opis.setOpaque(false);
				opis.setEditable(false);
				panelText.setLayout(new GridLayout(2, 1));

				panelImg.setLayout(new GridBagLayout());
				GridBagConstraints c = new GridBagConstraints();

				labelImg = new JLabel("");
				img = new ImageIcon(this.getClass().getResource("/Starship.jpg"));
				labelImg.setIcon(img);
				c.fill = GridBagConstraints.HORIZONTAL;
				c.gridx = 1;
				c.gridy = 0;
				panelImg.add(labelImg, c);

				label = new JLabel("Fot. Grafika komputerowa przedstawiająca start Starship. Zródło: Wikipedia");
				c.fill = GridBagConstraints.HORIZONTAL;
				c.weightx = 0.0;
				c.gridwidth = 3;
				c.gridx = 0;
				c.gridy = 1;
				panelImg.add(label, c);
				okno.setSize(900, 600);
				okno.setVisible(true);
			}
		};
		
		info.addActionListener(info_l);
		this.add(info);

		this.add(Box.createRigidArea(new Dimension(0, 10)));

		wykres = new JButton("Wykres");
		wykres.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(wykres);
	}

	public ButtonPanel(LayoutManager layout) {
		super(layout);

	}

	public ButtonPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);

	}

	public ButtonPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);

	}
	
}
