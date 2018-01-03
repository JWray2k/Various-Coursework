/**
 *
 * Jonathan Wray
 * CSCI - 195
 * HW15 Tester2
 */
public class RactangleTester2 {

    public static void main(String[] args) {
        Wray_HW15_Rectangle r2 = new Wray_HW15_Rectangle(-2, -4);
        System.out.println("Rectangle: " + r2);

        double Perimeter = r2.getPerimeter();
        System.out.println("Perimeter is:" + Perimeter);
        
        double Area = r2.getArea();
        System.out.println("The Area is: " + Area);
        
        double width = r2.getWidth();
        System.out.println("Width is: " + width);
        
        double height = r2.getHeight();
        System.out.println("Height is: " + height);
        

    }
}

/*// Create a Circle Object
4: Circle c1 = new Circle();
5: 
6: // have the object calculate its area then print the area
7: double c1Area = c1.getArea();
8: 
9: System.out.println("area is " + c1Area);
10: System.out.println("Expeced 78.54 ish");
11: 
12: // Set the circle object's radius to 1
13: c1.setRadius(1.0);
14: System.out.println("radius is " + c1.getRadius());
15: System.out.println("Expeced is 1");
16: 
17: // Create a second circle object, this time providing 
18: // an initial radius
19: Circle c2 = new Circle(2.0);
20: System.out.println("Radius of c2 is " + c2.getRadius());
21: }
22:
* */
