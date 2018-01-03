/*
 * Jonathan Wray
 * CSCI310 - HW05 - ListHeirarchy, Part 3
 * 2/19/2017
 */

/**
 *
 * @author jw91482
 * @param <E>
 */

//An optimized doubly linked list. Overrides methods of MyAbstractList.
public class MyLinkedListOp<E> extends MyLinkedList<E> {
    
    //Constructs an empty list.
    public MyLinkedListOp(){

    }
    
    //Constructs a list containing the elements of the array parameter.
    public MyLinkedListOp(E[] eArr){
        for(int i=0; i < eArr.length-1; i++) {
            add(i, eArr[i]);
        }
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
        if(!isEmpty()){
            s += getFirst().toString();
            for(int i = 0; i < size(); i++){            
                 s += ", " + get(i).toString();
            }
        }
        s += "]";
        return s;

        //returns a string representation of this list.
        
        //toString uses (i) - to parse through
        
    }
    
}
