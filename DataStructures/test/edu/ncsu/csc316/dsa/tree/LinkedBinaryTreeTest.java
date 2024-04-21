package edu.ncsu.csc316.dsa.tree;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.Position;

/**
 * Test class for LinkedBinaryTree
 * Checks the expected outputs of the BinaryTree abstract data type behaviors when using
 * a linked data structure to store elements
 *
 * @author Dr. King
 * @author // Your Name Here 
 *
 */
public class LinkedBinaryTreeTest {

    private LinkedBinaryTree<String> tree;
    private LinkedBinaryTree<String> newTree;
    private Position<String> one;
    private Position<String> two;
    private Position<String> three;
    private Position<String> four;
    private Position<String> five;
    private Position<String> six;
    private Position<String> seven;
    private Position<String> eight;
    private Position<String> nine;
    private Position<String> ten;

    /**
     * Create a new instance of a linked binary tree before each test case executes
     */       
    @Before
    public void setUp() {
        tree = new LinkedBinaryTree<String>(); 
    }
    
    /**
     * Sample tree to help with testing
     *
     * One
     * -> Two
     *   -> Six
     *   -> Ten
     *     -> Seven
     *     -> Five
     * -> Three
     *   -> Four
     *     -> Eight
     *     -> Nine
     * 
     * Or, visually:
     *                    one
     *                /        \
     *             two          three
     *            /   \            /
     *         six   ten          four
     *              /   \        /     \
     *            seven  five  eight nine    
     */  
    private void createTree() {
        one = tree.addRoot("one");
        two = tree.addLeft(one, "two");
        three = tree.addRight(one, "three");
        six = tree.addLeft(two, "six");
        ten = tree.addRight(two, "ten");
        four = tree.addLeft(three, "four");
        seven = tree.addLeft(ten, "seven");
        five = tree.addRight(ten, "five");
        eight = tree.addLeft(four, "eight");
        nine = tree.addRight(four, "nine");
    }
    
    /**
     * Test the output of the set(p,e) behavior
     */     
    @Test
    public void testSet() {
        createTree();
        tree.set(five, "hello");
        assertEquals(tree.right(ten).getElement(), "hello");
    }
    
    /**
     * Test the output of the size() behavior
     */     
    @Test
    public void testSize() {
        assertTrue(tree.isEmpty());
        createTree();
        assertEquals(tree.size(), 10);
        tree.remove(eight);
        assertEquals(tree.size(), 9);
        tree.addLeft(five, "me");
        assertEquals(tree.size(), 10);
    }
    
    /**
     * Test the output of the numChildren(p) behavior
     */     
    @Test
    public void testNumChildren() {
        createTree();
        assertEquals(tree.numChildren(two), 2);
        assertEquals(tree.numChildren(ten), 2);
        assertEquals(tree.numChildren(one), 2);
    }

    /**
     * Test the output of the parent(p) behavior
     */   
    @Test
    public void testParent() {
        createTree();
        assertEquals(tree.parent(five), ten);
        assertEquals(tree.parent(four), three);
    }

    /**
     * Test the output of the sibling behavior
     */     
    @Test
    public void testSibling() {
        createTree();
        assertEquals(tree.sibling(six), ten);
        assertEquals(tree.sibling(three), two);
    }

    /**
     * Test the output of the isInternal behavior
     */     
    @Test
    public void testIsInternal() {
        createTree();
        assertTrue(tree.isInternal(two));
        assertFalse(tree.isInternal(six));
    }

    /**
     * Test the output of the isLeaf behavior
     */     
    @Test
    public void isLeaf() {
        createTree();
        assertTrue(tree.isLeaf(six));
        assertFalse(tree.isLeaf(two));
    }

    /**
     * Test the output of the isRoot(p)
     */     
    @Test
    public void isRoot() {
        createTree();
        assertTrue(tree.isRoot(one));
        assertFalse(tree.isRoot(two));
        
    }
    
