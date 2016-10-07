package ucr.ac.cr.ecci.ci1221.util.algorithm;

import ucr.ac.cr.ecci.ci1221.util.collections.list.List;

/**
 * Utilitary class that provides sorting algorithms for sorting elements in lists.
 *
 *
 * @author Paola Ortega Saborio
 */
public class SortingAlgorithms {

    /**
     * Keeps swapping elements if the element to the left is bigger than the one on theright. Does this while the list is not in order.
     * @param list list where the sort will take place
     * @param <T> generic element
     */
    public static <T extends Comparable<? super T>> void bubbleSort(List<T> list){
        boolean swapped = true;
        while(swapped){
            swapped = false;
            int i = 0;
            for(int j = 1; j < list.size(); j++){
                if(list.get(j).compareTo(list.get(i)) < 0){
                    swapped = true;
                    T temp = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i, temp);
                }
                i++;
            }
        }
    }

    /**
     * Reinserts elements in an orderly fashion from left to right in the list.
     * @param list list where the sort will take place
     * @param <T> generic element
     */
    public static <T extends Comparable<? super T>> void insertionSort(List<T> list){
        for(int j = 1; j < list.size(); j++){
            int i = 0;
            boolean placed = false;
            while(!placed && i < j){
                if(list.get(i).compareTo(list.get(j)) > 0){
                    list.add(i, list.get(j));
                    list.remove(j+1);
                    placed = true;
                }
                else i++;
            }
        }
    }

    /**
     * Selects the smallest element in the list and arranges it from left to right
     * @param list list where the sort will take place
     * @param <T> generic element
     */
    public static <T extends Comparable<? super T>> void selectionSort(List<T> list){
        int min;
        for(int i = 0; i <= list.size() - 1; i++){
            min = i;
            for(int j = i + 1; j < list.size(); j++){
                if(list.get(j).compareTo(list.get(min)) < 0)
                    min = j;
            }
            list.add(i, list.get(min));
            list.remove(min + 1);
        }
    }

    /**
     * Recursive sort which uses a pivot element in order to rearrange its elements. Stops when the sub list size is of one element only.
     * @param list list where the sort will take place
     * @param <T> generic element
     */
    public static <T extends Comparable<? super T>> void quickSort(List<T> list){
        quicksort(list, 0, list.size() - 1);
    }

    /**
     * Private method used on quick sort in order to get a tighter control of its recursive function.
     * @param list list where the sort will take place.
     * @param start first element from the sub list.
     * @param end last element from the sub list.
     * @param <T> generic element
     */
    private static <T extends Comparable<? super T>> void quicksort(List<T> list, int start, int end){
        if(start + 1 <= end) {
            int pivot = end;
            int i = start;
            int j = end - 1;
            while (j >= i) {
                while (list.get(i).compareTo(list.get(pivot)) <= 0 && i < end && j >= i)
                    i++;
                while (list.get(j).compareTo(list.get(pivot)) >= 0 && j > start && j >= i)
                    j--;
                if (i <= j) {
                    T temp = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i, temp);
                    i++;
                    j--;
                }
            }
            T temp = list.get(pivot);
            list.set(pivot, list.get(i));
            list.set(i, temp);

            quicksort(list, start, pivot - 1);
            quicksort(list, pivot + 1, end);
        }
    }

    /**
     * Recursive sort which is based on partitioning one n length array into n arrays of 1 length, ordering them, and merging them back together.
     * @param list list where the sort will take place
     * @param <T> generic element
     */
    public static <T extends Comparable<? super T>> void mergeSort(List<T> list){
        T[] aux = (T[]) new Comparable[list.size()];
        mergesort(list, aux, 0, list.size() - 1);
    }

    /**
     *
     * Private method used on merge sort in order to get a tighter control of its recursive function.
     * @param list list where the sort will take place
     * @param aux auxiliary list used to temporarily store elements before passing them to the original list.
     * @param start first element from the sub list
     * @param end last element from the sub list
     * @param <T> generic element
     *
     */
    private static <T extends Comparable<? super T>> void mergesort(List<T> list, T[] aux, int start, int end){
        int half;
        if(end > start){
            half = (end + start) / 2;
            mergesort(list, aux, start, half);
            mergesort(list, aux, half + 1, end);
            merge(list, aux, start, end, half + 1);
        }
    }

    /**
     * Private function used to create the merge between the differen sublists
     * @param list list where the sort will take place
     * @param aux auxiliary list used to temporarily store elements before passing them to the original list.
     * @param start first element from the sub list
     * @param end last element from the sub list
     * @param half element in the middle of the sub list
     * @param <T> generic element
     */
    private static <T extends Comparable<? super T>> void merge(List<T> list, T[] aux, int start, int end, int half){
        int firstListPointer = start;
        int secondListPointer = half;

        for(int i = start; i <= list.size() - 1; i++)
            aux[i] = list.get(i);
        for(int j = start; j <= end; j++){
            if(firstListPointer > half) {
                list.set(j, aux[secondListPointer]);
                secondListPointer++;
            }else if(secondListPointer > end) {
                list.set(j, aux[firstListPointer]);
                firstListPointer++;
            }else if(aux[secondListPointer].compareTo(aux[firstListPointer]) < 0) {
                list.set(j, aux[secondListPointer]);
                secondListPointer++;
            }else if(j == firstListPointer){
                list.set(j, aux[firstListPointer]);
                firstListPointer++;
            }
        }
    }
}
