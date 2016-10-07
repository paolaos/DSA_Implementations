package ucr.ac.cr.ecci.ci1221.tests;

import ucr.ac.cr.ecci.ci1221.util.collections.list.ArrayList;
import ucr.ac.cr.ecci.ci1221.util.collections.list.DoubleLinkedList;
import ucr.ac.cr.ecci.ci1221.util.collections.list.LinkedList;
import ucr.ac.cr.ecci.ci1221.util.algorithm.SearchAlgorithms;
import ucr.ac.cr.ecci.ci1221.util.algorithm.SortingAlgorithms;

import java.util.Iterator;

/**
 * Test case for the Algorithms. Includes Tests for all the search and sort algorithms.
 *
 * Created by Paola Ortega S on 9/26/2016.
 */
public class MainAlgorithms {
    public static void main(String[] args) {
        System.out.println("---------------------------------------List 1---------------------------------------");
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        Integer tbf = 6;
        list1.add(1);
        list1.add(4);
        list1.add(5);
        list1.add(1);
        list1.add(2);
        list1.add(tbf);

        System.out.println("These are the elements in the first list: ");
        Iterator<Integer> iterator1 = list1.iterator();
        while(iterator1.hasNext()){
            Integer i = iterator1.next();
            System.out.println(i);
        }
        Integer search1 = SearchAlgorithms.linearSearch(list1, 6);
        System.out.println("I will search for the element 6 in the list using linear search. Is it there? " + tbf.equals(search1));

        SortingAlgorithms.quickSort(list1);
        System.out.println("These are the sorted elements in the first list using quick sort: ");
        Iterator<Integer> iterator2 = list1.iterator();
        while(iterator2.hasNext()){
            Integer i = iterator2.next();
            System.out.println(i);
        }


        System.out.println("---------------------------------------List 2---------------------------------------");
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(122);
        list2.add(431);
        list2.add(533);
        list2.add(134);
        list2.add(286);
        list2.add(343);
        list2.add(302);
        list2.add(170);

        System.out.println("These are the elements in the second list: ");
        Iterator<Integer> iterator3 = list2.iterator();
        while(iterator3.hasNext()){
            Integer i = iterator3.next();
            System.out.println(i);
        }

        SortingAlgorithms.bubbleSort(list2);
        System.out.println("These are the sorted elements in the third list using bubble sort: ");
        Iterator<Integer> iterator4 = list2.iterator();
        while(iterator4.hasNext()){
            Integer i = iterator4.next();
            System.out.println(i);
        }


        System.out.println("---------------------------------------List 3---------------------------------------");
        LinkedList<Integer> list3 = new LinkedList<>();
        Integer tbs = 236;
        list3.add(224);
        list3.add(542);
        list3.add(366);
        list3.add(tbs);
        list3.add(682);
        list3.add(738);

        System.out.println("These are the elements in the third list: ");
        Iterator<Integer> iterator5 = list3.iterator();
        while(iterator5.hasNext()){
            Integer i = iterator5.next();
            System.out.println(i);
        }

        SortingAlgorithms.selectionSort(list3);
        System.out.println("These are the sorted elements in the third list using selection sort: ");
        Iterator<Integer> iterator6 = list3.iterator();
        while(iterator6.hasNext()){
            Integer i = iterator6.next();
            System.out.println(i);
        }


        Integer search2 = SearchAlgorithms.binarySearch(list3, 236);
        System.out.println("I will search for the element 236 in the list using binary search. Is it there? " + tbs.equals(search2));


        System.out.println("---------------------------------------List 4---------------------------------------");
        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(22);
        list4.add(54);
        list4.add(36);
        list4.add(23);
        list4.add(68);
        list4.add(73);

        System.out.println("These are the elements in the fourth list: ");
        Iterator<Integer> iterator7 = list4.iterator();
        while(iterator7.hasNext()){
            Integer i = iterator7.next();
            System.out.println(i);
        }

        SortingAlgorithms.insertionSort(list4);
        System.out.println("These are the sorted elements in the fourth list using insertion sort: ");
        Iterator<Integer> iterator8 = list4.iterator();
        while(iterator8.hasNext()){
            Integer i = iterator8.next();
            System.out.println(i);
        }


        System.out.println("---------------------------------------List 5---------------------------------------");
        DoubleLinkedList<Integer> list5 = new DoubleLinkedList<>();
        list5.add(0);
        list5.add(2);
        list5.add(5);
        list5.add(3);
        list5.add(2);
        list5.add(6);

        System.out.println("These are the elements in the fifth list: ");
        Iterator<Integer> iterator9 = list5.iterator();
        while(iterator9.hasNext()){
            Integer i = iterator9.next();
            System.out.println(i);
        }

        SortingAlgorithms.mergeSort(list5);
        System.out.println("These are the sorted elements in the fifth list using mergesort: ");
        Iterator<Integer> iterator10 = list5.iterator();
        while(iterator10.hasNext()){
            Integer i = iterator10.next();
            System.out.println(i);
        }


    }



}
