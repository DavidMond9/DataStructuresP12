package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for RedBlackTreeMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * a red-black tree data structure 
 *
 * @author Dr. King
 * @author // Your Name Here 
 *
 */
public class RedBlackTreeMapTest {

    private BinarySearchTreeMap<Integer, String> tree;
    
    /**
     * Create a new instance of a red-black tree-based map before each test case executes
     */  
    @Before
    public void setUp() {
        tree = new RedBlackTreeMap<Integer, String>();
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
        tree.put(3, "three");
        tree.put(5, "five");
        assertEquals((int) tree.root().getElement().getKey(), 2); 
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
        tree.put(3, "three");
        tree.put(5, "five");
        assertEquals(tree.get(1), "one");
        assertEquals(tree.get(5), "five");
    }
    
    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        
        tree.put(1, "one");
        assertEquals((int) tree.root().getElement().getKey(), 1); 
        tree.put(2, "two");
        tree.put(3, "three");
        tree.put(5, "five");
        assertEquals("three", tree.remove(3));
        assertEquals("one", tree.remove(1));
        assertEquals((int) tree.root().getElement().getKey(), 2); 
        assertEquals("five", tree.remove(5));
        assertEquals("two", tree.remove(2));
        
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
        
        
        assertEquals((int) tree.root().getElement().getKey(), 7); 
        
        assertEquals(tree.remove(19), "nineteen");
        assertEquals(tree.remove(3), "three");
        assertEquals(tree.remove(5), "five");
        assertEquals(tree.remove(12), "twelve");
        assertEquals((int) tree.root().getElement().getKey(), 7); 




        
        
    }
}