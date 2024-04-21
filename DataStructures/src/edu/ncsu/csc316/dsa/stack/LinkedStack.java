package edu.ncsu.csc316.dsa.stack;

import java.util.EmptyStackException;

import edu.ncsu.csc316.dsa.list.SinglyLinkedList;

/**
 * The Linked Stack is implemented as a singly-linked list data structure to
 * support efficient, O(1) worst-case Stack abstract data type behaviors.
 * 
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the stack
 */
public class LinkedStack<E> extends AbstractStack<E> {

    /** Delegate to our existing singly linked list class **/
    private SinglyLinkedList<E> list;

    /**
     * Construct a new singly-linked list to use when modeling the last-in-first-out
     * paradigm for the stack abstract data type.
     */
    public LinkedStack() {
        list = new SinglyLinkedList<E>();
    }

	/**
	 * Adds an element to the front of the LinkedStack.
	 * @param element element to add to the front.
	 */
	public void push(E element) {
		list.addFirst(element);
	}

	/**
	 * Removes the top element of the LinkedStack and returns it.
	 * @return Top element that was removed.
	 */
	public E pop() {
		if(list.isEmpty()) {
			throw new EmptyStackException();
		}
		return list.removeFirst();
	}

	/**
	 * Gets the top element of the LinkedStack.
	 * @return returns the element at the top
	 */
	public E top() {
		if(list.isEmpty()) {
			throw new EmptyStackException();
		}
		return list.first();
	}

	/**
	 * Gets the size of the LinkedStack.
	 * @return returns the size of the stack.
	 */
	public int size() {
		return list.size();
	}
    
}