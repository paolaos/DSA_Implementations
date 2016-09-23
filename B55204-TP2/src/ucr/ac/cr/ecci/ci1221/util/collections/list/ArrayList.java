package ucr.ac.cr.ecci.ci1221.util.collections.list;

import java.util.Iterator;

/**
 * Array based implementation of the {@link List} model.
 *
 * @TODO Complete operators implementations, javadoc and any missing code.
 * @TODO Make exceptions for operators that need them.
 * @param <E> the type of elements in the list.
 * @author Paola Ortega Saborio
 */
public class ArrayList<E> implements List<E> {
    private E[] array;
    private int counter;
    private Iterator<E> last;
    private class arrayListIterator implements Iterator<E>{
        int currentPos;
        public arrayListIterator() {currentPos = -1;}

        public boolean hasNext(){
            return (counter >= 0 && currentPos < counter);
        }
        public E next(){
            if(counter > 0){
                return array[++currentPos];
            } else return null;
        }
    }
    private void resize(){
        E[] newArray = (E[]) new Object[array.length + 10];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    } // se asume que ya esta lleno.
    public ArrayList(){
        array = (E[]) new Object[10];
        counter = -1;
        last = this.iterator();
    }

    @Override
    public E get(int index) {
        return array[index];
    }

    @Override
    public E next(int index) {
        return array[index+1];
    }

    @Override
    public E previous(int index) {
        return array[index-1];
    }

    @Override
    public E set(int index, E element) {
        array[index] = element;
        return element;
    }

    @Override
    public void add(int index, E element) {
        if(!last.hasNext())
            resize();
        System.arraycopy(array, index, array, index+1, counter+1-(index)); //counter-(index)
        this.set(index, element);
        counter++;

    } //not finished

    @Override
    public boolean add(E e) {
        if(!last.hasNext())
            resize();
        counter++;
        array[counter] = e;
        last.next();
        return true;
    }

    @Override
    public E remove(int index) { // not finished
        E prey = array[index];
        E predator;
        Iterator<E> it = this.iterator();
        while(it.hasNext()){
            predator = it.next();
            if(prey.equals(predator)){

            }
        }
        counter--;
        return prey;
    } //not finished

    @Override
    public int size() {
        return counter+1;
    }

    @Override
    public boolean isEmpty() {
        return counter == -1;
    }

    @Override
    public void clear() {
        array = (E[]) new Object[10];
        counter = -1;
        last = this.iterator();
    }

    @Override
    public Iterator<E> iterator() {
        return new arrayListIterator();
    }
}
