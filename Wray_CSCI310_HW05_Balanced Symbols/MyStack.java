
import java.util.EmptyStackException;

/*
 * Jonathan Wray
 * CSCI310 - HW 05 - Balanced Symbols
 * 2/23/2017
 */

/**
 *
 * @author Jonathan Wray
 * @param <E>
 */
public interface MyStack<E> {
    



    /**
     * Removes and returns the element on the top of the stack.
     * @return element stored on the top of the stack
     * Throws: EmptyStackException - if the stack is empty
     */
    public E pop() throws EmptyStackException;
    
    /**
     * Adds the given element to the top of the stack.
     * Type E
     * Parameters: e - element to be added at to the stack
     * @param e
     */
    public void push(E e);
    
    /**
     * Returns, but does not remove, the element at the top of the stack.
     * @return element stored on the top of the stack
     * Throws: EmptyStackException - if the stack is empty
     * 
     */
    public E top() throws EmptyStackException;
    
    
    
    /**
     * Returns true if this list is empty, returns false otherwise.
     * This method may not use the size() method or a size variable.
     * @return true if this list is empty, returns false otherwise
     */
    public boolean isEmpty();
    
    
    /**
     * Returns the number of elements in this stack.
     *
     * @return number of elements in this stack.
     */
    public int size();


    /**
     * Returns a string containing each element in this stack, separated by commas, 
     * enclosed in square brackets, with TOS indicated.
     * The top of the stack is shown to the left and indicated with "TOS" plus a single space. For example: "TOS [3, 2, 1]"
     * Overrides: toString in class java.lang.Object
     * @return a string representation of this stack with TOS indicated.
     */
    @Override
    public String toString();
}

