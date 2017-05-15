package it.polito.tdp.metrodeparis.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.jgrapht.GraphPath;
import org.jgrapht.Graphs;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedMultigraph;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.alg.DijkstraShortestPath;

import it.polito.tdp.metrodeparis.dao.MetroDAO;

public class Model {
	
	MetroDAO md = new MetroDAO();
	private List<Fermata> fermate;
	//private List<FermataEnhanced> fermateEn;
	private WeightedGraph<Fermata, DefaultWeightedEdge> graph; //= new SimpleWeightedGraph<Fermata, DefaultWeightedEdge>(DefaultWeightedEdge.class);

	public List<Fermata> getFermate() {
		if(this.fermate == null){
			this.fermate=md.getAllFermate();
		}
		return this.fermate;
	}
	
	public String createGraph() throws SQLException {
		
		this.graph = new SimpleWeightedGraph<Fermata, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(graph, this.getFermate());
		
		List<Tratta> tratte = new LinkedList<Tratta>(md.getAllTratte().values());
		for(Tratta t : tratte){
			DefaultWeightedEdge dwe = graph.addEdge(t.getF1(), t.getF2());
			if(dwe!=null){
				graph.setEdgeWeight(dwe, t.getTempo());
				//System.out.println(dwe.toString() + " " + t.getTempo());
			}
		}
		
		return graph.toString();
		
	}

	public String calcolaPercorso(Fermata partenza, Fermata arrivo) throws SQLException {
		// TODO Auto-generated method stub
		
		//chiamare md.getMappaLinee()
		
		String grafo = "";
		grafo = this.createGraph();
		DijkstraShortestPath<Fermata, DefaultWeightedEdge> dsp = new DijkstraShortestPath<Fermata, DefaultWeightedEdge>(graph, partenza, arrivo);
		double tempo = 0.0;
		
		
		for(DefaultWeightedEdge t : dsp.getPathEdgeList()){
			tempo += graph.getEdgeWeight(t) + 0.5;
		}
		
		String res = "";
		return dsp.getPath().toString() + " il tempo totale è: "+tempo+" minuti";
	}
/*
	
	public List<FermataEnhanced> getFermateEnhanced() {
		if(this.fermateEn == null){
			this.fermateEn=md.getAllFermateEnhanced();
		}
		return this.fermateEn;
	}
	
	public WeightedGraph<FermataEnhanced, DefaultWeightedEdge> getGraph() throws SQLException {
		
		if(graph == null){
			this.createGraph();
		}
		
		return graph;
	}
	
	public String createGraph() {
		
		this.graph = new DirectedWeightedMultigraph<FermataEnhanced,DefaultWeightedEdge>(DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(graph, md.getAllFermateEnhanced());
		System.out.println(graph);
		List<Tratta> tratte = new LinkedList<Tratta>(md.getAllTratte().values());
		
		for(Tratta t : tratte) {
			DefaultWeightedEdge e = graph.addEdge(t.getF1Enhanced(), t.getF2Enhanced());
			if (e != null)
				graph.setEdgeWeight(e, t.getTempo());
		}
		
		System.out.println(graph);
		return graph.toString();
	}
	
public String calcolaPercorsoEn(FermataEnhanced partenza, FermataEnhanced arrivo) {
		
		DijkstraShortestPath<FermataEnhanced,DefaultWeightedEdge> dsp = new DijkstraShortestPath<FermataEnhanced,DefaultWeightedEdge>(graph,partenza,arrivo);
		
		String grafo = "";
		grafo = this.createGraph();
		//DijkstraShortestPath<Fermata, DefaultWeightedEdge> dsp = new DijkstraShortestPath<Fermata, DefaultWeightedEdge>(graph, partenza, arrivo);
		double tempo = 0.0;
		
		
		for(DefaultWeightedEdge t : dsp.getPathEdgeList()){
			tempo += graph.getEdgeWeight(t) + 0.5;
		}
		
		String res = "";
		return dsp.getPath().toString() + " il tempo totale è: "+tempo+" minuti";
	}
	*/
}
