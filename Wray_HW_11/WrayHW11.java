/*
 * Jonathan Wray
 * CSCI 195
 * HW 11
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WrayHW11 {     
        public static void main(String[] args) throws IOException {
        String fileName = "Largest Number.txt"; // Name of the text file
        File inputFile = new File(fileName);
        Scanner input = new Scanner(inputFile);
        
        int max = -1; //set max to one below
        
        int value;  // will be used in the loop to read each number
        double sum = 0; // Holds the sum of all of the numbers
        int count = 0; // Coutns how many numbers have been read
        
        while(count<10){
            value = input.nextInt();
            if (max < value){
                max = value;
            }
            count++;
            //for(int i = 0; i < numOfDataItems; i++){
            //number = input.nextInt();
            //number = number + 10;
            //output.println(number);
        }
        input.close();
        
        System.out.println("The Max is " + (max));
    }
}   

        // Open the input file        
        //File inFile = new File(directoryName + "/" + inFileName);
       // Scanner input = new Scanner(inFile);
        
        // Open the output file
        //File outFile = new File(directoryName + "/" + outFileName);
        //PrintWriter output = new PrintWriter(outFile);
        
        // Read the first number from the input file and write it 
        // to the output file.
        //int numOfDataItems = input.nextInt();
        //output.println(numOfDataItems);
        
        // Read the remaining numbers, adding 10 to each and writing
        // the result to the output file.
        //int number;

        //}
        

// Scanner Largest = new Scanner(new File(""));
       //     int max = -1;
        //    int i = 0;
        //    while(Largest.hasNextInt()){
          //       for (int i=1; i < File.length; i++){
          //           if(arr[i] > max){
                //this is a new maximum
           //        max = arr[i];
            //     }
                                         
             //            }
           // }
      //  }
       
            //String line = input.nextLine();
            
            
            
        
        //java.io.File file = new java.io.File("Largest Number.txt");
        //System.out.println("Does it exist? " + file.exists());
        //System.out.println("The file has " + file.length() + " bytes");
        //System.out.println("Can it be read? " + file.canRead());
        //System.out.println("Can it be written? " +file.canWrite());
        //System.out.println("Is it a directory? " + file.isDirectory());
        //System.out.println("Is it a file? " +file.isFile());
        //System.out.println("Is it absolute? " + file.isAbsolute());
        //System.out.println("Is it hidden? " + file.isHidden());
        //System.out.println("Absolute pat is " + file.getAbsolutePath());
        //System.out.println("Last modified on " + new java.util.Date(file.lastModified()));
       // int max = -1;
         //   }
       // }
//}
        //for (int i=1; i < File.length; i++){
         //   if (File[i]>max){
                //this is the new maximum
          //      max = File[i];                    
        //}
          //  System.out.println("The largest number of the file is: " + max);
            //          }
        
       // }
        
        //String line;
            //while (myScanner.hasNextInt()){
                //line = myScanner.nextInt()
            
        //Runtime rt=Runtime.getRuntime();
        //String file="C:\\Users\\John\\Desktop\\Spring 2014\\CSCI_195\\Wray_HW_11\\src\\Number11\\txt.java";
        //Process p=rt.exec("notepad " + file);
        
        //Scanner input = new Scanner("Largest Number.txt");
        //while (input.hasNext()){
         //   String firstName = input.next();
          //  String mi = input.next();
          //  String lastName = input.next();
           // int score = input.nextInt();
          //  System.out.println(
           //     firstName + " " + mi + lastName + " " + score);
       // }
        //Close the file
        //input.close();
        //
        //int[] arr = new int[](1,3,5,7,9,2,4,6,8,10);
        
        //int max = arr[0];
        
        //for(int i = 1; i < arr.length; i++){
        //    if(arr[i] > max){
                //this is a new maximum
         //       max = arr[i];
           // }
        //}
        //system.out.println(Arrays.toSting(arr));
        //}

        
        

       
       //read number from file;
       //max = number;



    
    



