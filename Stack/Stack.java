package Stack;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.EmptyStackException;

public class Stack {
    private LinkedList<Integer> stack = new LinkedList<Integer>();

    /**
     * Determines if stack is empty
     * 
     * @returns boolean: stack is empty
     */
    public boolean isEmpty() {
        try {
            stack.getFirst();
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    /**
     * Adds an integer to the top of the stack
     * 
     * @params integer: to add to top of stack
     */
    public boolean push(int toPush) {
        stack.addLast(toPush);
        return true;
    }

    /**
     * Removes an element from the top of the stack and returns it
     * 
     * @returns integer: removed from top of stack
     */
    public int pop() {
        try {
            return stack.removeLast();
        } catch (NoSuchElementException e) {
            throw new EmptyStackException();
        }
    }

    /**
     * Returns an element from the top of the stack
     * 
     * @returns integer: top of stack
     */
    public int peek() {
        try {
            return stack.getLast();
        } catch (NoSuchElementException e) {
            throw new EmptyStackException();
        }
    }
}