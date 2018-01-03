
import java.util.EmptyStackException;

/*
 * Jonathan Wray
 * CSCI310 - HW 05 - Balanced Symbols
 * 2/23/2017
 */

/**
 * A generic stack that uses a linked data type
 * @author jw91482
 * @param <E>
 */
public class LinkedStack<E> implements MyStack<E> {
    
    //Reference to the node on the top of the stack. Null if the stack is empty.
    protected SNode<E> head = null;
    
    //Tempororary SNode<E> reference
    protected SNode<E> temp = null;
    
    //Number of elements currently in this stack.
    protected int size;
    
    //Constructs a new LinkedStack that has a null head and size of zero.
    public LinkedStack(){
        size = 0;
    }


    //Adds the given element to the top of the stack.
    @Override
    public void push(E e) {
        temp = new SNode(e, null);
 
        if(isEmpty()){
            head = temp;
        }
        else{
            temp.next = head;
            head = temp;
        }
        size = size+1;
    }

    
    //Removes and returns the element on the top of the stack.
    @Override
    public E pop() throws EmptyStackException {
        if (head == null){
            throw new EmptyStackException();
        }
        //check for empty stack
        temp = head;
        E returnValue = head.data;
        head = head.next;
        size = size-1;
        return returnValue;
        
//        E temp = arr[size()-1];
//        size--;
//        return temp;
        //return L.removeLast;
    }

    
    //Returns, but does not remove, the element at the top of the stack.
    @Override
    public E top() throws EmptyStackException {
        if (head == null){
            throw new EmptyStackException();
        }
        return head.data;
    }
    
    //Returns the number of elements in this stack.
    @Override
    public int size() {
        return size;
    }
   

    //Returns true if this stack is empty, returns false otherwise. This method may not use the size() method or a size variable
    @Override
    public boolean isEmpty() {
        if(head == null){ //== is already a binary check... this is redundant because of that
            return true;
        }
        return false;
    }

    
    
    //Returns a string containing each element in this stack, separated by commas, enclosed in square brackets, with TOS indicated. 
    //The top of the stack is shown to the left and indicated with "TOS" plus a single space. For example: "TOS [3, 2, 1]"
//    @Override
//    public String toString(){
//        String s = "TOS [";
//            for(int i = 0; i < size(); i++){            
//                 s += pop().toString() + ", ";
//            }
//        s += "]";
//        return s;
//    }
    
    @Override
    public String toString(){
        SNode <E> current = head;
        String s ="TOS [";
        if(isEmpty()){
            return "TOS []";
        }
        for (int i = 0; i < size; i++){
            if (current.data != null){
                s += current.data;
                }
            if (i < size-1){
                s += ", ";
            }
            current = current.next;
        }
        s += "]";
        return s; 
    
    }
    
    
    private static class SNode<E>{

    public SNode( E d, SNode<E> n ){ 
        data = d; 
        next = n; 
    }

    public E data;
    public SNode<E> next;
}
    
}

        //ensure capacity
//        arr[size] = e; //addLast
//        size++;
        
        
        //L.add(e)
//        if(head == null){
//            head.data = e; 
//            head.next = null;
//        }
//        else{
//            head.next.data = e;
//            next = head;
//                }
