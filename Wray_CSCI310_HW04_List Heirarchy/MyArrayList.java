/*
 * Jonathan Wray
 * CSCI310 - HW04 - ListHeirarchy, Part 1
 * 2/15/2017
 */

/**
Concrete class MyArrayList
 MyArrayList()
 MyArrayList(E[] eArr)
 add(int i, E e)
 capacity()
 ensureCapacity(int newCap)
 get(int i)
 remove(int i)
 set(int i, E e)
 trimToSize()
 * @param <E>
 */

//Array based list. Implements those methods not implemented in MyAbstractList.
public class MyArrayList<E> extends MyAbstractList<E> {
    protected E[] arr; //Array to hold the list elements.
    public static final int INITIAL_CAPACITY = 4; //initial capacity of the list
    
    
    //Constructs an empty array-based list with capacity set to the INITIAL_CAPACITY.
    public MyArrayList(){
        arr = (E[]) new Object[INITIAL_CAPACITY];
    }
    
    //Constructs an array-based list containing the elements in the specified array.
    public MyArrayList(E[] eArr){
        arr = (E[]) new Object[eArr.length];
        
        for(E r:eArr){
            this.add(r);
        }
    }
    
    @Override
    //Adds the given element at the given index position i.
    public void add(int i, E e) throws IndexOutOfBoundsException{
        
        //throw an exception if the number isn't valid
        if (i < 0 || i > this.size()-1){
        String message = "The index does not exist ";
        throw new IndexOutOfBoundsException(message);
        }
        
        if(this.size() == this.capacity()){
            // Double the size of the array
            E[] temp = (E[]) new Object[this.capacity()*2];
            System.arraycopy(arr, 0, temp, 0, this.capacity());
            arr = temp;
        }
        //Copy the First part of the array before the given index + add single space for capacity.
        E[] tempFront = (E[]) new Object[arr.length+1];
        System.arraycopy(arr, 0, tempFront, 0, i); //only copy to the index of i
        tempFront[i] = e; //copy new element to index of i
        
        //create the second part of the array - past the index of i
        E[] tempEnd = (E[]) new Object[this.capacity()-i];
        System.arraycopy(arr, i, tempEnd, 0, tempEnd.length);
        System.arraycopy(tempEnd, 0, tempFront, i, tempEnd.length); //add two parts together
        arr = tempFront;
        size++;
            
    }
    
    //Returns the capacity of this list.
    public int capacity(){
        return arr.length;
    }

    //Increases the capacity of this ArrayList instance, if necessary, to ensure that 
    //it can hold at least the number of elements specified by the minimum capacity argument.
    public void ensureCapacity(int newCap){
        if(capacity() < newCap){ //only increases capacity if the newCapacity is larger than what's available
            E[] temp = (E[]) new Object[newCap]; //store a temp array with a size of newCapacity
            System.arraycopy(arr, 0, temp, 0, this.size()); //copy over old array
            arr = temp; //set temp as names array
        }
    }
    
    //Returns the index of the first occurrence of the specified element, -1 if the element is not in this list
    @Override //not sure that needs to be here...
    public int 	firstIndexOf(E e){
        return super.firstIndexOf(e);
    }
    
    //Returns the element at the given index position.
//    @Override
//    public E get(int i) throws IndexOutOfBoundsException {
//        if(i < 0 || i > this.size() - 1){
//            // we have a problem
//            String message = "index " + i +" not valid";
//            throw new IndexOutOfBoundsException(message);
//        }
//        
//        return arr[i];
//    }
    
    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= this.size()-1){
            String message = "The element does not exsist ";
            throw new IndexOutOfBoundsException(message);
    }
        
    return arr[i]; 
    }
    
    //Returns the index of the last occurrence of the specified element, -1 if the element is not in this list not found.
    @Override //not sure if I need override...
    public int lastIndexOf(E e){
        return super.lastIndexOf(e);
    }

    @Override
    //Replaces the element at the given index position with the given element and returns the old element.
    public E set(int i, E e) throws IndexOutOfBoundsException {
        if(i < 0 || i > this.size() - 1){
            // we have a problem
            String message = "index " + i +" not valid";
            throw new IndexOutOfBoundsException(message);
        }
        E temp = arr[i];
        arr[i] = e;
        return temp;
    }

    
    @Override
    //Removes and returns the element at the specified index position in the list.
    public E remove(int i) throws IndexOutOfBoundsException {
        if(i < 0 || i > this.size() - 1){
            // we have a problem
            String message = "index " + i +" not valid";
            throw new IndexOutOfBoundsException(message);
        }
        
        E removedItem = this.get(i); // save item to return
        
        // now adjust the array
        if(i < size - 1){
            System.arraycopy(arr, i+1, arr, i, size-i-1);
        }
        size--;
        
        return removedItem;
    }
    
    //Trims the capacity of this list to be the list's current size.
    public void trimToSize(){
        E[] temp = (E[]) new Object[this.size()];
        System.arraycopy(arr, 0, arr, 0, this.size());
        arr = temp;
    }
    
}
