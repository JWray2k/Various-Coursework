/*
 * Jonathan Wray
 * CSCI310 - HW03 - ListOfStrings
 * 2/9/2017
 */


public class ListTester {
    public static void main(String[] args) {
    ListOfStrings L = new ListOfStrings();

    // Add items until the capacity is increased
    System.out.println("\n------- Add List Items -----------------");
    printList(L);

    L.add("A");
    printList(L);

    L.add("B");
    printList(L);

    L.add("C");
    printList(L);

    L.add("D");
    printList(L);

    L.add("E");
    printList(L);

    // Get List items
    System.out.println("\n------- Get List Items -----------------");
    printList(L);
    System.out.println("List item 0: " + L.get(0));
    System.out.println("List item 2: " + L.get(1));
    System.out.println("Last list item: " + L.get(L.getSize() - 1));
    printList(L);

    // Set a list item
    System.out.println("\n------- Set List Items -----------------");
    L.set(2, "zzz");
    printList(L);

    System.out.println("\n------- Remove List Items --------------");
    printList(L);
    System.out.println("Remove item 2");
    String item = L.remove(2);
    System.out.println("removed item: " + item);
    printList(L);
    System.out.println();
    
    System.out.println("Remove First");
    item = L.removeFirst();
    System.out.println("Remove First: " + item);
    printList(L);
    System.out.println();
    
    System.out.println("Remove Last");
    item = L.removeLast();
    System.out.println("Remove Last: " + item);
    printList(L);
    System.out.println();
    
    System.out.println("Compress");
    L.compress();
    printList(L);
    System.out.println();
    
    System.out.println("Ensure Capacity");
    L.ensureCapacity(2);
    printList(L);
    System.out.println();
    
    System.out.println("Ensure Capacity");
    L.ensureCapacity(20);
    printList(L);
    System.out.println();
    
    System.out.println("Get Index");
    //L.getIndex("D");
    System.out.println(L.getIndex("D"));
    printList(L);
    System.out.println();
    
    System.out.println("Get Index");
    //L.getIndex("D");
    System.out.println(L.getIndex("H"));
    printList(L);
    System.out.println();
    
    System.out.println("Remove(String)");
    L.remove("D");
    //System.out.println(L.getIndex("H"));
    printList(L);
    System.out.println();
    
    System.out.println("Clear");
    L.clear();
    //System.out.println(L.getIndex("H"));
    printList(L);
    System.out.println();
    
    

//    System.out.println("Remove item 3");
//    item = L.remove(3);
//    System.out.println("removed item: " + item);
//    printList(L);
//    System.out.println();
//
//    System.out.println("Remove item 0");
//    item = L.remove(0);
//    System.out.println("removed item: " + item);
//    printList(L);


    
    }
    
    
    
    public static void printList(ListOfStrings lst){
        System.out.print("size: " + lst.getSize());
        System.out.print("  capacity: " + lst.getCapacity());
        System.out.print("  List: " + lst);
        System.out.println();
    }
}
