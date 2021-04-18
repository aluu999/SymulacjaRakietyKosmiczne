
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;



public class RakietaComboBoxListener implements ItemListener {

	public RakietaComboBoxListener() {

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getStateChange() == ItemEvent.SELECTED) {
			String rakieta = (String) arg0.getItem();
			switch (rakieta) {
			case "Big Falcon Rocket":
				BigFalconRocket bfr = new BigFalconRocket();
				break;
			case "Saturn V":
				SatrunV sv=new SatrunV();
				break;
			}
		}
	}
}