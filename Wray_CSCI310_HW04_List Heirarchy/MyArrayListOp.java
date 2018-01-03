/*
 * Jonathan Wray
 * CSCI310 - HW04 - ListHeirarchy, Part 1
 * 2/15/2017
 */

/**
 Concrete class MyArrayListOp
 MyArrayListOp()
 MyArrayListOp(E[] eArr)
 clear()
 firstIndexOf(E e)
 lastIndexOf(E e)
 removeLast()
 * @param <E>
 */
public class MyArrayListOp<E> extends MyArrayList<E>{
    
    //Constructs an empty array-based list with capacity set to the INITIAL_CAPACITY.
    public MyArrayListOp(){
        arr = (E[]) new Object[INITIAL_CAPACITY];
    }
    
    //Constructs an array-based list containing the elements in the specified array. 
    //If the array argument is non-empty, the capacity of this list is set to the list's size. 
    //However, if the array argument is empty, the capacity of this list is set to the INITIAL_CAPACITY.
    public MyArrayListOp(E[] eArr){
         arr = (E[]) new Object[eArr.length];
        
        for(E r:eArr){
            this.add(r);
        }
    }
    
    
    @Override
    public void clear() {
        arr = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;

        }
    
    @Override
    public E removeLast(){
        if(this.size == 0){
            return null;
        }
        return remove(this.size() - 1);
    }
    
    
}
