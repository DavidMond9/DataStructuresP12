package edu.ncsu.csc316.dsa.graph;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import edu.ncsu.csc316.dsa.Highway;
import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;
import edu.ncsu.csc316.dsa.list.positional.PositionalList;
import edu.ncsu.csc316.dsa.map.Map;

/**
 * Test class for MinimumSpanningTreeUtil
 * Checks the expected outputs of Prim-Jarnik's algorithm
 * and Kruskal's algorithm
 *
 * @author Dr. King
 * @author // Your Name Here 
 *
 */
public class MinimumSpanningTreeUtilTest {

    /**
     * Test the output of Prim-Jarnik's algorithm
     */ 
    @Test
    public void testPrimJarnik() {
    	Highway h1 = new Highway("1", 5);
    	Highway h2 = new Highway("2", 10);
    	Highway h3 = new Highway("3", 15);
    	Highway h4 = new Highway("4", 20);
    	Highway h5 = new Highway("5", 25);
    	Highway h6 = new Highway("6", 30);
    	Highway h7 = new Highway("7", 35);
    	Highway h8 = new Highway("8", 40);
    	Highway h9 = new Highway("9", 45);
    	Highway h10 = new Highway("10", 50);
		Graph<String, Highway> graph = new EdgeListGraph<String, Highway>();
        Vertex<String> v1 = graph.insertVertex("one");
        Vertex<String> v2 = graph.insertVertex("two");
        Vertex<String> v3 = graph.insertVertex("three");
        Vertex<String> v4 = graph.insertVertex("four");
        Vertex<String> v5 = graph.insertVertex("five");
        Edge<Highway> e1 = graph.insertEdge(v1, v2, h1);
        graph.insertEdge(v1, v3, h10);
        Edge<Highway> e3 = graph.insertEdge(v1, v4, h3);
        graph.insertEdge(v1, v5, h5);
        Edge<Highway> e5 = graph.insertEdge(v2, v3, h6);
        graph.insertEdge(v2, v4, h7);
        graph.insertEdge(v2, v5, h4);
        graph.insertEdge(v3, v4, h8);
        graph.insertEdge(v3, v5, h9);
        Edge<Highway> e10 = graph.insertEdge(v4, v5, h2);
       PositionalList<Edge<Highway>> list =  MinimumSpanningTreeUtil.primJarnik(graph);
       Iterator<Edge<Highway>> it = list.iterator();
       assertEquals(4, list.size());
       assertTrue(it.hasNext());
       assertEquals(e1, it.next());
       assertEquals(e3, it.next());
       assertEquals(e10, it.next());
       assertEquals(e5, it.next());
       assertFalse(it.hasNext());
    }
    
    /**
     * Test the output of Kruskal's algorithm
     */ 
    @Test
    public void testKruskal() {
    	Highway h1 = new Highway("1", 5);
    	Highway h2 = new Highway("2", 10);
    	Highway h3 = new Highway("3", 15);
    	Highway h4 = new Highway("4", 20);
    	Highway h5 = new Highway("5", 25);
    	Highway h6 = new Highway("6", 30);
    	Highway h7 = new Highway("7", 35);
    	Highway h8 = new Highway("8", 40);
    	Highway h9 = new Highway("9", 45);
    	Highway h10 = new Highway("10", 50);

    	
		Graph<String, Highway> e = new EdgeListGraph<String, Highway>();
        Vertex<String> v1 = e.insertVertex("one");
        Vertex<String> v2 = e.insertVertex("two");
        Vertex<String> v3 = e.insertVertex("three");
        Vertex<String> v4 = e.insertVertex("four");
        Vertex<String> v5 = e.insertVertex("five");
        e.insertEdge(v1, v2, h1);
        e.insertEdge(v1, v3, h10);
        e.insertEdge(v1, v4, h3);
        e.insertEdge(v1, v5, h5);
        e.insertEdge(v2, v3, h6);
        e.insertEdge(v2, v4, h7);
        e.insertEdge(v2, v5, h4);
        e.insertEdge(v3, v4, h8);
        e.insertEdge(v3, v5, h9);
        e.insertEdge(v4, v5, h2);
       PositionalList<Edge<Highway>> list =  MinimumSpanningTreeUtil.kruskal(e);
       Iterator<Edge<Highway>> it = list.iterator();
       assertEquals(4, list.size());
       assertTrue(it.hasNext());
       assertEquals(5, it.next().getElement().getWeight());
       assertEquals(10, it.next().getElement().getWeight());
       assertEquals(15, it.next().getElement().getWeight());
       assertEquals(30, it.next().getElement().getWeight());
       assertFalse(it.hasNext());
    }
    
}