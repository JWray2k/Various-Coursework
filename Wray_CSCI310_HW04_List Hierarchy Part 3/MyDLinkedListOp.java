/*
 * Jonathan Wray
 * CSCI310 - HW05 - ListHeirarchy, Part 3
 * 2/19/2017
 */

/**
 *
 * @author Jwray
 * @param <E>
 */
public class MyDLinkedListOp<E> extends MyDLinkedList<E> {
    
    //Constructs and empty list.
    public MyDLinkedListOp(){
        
    }
    
    //Constructs a new list containing the elements in the array parameter.
    public MyDLinkedListOp(E[] eArr){
        
        for(int i=0; i < eArr.length-1; i++) {
            add(i, eArr[i]);
        }
    }
    
    @Override
    public E getLast() throws IllegalStateException{
        if (size() <= 0){ //double check this size
            String message = "The element does not exsist ";
            throw new IndexOutOfBoundsException(message);
        }
        return tail.data;
        
    }
    
    @Override
    //Removes all list elements, if any exist
    public void clear(){
        head = tail = null;
        size = 0;
    }
    
    @Override
    //Returns a string containing each element in this list, separated by commas, enclosed in square brackets
    public java.lang.String toString(){
        String s = "[";
        if(!isEmpty()){ //I realize this is still n^2 - I'll try to fix it in the AM
            s += getFirst().toString();
            for(int i = 0; i < size(); i++){            
                 s += ", " + get(i).toString();
            }
        }
        s += "]";
        return s;
}
    
}
