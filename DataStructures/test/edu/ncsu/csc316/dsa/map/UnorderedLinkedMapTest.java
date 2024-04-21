package edu.ncsu.csc316.dsa.map;

import static org.junit.Assert.*;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.map.AbstractMap.MapEntry;

/**
 * Test class for UnorderedLinkedMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * an unordered link-based list data structure that uses the move-to-front heuristic for
 * self-organizing entries based on access frequency
 *
 * @author Dr. King
 *
 */
public class UnorderedLinkedMapTest {

	/**
	 * Map for integer, string.
	 */
    private Map<Integer, String> map;
    
    /**
     * Create a new instance of an unordered link-based map before each test case executes
     */     
    @Before
    public void setUp() {
        map = new UnorderedLinkedMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
        assertNull(map.put(3, "string3"));
        assertEquals("UnorderedLinkedMap[3]", map.toString());
        assertEquals(1, map.size());

    }

    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
        assertTrue(map.isEmpty());
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        assertFalse(map.isEmpty());
        assertEquals("UnorderedLinkedMap[1, 4, 2, 5, 3]", map.toString());
        
        assertEquals("string1", map.get(1));
        assertEquals("UnorderedLinkedMap[1, 4, 2, 5, 3]", map.toString());
        
        assertEquals(map.get(3), "string3");
        assertEquals(map.get(2), "string2");
    }
    
    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
        assertTrue(map.isEmpty());
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        assertFalse(map.isEmpty());
        assertEquals("UnorderedLinkedMap[1, 4, 2, 5, 3]", map.toString());
        
        assertEquals(map.remove(3), "string3");
        assertEquals(map.size(), 4);
        assertEquals("UnorderedLinkedMap[1, 4, 2, 5]", map.toString());
    }


    /**
     * Test the output of the entrySet() behavior
     */     
    @Test
    public void testEntrySet() {
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        Map.Entry<Integer, String> entry = it.next();
        assertEquals("string1", (String) entry.getValue());
        assertEquals(1, (int) entry.getKey());
        
    }

    /**
     * Test the output of the values() behavior
     */     
    @Test
    public void testValues() {
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        
        Iterator<String> it = map.values().iterator();
        assertTrue(it.hasNext());
        assertEquals(it.next(), "string1");
        assertEquals(it.next(), "string4");
        assertEquals(it.next(), "string2");
        assertEquals(it.next(), "string5");
        
    }
    /**
     * Test the output of the iterator() behavior
     */     
    @Test
    public void testIterator() {
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        
        Iterator<Integer> it = map.iterator();
        assertTrue(it.hasNext());
        assertEquals((int)it.next(), 1);
        assertEquals((int)it.next(), 4);
        assertEquals((int)it.next(), 2);
        assertEquals((int)it.next(), 5);
    }
    /**
     * Test compareTo.
     */
    @Test
    public void testCompareTo() {
    	MapEntry<Integer, String> entry = new MapEntry<>(0, "hi");
    	MapEntry<Integer, String> entry2 = new MapEntry<>(1, "no");
    	MapEntry<Integer, String> entry3 = new MapEntry<>(1, "maybe");
    	assertEquals(-1, entry.compareTo(entry2));
    	assertEquals(0, entry2.compareTo(entry3));
    }
}