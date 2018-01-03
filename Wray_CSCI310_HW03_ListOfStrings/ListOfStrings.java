/*
 * Jonathan Wray
 * CSCI310 - HW03 - ListOfStrings
 * 2/9/2017
 */


public class ListOfStrings {
    public static final int DEFAULT_CAPACITY = 4;
    private String[] names;
    private int size = 0;
    
    public ListOfStrings(){
        this(DEFAULT_CAPACITY);
    }
    
    public ListOfStrings(int initialCapacity){
        names = new String[initialCapacity];
    }
    
    public int getCapacity(){
        return names.length;
    }
    
    public int getSize(){
        return size;
    }
    
    
    // Adds name to the end of the list
    public void add(String name){
        if(this.getSize() == this.getCapacity()){
            // Double the size of the array
            String[] temp = new String[this.getCapacity()*2];
            System.arraycopy(names, 0, temp, 0, this.getCapacity());
            names = temp;
        }
        names[size] = name;
        size++;
    }
    
    
    // set item i to the given name
    public void set(int i, String name){
        if(i < 0 || i > this.getSize() - 1){
            // we have a problem
            String message = "index " + i +" not valid";
            throw new IndexOutOfBoundsException(message);
        }
        
        names[i] = name;
    }
    
    
    // returns the item at index i
    public String get(int i){
        if(i < 0 || i > this.getSize() - 1){
            // we have a problem
            String message = "index " + i +" not valid";
            throw new IndexOutOfBoundsException(message);
        }
        
        return names[i];
    }
    
    
    // removes and returns item i from the list
    public String remove(int i){
        if(i < 0 || i > this.getSize() - 1){
            // we have a problem
            String message = "index " + i +" not valid";
            throw new IndexOutOfBoundsException(message);
        }
        
        String removedItem = this.get(i); // save item to return
        
        // now adjust the array
        if(i < size - 1){
            System.arraycopy(names, i+1, names, i, size-i-1);
        }
        size--;
        
        return removedItem;
    }
    
    
    //Removes and returns the first string in the list. If the list is empty, null is returned
    public String removeFirst(){
        
        if(this.getSize() < 0){ //altered the remove code to look at just the first element
            // we have a problem
            String message = "String is empty";
            throw new IndexOutOfBoundsException(message);
        }
        
        String removedFirst = this.get(0); //saves the first item to return statement
        
        // now adjust the array
        if(0 < size - 1){ //instead of using i, we look at just the first element in the array
            System.arraycopy(names, 1, names, 0, size-1);
        }
        size--; //size is a counter... It's not actually deleting the array - it's just enabling us
        //do an array copy as we go through.
        
        return removedFirst; //returns the First element removed from the array.
    }
        
    
    //Removes and returns the last string in the list. If the list is empty, null is returned.
    public String removeLast(){
        
        if(this.getSize() < 0){ //altered the remove code to look at just the first element
        // we have a problem
         String message = "String is empty";
        throw new IndexOutOfBoundsException(message);
        }
        
        String removedLast = this.get(size-1);
        
        // now adjust the array
        if(0 < size - 1){ //instead of using i, we look at just the first element in the array
            System.arraycopy(names, 0, names, 0, size);
        }
        size--; //size is a counter... It's not actually deleting the array - it's just enabling us
        //do an array copy as we go through.
        
        return removedLast; //returns the Last element removed from the array.
    }
    
    
    //Removes all unused array elements from the end of the array, if any exist. 
    //After calling this method the size and the capacity of the list should be the same.
    public void compress(){
        
        if(getCapacity() > size){ //we need to check if the capacity is greater than size
            String[] temp = new String[size]; //create a temp array with a capacity = size
            System.arraycopy(names, 0, temp, 0, size); //copy all the names elements into temp array
            names = temp; //set the names array = new temp array with capacity = elements in it
        }
    }
    
    
    //Increases the capacity, if needed, to the new specified capacity. This may mean making a new, larger, array.
    public void ensureCapacity(int newCapacity){
        if(getCapacity() < newCapacity){ //only increases capacity if the newCapacity is larger than what's available
            String[] temp = new String[newCapacity]; //store a temp array with a size of newCapacity
            System.arraycopy(names, 0, temp, 0, size); //copy over old array
            names = temp; //set temp as names array
        }
    }
    //
    
    
    //Returns the index of the first occurrence of the specified string. If the string is not in the list, returns -1.
    public int getIndex(String s){
        int answer = -1;
        
        if(this.getSize() < 0){ //altered the remove code to look at just the first element
        // we have a problem
        String message = "String is empty";
        throw new IndexOutOfBoundsException(message);
        }
                
        for(int i = 0; i < size; i++){
            String temp = get(i); //pull the string value of the index
            if (temp == null ? s == null : temp.equals(s)){ //compare the string of the array to the temp
                answer = i; //set my return statement equal to i
            }
            if (answer == i){
                break; //I need to break the for loop on the first occurance of i matching s.
            }
        }
        return answer; //returns either the matching index or -1.
    }
    
    
    //Removes and returns the first occurrence of the specified string. If the string is not in the list, returns null.
    public String remove(String s){
        int answer = -1;
        
        if(this.getSize() < 0){ //altered the remove code to look at just the first element
        // we have a problem
        String message = "String is empty";
        throw new IndexOutOfBoundsException(message);
        }
                
        for(int i = 0; i < size; i++){
            String temp = get(i); //pull the string value of the index
            if (temp == null ? s == null : temp.equals(s)){ //compare the string of the array to the temp
                answer = i; //set my return statement equal to i
            }
            if (answer == i){
                break; //I need to break the for loop on the first occurance of i matching s.
            }
        }
        if (answer > -1){ //if answer has been marked > 1 - we'll call the remove method.
            remove(answer); //remove method based on the index of answer
            return names[answer]; //string that was removed
        } else {
            return null; //if nothing removed - we'll return null
        }
    }
                    
    
    //Removes all strings from the list and sets the capacity to the default capacity.
    public void clear(){
        String[] temp = new String[DEFAULT_CAPACITY];
        names = temp;
        size = 0;
    }
    


    @Override
    public String toString(){
        String s = "";
        s += "[";
        boolean first = true;
        for(int i = 0; i < size; i++){
            if(first){
                s += names[i];
                first = false;
            } else {
                s += ", ";
                s += names[i];
            }
        }
        s += "]";
        
        return s;
    }
    


}