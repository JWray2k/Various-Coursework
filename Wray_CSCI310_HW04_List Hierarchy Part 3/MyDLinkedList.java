/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jwray
 * @param <E>
 */
public class MyDLinkedList<E> extends MyAbstractList<E> {
    
    //Reference to the first element in this list. Null if the list is empty.
    protected DNode<E> head = null;
    
    //Reference to the last element in this list. Null if the list is empty.
    protected DNode<E> tail = null;
    
    //Tempororary SNode<E> reference
    protected DNode<E> temp = null;
    
    //Current SNode<E> reference
    protected DNode<E> current = null;
    
    //Reference to next SNode<E>
    protected DNode<E> next = null;
    
    //Reference to next SNode<E>
    protected DNode<E> prev = null;
    
    //Constructs and empty list.
    public MyDLinkedList(){
        
    }
    
    //Constructs a new list containing the elements in the array parameter.
    public MyDLinkedList(E[] eArr){
        
        //use a difference reference of different types
        for(int i=0; i < eArr.length-1; i++) {
            add(i, eArr[i]);
        }
    }


    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        if(i < 0 || i >= size()){
            String message = "The element does not exsist ";
            throw new IndexOutOfBoundsException(message);
        }
        current = head;
        if( i < size( ) ){
            current = head.next;
            for( int j = 0; j < i; j++ ){
                current = current.next;
                return current.data;
            }
        }
        return head.data;
    }

    
    @Override
    public final void add(int i, E e) throws IndexOutOfBoundsException {
        if (i < 0 || i > size()){ //double check this size
            String message = "The element does not exsist ";
            throw new IndexOutOfBoundsException(message);
        }
        current = head;
        
        //if list isEmpty(), do same stuff as addFirst...
        if(isEmpty()){
            addFirst(e);           
        }else if(i==0){
            temp = new DNode(e, null, head);
            tail = head;
            head = temp;
            size++;
        }else if(i==size){
            addLast(e);     
//      code prior to using addLast() method:
//            current = tail;
//            temp.data = e;
//            temp.next = null;
//            tail = temp;
//            current.next = tail;
        }else{
            temp = new DNode(e, null, null); //if list is empty (do same stuff as addFirst)
            //current = head; //part of SNode
            for(int j = 0; j < i-1; j++){
                prev.next = temp;
                current.prev = temp;
                temp.prev = prev;
                temp.next = current;
                //current = current.next; //was part of SNode
            }
//            temp.next = current.next; //part of SNode
//            current.next = temp; //part of SNode
            size++;
        }  
    }

    
    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size()){ //double check this size
            String message = "The element does not exsist ";
            throw new IndexOutOfBoundsException(message);
        }
        current = head;
        for(int j = 0; j < i; j++){
            current = current.next;
        }
        temp = current;
        current.data = e;
        
        //return element that was previously stored at the given index position
        return temp.data;
    }

    
    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size()){ //double check this size
            String message = "The element does not exsist ";
            throw new IndexOutOfBoundsException(message);
        }
        
        current = head;
        
        if(i == 0){
            head = current.next;
            prev = current.next;
        }
        

        for(int j = 0; j < i; j++){
            prev = current;
            current = current.next;
        }

        
        temp = current;
        prev = current;
        current.next = current.next.next;
        
        size--;
        return temp.next.data;
    }
    
    @Override
    public void addFirst(E e){
        temp = new DNode(e, null, null);
        head.prev = temp;
        temp.next = head;
        head = temp;
        size++;
    }
    
    @Override
    public void addLast(E data){
        if(isEmpty()){
            tail = new DNode(data, null, null);
            head = tail;
        }else{
            tail.next = new DNode(data, tail, null);
            tail = tail.next;
        }
        size++;
    }
    
    //Returns the index of the first occurrence of the speicied element, -1 if the element is not in this list
    @Override
    public int firstIndexOf(E e){ //e is the element being searched for.
        current = head;
        int index = 0;
        while(current.next!=null){
            if(current.data == e){
            return index; //index of the first occurrence of the specified element
            }
            else{
                current = current.next;
                index++;
            }
        }
        return -1;
        //things in here can be Integer, String, Boolean, Character... (not primitives like int, char, float..)
    }

    
    //Returns the index of the last occurrence of the specified element, -1 if the element is not in this list not found.
    @Override
    public int lastIndexOf(E e){
        int lastSeenAt = -1;
        current = head;
        int index = 0;
        while(current!=null){
            if(current.data == e){
                lastSeenAt = index;
            }
            index++;
            current = current.next;
        }
        return lastSeenAt; //could stil be -1
    }
    
}

class DNode<E>{

    public DNode( E d, DNode<E> p, DNode<E> n ){ 
        data = d; 
        prev = p;
        next = n; 
    }

    public E data;
    public DNode<E> prev;
    public DNode<E> next;
}
