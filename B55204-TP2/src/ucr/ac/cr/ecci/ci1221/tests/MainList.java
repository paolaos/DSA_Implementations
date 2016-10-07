package ucr.ac.cr.ecci.ci1221.tests;

import ucr.ac.cr.ecci.ci1221.domain.Song;
import ucr.ac.cr.ecci.ci1221.util.collections.list.ArrayList;
import ucr.ac.cr.ecci.ci1221.util.collections.list.DoubleLinkedList;
import ucr.ac.cr.ecci.ci1221.util.collections.list.LinkedList;
import ucr.ac.cr.ecci.ci1221.util.collections.list.List;

import java.util.Iterator;

/**
 * Test case for the List Collection. Includes Tests for ArrayList, Linked List and Double Linked List.
 * Verifies functions for every single operator.
 *
 * Created by Paola Ortega S on 9/26/2016.
 */
public class MainList {

    public static void main(String[] args) {
        System.out.println("---------------------------------------Beginning of ArrayList Test---------------------------------------");

        List<Song> list = new ArrayList<Song>();

        System.out.println("Size should be zero: " + list.size() + " and be empty: " + list.isEmpty());

        Song bohemianRhapsody = new Song("Bohemian Rhapsody", 367);

        list.add(new Song("The Show Must Go On", 262));
        list.add(bohemianRhapsody);
        list.add(new Song("Radio Ga Ga", 356));
        list.add(new Song("It's a Hard Life", 254));

        System.out.println("Size should be 4: " + list.size() + " and be empty false: " + list.isEmpty());

        list.remove(0);
        System.out.println("Size should be 3: " + list.size() + " and be empty false: " + list.isEmpty());

        Song song = list.get(0);
        System.out.println("The song retrieved should be Bohemian Rhapsody: " + bohemianRhapsody.equals(song));

        Song iWantToBreakFree = new Song("I Want To Break Free", 320);

        list.add(1, iWantToBreakFree);
        System.out.println("We just added 'I Want To Break Free' to the second position.");

        Iterator<Song> iterator = list.iterator();
        while(iterator.hasNext()){
            Song element = iterator.next();
            System.out.println("Song name: " + element.getTitle() + " \tDuration: " + element.getSeconds());
        }

        System.out.println("Next to Radio Ga Ga is It's a Hard Life: " + list.next(2).getTitle() + ". Previous to it is I Want To Break Free: " + list.previous(2).getTitle());

        Song somebodyToLove = new Song("Somebody to Love", 456);
        list.set(0, somebodyToLove);
        System.out.println("The first song was changed to Somebody to Love: " + somebodyToLove.equals(list.first()));

        list.clear();
        System.out.println("Size should be zero: " + list.size() + " and be empty: " + list.isEmpty());


        System.out.println("---------------------------------------Beginning of LinkedList Test---------------------------------------");

        LinkedList<Integer> list1 = new LinkedList<>();
        System.out.println("List is empty, should say true: " + list1.isEmpty());
        System.out.println("List has no elements: " + list1.size());

        list1.add(2);
        list1.add(2);
        list1.add(1, 1);
        list1.add(0, 3);
        list1.add(4, 4);
        list1.add(5);

        System.out.println("The first element of the list is number 3: " + list1.first());
        System.out.println("List has six elements: " + list1.size());
        System.out.println("Which are the following: " + list1.toString());
        System.out.println("List is not empty, should say false: " + list1.isEmpty());
        System.out.println("I want to get the second element from the list, which is 2: " + list1.get(1));
        list1.add(1, 2);
        System.out.println("If we add #2 in the second position of the list, it'd look like this: ");

        Iterator<Integer> iterator3 = list1.iterator();
        while(iterator3.hasNext()){
            Integer i = iterator3.next();
            System.out.println(i);
        }

        System.out.println("Next to 2 is 2: " + list1.next(1) + " | Previous to 2 is 3: " + list1.previous(1));
        list1.set(2,32);
        System.out.println("Now let's change the third element to be #32: " + list1.toString());
        list1.remove(1);
        System.out.println("We will eliminate the second element of the list: " + list1.toString());
        list1.remove(0);
        System.out.println("Now the first: " + list1.toString());
        list1.remove(3);
        System.out.println("Now the last: " + list1.toString());
        list1.clear();
        System.out.println("Let's clear the whole list. Is it empty? " + list1.isEmpty());
        System.out.println("Why can't we visualize the list anymore? " + list1.toString());

        System.out.println("---------------------------------------Beginning of DoubleLinkedList Test---------------------------------------");

        DoubleLinkedList<String> farm = new DoubleLinkedList<>();
        System.out.println("Farm is empty, should say true: " + farm.isEmpty());
        System.out.println("Farm has zero animals: " + farm.size());
        farm.add("cow");
        System.out.println("The first animal in the farm is the cow: " + farm.first());
        farm.add("dog");
        farm.add("sheep");
        farm.add("horse");
        farm.add("Alejandra the rat");

        Iterator<String> iterator2 = farm.iterator();
        while(iterator2.hasNext()){
            String i = iterator2.next();
            System.out.println(i);
        }

        System.out.println("Farm is size 5: " + farm.size());
        System.out.println("Which are the following: " + farm.toString());
        System.out.println("Farm is not empty, should say false: " + farm.isEmpty());
        System.out.println("I want to get the dog (second animal) from the farm: " + farm.get(1));
        System.out.println("Now I want to get Alejandra the rat (last animal) from the farm: " + farm.get(4));
        farm.add(1, "elephant");
        System.out.println("If we add an elephant to the second position in the farm, it'd look like this: " + farm.toString());
        farm.add(4, "pig");
        System.out.println("If we add a pig to the fifth position in the farm, it'd look like this: " + farm.toString());
        System.out.println("We will check that farm is size 7: " + farm.size());
        System.out.println("Next to dog is sheep: " + farm.next(2) + " | Previous to dog is elephant: " + farm.previous(2));
        farm.set(3,"cat");
        System.out.println("I replaced the sheep with a cat: " + farm.toString());
        farm.remove(1);
        System.out.println("We will remove the elephant from the farm: " + farm.toString());
        farm.remove(0);
        System.out.println("Now the cow: " + farm.toString());
        farm.remove(4);
        System.out.println("Now the rat: " + farm.toString());
        farm.remove(2);
        System.out.println("Now the pig: " + farm.toString());
        System.out.println("Farm should be size 3: " + farm.size());
        farm.clear();
        System.out.println("Let's clear the whole farm. Is it empty? " + farm.isEmpty());

    }
}
