import java.util.ArrayList;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Wykres {
	ChartFrame frame;
	XYSeries series;
	XYSeriesCollection dataset;
	JFreeChart chart;
	ChartPanel chartPanel;
	public Wykres() {}
	public Wykres(ArrayList<Double> listaP, ArrayList<Double> listaC) {
		
		series = new XYSeries("Wykres");
		for(int k=0;k<listaP.size();k++) {
			series.add(listaC.get(k), listaP.get(k));
		}
		
		dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		
	
		chart = ChartFactory.createXYLineChart("Zależność prędkości od czasu", 
				"t[s]", 
				"v[m/s]", dataset, 
				PlotOrientation.VERTICAL, 
				true, // legenda
				true, // tooltips
				false);

		frame = new ChartFrame("Wykres", chart);
		frame.setVisible(true);
		frame.setSize(500, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
