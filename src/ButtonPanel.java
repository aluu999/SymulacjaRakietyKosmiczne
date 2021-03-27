import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButtonPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public JTextField text;
	public JButton info;
	public JButton wykres;
	public JComboBox<Object> wyborRakiety;
	public JLabel wR;
	public JComboBox<Object> wyborPlanety;
	public JLabel wP;

	public ButtonPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		//ustalenie odstêpów od granicy panelu

		wR = new JLabel("Wybór rakiety:");
		wR.setAlignmentX(Component.CENTER_ALIGNMENT);
		//wycentrowanie komponentu
		this.add(wR);
		String[] listaRakiet = { "Big Falcon Rocket", "Saturn V (S-IC)" };
		wyborRakiety = new JComboBox<Object>(listaRakiet);
		wyborRakiety.setMaximumSize(wyborRakiety.getPreferredSize());
		//zmiana rozmiaru comboboxa
		this.add(wyborRakiety);

		this.add(Box.createRigidArea(new Dimension(0, 10)));
		//utworzenie wolnej przestrzeni miedzy komponentaami
		
		text = new JTextField("Masa paliwa [kg]");
		text.setMaximumSize(text.getPreferredSize());
		this.add(text);

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
