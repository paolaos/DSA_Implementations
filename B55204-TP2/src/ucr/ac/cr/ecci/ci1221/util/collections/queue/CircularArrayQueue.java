package ucr.ac.cr.ecci.ci1221.util.collections.queue;



/**
 * Circular array based implementation of the {@link Queue} model.
 *
 *
 * @param <E> the type of elements in the queue.
 * @author Paola Ortega Saborio
 */
public class CircularArrayQueue<E> implements Queue<E> {
    /**
     * Internal counter that keeps track of how many elements are being held in the structure.
     * Important: the counter starts at -1, meaning the structure is empty. The first element is 0, and so forth.
     *
     */
    private int counter;

    /**
     * Internal counter that increments whenever an element is dequeued into the structure
     */
    private int read;

    /**
     *Internal counter that increments whenever an element is queued from the structure.
     */
    private int write;

    /**
     * Static array implemented to artificially create the dynamic array from this class.
     */
    private E[] array;

    /**
     * Private method used to resize the static Array when it runs out of storage. Always increments by 20.
     */
    private void resize(){
        E[] newArray = (E[]) new Object[array.length + 20];
        for(int i = 0; i <= counter; i++){
            newArray[i] = array[read];
            read = (read + 1) % array.length;
        }
        read = 0;
        write = counter;
        array = newArray;
    }

    /**
     * Constructor. Initializes an empty static array, read and write and starts the internal counter with -1.
     */
    public CircularArrayQueue(){
        array = (E[]) new Object[20];
        counter = -1;
        read = write = 0;
    }

    /**
     * Inserts the specified element into the queue.
     * @param element the element to add
     */
    @Override
    public void enqueue(E element) {
        if(counter + 1 >= array.length)
            resize();
        array[write] = element;
        write = (write + 1) % array.length;
        counter++;
    }

    /**
     * Retrieves and removes the head of this queue. If queue is empty, returns null.
     * @return head of the queue. Null if queue is empty.
     */
    @Override
    public E dequeue() {
        if(counter == -1) return null;
        E temp = array[read];
        array[read] = null;
        read = (read + 1) % array.length;
        counter--;
        if(counter == 0)
            read = write;
        return temp;
    }

    /**
     * Retrieves, but does not remove, the head of the queue.
     * @return head of the queue (without removing it from the queue). Null if queue is empty.
     */
    @Override
    public E peek() {
        if(counter == -1) return null;
        return array[read];
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
        counter = read = write = -1;
    }

}
