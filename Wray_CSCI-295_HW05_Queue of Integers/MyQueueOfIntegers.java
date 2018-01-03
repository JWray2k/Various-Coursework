/*
 * Jonathan Wray
 * CSCI295 - HW05 - Queue of Integers
 * 9/18/2016
 */

//Below are the methods which must find their way into my Queue class

/**
 * Interface for a queue of Integers: a collection of Integers that are inserted
 * and removed according to the first-in first-out principle.
 *
 */
public interface MyQueueOfIntegers {

    /** 
     * Returns the number of elements in the queue.
     * @return number of elements in the queue.
     */
    public int size();

    /** 
     * Returns true if this queue is empty, false otherwise.
     * @return true if this queue is empty, false otherwise.
     */
    public boolean isEmpty();

    /**
     * Returns (but does not remove) the element at the front of this queue.
     * Returns null if this queue is empty.
     * @return element at the front of the queue, or null if the queue is empty.
     */
    public Integer front();

    /** 
     * Add the given element at the rear of the queue.
     * @param element new element to be added to this queue.
     */
    public void enqueue(Integer element);

    /** 
     * Removes and returns the element at the front of this queue. Returns null
     * if this queue is empty.
     * @return element at the front of the queue, or null if the queue is empty.
     */
    public Integer dequeue();

    /**
     * Returns a string showing all elements in this queue. The String should
     * show the elements in the queue, each separated by a comma and a space.
     * There should be square brackets around the queue elements. The front of
     * the queue should be on the left and the rear on the right. The string
     * "Front " should be to the left and the string " Rear" to the right. For
     * example, if 11 were enqueued first, followed by 22, then the toString
     * method should return the string "Front [11, 22] Rear".
     * @return a string showing all elements in this queue.
     */
    @Override
    String toString();
}

