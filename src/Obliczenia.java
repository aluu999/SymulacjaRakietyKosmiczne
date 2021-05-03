import java.util.concurrent.ScheduledExecutorService;

import javax.swing.JOptionPane;

public class Obliczenia {

	public double pozostalaMasa, masaCalkowita, predkosc;
	public int j;

	public Obliczenia() {
	}

	public void oblicz(double poczatkowaMasa, double masaRakiety, double ng, double vg, double g,
			ScheduledExecutorService scheduler, double pierwszaPredkosc, double drugaPredkosc, int j, boolean isRunning,
			FuelPanel panel) {

		if (isRunning == true) {
			if (poczatkowaMasa > ng) {
				pozostalaMasa = poczatkowaMasa - (ng * 0.5 *j);
				masaCalkowita = masaRakiety + poczatkowaMasa;
				panel.wskaznikPaliwa.setValue((int) pozostalaMasa);
				predkosc = (vg * Math.log(masaCalkowita / (masaCalkowita - (ng * 0.5 *j)))) - (g *  0.5 *j);

				panel.predkoscValue = (float) predkosc;
				panel.czasValue = 0.5* j;
				panel.paliwoValue = pozostalaMasa;
				panel.updateLabels();

				if (predkosc < 0) {
					JOptionPane.showMessageDialog(null, "Rakieta jest zbyt ciężka, by się wznieść!", "Anulowano",
							JOptionPane.WARNING_MESSAGE);
					scheduler.shutdownNow();
				}
				if (pozostalaMasa <= 0) {
					panel.paliwoValue = 0;
					panel.updateLabels();
					JOptionPane.showMessageDialog(null, "Skończyło się paliwo", "Koniec", JOptionPane.WARNING_MESSAGE);
					scheduler.shutdownNow();
				}
				if (predkosc >= pierwszaPredkosc && pozostalaMasa >= 0) {
					JOptionPane.showMessageDialog(null, "Pierwsza prędkość kosmiczna! Wyniesiono rakietę na orbitę!");
				}
				if (predkosc >= drugaPredkosc && pozostalaMasa >= 0) {
					JOptionPane.showMessageDialog(null, "Osiągnięto prędkość ucieczki!");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Zbyt mała masa paliwa", "Anulowano", JOptionPane.WARNING_MESSAGE);
				scheduler.shutdownNow();
			}
		}

	}

	public void przerwijWatek(ScheduledExecutorService scheduler, boolean isRunning) {
		if (isRunning == false) {
			System.out.println("Reset, przerwano watek");
			JOptionPane.showMessageDialog(null, "Zakończono i zresetowano");
			scheduler.shutdownNow();
		}
	}

}
