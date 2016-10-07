package ucr.ac.cr.ecci.ci1221.util.collections.stack;

import java.util.Iterator;

/**
 * Array based implementation of the {@link Stack} model.
 *
 *
 * @param <E> the type of elements in the stack.
 * @author Paola Ortega Saborio
 */
public class ArrayStack<E> implements Stack<E>{
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
     * Constructor. Initializes an empty static array and starts the internal counter with -1.
     */
    public ArrayStack(){
        counter = -1;
        array = (E[]) new Object[20];
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
     * Pushes an item onto the top of this stack.
     * @param   element the item to be pushed onto this stack.
     */
    @Override
    public void push(E element) {
        if(counter + 1 > array.length)
            resize();
        if(counter != -1)
            System.arraycopy(array, 0, array, 1, counter);
        array[0] = element;
        counter++;
    }

    /**
     * Removes the object at the top of this stack.
     * @return  The object at the top of this stack or null if this stack is empty.
     */
    @Override
    public E pop() {
        if(counter == -1){
            ArrayIndexOutOfBoundsException a = new ArrayIndexOutOfBoundsException();
            throw a;
        }
        E temp = array[0];
        System.arraycopy(array, 1, array, 0, counter - 1);
        array[counter] = null;
        counter--;
        return temp;
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
        return array[0];
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
        array = (E[]) new Object[10];
        counter = -1;
    }

}
