package ucr.ac.cr.ecci.ci1221.tests;

import ucr.ac.cr.ecci.ci1221.util.collections.stack.ArrayStack;
import ucr.ac.cr.ecci.ci1221.util.collections.stack.InvertedArrayStack;
import ucr.ac.cr.ecci.ci1221.util.collections.stack.LinkedListStack;


/**
 *
 * Test case for the Stack Collection. Includes Tests for Array Stack, Linked List Stack and Inverted Array Queue.
 * Verifies functions for every single operator.
 *
 * Created by Paola Ortega S on 9/24/2016.
 */
public class MainStack {
    public static void main(String[] args) {
        System.out.println("---------------------------------------Beginning of ArrayStack Test---------------------------------------");
        ArrayStack<Integer> stack1 = new ArrayStack<>();
        System.out.println("Stack is empty, should say true: " + stack1.isEmpty());
        System.out.println("Stack has zero elements: " + stack1.size());
        stack1.push(2);
        stack1.push(3);
        stack1.push(1);
        stack1.push(0);
        stack1.push(2);
        stack1.push(5);
        System.out.println("Stack has six elements: " + stack1.size());
        System.out.println("Stack is not empty, should say false: " + stack1.isEmpty());
        System.out.println("The top of the stack should be 5: " + stack1.peek());
        stack1.pop();
        System.out.println("If we pop one element out of the stack, the top should be 2: " + stack1.peek());
        stack1.clear();
        System.out.println("Let's clear the whole stack. Is it empty? " + stack1.isEmpty());


        System.out.println("---------------------------------------Beginning of InvertedArrayStack Test---------------------------------------");
        InvertedArrayStack<Character> stack2 = new InvertedArrayStack<>();
        System.out.println("Stack is empty, should say true: " + stack2.isEmpty());
        System.out.println("Stack has zero elements: " + stack2.size());
        stack2.push('a');
        stack2.push('b');
        stack2.push('b');
        stack2.push('e');
        stack2.push('c');
        stack2.push('d');
        System.out.println("Stack has six elements: " + stack2.size());
        System.out.println("Stack is not empty, should say false: " + stack2.isEmpty());
        System.out.println("The top of the stack should be 'd': " + stack2.peek());
        stack2.pop();
        System.out.println("If we pop one element out of the stack, the top should be 'c': " + stack2.peek());
        stack2.clear();
        System.out.println("Let's clear the whole stack. Is it empty? " + stack2.isEmpty());

        System.out.println("---------------------------------------Beginning of LinkedListStack Test---------------------------------------");
        LinkedListStack<String> stack3 = new LinkedListStack<>();
        System.out.println("Basket is empty, should say true: " + stack3.isEmpty());
        System.out.println("Basket has zero elements: " + stack3.size());
        stack3.push("Apple");
        stack3.push("Watermelon");
        stack3.push("Lemon");
        stack3.push("Banana");
        stack3.push("Pineapple");
        stack3.push("Orange");
        System.out.println("Basket has six elements: " + stack3.size());
        System.out.println("Basket is not empty, should say false: " + stack3.isEmpty());
        System.out.println("The fruit at the top of the basket is an orange: " + stack3.peek());
        stack3.pop();
        System.out.println("If we pop one fruit out of the list, the pineapple should be at the top: " + stack3.peek());
        stack3.clear();
        System.out.println("Let's clear the whole basket. Is it empty? " + stack3.isEmpty());
    }
}
