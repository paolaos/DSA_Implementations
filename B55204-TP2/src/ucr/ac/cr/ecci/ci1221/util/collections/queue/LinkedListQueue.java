package ucr.ac.cr.ecci.ci1221.util.collections.queue;


/**
 * Linked based implementation of the {@link Queue} model.
 *
 *
 * @param <E> the type of elements in the queue.
 * @author Paola Ortega Saborio
 */
public class LinkedListQueue<E> implements Queue<E> {
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
     * Node that points to the last node of the list.
     */
    private Node tail;

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
         * Pointer that signals where the previous node is.
         */
        private Node prev;

        /**
         * Constructor.
         * @param element to be stored inside the node.
         */
        public Node(E element){
            this.element = element;
            next = prev = null;
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
     * Constructor. Initializes both list nodes and the internal counter with -1.
     */
    public LinkedListQueue(){
        counter = -1;
        head = tail = null;
    }

    /**
     * Inserts the specified element into the queue.
     * @param element the element to add
     */
    @Override
    public void enqueue(E element) {
        Node temp = new Node(element);
        if(counter != -1){
            head.prev = temp;
            temp.next = head;
            head = head.prev;
        }else
            head = tail = temp;
        counter++;
    }

    /**
     * Retrieves and removes the head of this queue. If queue is empty, returns null.
     * @return head of the queue. Null if queue is empty.
     */
    @Override
    public E dequeue() {
        if(counter == -1) return null;
        Node aux = tail;
        tail = tail.prev;
        tail.next = null;
        aux.prev = null;
        return aux.getElement();
    }

    /**
     * Retrieves, but does not remove, the head of the queue.
     * @return head of the queue (without removing it from the queue). Null if queue is empty.
     */
    @Override
    public E peek() {
        if(counter == -1) return null;
        return tail.getElement();
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
        head = tail = null;
        counter = -1;
    }

}
