package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.map.search_tree.*;

/**
 * Test class for SplayTreeMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * a splay tree data structure 
 *
 * @author Dr. King
 * @author // Your Name Here 
 *
 */
public class SplayTreeMapTest {

    private BinarySearchTreeMap<Integer, String> tree;
    
    /**
     * Create a new instance of a splay tree-based map before each test case executes
     */     
    @Before
    public void setUp() {
        tree = new SplayTreeMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        
        tree.put(1, "one");
        assertEquals((int) tree.root().getElement().getKey(), 1); 
        tree.put(2, "two");
        assertEquals((int) tree.root().getElement().getKey(), 2); 
        tree.put(3, "three");
        assertEquals((int) tree.root().getElement().getKey(), 3); 
        tree.put(10,  "ten");
        assertEquals((int) tree.root().getElement().getKey(), 10); 
    }
    
    /**
     * Test the output of the get(k) behavior
     */ 
    @Test
    public void testGet() {
    	assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        
        tree.put(1, "one");
        assertEquals((int) tree.root().getElement().getKey(), 1); 
        tree.put(2, "two");
        assertEquals((int) tree.root().getElement().getKey(), 2); 
        tree.put(3, "three");
        assertEquals((int) tree.root().getElement().getKey(), 3); 
        tree.put(10,  "ten");
        assertEquals((int) tree.root().getElement().getKey(), 10); 
        
        assertEquals("two", tree.get(2));
        assertEquals("three", tree.get(3));
        assertEquals((int) tree.root().getElement().getKey(), 3);
    }
    
    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
    	assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        
        tree.put(1, "one");
        assertEquals((int) tree.root().getElement().getKey(), 1); 
        tree.put(2, "two");
        assertEquals((int) tree.root().getElement().getKey(), 2); 
        tree.put(3, "three");
        assertEquals((int) tree.root().getElement().getKey(), 3); 
        tree.put(10,  "ten");
        assertEquals((int) tree.root().getElement().getKey(), 10); 
        
        assertEquals("one", tree.remove(1));
        
        assertEquals("ten", tree.remove(10));
        assertEquals((int) tree.root().getElement().getKey(), 3); 
        
        tree.put(12, "twelve");
        tree.put(3, "three");
        tree.put(7, "seven");
        tree.put(10, "ten");
        tree.put(1, "one");
        tree.put(19, "nineteen");
        tree.put(5, "five");
        tree.put(6, "six");
        tree.put(8, "eight");
        tree.put(4, "four");
        assertEquals("ten", tree.remove(10));
        assertEquals("eight", tree.remove(8));
        assertEquals("one", tree.remove(1));
        assertEquals((int) tree.root().getElement().getKey(), 4);
        
        

    }
}