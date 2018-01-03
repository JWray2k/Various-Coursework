/*
 * Jonathan Wray
 * CSCI295 - HW05 - Queue of Integers
 * 9/18/2016
 */

/*
 * HW 05 - Queue of Integers

In class we developed an interface for a stack of integers along with a class that 
implemented the interface and a tester program to test the class. For this assignment 
I am providing you with an interface for a queue of integers and a tester. 
You are to write a class that implements the interface provided. 
The details for each method are contained in the JavaDoc comments written in the interface. 
The tester provided is only intended to help you see how your class is working. 
I will likely use a different program when grading the homework.
 */

import java.util.ArrayList;

public class QueueOfIntegers implements MyQueueOfIntegers{
    ArrayList<Integer> list;
    //I'm not allowed to import the built-in queue class - Can I make it a method?
    //I need to decided if it's a method or class that I need from queue.
    public QueueOfIntegers(){
      list = new ArrayList<>();  
    }
    
    
    @Override
    public int size(){
        return list.size();
    //    if (size.length => 1){
    //            return true;
    //}else{
    //    return false;
    //}
    
    //Returns the number of elements in the queue... I guess I need a constructor first
}
    
    @Override
    public boolean isEmpty(){
        return list.isEmpty();
      //Returns (but does not remove) the element at the front of this queue.
      //Returns null if this queue is empty.
    
    }
    
    @Override
    public Integer front(){ //simular to top() showed in class
        if(list.size() > 0){
            int front = list.get(0); //first value in an array has the placeholder of 0
            return front;
        }else{
            return null;
        }
  
        //return first value of int list
        //else return null if empty
    }

    @Override
    public void enqueue(Integer element){ //works like push
        //when the endqueue(5) method would be called, it will add 5 to the rear of queue
        //Add the given element at the rear of the queue.
        list.add(element);
    }
    
