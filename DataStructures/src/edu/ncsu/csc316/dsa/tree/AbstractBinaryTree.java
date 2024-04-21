package edu.ncsu.csc316.dsa.tree;

import edu.ncsu.csc316.dsa.Position;

/**
 * A skeletal implementation of the Binary Tree abstract data type. This class
 * provides implementation for common methods that can be implemented the same
 * no matter what specific type of concrete data structure is used to implement
 * the binary tree abstract data type.
 * 
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the binary tree
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
    
    
	@Override
    public Iterable<Position<E>> inOrder() {
		PositionCollection traversal = new PositionCollection();
		if(!isEmpty()) {
			inOrderHelper(root(), traversal);
		}
		return traversal;
    }

    private void inOrderHelper(Position<E> p, PositionCollection traversal) {
    	if(p != null) {
    		inOrderHelper(left(p), traversal);
    		traversal.add(p);
    		inOrderHelper(right(p), traversal);
    	}
    }
    
    @Override
    public int numChildren(Position<E> p) {
        AbstractTreeNode<E> node = validate(p);
        int count = 0;
        if(left(node) != null) {
        	count++;
        }
        if(right(node) != null) {
        	count++;
        }
        return count;
    }
    
    @Override
    public Position<E> sibling(Position<E> p) {
        AbstractTreeNode<E> node = validate(p);
        if(isRoot(node)) {
        	return null;
        }
        Position<E> parentPos = parent(node);
        if(parentPos == null) {
        	return null;
        }
        AbstractTreeNode<E> parent = validate(parentPos);
        if(node == left(parent)) {
        	return right(parent);
        }
        else {
        	return left(parent);
        }
    }
    
    @Override
    public Iterable<Position<E>> children(Position<E> p) {
        AbstractTreeNode<E> node = validate(p);
        PositionCollection childrenCollection = new PositionCollection();
        if (left(node) != null) {
            childrenCollection.add(left(node));
        }
        if (right(node) != null) {
            childrenCollection.add(right(node));
        }
        return childrenCollection;
    }
}