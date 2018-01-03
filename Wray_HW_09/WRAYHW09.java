import java.util.Scanner;

/* HW08
Jonathan Wray
CSCI-195
*/

public class WRAYHW09 {
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
