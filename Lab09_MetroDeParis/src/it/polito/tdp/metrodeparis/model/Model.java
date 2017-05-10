package it.polito.tdp.metrodeparis.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.jgrapht.Graphs;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.metrodeparis.dao.MetroDAO;

public class Model {
	
	MetroDAO md = new MetroDAO();
	private List<Fermata> fermate;
	private UndirectedGraph<Fermata, DefaultWeightedEdge> graph;

	public List<Fermata> getFermate() {
		if(this.fermate == null){
			this.fermate=md.getAllFermate();
		}
		return this.fermate;
	}
	
	public String createGraph() throws SQLException {
		
		graph = new SimpleWeightedGraph<Fermata, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(graph, this.getFermate());
		
		List<Tratta> tratte = new LinkedList<Tratta>(md.getAllTratte().values());
		for(Tratta t : tratte){
			graph.addEdge(t.getF1(), t.getF2());
		}
		
		return graph.toString();
		
	}

	public String calcolaPercorso(Fermata value, Fermata value2) throws SQLException {
		// TODO Auto-generated method stub
		
		//chiamare md.getMappaLinee()
		
		String graph = "";
		graph = this.createGraph();
		String res = "";
		//res = md.
		return graph;
	}

}
