package ucr.ac.cr.ecci.ci1221.util.collections.list;



import java.util.Iterator;

/**
 * Array based implementation of the {@link List} model.
 *
 * @param <E> the type of elements in the list.
 * @author Paola Ortega Saborio
 */
public class ArrayList<E> implements List<E> {
    /**
     * Static array implemented to artificially create the dynamic array from this class.
     */
    private E[] array;
    /**
     * Internal counter that keeps track of how many elements are being held in the structure.
     * Important: the counter starts at -1, meaning the structure is empty. The first element is 0, and so forth.
     *
     */
    private int counter;

    /**
     * Internal fix for the Iterator used in this particular context (array list).
     */
    private class arrayListIterator implements Iterator<E>{
        /**
         * Position of the current element that is being iterated over.
         */
        int currentPos;

        /**
         * Constructor. Initializes the position counter.
         */
        public arrayListIterator() {currentPos = -1;}

        /**
         * Checks if there exists an element next to the one that's currently being iterated over.
         * @return true if there exists such element. False otherwise.
         */
        @Override
        public boolean hasNext(){
            return (currentPos < counter);
        }

        /**
         * Changes the iterator to the next element.
         * @return the newly iterated element.
         */
        @Override
        public E next(){
            if(hasNext()){
                currentPos++;
                return array[currentPos];
            } else return null;
        }
    }

    /**
     * Private method used to resize the static Array when it runs out of storage. Always increments by 20.
     */
    private void resize(){
        E[] newArray = (E[]) new Object[array.length + 20];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    /**
     * Constructor. Initializes an empty static array and starts the internal counter with -1.
     */
    public ArrayList(){
        array = (E[]) new Object[20];
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
        return array[0];
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
        return array[index];
    }

    /**
     * @param index the index used to calculate the next element.
     * @return the element in the next position, null if index is the last element.
     */
    @Override
    public E next(int index) {
        if(index == counter)
            return null;
        return array[index+1];
    }

    /**
     * @param index the index used to calculate the previous element.
     * @return the element in the previous position, null if index is the first element.
     */
    @Override
    public E previous(int index) {
        if(index == 0)
            return null;
        return array[index-1];
    }

    /**
     * Replaces the element at the specified position with the element given as a parameter.
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
    @Override
    public E set(int index, E element) {
        E temp = array[index];
        if(index > counter + 1 || index < 0){
            ArrayIndexOutOfBoundsException a = new ArrayIndexOutOfBoundsException("Index is out of range");
            throw a;
        }
        if(element == null){
            NullPointerException n = new NullPointerException("Specified element is null.");
            throw n;
        }
        if(element == null){
            NullPointerException n = new NullPointerException("Specified element is null.");
            throw n;
        }
        array[index] = element;
        return temp;
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
        if (counter + 1 == array.length)
            resize();
        if (index == 0)
            add(element);
        else if (index == counter + 1)
            array[counter + 1] = element;
        else{
            System.arraycopy(array, index, array, index + 1, counter - index + 1);
            array[index] = element;
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
        if(counter + 1 == array.length)
            resize();
        counter++;
        array[counter] = e;
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
        E aux = array[index];
        if(index != counter)
            System.arraycopy(array, index + 1, array, index, counter - index);
        array[counter] = null;
        counter--;
        return aux;
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
        array = (E[]) new Object[20];
        counter = -1;
    }

    /**
     *
     * @return an Iterator over generic elements.
     */
    @Override
    public Iterator<E> iterator() {
        return new arrayListIterator();
    }
}
