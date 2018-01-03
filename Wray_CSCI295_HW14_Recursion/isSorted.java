
import java.util.Scanner;

/*
 * Jonathan Wray
 * CSCI-295: HW14
 * Dec 7, 2016
 */

/*

Is Sorted

Given an array of integers, determine of the array is sorted in non-decreasing order.

isSorted({1, 2, 3, 4, 5, 6}) → true
isSorted({2, 2, 2, 2, 2, 2}) → true
isSorted({5}) → true
isSorted({}) → true
isSorted({1, 2, 3, 2, 3, 4, 5, 6}) → false
isSorted({6, 5, 4, 3, 2, 1}) → false

 */

/**
 *
 * @author jw91482
 */
public class isSorted {
    private int[] array;

    public isSorted() {
        array = new int[] { 0, 0, 0 };
    }
    
    public isSorted(int[] array){
        recursiveSort(array);
    }
    

    public void recursiveSort(int[] intArray) {
        if(intArray.length <= 1){
            return; // Base case: if there is just a single element
        }               

        int[] a = new int[intArray.length / 2]; // Dividing the array.length by 2 splits it in half
        int[] b = new int[intArray.length - a.length]; //subtract a's length from the initial array to get b.
        for(int i = 0; i < intArray.length; i++) {//iterate through the array one at a time.
            if(i < a.length){ //populate a by only going up to half way through the initial array - declared as a now.
                a[i] = intArray[i];
            }else{ //populate b with the remaining information
                b[i - a.length] = intArray[i];
            }
        }

    recursiveSort(a); // Recursively sort first by making our method call.
    recursiveSort(b); // and then the second half.

    int ai = 0;                               
    int bi = 0;                                  
    while(ai + bi < intArray.length) { //Merge halves: ai, bi track position in in each half.
        if(bi >= b.length || (ai < a.length && a[ai] < b[bi])) {
            intArray[ai + bi] = a[ai]; // (copy element of first array over)
            ai++;
        } else {
            intArray[ai + bi] = b[bi]; // (copy element of second array over)
            bi++;
        }
    }
}
    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);

        System.out.println("isSorted({1, 2, 3, 4, 5, 6}) -> " + isSorted.recursiveSort({1, 2, 3, 4, 5, 6}));
        System.out.println("isSorted(12) -> " + isSorted.recursiveSort({1, 2, 3, 4, 5, 6});
        System.out.println("isSorted(12) -> " + isSorted.recursiveSort({1, 2, 3, 4, 5, 6});
        System.out.println("--------------------------------");
        System.out.println("Enter an array of integers in any order: ");
        System.out.println("The sorted array is " + isSorted.recursiveSort(user_input.next[]()));
        //int n = user_input.nextInt();
        
}
}
