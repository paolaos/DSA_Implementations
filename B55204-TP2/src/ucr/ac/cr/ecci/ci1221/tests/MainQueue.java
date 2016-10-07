package ucr.ac.cr.ecci.ci1221.tests;

import ucr.ac.cr.ecci.ci1221.util.collections.queue.CircularArrayQueue;
import ucr.ac.cr.ecci.ci1221.util.collections.queue.ArrayQueue;
import ucr.ac.cr.ecci.ci1221.util.collections.queue.LinkedListQueue;

/**
 *
 * Test case for the Queue Collection. Includes Tests for Array Queue, Linked List Queue and Circular Array Queue.
 * Verifies functions for every single operator.
 *
 * Created by Paola Ortega S on 9/26/2016.
 */
public class MainQueue {
    public static void main(String[] args) {
        System.out.println("---------------------------------------Beginning of ArrayQueue Test---------------------------------------");
        ArrayQueue<Integer> queue1 = new ArrayQueue<>();
        System.out.println("Queue is empty, should say true: " + queue1.isEmpty());
        System.out.println("Queue has zero elements: " + queue1.size());
        queue1.enqueue(8);
        queue1.enqueue(3);
        queue1.enqueue(1);
        queue1.enqueue(0);
        queue1.enqueue(2);
        queue1.enqueue(5);
        System.out.println("Queue has six elements: " + queue1.size());
        System.out.println("Queue is not empty, should say false: " + queue1.isEmpty());
        System.out.println("The top of the queue should be 8: " + queue1.peek());
        queue1.dequeue();
        System.out.println("If we dequeue one element out of the stack, the top should be 3: " + queue1.peek());
        queue1.clear();
        System.out.println("Let's clear the whole queue. Is it empty? " + queue1.isEmpty());

        System.out.println("---------------------------------------Beginning of LinkedListQueue Test---------------------------------------");
        LinkedListQueue<Character> queue2 = new LinkedListQueue<>();
        System.out.println("Queue is empty, should say true: " + queue2.isEmpty());
        System.out.println("Queue has zero elements: " + queue2.size());
        queue2.enqueue('a');
        queue2.enqueue('b');
        queue2.enqueue('b');
        queue2.enqueue('e');
        queue2.enqueue('c');
        queue2.enqueue('d');
        System.out.println("Queue has six elements: " + queue2.size());
        System.out.println("Queue is not empty, should say false: " + queue2.isEmpty());
        System.out.println("The top of the queue should be 'a': " + queue2.peek());
        queue2.dequeue();
        System.out.println("If we dequeue one element out of the queue, the top should be 'b': " + queue2.peek());
        queue2.clear();
        System.out.println("Let's clear the whole queue. Is it empty? " + queue2.isEmpty());

        System.out.println("---------------------------------------Beginning of CircularArrayQueue Test---------------------------------------");
        CircularArrayQueue<String> queue3 = new CircularArrayQueue<>();
        System.out.println("Basket is empty, should say true: " + queue3.isEmpty());
        System.out.println("Basket has zero elements: " + queue3.size());
        queue3.enqueue("Apple");
        queue3.enqueue("Watermelon");
        queue3.enqueue("Lemon");
        queue3.enqueue("Banana");
        queue3.enqueue("Pineapple");
        queue3.enqueue("Orange");
        System.out.println("Basket has six elements: " + queue3.size());
        System.out.println("Basket is not empty, should say false: " + queue3.isEmpty());
        System.out.println("The fruit at the top of the basket is an apple: " + queue3.peek());
        queue3.dequeue();
        System.out.println("If we pop one fruit out of the list, the watermelon should be at the top: " + queue3.peek());
        queue3.clear();
        System.out.println("Let's clear the whole basket. Is it empty? " + queue3.isEmpty());

    }
}
