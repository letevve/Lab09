package it.polito.tdp.metrodeparis.model;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

public class Tratta {
	
	private Fermata f1;
	private Fermata f2;
	private Linea linea;
	private int connessione;
	private double tempo;
	
	public Tratta(Fermata f1, Fermata f2, Linea linea, int connessione) {
		this.f1 = f1;
		this.f2 = f2;
		this.linea = linea;
		this.connessione = connessione;
		this.tempo = calcolaTempo();
	}

	private double calcolaTempo() {
		double distanza = LatLngTool.distance(f1.getCoords() , f2.getCoords() , LengthUnit.KILOMETER);
		tempo = distanza / linea.getVelocità();
		return tempo*60;
	}

	private double calcolaDistanza() {
		// TODO Auto-generated method stub
		double distanza = LatLngTool.distance(new LatLng(f1.getCoords().getLongitude(), f1.getCoords().getLatitude()), new LatLng(f2.getCoords().getLongitude(), f2.getCoords().getLatitude()), LengthUnit.KILOMETER); 
		return distanza;
	}

	/**
	 * @return the f1
	 */
	public Fermata getF1() {
		return f1;
	}

	/**
	 * @param f1 the f1 to set
	 */
	public void setF1(Fermata f1) {
		this.f1 = f1;
	}

	/**
	 * @return the f2
	 */
	public Fermata getF2() {
		return f2;
	}

	/**
	 * @param f2 the f2 to set
	 */
	public void setF2(Fermata f2) {
		this.f2 = f2;
	}

	/**
	 * @return the linea
	 */
	public Linea getLinea() {
		return linea;
	}

	/**
	 * @param linea the linea to set
	 */
	public void setLinea(Linea linea) {
		this.linea = linea;
	}

	/**
	 * @return the connessione
	 */
	public int getConnessione() {
		return connessione;
	}

	/**
	 * @param connessione the connessione to set
	 */
	public void setConnessione(int connessione) {
		this.connessione = connessione;
	}

	/**
	 * @return the tempo
	 */
	public double getTempo() {
		return tempo;
	}

	/**
	 * @param tempo the tempo to set
	 */
	public void setTempo(double tempo) {
		this.tempo = tempo;
	}
	
	public FermataEnhanced getF1Enhanced(){
		FermataEnhanced f1e = new FermataEnhanced(this.getF1().getIdFermata(), this.getF1().getNome(), this.getF1().getCoords(), this.getLinea().getId());
		return f1e;
	}
	
	public FermataEnhanced getF2Enhanced(){
		FermataEnhanced f1e = new FermataEnhanced(this.getF2().getIdFermata(), this.getF2().getNome(), this.getF2().getCoords(), this.getLinea().getId());
		return f1e;
	}

}
