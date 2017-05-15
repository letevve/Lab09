package it.polito.tdp.metrodeparis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javadocmd.simplelatlng.LatLng;

import it.polito.tdp.metrodeparis.model.Fermata;
import it.polito.tdp.metrodeparis.model.FermataEnhanced;
import it.polito.tdp.metrodeparis.model.Linea;
import it.polito.tdp.metrodeparis.model.Tratta;

public class MetroDAO {
	
	private Map<Integer, Fermata> mappaFermate = new HashMap<Integer, Fermata>();
	private Map<Integer, Linea> mappaLinee = new HashMap<Integer, Linea>();

	public List<Fermata> getAllFermate() {

		final String sql = "SELECT id_fermata, nome, coordx, coordy FROM fermata ORDER BY nome ASC";
		List<Fermata> fermate = new ArrayList<Fermata>();
		

		try {
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Fermata f = new Fermata(rs.getInt("id_Fermata"), rs.getString("nome"), new LatLng(rs.getDouble("coordx"), rs.getDouble("coordy")));
				fermate.add(f);
				mappaFermate.put(f.getIdFermata(), f);
			}

			st.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore di connessione al Database.");
		}

		return fermate;
	}
	
	public List<FermataEnhanced> getAllFermateEnhanced() {

		final String sql = "SELECT id_fermata, nome, coordx, coordy, id_linea FROM fermata, connessione WHERE connessione.id_stazP=fermata.id_fermata ORDER BY nome ASC";
		List<FermataEnhanced> fermateEn = new ArrayList<FermataEnhanced>();
		

		try {
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				FermataEnhanced fe = new FermataEnhanced(rs.getInt("id_Fermata"), rs.getString("nome"), new LatLng(rs.getDouble("coordx"), rs.getDouble("coordy")), rs.getInt("id_linea"));
				fermateEn.add(fe);
				//mappaFermate.put(fe.getIdFermata(), fe);
			}

			st.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore di connessione al Database.");
		}

		return fermateEn;
	} 
	
	public Map<Integer, Linea> getMappaLinee(){
		final String sql = "SELECT * FROM linea ";
		

		try {
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Linea l = new Linea(rs.getInt("id_linea"), rs.getString("nome"), rs.getInt("velocita"), rs.getInt("intervallo"));
				mappaLinee.put(l.getId(), l);
			}

			st.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore di connessione al Database.");
		}

		return mappaLinee;
		
	}
	
	public Map<Integer, Tratta> getAllTratte(){
		
		final String sql = "SELECT * FROM connessione";
		Map<Integer, Tratta> tratte = new HashMap<Integer, Tratta>();
		mappaLinee = this.getMappaLinee();
		
		try {
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Fermata f1 = mappaFermate.get(rs.getInt("id_stazP"));
				Fermata f2 = mappaFermate.get(rs.getInt("id_stazA"));
				Linea l = mappaLinee.get(rs.getInt("id_linea"));
				Tratta t = new Tratta(f1, f2, l, rs.getInt("id_connessione"));
				tratte.put(t.getConnessione(), t);
			}

			st.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore di connessione al Database.");
		}

		return tratte;
	}
	
	
	
}
