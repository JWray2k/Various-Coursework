
/**
 * Jonathan Wray CSCI 195 Homework 15 4/29/2014
 */
public class Wray_HW15_Rectangle {

    // Instance Variables
    double width;
    double height;

    // Constructors
    public Wray_HW15_Rectangle() {
        width = 1.0;
        height = 1.0;
    }

    public Wray_HW15_Rectangle(double h, double w){
        width = w;
        height = h;
        if (width <= 0){
            throw new RuntimeExeption("Width must be a positive value.");
        }
        if (height <= 0){
            throw new RuntimeExeption("Height must be a positive value.");
        }
        
        
    }

    //public Wray_HW15_Rectangle(double initRectangle){
  
      //  InitHeight = width(1.0);
       // InitWidth = height(1,0);
        
      //  InitPerimeter = InitHeight + InitWidth;
      //  InitArea = InitWidth;
   // }

    public Wray_HW15_Rectangle(double initheight) {
        height = initheight;
    }
    public void setWidth(double newWidth) {
        width = newWidth;
    }

    public double getWidth() {
        return width;
    }

    public void setHeight(double newHeight) {
        height = newHeight;
    }

    public double getHeight() {
        return height;
    }
    //    public void setArea(double newArea) {
    //    Area = newArea;
    //}

    public double getArea() {
        return (width * height);
    }

    public double getPerimeter() {
        return (width + height);
    }
    
    public String toString(){
        String s = "width is: " + width + "   " + "height is: " + height;
        return s;
    }
    

    //public String toString() {
        //String s = "";
        //s += "Balance: ";
        //s += String.format("$%6.2f", getBalance());

       // return s;
    //}
}
//Two double data fields named width and height that specify the width and height of the rectangle. Both should have a default value of 1.0.
//A default constructor (a no-argument constructor) that creates a default rectangle.
//A constructor that creates a rectangle with the specified width and height.
//Methods called setWidth and getWidth to get and set the width of the rectangle.
//Methods called setHeight and getHeight to get and set the height of a rectangle.
//Methods called getArea and getPerimeter to get the area and perimeter of a rectangle.

