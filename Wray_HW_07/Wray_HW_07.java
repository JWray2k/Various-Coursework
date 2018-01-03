package wray_hw_07;

//import static java.lang.Math.PI;
import java.util.Scanner;
//import java.awt.Point;

/* HW07
Jonathan Wray
CSCI-195
*/

public class Wray_HW_07 {
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the coordinates for circle 1: ");
        System.out.print("X: ");
        int x1 = input.nextInt();
        System.out.print("Y: ");
        int y1 = input.nextInt();
        System.out.print("Radius: ");
        int r1 = input.nextInt();
        //Point a = new Point (x1,y1);
        System.out.print("Please enter the coordinates for circle 2: ");
        System.out.print("X: ");
        int x2 = input.nextInt();
        System.out.print("Y: ");
        int y2 = input.nextInt();
        System.out.print("Radius: ");
        int r2 = input.nextInt();
        //Point b = new Point(x2, y2);
        //double radius;
        //double area;
        //radius = r1;
        //area = radius * radius * PI;
       // System.out.println("The area for the circle of radius " + radius + " is " + area);
    //double dist = a.distance(b);
    // double dist = Point.distance(a,b);
        double Distance = Math.sqrt((x1*x1-x2*x2)+(y1*y1-y2*y2));
               //System.out.println("The distance is" + Distance);
               
               if (Distance > r1+r2){
               System.out.println("The smaller circle is completely outside of the larger circle");
               }
               else if (Distance < r1+r2){
               System.out.println("The smaller circle is completly within the larger circle");
               }
               else {
               System.out.println("The two circles overlap");
               }
    }
}
        //System.out.println("Distance from " + a + " to " + b + " is " + dist);
        //double C1 = (2*PI*r1);
        //System.out.print(C1);
              