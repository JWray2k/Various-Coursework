import java.util.Scanner;

public class WrayHW06 {
  public static void main(String[] args){
    Scanner input= new Scanner(System.in);
    System.out.println("Enter an integer value for first side of triangle: ");
    int a = input.nextInt();
    
    System.out.println("Enter an integer value for the second side of the triangle: " );
    int b = input.nextInt();
    
    System.out.println("Enter an integer value for the hyponenuse: ");
    int h = input.nextInt();
    
    
    if ((a * a) + (b * b) == (h * h)){
        System.out.println("This triangle is a Pythagorean Triple");
    } else {
        System.out.println("This is not a Pythagorean Triple");
    }
  }
 
}
  
