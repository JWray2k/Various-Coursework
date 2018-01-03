
import java.util.Scanner;

/*
 * Jonathan Wray
 * CSCI-295: HW14
 * Dec 7, 2016
 */

/*

Reverse a String

Given a string, returns a new string where all the characters have been reversed.

reverseString("abcd") →"dcba"
reverseString("x") → "x"
digitsRight("") → "" 
digitsRight("St. Ambrose") → "esorbmA .tS"

- For this problem, a smaller version would be to switch a single letter with itself.
- If I can figure out how to reverse a two-letter word, then I can do recursion.

 */

/**
 *
 * @author jw91482
 */
public class reverseAString {
    
public static void main(String[] args) {
    // Create a Scanner
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a String to be reversed: ");
    String string = input.next();
    
  
    // Find and display the reverse of the input
    System.out.println("The reverse of your string "
    + string + " is " + reverse(string));
 }
    
    
//This recursive method call happens over and over again until the base case is it.
//my string swap will be populated and then returned once the base case is realized.
public static String reverse(String s){
    StringBuilder swap = new StringBuilder(); //strings are immutable.... need to rework
    if (s.length() <= 1){ // Base case
        return swap.toString(); //need to convert my return type to a String using toString() method.
    }else if (s.charAt(0) != s.charAt(s.length() - 1)){ // Base case
        return swap.toString();
    }else{ //create smaller pieces of the the string as you iterate throught it.
        swap.append(s.charAt(s.length() - 1)); //append shoud add the char onto swap every time...
        return reverse(s.substring(0, s.length() - 1)); //there is a recursive method call inside of the else statment
    }
}

}



//This solution uses a loop statement, which isn't proper recursion.
    
//    public static String reverse(String input){
//    char[] in = input.toCharArray();
//    int F=0; //F represents the front of the string
//    int R=in.length-1; //R represents the rear of the string
//    char temp;
//    while(R > F){
//        temp = in[F];
//        in[F]=in[R];
//        in[R] = temp;
//        R--;
//        F++;
//    }
//    return new String(in); //had to cast it as a String
// }

 
    
//The below was printing out a string of numeric characters rather than a string of letters...
    
//    public static String reverse(String s){
//        if (s.length() <= 0){
//            return s; //need a case for empty string
//            
//        }else{
//            int R = s.charAt(s.length()-1);    
//            String swap = "";
//                for(int i = 0; i < s.length()-1; i++){
//                    int count = 2;
//                    swap += R;
//                    R = s.charAt(s.length()-count);
//                    count++;
//                }
//                return swap;
//        }
//    }
    
//public static void main(String[] args) {
//    Scanner user_input = new Scanner(System.in);
//
//    System.out.println("reverseAString(abcd) -> " + reverseAString.reverse("abcd"));
//    System.out.println("reverseAString(x)-> " + reverseAString.reverse("x"));
//    System.out.println("reverseAString( ) -> " + reverseAString.reverse(""));
//    System.out.println("reverseAString(St. Ambrose) -> " + reverseAString.reverse("St. Ambrose"));
//    System.out.println("--------------------------------");
//    System.out.println("Enter a String of letters (or word): ");
//    System.out.println("The reverse of this string is " + reverseAString.reverse(user_input.next()));
//        
