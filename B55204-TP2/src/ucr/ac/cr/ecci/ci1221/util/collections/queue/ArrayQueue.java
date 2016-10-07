package ucr.ac.cr.ecci.ci1221.util.collections.queue;


/**
 * Array based implementation of the {@link Queue} model.
 *
 *
 * @param <E> the type of elements in the queue.
 * @author Paola Ortega Saborio
 */
public class ArrayQueue<E> implements Queue<E> {
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
    public ArrayQueue(){
        array = (E[]) new Object [20];
        counter = -1;
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
     * Inserts the specified element into the queue.
     * @param element the element to add
     */
    @Override
    public void enqueue(E element) {
        if(counter + 1 > array.length)
            resize();
        if(counter != -1)
            System.arraycopy(array, 0, array, 1, counter + 1);
        array[0] = element;
        counter++;
    }

    /**
     * Retrieves and removes the head of this queue. If queue is empty, returns null.
     * @return head of the queue. Null if queue is empty.
     */
    @Override
    public E dequeue() {
        if(counter == -1) return null;
        E temp = array[counter];
        System.arraycopy(array, 1, array, 0, counter - 1);
        array[counter] = null;
        counter--;
        return temp;
    }

    /**
     * Retrieves, but does not remove, the head of the queue.
     * @return head of the queue (without removing it from the queue). Null if queue is empty.
     */
    @Override
    public E peek() {
        if(counter == -1) return null;
        return array[counter];
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
        array = (E[]) new Object [20];
        counter = -1;
    }
}
