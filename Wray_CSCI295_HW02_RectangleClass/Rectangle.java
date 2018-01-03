/**
 * Jonathan Wray
 * CSCI 295
 * HW02
 * 9/5/2015
 * 
HW 02 - Rectangle Class

Design a class named Rectangle to represent a rectangle that has an (x, y) 
coordinate of of its top-left corner along with a width and height. For this 
assignment we'll use the standard computer graphic coordinate system, in which 
the point (0, 0) is at the top left with the x-axis going to the right and the 
y-axes going down. Below are are the specific requirements for your 
Rectangle class.


Instance Variables

Your class should have exactly four instance variables, 
all of which are of type int. The names of the variables should be: x, y, width, 
and height. It is expected that values for all four of these variables will be 
non-negative, although your class is not required to check for that. If negative 
values are ever stored in any of the instance variables, then the behavior of a 
Rectangle object is undefined.
 */
//import java.lang.*;
import java.util.Random;
//Constructors

//Your class is to have two constructors:
//not sure if I need parenthesis after Rectangle.
public class Rectangle {
    private int width;
    private int height;
    private int x;
    private int y;


//This is the default constructor. It sets all instance variables to zero.
public Rectangle(){
    Rectangle r1 = new Rectangle(0,0,0,0);
}


//This constructor provides initial values for all four instance variables.
public Rectangle(int x, int y, int width, int height){
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
}
//Methods
//Below are the method signatures along with descriptions for each method 
//that you must include in your Rectangle class.

public int getX(){
    return x;
}
//Returns the value of the instance variable x.

public int getY(){
    return y;
}
//Returns the value of the instance variable y.

public int getWidth(){
    if (width < 1){
        return width = 0;
    }
    else{
    return width;
    }
}

//Returns the value of the instance variable width.

public int getHeight(){
     if (height < 1){
        return height = 0;
    }
    else{
    return height;
    }
}

//Returns the value of the instance variable height.

public int area(){
    return width * height;
}

//Returns the area of the Rectangle.

public int perimeter(){
    return 2 * (width+height);
}

//Returns the perimeter of the Rectangle.

public void setRect(int x, int y, int width, int height){
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
}
//Sets the four instance variables to the four specified values.

public void setRect(Rectangle r){
    this.x = r.x;
    this.y = r.y;
    this.width = r.width;
    this.height = r.height;
}
//Sets the four instance variables of this Rectangle to the corresponding four values in the parameter Rectangle.

public void translate(int deltaX, int deltaY){
    x = x + deltaX;
    y = y + deltaY;
}
//Changes the instance variables x and y by adding the values of deltaX and deltaY.

public Rectangle createIntersection(Rectangle r){
    //if (r.x < x - Math.abs(r.width-width){
        Random generator = new Random();
        int minX = x+1-r.width;
        int maxX = x+width-1;
        int minY = y-1+r.height;
        int maxY = y-width+1;

        //need to randomize the x value and the y value so that there is an overlap
        //for the second rectangle with the first rectangle.
        
        int randomX = generator.nextInt((maxX - minX) + 1) + minX;
        int randomY = generator.nextInt((maxY - maxY) + 1) + minY;
        //generate random number for x and y to overlap the initial rectangle
        r.height = height;
        r.width = width;
        
        r.x = randomX;
        r.y = randomY;
        
        //set x and y = new random x and y.
        
        return r;
}

//Returns a new Rectangle object representing the intersection of this Rectangle with the specified Rectangle.

public boolean intersects(Rectangle r){
    int x1 = x;
    int x2 = x+width;
    int y1 = y;
    int y2 = y-height;
    // My points are as follows: (x1,y1) (x1, y2) (x2, y1) (x2, y2)
    
    
    
    
     //Rectangle bounds = new Rectangle(points[0]);
     //for (int i = 1; i < points.length; i++) {
     //    bounds.add(points[i]);
     //}
    //referenced from https://docs.oracle.com/javase/7/docs/api/java/awt/Rectangle.html
    
    
    
    // public boolean contains(Point p){
    //    return (this.getLocation().getX() < p.getX() && this.getLocation().getY() < p.getY() &&
    //            this.getLocation().getX() + this.getWidth() > p.getX()  &&
    //            this.getLocation().getY() + this.getHeight() > p.getY());
    //}referenced from http://stackoverflow.com/questions/5345031/checking-if-a-point-is-inside-a-specified-rectangle
    
    
    //Rectangle r1;
    //Rectangle r2;
    //double area1 = r1.width * r1.height;
    //double area2 = r2.width * r2.height;
//I need to figure out if rectangle r has a x and y value (factoring in the height and width
//that overlaps the x and y value (also factoring in height and width) of the original
//rectangle. I want to do this through calculation of ranges - perhaps using the generator
//used in the createIntersection method. I think I also need to use the absolute value to calculate.
//area areaA = new area(r1)
return true;
}

//Returns true if this intersect intersects the specified Rectangle and returns 
//false of the two Rectangles do not intersect. For this assignment, two 
//Rectangles are said to intersect only of their interiors overlap.

public String toString(){
     return "Rectangle" + "[" + "x=" + x + ",y=" + y + "w=" + width+ "h=" + height + "]";
}

//Returns the name of the class and the value of the four instance variables. 
//For example, if the rectangle is at position (10,13) with a width of 6 and a 
//height of 9, then the following would be returned by the toString() method:

//Rectangle[x=10,y=13,w=6,h=9]

//Grading and Testing Your Rectangle Class

//I will be using this RectangleTester program to grade this assignment. 
//You can download this program and copy it into your NetBeans project to test 
//your Rectangle class yourself. If your class is working properly, the tester 
//program should produce the following output:

//Results of 127 tests:
//No Errors Found.
        
        }
