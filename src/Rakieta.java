
public class Rakieta {
	
	public double vgz,ngz,vgm,ngm,masaRakiety;
	public String nazwaRakiety;
	
	public Rakieta(String nazwaRakiety, double vgz, double ngz, double vgm, double ngm, double masaRakiety){
        this.vgz = vgz;
        this.ngz = ngz;
        this.vgm = vgm;
        this.ngm = ngm;
        this.masaRakiety = masaRakiety;
        this.nazwaRakiety = nazwaRakiety;
        
    }

	public double getVGZ() {
		return vgz;
	}
	public double getNGZ() {
		return ngz;
	}
	public double getVGM() {
		return vgm;
	}
	public double getNGM() {
		return ngm;
	}
	public double getMasaRakiety() {
		return masaRakiety;
	}
	public String getNazwaRakiety(){
        return nazwaRakiety;
    }
	public String toString() {
		return nazwaRakiety;
	}


}
