package ucr.ac.cr.ecci.ci1221.util.collections.stack;

import ucr.ac.cr.ecci.ci1221.util.collections.list.LinkedList;

import java.util.Iterator;

/**
 * Array based implementation of the {@link Stack} model.
 *
 *
 * @param <E> the type of elements in the stack.
 * @author Paola Ortega Saborio
 */
public class LinkedListStack<E> implements Stack<E> {
    /**
     * Internal counter that keeps track of how many elements are being held in the structure.
     * Important: the counter starts at -1, meaning the structure is empty. The first element is 0, and so forth.
     *
     */
    private int counter;

    /**
     * Node that points to the first node of the list.
     */
    private Node head;

    /**
     * Internal structure that allows the internal manipulation of the order and the contents from the elements at the list.
     */
    private class Node {
        /**
         * Generic element that is being stored
         */
        private E element;

        /**
         * Pointer that signals where the next node is.
         */
        private Node next;

        /**
         * Constructor.
         * @param element to be stored inside the node.
         */
        public Node(E element){
            this.element = element;
        }

        /**
         * Function that explicitly returns the element inside the node.
         * @return the element inside the node.
         */
        public E getElement() {
            return element;
        }

        /**
         * Modifies a specific node with the element passed as a parameter.
         * If there was an element previously stored in the node, it gets replaced with the new element.
         * @param element to be placed inside the node.
         */
        public void setElement(E element) {
            this.element = element;
        }
    }

    /**
     * Constructor. Initializes the head node and the internal counter with -1.
     */
    public LinkedListStack(){
        counter = -1;
        head = null;
    }

    /**
     * Pushes an item onto the top of this stack.
     * @param   element the item to be pushed onto this stack.
     */
    @Override
    public void push(E element) {
        Node temp = new Node(element);
        if(head != null){
            temp.next = head;
            head = temp;
        } else head = temp;
        counter++;
    }

    /**
     * Removes the object at the top of this stack.
     * @return  The object at the top of this stack or null if this stack is empty.
     */
    @Override
    public E pop() {
        if(head == null){
            ArrayIndexOutOfBoundsException a = new ArrayIndexOutOfBoundsException();
            throw a;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        counter--;
        return temp.getElement();
    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     *
     * @return  the object at the top of this stack or null if this stack is empty.
     */
    @Override
    public E peek() {
        if(counter == -1)
            return null;
        return head.getElement();
    }

    /**
     * Important: since this function has an ADT output, the internal counter is increased by one.
     * @return the number of elements in this collection.
     */
    @Override
    public int size() {
        return counter + 1;
    }

    /**
     * Checks if the collection is empty.
     * @return true if the collection has no elements
     */
    @Override
    public boolean isEmpty() {
        return counter == -1;
    }

    /**
     * Removes all of the elements from this collection.
     */
    @Override
    public void clear() {
        head = null;
        counter = -1;
    }


}
