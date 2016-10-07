package ucr.ac.cr.ecci.ci1221.util.collections.list;

import java.util.Iterator;

/**
 * Doubly Linked pointer based implementation of the {@link List} model.
 *
 *
 * @param <E> the type of elements in the list.
 * @author Paola Ortega S.
 */
public class DoubleLinkedList<E> implements List<E>  {
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
    private class Node{
        /**
         * Generic element that is being stored
         */
        private E element;

        /**
         * Pointer that signals where the previous node is.
         */
        private Node prev;

        /**
         * Pointer that signals where the next node is.
         */
        private Node next;

        /**
         * Constructor.
         * @param element to be stored inside the node.
         */
        private Node(E element){
            this.element = element;
            prev = next = null;
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
     * Internal fix for the Iterator used in this particular context (double linked list).
     */
    private class doubleLinkedListIterator implements Iterator<E>{
        /**
         * Position of the current element that is being iterated over.
         */
        private int currentInt;

        /**
         * Constructor. Initializes the position counter.
         */
        public doubleLinkedListIterator(){
            currentInt = -1;
        }

        /**
         * Checks if there exists an element next to the one that's currently being iterated over.
         * @return true if there exists such element. False otherwise.
         */
        @Override
        public boolean hasNext(){
            return (currentInt < counter);
        }

        /**
         * Changes the iterator to the next element.
         * @return the newly iterated element.
         */
        @Override
        public E next(){
            if(currentInt >= counter)
            return null;
            if(currentInt == -1){
                currentInt++;
                return head.getElement();
            }
            Node aux = head;
            for(int i = 0; i <= currentInt; i++)
                aux = aux.next;
            currentInt++;
            return aux.getElement();
        }
    }

    /**
     * Constructor. Initializes both list nodes and the internal counter with -1.
     */
    public DoubleLinkedList(){
        head = tail = null;
        counter = -1;
    }

    /**
     * @return the first element of the collection.
     */
    @Override
    public E first(){
        if(counter == -1){
            IndexOutOfBoundsException i = new IndexOutOfBoundsException("There are no elements in the list.");
            throw i;
        }
        return head.getElement();
    }

    /**
     * @param index index of the element to return
     * @return the element at the specified position in this collection
     */
    @Override
    public E get(int index) {
        if(counter == -1 || index > counter){
            IndexOutOfBoundsException i = new IndexOutOfBoundsException("Index is out of range.");
            throw i;
        }
        Node temp;
        if(counter - index >= index){
            temp = head;
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }
        } else {
            temp = tail;
            for(int i = counter; i> index; i--){
                temp = temp.prev;
            }
        }
        return temp.getElement();
    }

    /**
     * @param index the index used to calculate the next element.
     * @return the element in the next position, null if index is the last element.
     */
    @Override
    public E next(int index) {
        if(index == counter)
            return null;
        Node temp;
        if(counter - index >= index){
            temp = head;
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }
        } else {
            temp = tail;
            for(int i = counter; i > index; i--){
                temp = temp.prev;
            }
        }
        return temp.next.getElement();
    }

