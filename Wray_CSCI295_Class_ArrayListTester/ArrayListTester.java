
import java.util.ArrayList;

public class ArrayListTester {
    public static void main(String[] args) {
        // Make an array of int and fill it with some values
        int[] array1 = new int[10];
        for(int i = 0; i < array1.length; i++){
            array1[i] = -i;
        }
        
        // Print the array
        for(int i = 0 ; i < array1.length; i++){
            System.out.print(array1[i] + " ");
        }
        
        System.out.println(); // Print a new line
        
        // Make an ArrayList of Integer and fill it with some Integer objects
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(16);
        list1.add(4);
        list1.add(5);
        list1.add(15);
        
        // Print the ArrayList
        for(int i = 0; i < list1.size(); i++){
            System.out.print(list1.get(i) + " ");
        }
        
        System.out.println(); // Print a new line
        
        // Print the ArrayList, automatically using its toString method
        System.out.println(list1);
        
        // Add up all elements in the list
        int sum = 0;
        for(int i = 0; i < list1.size(); i++){
            sum += list1.get(i);
        }
        
        System.out.println("sum = " + sum);
        
        
        // Add up all elements using an "Enhanced for loop"
        sum = 0;
        for(int n : list1){
            sum += n;
        }
        System.out.println("sum is still " + sum);
        
        // Make an ArrayList of Rectangle and add some Rectangle objects
        ArrayList<Rectangle> rects = new ArrayList<>();
        rects.add(new Rectangle(1,1,1,1));
        rects.add(new Rectangle(2,2,2,2));
        rects.add(new Rectangle(3,3,3,3));

        // Print each list element using an enhanced for loop
        for(Rectangle r : rects){
            System.out.println(r);
        }
        
        // Perform an operation on each Rectangle object in the ArrayList
        for(Rectangle r : rects){
            r.translate(10, 0);
        }
        
        // Print the list of Rectangles again
        for(Rectangle r : rects){
            System.out.println(r);
        }
        
        System.out.println(); // Print a new line
        
        // Demonstrate that you cannot assign a new value to list elements
        // using the enhanced for loop
        System.out.println("List 1 has:");
        System.out.println(list1);
        
        // This doesn't change any elements in the list.
        for(Integer n : list1){
            n = n + 10;
        }
        
        System.out.println(list1);
        
    }

}