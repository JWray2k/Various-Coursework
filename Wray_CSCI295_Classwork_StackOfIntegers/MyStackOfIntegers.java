public interface MyStackOfIntegers {
    
    /**
     * Adds the given element to the top of the stack.
     * @param element the element to be added to the stack.
     */
    void push(int element);
    
    /**
     * Returns and removes the element at the top of the stack.
     * @return element at the top of the stack.
     */
    int pop();
    
    
    /**
     * Returns the element at the top of the stack.
     * @return element at the top of the stack.
     */
    int top();
    
    /**
     * Returns true if this stack is empty, returns false otherwise.
     * @return true if this stack is empty, returns false otherwise
     */
    boolean isEmpty();
    
    /**
     * Returns the number of elements in this stack.
     * @return the number of elements in this stack.
     */    int size();
    
    /**
     * Returns a string showing all elements in this stack. The top of stack
     * is shown.
     * @return a string showing all elements in this stack.
     */
    @Override
    String toString();
    
    
}