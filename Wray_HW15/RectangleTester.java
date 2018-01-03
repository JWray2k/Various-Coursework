
/**
 * Jonathan Wray 
 * CSCI 195 
 * HW 15 Tester
 */
public class RectangleTester {
    //private static String Wray_HW15_Rectangle;
    public static void main(String[] args) {
        // Create a Rectangle Object
        Wray_HW15_Rectangle r1 = new Wray_HW15_Rectangle();
        System.out.println("Rectangle: " + r1);

        double Perimeter = r1.getPerimeter();
        System.out.println("Perimeter is: " + Perimeter);
        
        // have the object calculate its area then print the area
        double Area = r1.getArea();

        System.out.println("Area is " + Area);
        
        double width = r1.getWidth();
        System.out.println("Width is: " + width);
        
        double height = r1.getHeight();
        System.out.println("Height is: " + height);


        // Set the circle object's radius to 1
// r1.setHeight(1.0);
        //System.out.println("Area is " + r1.getArea());
        //System.out.println("Expeced is 1");

        // Create a second circle object, this time providing 
        // an initial radius
        //Wray_HW15_Rectangle r2 = new Wray_HW15_Rectangle(2.0);
        //System.out.println("Area of c2 is " + r2.getArea());
    }
}
//public class BankAccountTester {
//3: public static void main(String[] args) {
//4: BankAccount acct1 = new BankAccount();
//5: System.out.println("acct1: " + acct1);
//6: 
//7: BankAccount acct2 = new BankAccount(100.12);
//8: System.out.println("acct2: " + acct2);
//9: 
//10: acct1.deposit(50);
//11: acct1.withdraw(30);
//12: System.out.println("acct1: " + acct1);