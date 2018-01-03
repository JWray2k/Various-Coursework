
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import java.io.PrintWriter;
import java.util.Arrays;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class WRAY_HW13 {

      
    public static void main(String[] args) throws IOException {
        JFileChooser chooser = new JFileChooser(new File(".ppm"));
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
       
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();

        String fullDirectoryName = f.getCanonicalPath();
        String baseFileName = f.getName();
        String outFileName = f.getName();

        String fullyQualifiedFileName;
        for (int i = 0; i < 10; i++) {
            fullyQualifiedFileName = fullDirectoryName + "/" + baseFileName + "_" + (i + 1) + ".ppm";
            Scanner file = new Scanner(new File(fullyQualifiedFileName));
             
            File outFile = new File(fullDirectoryName + "/" + "HighRes.ppm");
            PrintWriter output = new PrintWriter(outFile);
        
            String P3 = file.nextLine();
            
            
            int size = file.nextInt();
            int fullSize = size * file.nextInt();
            fullSize = fullSize * 3;
            
            int max = file.nextInt();
            
            output.println(P3);
            output.println(size);
            output.println(max);
        
        // Read the remaining numbers, adding 10 to each and writing
        // the result to the output file.
        //int number;
        //for(int i = 0; i < numOfDataItems; i++){
        //    number = input.nextInt();
         //   number = number + 10;
         //  output.println(number);
        //}
            int[] arr = new int[fullSize];

            for(int a = 0; a < arr.length; a++){
                arr[a] = file.nextInt();
            }
            System.out.println("Here are the numbers from the file:");
            System.out.println(Arrays.toString(arr));
            //System.out.println("the total is " + P3 + size + max);
            

            while (file.hasNextLine()) {
                String data = file.nextLine();
                //System.out.println(data);
                //output.println(data);
                String sum = (sum + data);
            }
            file.close();
        }


    }
}