package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for AVLTreeMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * an AVL tree data structure 
 *
 * @author Dr. King
 * @author // Your Name Here 
 *
 */
public class AVLTreeMapTest {

    private BinarySearchTreeMap<Integer, String> tree;
    
    /**
     * Create a new instance of an AVL tree-based map before each test case executes
     */     
    @Before
    public void setUp() {
        tree = new AVLTreeMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        
        tree.put(1,  "one");
        tree.put(3,  "three");
        tree.put(2, "two");
        tree.put(-3, "neg3");
        
        assertEquals((int) tree.root().getElement().getKey(), 2);
        assertEquals((int) tree.left(tree.root()).getElement().getKey(), 1);
        assertEquals((int) tree.right(tree.root()).getElement().getKey(), 3);

    }
    
    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
        tree.put(1,  "one");
        tree.put(3,  "three");
        tree.put(2, "two");
        tree.put(-3, "neg3");
        
        assertEquals(tree.get(3), "three");
        assertEquals(tree.get(-3), "neg3");
    }
    
    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
        assertTrue(tree.isEmpty());
        
        tree.put(1,  "one");
        tree.put(3,  "three");
        tree.put(2, "two");
        tree.put(-3, "neg3");
        
        assertEquals("three", tree.remove(3));
        assertEquals("one", tree.remove(1));
        assertEquals(2, (int) tree.root().getElement().getKey());
    }
}
