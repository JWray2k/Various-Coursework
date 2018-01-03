/*
 * Jonathan Wray
 * HW10
 * CSCI 195
 */

public class FourMethods {
    
    public static void main(String[] args){
        aboveAverageTester();
        compareTester();
        isVowelTester();
        isPrimeTester();
    }


    public static void aboveAverageTester() {
        // Call the aboveAverage method with known values and see if the 
        // correct results are returned.
      aboveAverage (2,2,2,2,2,2);
      aboveAverage (2,2,80,2,2,2);
      aboveAverage (80,80,80,2,80,80);
    }
    
    
    public static void compareTester(){
        // Call the compare method with known values and see if the 
        // correct results are returned.
       int compare_1 = compare (1,5);
       //System.out.println("Test 1");
       int compare_2 = compare (5,5);
       int compare_3 = compare (20,1);
    }
    
    
    public static void isVowelTester(){
        // Call the isVowel method with known values and see if the 
        // correct results are returned.
        boolean result_V1 = isVowel ('a');
        System.out.println(result_V1);
        
        boolean result_V2 = isVowel ('z');
        System.out.println (result_V2);
        
        boolean result_V3 = isVowel ('q');
        System.out.println(result_V3);
        
        boolean result_V4 = isVowel ('o');
        System.out.println(result_V4);
    }
    
    
    public static void isPrimeTester(){
        // Call the isPrime method with known values and see if the 
        // correct results are returned.
        boolean result_1 = isPrime (5);
        System.out.println("Answer for 5 is " + result_1);
        
        boolean result_2 = isPrime (6);
        System.out.println("Answer for 6 is " + result_2);
        
        boolean result_3 = isPrime (54);
        System.out.println("Answer for 54 is " + result_3);
        
        boolean result_4 = isPrime (11);
        System.out.println("Answer for 11 is " + result_4);
        
    }
    
    
    public static int aboveAverage(int a, int b, int c, int d, int e, int f) {
        // Complete this method as described in the homework assignment
        int count = 0;
        
        double average = ((a+b+c+d+e+f)/6.0);
        if (a > average){
            count++;
        }
        if (b > average){
            count++;
        }
        if (c > average){
            count++;
        }
        if (d > average){
            count++;
        }
        if (e > average){
            count++;
        }
        if (f > average){
            count++;
        }
        System.out.println("Numbers above average: " + count);
        return count;

    }


    public static int compare(int x, int y) {
        // Complete this method as described in the homework assignment
        if (x>y){
            System.out.println(x + " is greater than " + y);
        }
        else if (x==y){
            System.out.println(x + " is equal to " + y);
        }
        else{
            System.out.println(x + " is less than " +y);
    }
       return 0;
    }


    public static boolean isVowel(char ch) {
        // Complete this method as described in the homework assignment
        if(ch=='a'||ch=='A'||ch=='e'||ch=='E'||ch=='i'||ch=='I'||ch=='o'||ch=='O'||ch=='u'||ch=='U'){
            System.out.println("Entered character is vowel.");
            return true;
 }
        else
            System.out.println("Entered character is consonant.");
           return false;
 
}
    


    public static boolean isPrime(int x) {
        // Complete this method as described in the homework assignment
            for(int i=2;2*i<x;i++) {
                if(x%i==0)
                    return false;
                }  
                return true;
}
  
}


