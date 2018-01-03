/*
 * Jonathan Wray
 * CSCI-295 - Object Oriented II
 * HW11 - WaterType GUI
 * 11/5/2016
 */


/*
Write a program that prompts the use to enter the temperature of water and then 
prints one of the following three messages based on the temperature entered:

The water is frozen.
The water is liquid.
The water is boiling.


Sample Runs


Enter water temp in degrees F: 15
The water is frozen.


Enter water temp in degrees F: 32
The water is frozen.


Enter water temp in degrees F: 99
The water is liquid.



Enter water temp in degrees F: 200
The water is liquid.



Enter water temp in degrees F: 212
The water is boiling.



Enter water temp in degrees F: 300
The water is boiling.

 */

/**
 *
 * @author jw91482
 */
import java.util.Scanner;

//public class waterTemp {
//
//    public static void main(String[] args) {
//        
//       Scanner user_input = new Scanner( System.in ); 
//       
//        int degrees;
//        String waterType =  null;
//        
//       System.out.print("Enter water temp in degrees F: ");
//        degrees = user_input.nextInt();
//        
//        if (degrees <= 32){
//            waterType = "frozen";
//            //System.out.println("The waster is " + waterType + ".");
//        }
//        
//        else if (degrees > 32 && degrees < 212){
//            waterType = "liquid";
//            //System.out.println("The waster is " + waterType);
//        }
//        
//        else if (degrees >= 212){
//            waterType = "boiling";
//            //System.out.println("The waster is " + waterType);
//        }
//        
//        System.out.println("The water is " + waterType + ".");
//        
//    }
//}

public class waterTemp{
int degrees;
String waterType = "unspecified";

Scanner user_input = new Scanner( System.in );

    // Constructors
    public waterTemp(){
        degrees = 0;
    }

    public waterTemp(int degrees){
        degrees = user_input.nextInt();
        if (degrees <= 32){
            waterType = "frozen";
            //System.out.println("The waster is " + waterType + ".");
        }
        
        else if (degrees > 32 && degrees < 212){
            waterType = "liquid";
            //System.out.println("The waster is " + waterType);
        }
        
        else if (degrees >= 212){
            waterType = "boiling";
            //System.out.println("The waster is " + waterType);
        }
        
        System.out.println("The water is " + waterType + ".");
    }

        public void setDegrees(int newTemp){
            //System.out.print("Enter water temp in degrees F: ");
            //newTemp = user_input.nextInt();
            degrees = newTemp;
        }
    

    public int getDegrees(){
        return degrees;
    }

    public String getWaterType(){
        if (degrees <= 32){
            waterType = "frozen";
            //System.out.println("The waster is " + waterType + ".");
        }
        
        else if (degrees > 32 && degrees < 212){
            waterType = "liquid";
            //System.out.println("The waster is " + waterType);
        }
        
        else if (degrees >= 212){
            waterType = "boiling";
            //System.out.println("The waster is " + waterType);
        }

        return waterType;
    }
}

