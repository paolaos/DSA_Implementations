package ucr.ac.cr.ecci.ci1221.util.algorithm;

import ucr.ac.cr.ecci.ci1221.util.collections.list.List;

/**
 * Utilitary class that provides searching algorithms for looking for elements in lists.
 *
 *
 * @author Student name.
 */
public class SearchAlgorithms<T extends Comparable<T>>{

    /**
     * Searches element by element (from left to right) until it finds the element.
     * @param list list where the search will take place
     * @param key element to be searched on the list
     * @param <T> generic element
     * @return the element that was being searched on the list. Null if the element was not found.
     */
    public static <T extends Comparable<? super T>> T linearSearch(List<T> list, T key){
        boolean found = false;
        int i = 0;
        while(!found && i <= list.size()){
            if(list.get(i).compareTo(key) == 0)
                found = true;
            else i++;
        }
        if(!found)
            return null;
        return list.get(i);
    }

    /**
     * The dynamic in this search method relies in partitioning the list in half until the element is found.
     * Requirement: elements in the list have to be ordered prior to using binary search.
     * @param list list where the search will take place
     * @param key element to be searched on the list
     * @param <T> generic element
     * @return the element that was being searched on the list.
     */
    public static <T extends Comparable<? super T>> T binarySearch(List<T> list, T key){
        int a = 0;
        int b = list.size();
        while(a <= b){
            int c = a + (b - a) / 2;
            if(list.get(c).compareTo(key) == 0)
                return list.get(c);
            else if(list.get(c).compareTo(key) < 0)
                a = c + 1;
            else b = c - 1;
        }
        return null;
    }
}
