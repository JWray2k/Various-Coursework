/* Jonathan Wray
 * CSCI-195
 * Homework: HW 04
 */
import java.util.Scanner;
public class WrayHW04Gold {
    public static void main(String[] args) {
        int count;
        Scanner input = new Scanner (System.in);  //create a scanner
        //read inpur from user
        System.out.println("Enter the number of Gold-Pressed Latinum bars: ");
        count = input.nextInt(); // read user input
        System.out.println ("The value of your " + count + " bar(s) of Gold-Pressed Latinum is " + (count * 1587) + " U.S. dollars");
    }
}
