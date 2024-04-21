package edu.ncsu.csc316.dsa.graph;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;
import edu.ncsu.csc316.dsa.map.Map;

/**
 * Test class for GraphTraversalUtil
 * Checks the expected outputs of depth first search
 * and breadth first search
 *
 * @author Dr. King
 * @author David Mond
 *
 */
public class GraphTraversalUtilTest {

    /**
     * Test the output of depth first search on a graph
     */ 
    @Test
    public void testDepthFirstSearch() {
         Graph<String, Integer> graph = new EdgeListGraph<String, Integer>();
         Vertex<String> v1 = graph.insertVertex("one");
         Vertex<String> v2 = graph.insertVertex("two");
         Vertex<String> v3 = graph.insertVertex("three");
         Vertex<String> v4 = graph.insertVertex("four");
         Vertex<String> v5 = graph.insertVertex("five");
         Edge<Integer> e1 = graph.insertEdge(v1, v2, 5);
         graph.insertEdge(v1, v3, 6);
         graph.insertEdge(v1, v4, 19);
         graph.insertEdge(v1, v5, 25);
         Edge<Integer> e5 = graph.insertEdge(v2, v3, 22);
         graph.insertEdge(v2, v4, 8);
         graph.insertEdge(v2, v5, 64);
         Edge<Integer> e8 = graph.insertEdge(v3, v4, 41);
         graph.insertEdge(v3, v5, 44);
         Edge<Integer> e10 = graph.insertEdge(v4, v5, 57);
         Map<Vertex<String>, Edge<Integer>> map = GraphTraversalUtil.depthFirstSearch(graph, v1);
         assertEquals(4, map.size());
         assertEquals(e1, map.get(v2));
         assertEquals(e5, map.get(v3));
         assertEquals(e8, map.get(v4));
         assertEquals(e10, map.get(v5));

    }
    
    /**
     * Test the output of the breadth first search
     */ 
    @Test
    public void testBreadthFirstSearch() {
    	Graph<String, Integer> e = new EdgeListGraph<String, Integer>();
        Vertex<String> v1 = e.insertVertex("one");
        Vertex<String> v2 = e.insertVertex("two");
        Vertex<String> v3 = e.insertVertex("three");
        Vertex<String> v4 = e.insertVertex("four");
        Vertex<String> v5 = e.insertVertex("five");
        Edge<Integer> e1 = e.insertEdge(v1, v2, 15);
        Edge<Integer> e2 = e.insertEdge(v1, v3, 1000);
        Edge<Integer> e3 = e.insertEdge(v1, v4, 1500);
        Edge<Integer> e4 = e.insertEdge(v1, v5, 20);
        e.insertEdge(v2, v3, 2);
        e.insertEdge(v2, v4, 3);
        e.insertEdge(v2, v5, 35);
        e.insertEdge(v3, v4, 41);
        e.insertEdge(v3, v5, 4);
        e.insertEdge(v4, v5, 58);
        e.insertEdge(v1, v2, 1);
        
        Map<Vertex<String>, Edge<Integer>> map = GraphTraversalUtil.breadthFirstSearch(e, v1);
        assertEquals(4, map.size());
        assertEquals(e1, map.get(v2));
        assertEquals(e2, map.get(v3));
        assertEquals(e3, map.get(v4));
        assertEquals(e4, map.get(v5));
    }
}