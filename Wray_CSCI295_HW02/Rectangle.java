/**
 * Jonathan Wray
 * CSCI 295
 * HW01
 * 8/30/2015
 */

package wray_csci295_hw01;

public class Rectangle {
    private double width;
    private double height;

    //constructor
    public Rectangle(){
        width = 1.0;
        height = 2.0;
    }

    public double getHeight(){
        return height;
    }

    public void setHeight(double newHeight){
        if (newHeight > 0){
            height = newHeight;
        }
    }

    public double getWidth(){
        return width;
    }

    public void setWidth(double newWidth){
        if (newWidth > 0){
            width = newWidth;
        }
    }

    public double getArea(){
        double area = height*width;
        return area;
    }

    public double getPerimeter(){
        double perimeter = 2*height + 2*width;
        return perimeter;
    }

}