    /**
     * Test the output of the preOrder traversal behavior
     */     
    @Test
    public void testPreOrder() {
        createTree();
        Iterable<Position<String>> pre = tree.preOrder();
        Iterator<Position<String>> it = pre.iterator();
        assertEquals(it.next(), one);
        assertEquals(it.next(), two);
        assertEquals(it.next(), six);
        assertEquals(it.next(), ten);
        assertEquals(it.next(), seven);
        assertEquals(it.next(), five);
        assertEquals(it.next(), three);
        assertEquals(it.next(), four);
        assertEquals(it.next(), eight);
        assertEquals(it.next(), nine);
    }

    /**
     * Test the output of the postOrder traversal behavior
     */     
    @Test
    public void testPostOrder() {
        createTree();
        Iterable<Position<String>> post = tree.postOrder();
        Iterator<Position<String>> it = post.iterator();
        assertEquals(it.next(), six);
        assertEquals(it.next(), seven);
        assertEquals(it.next(), five);
        assertEquals(it.next(), ten);
        assertEquals(it.next(), two);
        assertEquals(it.next(), eight);
        assertEquals(it.next(), nine);
        assertEquals(it.next(), four);
        assertEquals(it.next(), three);
        assertEquals(it.next(), one);
    }
    
    /**
     * Test the output of the inOrder traversal behavior
     */     
    @Test
    public void testInOrder() {
        createTree();
        Iterable<Position<String>> in = tree.inOrder();
        Iterator<Position<String>> it = in.iterator();
        assertEquals(it.next(), six);
        assertEquals(it.next(), two);
        assertEquals(it.next(), seven);
        assertEquals(it.next(), ten);
        assertEquals(it.next(), five);
        assertEquals(it.next(), one);
        assertEquals(it.next(), eight);
        assertEquals(it.next(), four);
        assertEquals(it.next(), nine);
        assertEquals(it.next(), three);
    }

    /**
     * Test the output of the Binary Tree ADT behaviors on an empty tree
     */     
    @Test
    public void testEmptyTree() {
    	createTree();
        assertFalse(tree.isEmpty());
        newTree = new LinkedBinaryTree<String>(); 
        assertTrue(newTree.isEmpty());
    }
    
    @Test
    public void testLevelOrder() {
        createTree();
        Iterable<Position<String>> level = tree.levelOrder();
        Iterator<Position<String>> it = level.iterator();
        assertEquals(it.next(), one);
        assertEquals(it.next(), two);
        assertEquals(it.next(), three);
        assertEquals(it.next(), six);
        assertEquals(it.next(), ten);
        assertEquals(it.next(), four);
        assertEquals(it.next(), seven);
        assertEquals(it.next(), five);
        assertEquals(it.next(), eight);
        assertEquals(it.next(), nine);
    }

    /**
     * Test the output of the addLeft(p,e) behavior, including expected exceptions
     */      
    @Test
    public void testAddLeft() {
    	createTree();
    	tree.addLeft(eight, "test");
        assertEquals(tree.left(eight).getElement(), "test");
        tree.addLeft(five, "new");
        assertEquals(tree.left(five).getElement(), "new");
    }
    
    /**
     * Test the output of the addRight(p,e) behavior, including expected exceptions
     */      
    @Test
    public void testAddRight() {
    	createTree();
    	tree.addRight(eight, "test");
        assertEquals(tree.right(eight).getElement(), "test");
        tree.addRight(five, "new");
        assertEquals(tree.right(five).getElement(), "new");
    }   
    
    /**
     * Test the output of the remove(p) behavior, including expected exceptions
     */         
    @Test
    public void testRemove() {
        createTree();
        try {
        	tree.remove(four);
        } catch(IllegalArgumentException e) {
        	assertEquals(e.getMessage(), "The node has two children");
        }
        assertEquals(tree.size(), 10);
        tree.remove(eight);
        assertEquals(tree.size(), 9);
        assertEquals(tree.left(four), null);
    }
    /**
     * Test the output of the toString() behavior
     */
    @Test
    public void testToString() {
    	createTree();
    	assertEquals(tree.toString(), "LinkedBinaryTree[\none\n two\n  six\n  ten\n   seven\n   five\n three\n  four\n   eight\n   nine\n]");
    }
}