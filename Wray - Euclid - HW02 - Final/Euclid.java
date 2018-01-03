import static java.lang.Integer.min;
import java.util.Scanner;

/*
 * Jonathan Wray
 * CSCI-393
 * 2/2/2016
 * HW02 - Euclid's Algorithm
 */

/**
 *
 * @author Jwray
 */


public class Euclid {

    //Standard implimentation
    static int gcd_mod(int m, int n){
        int r;
        while (n!=0){
            r = m % n;
            m = n;
            n = r;
        }
        //if (m == 0) { --didn't work
        //    throw new IllegalArgumentException("variable 'm' is 0");
        //}
        return m;
    }
    
    /*Euclid Recursion
    Euclid(m,n){
        if (n==0){
            return m
            }
        return Euclid(n, m%n); --this makes a slow funcitonal call
    }
    */
    
    //Recursive implementation
    public static int gcd_recursive(int m, int n) {
        if (n == 0){
            return m;
        }
        else return gcd_recursive(n, m % n);
    }
    
    public static int gcd_subtraction(int m, int n) {
        while (n != 0) {
            if (m > n) {
                m -= n;
            }
            else {
                n -= m; //it's more efficient to use -=
            }
        }
        return m;
    }
        
    //GCD2 - found in notes from 1/21/2016
    public static int Consecutive_Integer(int m, int n){
        int t = min(m,n);
        while(m%t != 0 || n%t != 0){
            t--; //(decriment)
    }
        //if (t == 1){
        //    System.out.println("1 - which isn't a valud gcd");
        //}
        // else{
       return t;
    }
    
    
        
public static void main (String[]args){
    Scanner input = new Scanner(System.in);

    System.out.println("Please enter a value for m greater than 1");
        int m = input.nextInt();
        while (m < 2){
            System.out.println("Try again, the number must be greater than 1!");
            m = input.nextInt();
        }
        

    System.out.println("Please enter a value for n");
        int n = input.nextInt();
        while (n < 2){
            System.out.println("Try again, the number must be greater than 1!");
            n = input.nextInt();
        }
    
        
    if (gcd_mod(m,n) == 1){
        System.out.println("There is no greatest common divisor (1 isn't valid)!");
    }
    else{
    System.out.println("The greatest common divisor using Textbook Euclid (standard mod) is : " +gcd_mod(m,n));
    System.out.println("The greatest common divisor using Recursive Euclid is : " +gcd_recursive(m,n));
    System.out.println("The greatest common divisor using Subtraction Euclid (found from questiion 3 in HW01) is : " +gcd_subtraction(m,n));
    System.out.println("The greatest common divisor using Consecutive Integer Checking Algorithm is : " +Consecutive_Integer(m,n));
  }
}
    
}
