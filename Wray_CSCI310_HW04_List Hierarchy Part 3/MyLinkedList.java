/*
 * Jonathan Wray
 * CSCI310 - HW05 - ListHeirarchy, Part 2
 * 2/17/2017
 */

/**
 *
 * @author jw91482
 * @param <E>
 */
public class MyLinkedList<E> extends MyAbstractList<E>{
    
    //Reference to the first element in this list. Null if the list is empty.
    protected SNode<E> head = null;
    
    //Reference to the last element in this list. Null if the list is empty.
    protected SNode<E> tail = null;
    
    //Tempororary SNode<E> reference
    protected SNode<E> temp = null;
    
    //Current SNode<E> reference
    protected SNode<E> current = null;
    
    //Reference to next SNode<E>
    protected SNode<E> next = null;
    
    
    //Constructs an empty list
    public MyLinkedList(){
        head = new SNode(null, null);
        tail = new SNode(null, null);
    }
    
    //Constructs a new list containing the elements in the array parameter
    public MyLinkedList(E[] eArr){

        //use a difference reference of different types
        for(int i=0; i < eArr.length-1; i++) {
            add(i, eArr[i]);
        }
    }

    //Returns the element at the given index position.
    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size()){ //double check this size
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
    
//There is infinite recursion: getFirst() calls get(0), and get(0) calls getFirst().
//The optimized toString method is still O(n^2) instead of O(n).
    
    //Adds the given element at the given index position i.
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
            temp = new SNode(e, head);
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
            temp = new SNode(e, null); //if list is empty (do same stuff as addFirst)
            current = head;
            for(int j = 0; j < i-1; j++){
                current = current.next; //making current and a head
            }
            temp.next = current.next;
            current.next = temp;
            size++;
        }     
    }


    //Removes and returns the element at the specified index position in the list
    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size()){ //double check this size
            String message = "The element does not exsist ";
            throw new IndexOutOfBoundsException(message);
        }
        
        current = head;
        
        if(i == 0){
            head = current.next;
        }
        

        for(int j = 0; j < i; j++){
            current = current.next;
        }

        
        temp = current;
        current.next = current.next.next;
        
        size--;
        return temp.next.data;
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

    
//    For the add method:
//    If isEmpty: //maybe not a method that should be overwritten..
    @Override
    public void addFirst(E e){
        temp = new SNode(e, head);
        head = temp;
        head.next = current;
        size++;
    }
    


    @Override
    public void addLast(E data){
        if(isEmpty()){
            tail = new SNode(data, null);
            head = tail;
        }else{
            tail.next = new SNode(data, null);
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
    
    //additional helper method Dr. Lillis gave us in class
    public SNode<E> move(int i){
        current = head;
        for(int j = i; j < i; j++){
            current = current.next;
        }
        return current;
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

//    public void add(int i, E data){
//        
//    
//        temp = new SNode(data, null); //if list is empty (do same stuff as addFirst)
//        current = head;
//        for(int j = 0; j < i-1; j++){
//            current = current.next; //making current and a head
//        }
//        temp.next = current.next;
//        current.next = temp;
//    }
    
    //if i = 0 //addFirst()
    //Temp = new SNode(data, null);
    //Temp.next = head;
    //current = temp;
    //Data structure contains the node - each node is responsible for which node comes next
    
    
    

//            Move current to right spot
//            add(E e){
//                add(size,e);
//            }
//            addFirst(E e){
//                add(0,e);
//            }
//            addLast(E e){
//                add(size, e);
//            }
    


//    Notes:    
//    if i = 0 //addFirst
//    temp = new SNode(data);
//    temp.next = head;
//    current = temp;
//    
//    Data structure contains the node - each node is responsible for which node comes next
    
//        SNode<E>;
//        Protected E data;
//        Protected SNode<E> data;
//        SNode.data (E data){
//            this.data = data;
//            next = null;
//        }else{
//        SNode<E> temp = new SNode(data);
//        temp.next = head;
//        head = temp;
//}

        //SNode<E> current = head;
//        SNode<E> current = get(i);
//        E oldVal = current.data;
//        current.data = e;
//        return oldVal;
//    current = head;
//    current = current.next
//    temp.next = current.next
//    current.next = temp
//    current.next = head
//    current.next = current.next.next

        //Notes:
//        E temp = get(size()-1);
//        set(size()-1, null);
//        size--;
//        return temp;  

//    Notes:
//    SNode<E>
//    Protected E data
//    Protected SNode <E> data
//    SNode(E data){
//        this.data = data;
//        next = null;
//    else
//    SNode temp = new SNode(data);
//    Temp.next = Head;
//    Head = Temp;
//    
//    SNodes have piece of data called next (always)

    