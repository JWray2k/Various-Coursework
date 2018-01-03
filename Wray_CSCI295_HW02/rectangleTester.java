
/**
 * Jonathan Wray
 * CSCI 295
 * HW01
 * 8/30/2015
 */

package Wray_CSCI295_HW02_Rectangle;

public class rectangleTester {
    public static void main(String[] args){
        //Test the constructor
        
        Rectangle r1 = new Rectangle();
        System.out.println("r1 height is: " + r1.getHeight());
        System.out.println("r1 width is: " + r1.getWidth());
        System.out.println("r1 area is: " + r1.getArea());
        System.out.println("r1 perimeter is: " + r1.getPerimeter());
                
        //Test the setHeight method
        r1.setHeight(11);
        System.out.println("r1 height is: " + r1.getHeight());
        
        //Test the setWidth method
        r1.setWidth(8);
        System.out.println("r1 width is: " + r1.getWidth());
        
        //Test the getArea method
        System.out.println("r1 area is: " + r1.getArea());
         
        //Test the getPerimeter method
        System.out.println("r1 perimeter is: " + r1.getPerimeter());
                       
    }
}
