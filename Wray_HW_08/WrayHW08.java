package WrayHW08;

import java.util.Scanner;

/* HW08
Jonathan Wray
CSCI-195
*/

public class WrayHW08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 1;
        int pennies = 1;
        int day = 2;
        
        //int sum = 0;
        //int positive = 0;
        //int negative = 0;

        
        System.out.println("Enter number of days:" );
        int n = input.nextInt();
        while(n > day){
            System.out.println("Day" +count);
              System.out.println(":" +pennies);
            pennies = (day*pennies);
            day++;
            count++;

           
                    
            //System.out.printf("%4d", n*count);
            
            //number = input.nextInt();
            //count++;
            //if (number >=0) { positive++; }
             //else {negative++;}
            
        }

       
    }
}

       


        //enter an integer, the input ends if it is 0
        //the number of positives is
        //the number of negatives is
        //the total is enter is
        //the average is
        //No numbers are entered except 0
  ///   public static void main(String[] args) {
//4: // Print first row of labels
//5: System.out.println(" | 0 1 2 3 4 5 6 7 8 9 10");
//6: System.out.println("~~~~~|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//7: 
//8: // Print each row of the table
//9: for(int i = 0; i <= 10; i++) {
//10: System.out.printf("%4d |", i); // label for the far left column of this row
//11: 
//12: // Loop through each value of j and compute the product
//13: for(int j = 0; j <= 10; j++){
//14: System.out.printf("%4d", i*j);
//15: }
//16: System.out.println();