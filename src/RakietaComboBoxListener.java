import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPanel;

public class RakietaComboBoxListener implements ItemListener {

	JPanel p;
	public FuelPanel fPanel;
	public float vgz;

	public RakietaComboBoxListener() {

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getStateChange() == ItemEvent.SELECTED) {
			String rakieta = (String) arg0.getItem();
			switch (rakieta) {
			case "Big Falcon Rocket":
				// chcemy przeniesc predkosci i spalanie do klasy FuelPanel
				vgz = 300;
				fPanel = new FuelPanel(vgz);
				get();
				break;
			case "Saturn V":
				break;
			}
		}
	}
	public float get() {
		//System.out.println(vgz); //tutaj dochodzi poprawnie
		return vgz;
	}
}