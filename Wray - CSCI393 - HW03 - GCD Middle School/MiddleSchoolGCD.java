import java.util.Arrays;
import java.util.Scanner;

/*
 * Jonathan Wray
 * CSCI-393
 * 2/2/2016
 * HW03 - Middle School Gcd
 */


public class MiddleSchoolGCD {
    private static int [] generatePrimes(int max) {
        boolean[] isComposite = new boolean[max + 1];
        for (int i = 2; i * i <= max; i++) {
            if (!isComposite [i]) {
                for (int j = i; i * j <= max; j++) {
                    isComposite [i*j] = true;
                }
            }
        }
        int numPrimes = 0;
        for (int i = 2; i <= max; i++) {
            if (!isComposite [i]) numPrimes++;
        }
        int [] primes = new int [numPrimes];
        int index = 0;
        for (int i = 2; i <= max; i++) {
            if (!isComposite [i]) primes [index++] = i;
        }
        return primes;
    }
    

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("Please enter a value for m greater than 1");
        int m = input.nextInt();
        while (m < 2){
            System.out.println("Try again, the number must be greater than 1!");
            m = input.nextInt();
        }       
    //System.out.println(Arrays.toString(generatePrimes(m)));
    //need to return and not just print...
    int [] arrayM;
    arrayM = generatePrimes(m); //maybe this will do
    System.out.println(Arrays.toString(arrayM));
    //System.out.println(Arrays.toString(arrayA)); //test to see if array was populated
    

    System.out.println("Please enter a value for n");
        int n = input.nextInt();
        while (n < 2){
            System.out.println("Try again, the number must be greater than 1!");
            n = input.nextInt();
        }
    System.out.println(Arrays.toString(generatePrimes(n)));
    int [] arrayN = generatePrimes(n);
    
    //New array
    
    //System.out.println(Arrays.toString(arrayB)); //test to see if array was populated
    
    int i;
    for (i = 0; i < arrayM.length; i++) {
        int [] arrayA; //had to do this to get arrayM values to duplicate - so there could be more than one 2.
        arrayA = new int[arrayM.length];
        while (m % arrayM[i] == 0){ //currently adds on a value which has a division = 1...
           //arrayA.append(arrayM[i]); - not sure how to append in java
           //System.out.println(arrayM[i]); // printing out 0 zalues for contents of arrayA....
           //arrayA[i] = arrayA[i+1];
           arrayA[i] = arrayM[i];
           m = m/arrayM[i];
           //System.out.println(arrayA[i]); // used to check if new array was populated
        }
        

    int j;
    for (j = 0; j < arrayN.length; j++) {
        int [] arrayB; //had to do this to get arrayN values to duplicate - so there could be more than one 2.
        arrayB = new int[arrayN.length]; //I think I need to be making this an arrayList?
        while (n % arrayN[j] == 0){ //currently adds on a value which has a division = 1...
           //arrayA.append(arrayM[i]); - not sure how to append in java
           //arrayA[i] = arrayA[i+1];
           n = n/arrayN[j];
           arrayB[j] = arrayN[j];
           //System.out.println(arrayB[j]); //used to test if new array was populated
        }
           int k;
           int p;
           int gcd = 1;
           for (k = 0; k < arrayA.length; k++){
               for (p = 0; p < arrayB.length; p++){
                   if(arrayA[k] == arrayB[p]){
                       gcd = gcd * arrayA[k];
                       System.out.println(gcd);
                    //System.out.println(arrayA[k]);
                       //STILL PRINTS OUT ZERO VALUES AHHHHH!!!!!!!!!
                       //need to make the results (non-zeros) multiply by eachother for the GCD
                       
                   }
               }
               
               //so I have a super nested loop now.
            /*int k = 0;
            int count = 0;
            int [] arrayGCD; //final array
            arrayGCD = new int[arrayA.length];
            int p = 0;
            while(k <= arrayA.length-1){ //loops through this 3 times...
               //arrayGCD = new int[p];
               System.out.println(arrayA[k]);
               //System.out.println(arrayB[count]);
               if (arrayA[k] == arrayB[count]){ //this is giving me an array index out of bounds
                   arrayGCD[p] = arrayA[k];
                   k++;
                   p++;
                   //System.out.println(k); //this is looping through a
                   //count = 0;
               }
               else if (count >= arrayB.length-1){
                   k++;
                   count = 0;
               }
               else{
                   count++;
               }
          */ }
            //System.out.println(Arrays.toString(arrayGCD));
//my new array (arrayGCD is being populated with zeros even though arrayA and arrayB don't contain any
//I need to figure out why I am getting zeros indexed and then I will be able to move on 
           
           }
        }
    }
   
    
 
    
    
//        for (j = 0; j < arrayB.length; j++) {
 //           if (arrayA[i] == arrayB[j]) {
    
    //Next task is to campare the length of arrayA and arrayB to one another to determine which is shorter. /not needed
    //Once shorter one has been determined, there will need to be a loop for each number in that array
    //...comparing it to the larger array with another loop statement. If the numbers match up,
    //...that number will be put into a new array populated with common integers in both arrays.
    //...once the smaller array's primes have been read through, it is no longer neccessary to keep parsing
    //...through the larger array. All common primes now exist within the new array list.
    
    //Once I have my new array populated, I will then need to parse through the new
    //...array and multiply each array element as I itterate through it until I reach the end of array.length.
    //}
    }

