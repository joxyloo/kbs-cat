/******************************************************************************
 *  Compilation:  javac Stack.java
 *
 *  The Stack class represents a last-in-first-out (LIFO) stack of generic items.
 *  It supports the usual push and pop operations, along with methods for peeking at the
 *  top item, testing if the stack is empty, getting the number of items in the stack, and
 *  iterating over the items in LIFO order.
 *
 *  This implementation uses a singly-linked list with a nested class for linked-list nodes.
 *
 *  For additional documentation, see http://introcs.cs.princeton.edu/43stack of
 *  Introduction to Programming in Java: An Interdisciplinary Approach
 *	by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *
 ******************************************************************************/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
    private int n;          // size of the stack
    private Node first;     // top of stack
    private int originalSize; // the original size of the stack
    private ArrayList<String> untouchedItem;

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

   /**
     * Initializes an empty stack.
     */
    public Stack() {
        first = null;
        n = 0;
        originalSize = 0;
        untouchedItem =new ArrayList<String>();
    }

    /**
     * Returns true if this stack is empty.
     *
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this stack.
     *
     * @return the number of items in this stack
     */
    public int size() {
        return n;
    }
    //return number of items in the stack
    public int originalSize() {
    	return originalSize;
    }

    /**
     * Adds the item to this stack.
     *
     * @param  item the item to add
     */
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        originalSize++;
        n++;
        untouchedItem.add(item.toString());
    }
    
    public ArrayList<String> getAllSymptom(){
    	return untouchedItem;
    }
    /**
     * Removes and returns the item most recently added to this stack.
     *
     * @return the item most recently added
     * @throws NoSuchElementException if this stack is empty
     */
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }


    /**
     * Returns (but does not remove) the item most recently added to this stack.
     *
     * @return the item most recently added to this stack
     * @throws NoSuchElementException if this stack is empty
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    /**
     * Returns a string representation of this stack.
     *
     * @return the sequence of items in this stack in LIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }


    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     *
     * @return an iterator to this stack that iterates through the items in LIFO order
     */
    public Iterator<Item> iterator()  { return new ListIterator();  }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }}