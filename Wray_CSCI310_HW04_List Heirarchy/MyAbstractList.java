/*
 * Jonathan Wray
 * CSCI310 - HW04 - ListHeirarchy, Part 1
 * 2/15/2017
 */

/**
Abstract class MyAbstractList
 add(E e)
 addFirst(E e)
 addLast(E e)
 clear()
 contains(E e)
 firstIndexOf(E e)
 getFirst()
 getLast()
 isEmpty()
 lastIndexOf(E e)
 removeFirst()
 removeLast()
 setFirst(E e)
 setLast(E e)
 size()
 toString()
 * @param <E>
 */

public abstract class MyAbstractList<E> implements MyList<E> {
    protected int size;
    
    @Override
    //Adds the given element to the end of this list.
    public void add(E e){
        add((size()-1), e);
        size++;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public E getFirst() throws IllegalStateException {
        //throw an exeption for an empty list
        if (size <= 0){
        String message = "The list is empty ";
        throw new IndexOutOfBoundsException(message);
        }
        
        return get(0);
    }

    @Override
    public E getLast() throws IllegalStateException {
        //throw an exception for an empty list
        if (size <= 0){
        String message = "The list is empty ";
        throw new IndexOutOfBoundsException(message);
        }
        
        return get(size()-1);
    }

//    @Override
//    public Object get(int i) throws IndexOutOfBoundsException {
//        return get(i);
//    }


    @Override
    public void addFirst(E e) {
        add(0, e);
    }

    @Override
    public void addLast(E e) {
        add((size()-1), e);
    }


    @Override
    public E setFirst(E e) throws IllegalStateException {
        return set(0,e);
    }

    @Override
    public E setLast(E e) throws IllegalStateException {
        return set(size()-1, e);
    }

//    @Override
//    public E set(int i, E e) throws IndexOutOfBoundsException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public E removeFirst() throws IllegalStateException {
        return remove(0);
    }

    @Override
    public E removeLast() throws IllegalStateException {
        return remove(size()-1);
    }

//    @Override
//    public E remove(int i) throws IndexOutOfBoundsException {
//        return remove(i);
//    }

    @Override
    public void clear() {
        while(!isEmpty()){
            removeLast();
        }
        size = 0;
    }

    @Override
    public boolean contains(E e) {
        if(size()==0){
            return false;
        }
        for(int i = 0; i < size()-1; i++){
            if(get(i).equals(e)){
                return true;
            }    
        }
        return false;
    }
    
   

    @Override
    public int firstIndexOf(E e) {
        if(size()==0){
            return -1;
        }
        for(int i = 0; i<size()-1; i++){
            if(get(i).equals(e)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        if(size()==0){
            return -1;
        }
        for(int i = size()-1; i<=0; i++){
            if(get(i).equals(e)){
                return i;
            }
        }
        return -1;
    }
    
}
