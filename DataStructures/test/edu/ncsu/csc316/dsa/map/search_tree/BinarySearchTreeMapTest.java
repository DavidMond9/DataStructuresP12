package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.map.Map;

/**
 * Test class for BinarySearchTreeMap
 * Checks the expected outputs of the Map and Tree abstract data type behaviors when using
 * an linked binary tree data structure 
 *
 * @author Dr. King
 * @author // Your Name Here 
 *
 */
public class BinarySearchTreeMapTest {

    private BinarySearchTreeMap<Integer, String> tree;
    
    /**
     * Create a new instance of a binary search tree map before each test case executes
     */
    @Before
    public void setUp() {
        tree = new BinarySearchTreeMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        tree.put(1, "one");
        assertEquals(1, tree.size());
        assertFalse(tree.isEmpty());
        assertEquals(1, (int)tree.root().getElement().getKey());
        
        tree.put(5,  "two");
        assertEquals("two", tree.get(5));
        tree.put(0, "three");
        assertEquals("three", tree.get(0));
        
        Iterator<Map.Entry<Integer, String>> iterator = tree.entrySet().iterator();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertEquals("one", iterator.next().getValue());
        
    }
    
    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
        tree.put(1,  "one");
        assertEquals(1, tree.size());
        assertEquals("one", tree.get(1));
        tree.put(2, "two");
        assertEquals("two", tree.get(2));
        
        
        
    }

    /**
     * Test the output of the remove(k) behavior
     */ 
    @Test
    public void testRemove() {
        tree.put(1,  "one");
        assertEquals(1, tree.size());
        
        assertNull(tree.remove(10));
        assertEquals(1, tree.size());
        
        assertEquals("one", tree.remove(1));
        assertEquals(0, tree.size());
        tree.put(3,  "three");
        tree.put(1,  "one");
        tree.put(2,  "two");
        tree.put(5,  "five");
        tree.put(4,  "four");
        assertEquals("five", tree.remove(5));
        assertEquals("three", tree.remove(3));
        assertEquals("two", tree.remove(2));
        assertNull(tree.remove(7));
        
       
        
    }
}