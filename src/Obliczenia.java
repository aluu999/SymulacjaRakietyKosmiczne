import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;
import javax.swing.JOptionPane;

public class Obliczenia {

	public double pozostalaMasa, masaCalkowita, predkosc, predkoscPoprzednia;
	public int j, click;
	public Wykres chart;
	ArrayList<Double> listaPredkosc;
	ArrayList<Double> listaCzas;

	public Obliczenia() {
		listaPredkosc = new ArrayList<Double>();
		listaCzas = new ArrayList<Double>();
	}

	public void oblicz(double poczatkowaMasa, double masaRakiety, double ng, double vg, double g,
			ScheduledExecutorService scheduler, double pierwszaPredkosc, double drugaPredkosc, int j, boolean isRunning,
			FuelPanel panel, int c, String nazwa) {

		if (isRunning == true) {
			if (poczatkowaMasa > ng) {
				pozostalaMasa = poczatkowaMasa - (ng * 0.5 * j);
				if (nazwa == "SaturnV") {
					if (0.5*j >= 35  && 0.5*j<45) {
						masaRakiety = masaRakiety - 800000;
					}
					if (0.5*j >= 45 && 0.5*j<65) {
						masaRakiety = masaRakiety - 900000;
					}
					if(0.5*j >=65) {
						masaRakiety = masaRakiety - 960000;
					}
				}
				
				if (nazwa == "Big Falcon Rocket") {
					if (0.5*j >= 45  && 0.5*j<55) {
						masaRakiety = masaRakiety - 100000;
					}
					if (0.5*j >= 55 ) {
						masaRakiety = masaRakiety - 145000;
					}
					
				}
				masaCalkowita = masaRakiety + poczatkowaMasa;
				panel.wskaznikPaliwa.setValue((int) pozostalaMasa);
				predkosc = (vg * Math.log(masaCalkowita / (masaCalkowita - (ng * 0.5 * j)))) - (g * 0.5 * j);

				panel.predkoscValue = (float) predkosc;
				panel.czasValue = 0.5 * j;
				panel.paliwoValue = pozostalaMasa;
				panel.updateLabels();

				// listy do wykresu
				listaPredkosc.add(predkosc);
				listaCzas.add(0.5 * j);

				// liczymy poprzednia predkosc zeby nie pokazywaly sie zapetlone okna o
				// predkosciach kosmicznych
				predkoscPoprzednia = (vg * Math.log(masaCalkowita / (masaCalkowita - (ng * 0.5 * (j - 1)))))
						- (g * 0.5 * (j - 1));

				if (predkosc < 0) {
					panel.predkoscValue = 0;
					panel.czasValue = 0;
					panel.paliwoValue = poczatkowaMasa;
					panel.updateLabels();
					JOptionPane.showMessageDialog(null, "Rakieta jest zbyt ciężka, by się wznieść!", "Anulowano",
							JOptionPane.WARNING_MESSAGE);
					scheduler.shutdownNow();
				}
				if (predkoscPoprzednia < pierwszaPredkosc && predkosc >= pierwszaPredkosc && pozostalaMasa >= 0) {
					JOptionPane.showMessageDialog(null, "Pierwsza prędkość kosmiczna! Wyniesiono rakietę na orbitę!");
				}
				if (predkoscPoprzednia < drugaPredkosc && predkosc >= drugaPredkosc && pozostalaMasa >= 0) {
					JOptionPane.showMessageDialog(null, "Osiągnięto prędkość ucieczki!");
				}
				if (pozostalaMasa <= 0) {
					panel.paliwoValue = 0;
					panel.updateLabels();
					JOptionPane.showMessageDialog(null, "Skończyło się paliwo", "Koniec", JOptionPane.WARNING_MESSAGE);
					setListy(listaPredkosc, listaCzas);
					scheduler.shutdownNow();
				}
				
			} else {
				panel.paliwoValue = poczatkowaMasa;
				panel.updateLabels();
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

	public void setListy(ArrayList<Double> listaP, ArrayList<Double> listaC) {
		this.listaPredkosc = listaP;
		this.listaCzas = listaC;
	}

	public ArrayList<Double> getListaP() {
		return listaPredkosc;
	}

	public ArrayList<Double> getListaC() {
		return listaCzas;
	}

}
