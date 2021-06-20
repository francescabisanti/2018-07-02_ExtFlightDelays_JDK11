package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	SimpleWeightedGraph <Airport, DefaultWeightedEdge> grafo;
	ExtFlightDelaysDAO dao;
	Map <Integer, Airport> idMap;
	
	public Model() {
		dao= new ExtFlightDelaysDAO();
		idMap= new HashMap <Integer, Airport>();
		dao.loadAllAirports(idMap);
	}
	
	public void creaGrafo(Integer numeroVoli) {
		grafo= new SimpleWeightedGraph <Airport, DefaultWeightedEdge> (DefaultWeightedEdge.class);
		Graphs.addAllVertices(this.grafo, dao.getVertici(idMap, numeroVoli));
	}
	
	public int getNVertici() {
		return this.grafo.vertexSet().size();
	}
}