    /**
     * @param index the index used to calculate the previous element.
     * @return the element in the previous position, null if index is the first element.
     */
    @Override
    public E previous(int index) {
        if(index == 0)
            return null;
        Node temp;
        if(counter - index >= index){
            temp = head;
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }
        } else {
            temp = tail;
            for(int i = counter; i> index; i--){
                temp = temp.prev;
            }
        }
        return temp.prev.getElement();
    }

    /**
     * Replaces the element at the specified position with the element given as a parameter.
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
    @Override
    public E set(int index, E element) {
        E previousElement = this.get(index);
        if(index > counter + 1 || index < 0){
            ArrayIndexOutOfBoundsException a = new ArrayIndexOutOfBoundsException("Index is out of range");
            throw a;
        }
        if(element == null){
            NullPointerException n = new NullPointerException("Specified element is null.");
            throw n;
        }
        Node temp;
        if(counter - index >= index){
            temp = head;
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }
        } else {
            temp = tail;
            for(int i = counter; i> index; i--){
                temp = temp.prev;
            }
        }
        temp.setElement(element);
        return previousElement;
    }

    /**
     * Inserts the element at the specified position with the element given as a parameter.
     * Shifts the element currently at that position
     * (if any) and any subsequent elements to the right. Increases counter by 1.
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    @Override
    public void add(int index, E element) {
        if(index > counter + 1 || index < 0){
            ArrayIndexOutOfBoundsException a = new ArrayIndexOutOfBoundsException("Index is out of range");
            throw a;
        }
        if(element == null){
            NullPointerException n = new NullPointerException("Specified element is null.");
            throw n;
        }
        Node node = new Node(element);
        if(index != 0 && index != counter + 1){
            Node temp;
            if(counter - index >= index){
                temp = head;
                for(int i = 0; i < index-1; i++){
                    temp = temp.next;
                }
                node.next = temp.next;
                temp.next.prev = node;
                temp.next = node;
                node.prev = temp;
            } else {
                temp = tail;
                for(int i = counter; i >= index+1; i--){
                    temp = temp.prev;
                }
                node.prev = temp.prev;
                temp.prev.next = node;
                temp.prev = node;
                node.next = temp;
            }
        } else {
            if(index == counter + 1){
                tail.next = node;
                node.prev = tail;
                tail = tail.next;
            }
            else {
                head.prev = node;
                node.next = head;
                head = head.prev;
            }
        }
        counter++;
    }

    /**
     * Appends the specified element to the end of this list. Increases counter by 1.
     * @param e element to be appended to this list
     * @return true when the element is added.
     */
    @Override
    public boolean add(E e) {
        if(e == null){
            NullPointerException n = new NullPointerException("Specified element is null.");
            throw n;
        }
        Node temp = new Node(e);
        if(counter != -1){
            tail.next = temp;
            temp.prev = tail;
            tail = tail.next;
        }else{
            head = tail = temp;
        }
        counter++;
        return true;
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left. Decreases counter by 1.
     * @param index the index of the element to be removed
     * @return the element that was removed from the list.
     */
    @Override
    public E remove(int index) {
        if(counter == -1){
            ArrayIndexOutOfBoundsException a = new ArrayIndexOutOfBoundsException();
            throw a;
        }
        Node aux;
        if(index != 0 && index < counter){
            Node temp;
            if(counter - index >= index){
                temp = head;
                for(int i = 0; i < index-1; i++)
                    temp = temp.next;
                aux = temp.next;
                temp.next = temp.next.next;
                aux.next.prev = temp;
                aux.prev = null;
                aux.next = null;
            } else {
                temp = tail;
                for(int i = counter; i > index+1; i--)
                    temp = temp.prev;
                aux = temp.prev;
                temp.prev = temp.prev.prev;
                aux.prev.next = temp;
                aux.next = null;
                aux.prev = null;
            }
        }else{
            if(index == counter){
                aux = tail;
                tail = tail.prev;
                tail.next = null;
                aux.prev = null;
            }
            else {
                aux = head;
                head = head.next;
                head.prev = null;
                aux.next = null;
            }
        }
        counter--;
        return aux.getElement();
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
     *
     * @return an Iterator over generic elements.
     */
    @Override
    public Iterator<E> iterator() {
        return new doubleLinkedListIterator();
    }

    /**
     * Removes all of the elements from this collection.
     */
    @Override
    public void clear() {
        head = tail = null;
        counter = -1;
    }

    /**
     * Test method used to visualize the elements from the list into strings.
     * @return a string representation of the collection.
     */
    public String toString(){
        Node node = head;
        String str = "";
        Iterator<E> it = this.iterator();
        while(it.hasNext()){
            str = str + node.element + ", ";
            node = node.next;
            it.next();
        }
        return str;
    }
}
