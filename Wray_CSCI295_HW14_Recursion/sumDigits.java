
import java.util.Scanner;

/*
 * Jonathan Wray
 * CSCI-295: HW14
 * Dec 7, 2016
 */


/*

Sum Digits

Given a positive integer, return the sum of the integer's digits. 
Below are some sample inputs and outputs:

sumDigits(12) → 3
sumDigits(159) → 15
sumDigits(4) → 4.

use %10 add last digit
/10 to remove the last digit
 */

/**
 *
 * @author jw91482
 */
public class sumDigits {
    
//    public sumDigits(){
//        calculateSumDigits();
//    }
    
    public sumDigits(int n){
        calculateSumDigits(n);
    }
//Base case - n = 0
public static int calculateSumDigits(int n){
int total = 0;
if(n == 0){
    return 0;
//}else if(n < 10){ - this case isn't needed
//    return n;
}else{
    while(n > 0){
        total += n%10;
        n = n/10;     
    }
    return total;
}

//you need to 
    
}

public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);

        System.out.println("sumDigits(12) -> " + sumDigits.calculateSumDigits(12));
        System.out.println("sumDigits(159) -> " + sumDigits.calculateSumDigits(159));
        System.out.println("sumDigits(4) -> " + sumDigits.calculateSumDigits(4));
        System.out.println("--------------------------------");
        System.out.println("Enter a number: ");
        System.out.println("The sum of the digits is " + sumDigits.calculateSumDigits(user_input.nextInt()));
        //int n = user_input.nextInt();
        
}
}









/**
 * 
public static void main(String[] args) {
if (args.length != 2) {
    showUsage();
} else {
    int n = Integer.parseInt(args[1]);

* 
 * else if (args[0].equals("R")) {
                // Run recursive version
                System.out.println("Recurson: Fib(0) to Fib(" + n + ")");

                for (int i = 0; i <= n; i++) {
                    long f = fibRecursive(i);
                    System.out.println("fib(" + i + ") = " + f);
                }
                * 

// Use recursion 
    public static long fibRecursive(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    static void showUsage() {
        System.out.println("Usage: Fib [D|I|R] n");
        System.out.println("    Where:");
        System.out.println("        D is for Dynamic");
        System.out.println("        I is for Iterative");
        System.out.println("        R is for Recursive");
        System.out.println("        n is how many Fibonacci numbers to compute");
    }
 */