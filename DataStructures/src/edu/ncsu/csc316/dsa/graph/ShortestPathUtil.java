package edu.ncsu.csc316.dsa.graph;

import edu.ncsu.csc316.dsa.Weighted;
import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;
import edu.ncsu.csc316.dsa.map.Map;
import edu.ncsu.csc316.dsa.map.UnorderedLinkedMap;
import edu.ncsu.csc316.dsa.map.hashing.LinearProbingHashMap;
import edu.ncsu.csc316.dsa.priority_queue.AdaptablePriorityQueue;
import edu.ncsu.csc316.dsa.priority_queue.HeapAdaptablePriorityQueue;
import edu.ncsu.csc316.dsa.priority_queue.PriorityQueue;
import edu.ncsu.csc316.dsa.set.HashSet;
import edu.ncsu.csc316.dsa.set.Set;

/**
 * ShortestPathUtil provides a collection of behaviors for computing shortest
 * path spanning trees for a given graph.
 * 
 * The ShortestPathUtil class is based on the textbook:
 *
 * Data Structures and Algorithms in Java, Sixth Edition Michael T. Goodrich,
 * Roberto Tamassia, and Michael H. Goldwasser John Wiley and Sons, 2014
 * 
 * @author Dr. King
 * @author // Your Name Here 
 *
 */
public class ShortestPathUtil {
    
    /**
     * For a connected graph, returns a map that represents shortest path costs to
     * all vertices computed using Dijkstra's single-source shortest path algorithm.
     * 
     * @param <V>   the type of data in the graph vertices
     * @param <E>   the type of data in the graph edges
     * @param graph the graph for which to compute the shortest path spanning tree
     * @param start the vertex at which to start computing the shorest path spanning
     *              tree
     * @return a map that represents the shortest path costs to all vertices in the
     *         graph
     */ 
    public static <V, E extends Weighted> Map<Vertex<V>, Integer> dijkstra(Graph<V, E> graph, Vertex<V> start) {
        AdaptablePriorityQueue<Integer, Vertex<V>> q = new HeapAdaptablePriorityQueue<Integer, Vertex<V>>();
        Map<Vertex<V>, Integer> m = new LinearProbingHashMap<Vertex<V>, Integer>();
        Set<Vertex<V>> s = new HashSet<Vertex<V>>();
        Map<Vertex<V>, PriorityQueue.Entry<Integer, Vertex<V>>> m2 = new LinearProbingHashMap<Vertex<V>, PriorityQueue.Entry<Integer, Vertex<V>>>();
        for(Vertex<V> v : graph.vertices()) {
        	if(v == start) {
        		m.put(v, 0);
        	}
        	else {
        		m.put(v, (int) Double.POSITIVE_INFINITY);	
        	}
        	int cost = m.get(v);
        	PriorityQueue.Entry<Integer, Vertex<V>> entry = q.insert(cost, v);
        	m2.put(v, entry);
        }
        while(!q.isEmpty()) {
        	PriorityQueue.Entry<Integer, Vertex<V>> entry2 = q.deleteMin();
        	Vertex<V> val = entry2.getValue();
        	s.add(val);
        	for(Edge<E> e : graph.outgoingEdges(val)) {
        		Vertex<V> opp = graph.opposite(val, e);
        		if(!s.contains(opp)) {
        			int weight = m.get(val) + e.getElement().getWeight();
        			if(weight < m.get(opp))	{
        				m.put(opp, weight);
        				q.replaceKey(m2.get(opp), weight);
        			}
        		}
        	}
        }
        return m;
    }
    
    /**
     * For a connected graph, returns a map that represents shortest path spanning
     * tree edges computed using Dijkstra's single-source shortest path algorithm.
     * 
     * @param <V>       the type of data in the graph vertices
     * @param <E>       the type of data in the graph edges
     * @param graph         the graph for which to compute the shortest path spanning
     *                  tree
     * @param start         the vertex at which to start computing the shortest path
     *                  spanning tree
     * @param costs the map of shortest path costs to reach each vertex in the
     *                  graph
     * @return a map that represents the shortest path spanning tree edges
     */ 
    public static <V, E extends Weighted> Map<Vertex<V>, Edge<E>> shortestPathTree(Graph<V, E> graph, Vertex<V> start, Map<Vertex<V>, Integer> costs) {
        Map<Vertex<V>, Edge<E>> m = new UnorderedLinkedMap<Vertex<V>, Edge<E>>();
        for(Vertex<V> v : costs) {
        	if(v != start) {
        		for(Edge<E> e : graph.incomingEdges(v)) {
        			Vertex<V> opp = graph.opposite(v, e);
        			if(costs.get(v) == (e.getElement().getWeight() + costs.get(opp))) {
        				m.put(v, e);
        			}
        		}
        	}
        }
        return m;
    }
}