package edu.ncsu.csc316.dsa.graph;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.dsa.Highway;
import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;
import edu.ncsu.csc316.dsa.map.Map;

/**
 * Test class for ShortestPathUtil
 * Checks the expected outputs of Dijksra's algorithm
 * and the shortest path tree construction method
 *
 * @author Dr. King
 * @author // Your Name Here 
 *
 */
public class ShortestPathUtilTest {

    /**
     * Test the output of Dijkstra's algorithm
     */ 
    @Test
    public void testDijkstra() {
    	Highway h1 = new Highway("1", 5);
    	Highway h2 = new Highway("2", 10);
    	Highway h3 = new Highway("3", 15);
    	Highway h4 = new Highway("4", 20);
    	Highway h5 = new Highway("5", 35);
    	Highway h6 = new Highway("6", 40);
    	Highway h7 = new Highway("7", 50);

    	
		Graph<String, Highway> e = new EdgeListGraph<String, Highway>();
        Vertex<String> v1 = e.insertVertex("one");
        Vertex<String> v2 = e.insertVertex("two");
        Vertex<String> v3 = e.insertVertex("three");
        Vertex<String> v4 = e.insertVertex("four");
        Vertex<String> v5 = e.insertVertex("five");
        e.insertEdge(v1, v2, h1);
        e.insertEdge(v1, v3, h7);
        e.insertEdge(v2, v3, h2);
        e.insertEdge(v1, v4, h6);
        e.insertEdge(v3, v4, h3);
        e.insertEdge(v1, v5, h5);
        e.insertEdge(v4, v5, h4);
        Map<Vertex<String>, Integer> map = ShortestPathUtil.dijkstra(e, v1);
        assertEquals(5, map.size());
        assertEquals(0, (int) map.get(v1));
        assertEquals(5, (int) map.get(v2));
        assertEquals(15, (int) map.get(v3));
        assertEquals(30, (int) map.get(v4));
        assertEquals(35, (int) map.get(v5));
    }
    
    /**
     * Test the output of the shortest path tree construction method
     */ 
    @Test
    public void testShortestPathTree() {
    	Highway h1 = new Highway("1", 5);
    	Highway h2 = new Highway("2", 10);
    	Highway h3 = new Highway("3", 15);
    	Highway h4 = new Highway("4", 20);
    	Highway h5 = new Highway("5", 35);
    	Highway h6 = new Highway("6", 40);
    	Highway h7 = new Highway("7", 50);

    	
    	Graph<String, Highway> e = new EdgeListGraph<String, Highway>();
        Vertex<String> v1 = e.insertVertex("one");
        Vertex<String> v2 = e.insertVertex("two");
        Vertex<String> v3 = e.insertVertex("three");
        Vertex<String> v4 = e.insertVertex("four");
        Vertex<String> v5 = e.insertVertex("five");
        Edge<Highway> e1 = e.insertEdge(v1, v2, h1);
        e.insertEdge(v1, v3, h7);
        Edge<Highway> e3 = e.insertEdge(v2, v3, h2);
        e.insertEdge(v1, v4, h6);
        Edge<Highway> e5 = e.insertEdge(v3, v4, h3);
        Edge<Highway> e6 = e.insertEdge(v1, v5, h5);
        e.insertEdge(v4, v5, h4);
        Map<Vertex<String>, Integer> map2 = ShortestPathUtil.dijkstra(e, v1);
        Map<Vertex<String>, Edge<Highway>> map = ShortestPathUtil.shortestPathTree(e, v1, map2);
        assertEquals(4, map.size());
        assertEquals(null, map.get(v1));
        assertEquals(e1,  map.get(v2));
        assertEquals(e3, map.get(v3));
        assertEquals(e5, map.get(v4));
        assertEquals(e6,  map.get(v5));
    }
    
}