    @Override
    public Integer dequeue(){ //works like pop() from stack
        //Removes and returns the element at the front of this queue. Returns null
        //if this queue is empty.
        //otherList = new ArrayList<>();
        if (list.size() > 0){
            int front = list.get(0); //first value in an array has the placeholder of 0
            int length = list.size();
            int dequeue = list.remove(0);
            return front;                     
        }else{
            return null;
        }
        
    }
    
    
    @Override
    public String toString(){
        /*
     * Returns a string showing all elements in this queue. The String should
     * show the elements in the queue, each separated by a comma and a space.
     * There should be square brackets around the queue elements. The front of
     * the queue should be on the left and the rear on the right. The string
     * "Front " should be to the left and the string " Rear" to the right. For
     * example, if 11 were enqueued first, followed by 22, then the toString
     * method should return the string "Front [11, 22] Rear".
        */
        
        String s = "Front ";
        s = s + list.toString();
        s = s + " Rear";
        
        return s;
    }
    
    
/*
    For this assignment, reference the StackofIntegers and ArrayListTester which
    Dr. Lillis has provided. 

Notes from 9/13/2016
    This task spun off of a lecture on Proceedural programming, autoboxing and auto unboxing.
    Auto Boxing takes a variable type and creates a wrapper class.
    Auto Uboxing Takes a wrapper class and pulls the variable type.
    
    Public Class AutoUnboxingBoxing{
        publix statis void main.....{
            Double d = 24.65;
    
            System.out.println("d = " + d);
    
            (below is an object reference to an integer -> pulls out int, increments by 1
            and then puts the new object into that spot.)
            for (Integer i = 0; i < 7; i++){
                System.out.printLn(i);
            }
        }
    
    - in many instances, Java requires you to use object types over primitive types. - such as ArrayLists.
    - Wrapper classes have methods and instance varaibles inside of them.
    
    public class ArrayListTester{
        public static void main(String[] args){
        //first, make an array list of int
        int[] array1 = new int[10];
        for(int i = 0; i < array1.length; i++){
            array1[i] = -i;
        }
        for(int i = 0; i < array1.length; i++){
            System.out.print(array1[i] + " ");
        }
        //The Array has to hold the same thing (type)
        //Now, make an ArrayList of Integer - **New Syntax**
    
        import java.util.ArrayList;
        ArrayList<Integer> list1 = new ArrayList<>();
    
        //you can put any type in an ArrayList you want.
        //Arrays are not objects - they work differently - efficiently fast
        //ArrayLists are opperated with a public interface.
        
        list1.add(16); //this is an int not Integer -> autowrapped
        list1.add(4);
        list1.add(5);
        list1.add(15);
        
        for(int i = 0; i <list1.size(); i++){ //not .length like the rest of java
            System.out.print(list1.get(i) + " "); //don't use println -> print shows them all on the same line
        }
    
        System.out.println(); //Prints a new line
        //An easier way to print the whole list
        System.out.println(list1);
    
        //Add up all the elements in teh list
        int sum = 0;
        for(int i = 0; i < list1.size(); i++){
            sum += list1,get(i);
        }
        System.out.println("Sum = " + sum);
        }
    
        //pulls everythign out of a list one at a time
        //"Enhanced for loop"
        //New syntax
        for(Integer n : list1){ //2 pieces sepparated by a colon
        //can make n an int instead of Integer here to move the autounboxing...
        //Integer and n are variables - must match the 'type' of thigns in the list.
        //make n = the thing in the list. - for each Integer n in the list1
        sum += n; //sum is an Integer reference; n is line
        }
        System.out.println("sum is still " + sum);
        //ArrayList of Rectangle Objects
        ArrayList<Rectangle> rects = new ArrayList<>();
        rects.add(new Rectangle(1, 1, 1, 1)); //creates the object and put it in the list
        rects.add(new Rectangle(2, 2, 2, 2));
        rects.add(new Rectangle(3, 3, 3, 3));
    
        for(Rectangle r : rects){
            System.out.println(r);
        }
        //Result
        Rectangle[x=1, y=1, w=1, h=1]
        Rectangle[x=2, y=2, w=2, h=2]
        Rectangle[x=3, y=3, w=3, h=3]
    
        for(Rectangle r: rects){
            r.translate(10,0);
        }
    
        for(Rectangle r : rects){
            System.out.println(r);
        }
        //if making r point to a new Rectangle - different than it started as
    
        System.out.println();
        System.out.println("List 1 has: ");
        System.out.println(list1);
    
        //Ingteger class is immutable.
    
        Notes from 9/15/2016
    
    Stack: **** 
    - liske a list, but it's not
    - can only take Add + Remove from teh same end. (front of the list or end of the list)
    - Call This the "top" of the stack - TOS
    LIFO
    - Dish washer ex) take a plate and put it in the cubbard using only 1 arm.
    - last one in is the first one out.
    - Top of the stack is the last one added.
    
    Methods for Stack are as follows (This is the public interface)
    - POP (Remove)
    - Push (Add)
    - TOP (Look at TOS)
    - Size (# of things in the stack)
    - isEmpty (returns boolean true/false)
    - toStraing
    
    //Using a Stack over an array could allow you to be more efficient
    //Stacks are used for Abstract Data Types (ADT)
    - building an Array of strings was a pain in the neck -> led to Integer being created
    - When doing a method call - java pulls from the stack
    - Stacks method data on memory in a stack.
    - stacks are used for evaluating expressions.
    
    Interface: *****
    - Simular to a java class - but it doesn't have certain things
    - No instance variables
    - No method body - signatures only
    - Everything is Public *ALWAYS*
    - Cannot make an instance
    - Provide list of required methods for your class
    - stack imliment (my stack interface)
    
    public interface MyStack{ //refactored to MyStackOfIntegers (changes file name)
    //stuff entered here.... review notes or look at class put on website
    //Java Doc comments can be viewed within NetBeans - use '/**' to create them.
    
    public class StackOfIntegers implements MyStackOfIntegers{
        ArrayList<Integer> list;
        list = new ArrayList<>();
    
        public StackOfIntegers(){
        //default constructor - empty ArrayList
        }
    
        public void push(int item){
        list.add(item);
        }
    
        pulic int pop{ //will track what parameters are in interface
            int size = list.size();
            int tos = list.get(size-1);
            return tos;
    
    //review these classes from class website...
    
    Here's another version of the task provided by the book:
10.10 - p.402 (The Queue class) Section 10.6 gives a class for Stack. Design a class named
Queue for storing integers. Like a stack, a queue holds elements. In a stack, the
elements are retrieved in a last-in first-out fashion. In a queue, the elements are
retrieved in a first-in first-out fashion. The class contains:
■ An int[] data field named elements that stores the int values in the queue.
■ A data field named size that stores the number of elements in the queue.
■ A constructor that creates a Queue object with default capacity 8.
■ The method enqueue(int v) that adds v into the queue.
■ The method dequeue() that removes and returns the element from the queue.
■ The method empty() that returns true if the queue is empty.
■ The method getSize() that returns the size of the queue.
Draw an UML diagram for the class. Implement the class with the initial array
size set to 8. The array size will be doubled once the number of the elements
exceeds the size. After an element is removed from the beginning of the array,
you need to shift all elements in the array one position the left. Write a test
program that adds 20.
    
(p. 783)
A queue is a first-in, first-out data structure. Elements are appended to the end of the queue
and are removed from the beginning of the queue. In a priority queue, elements are assigned
priorities. When accessing elements, the element with the highest priority is removed first.
This section introduces queues and priority queues in the Java API.
    */

}