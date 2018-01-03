/**
 * Jonathan Wray
 * CSCI 400
 * HW09 - DFA File I/O
 * 11/16/2015
 */



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;


public class DFA {
    public static void main(String[] args) throws FileNotFoundException {
        //scan the file
        Scanner input = new Scanner(new File("DFA.txt"));
        //read the file
        int numDFA = input.nextInt();
        //loop for amount of dfas
       for (int remainingDFA = 0; remainingDFA < numDFA; remainingDFA++){
            int numberOfStates = input.nextInt();
            int startState;
            int numChar;


            String alphabet = "";
            alphabet = input.next();

            numChar = alphabet.length();            
            
            //created a 2d array with the dimensions numberOfStates x numChar
            int table[][] = new int[numberOfStates][numChar];

            //populates a 2d array containing all accepted states.   
            int column;
            int row;
            for (column=0; column < numberOfStates; column++){
                for (row=0; row < alphabet.length(); row++){
                    table[column][row] += input.nextInt();      
                }
               
        }
            startState = input.nextInt();
            
            int numofacceptStates = input.nextInt();
            
            int acceptState = input.nextInt();
            
            //so what I'm trying to do below is create a Hashtable (works like map in Python)
            //I need to parse through my alphabet first, and then for my first letter of my 
            //alphabet, I have to parse through all of the rows in my first column
            //this will then allow me to assign my values to a such that
            //I will end up with {a:1},{a:2},{a:3} if I were to read in the first input
            //shown in the example for the homework. After reaching the end of column.length,
            //I would then go back into the loop and read in the next letter of my alphabet
            //and then parse throught the values of my next column. In the HW example,
            //my next letter would be "b" and I would end up populating the rest of my
            //Hashtable with {b:0},{b:3}.
            //In the end Hashtable State would contain the key value pairs {a:1},
            //{a:2},{a:3),{b:0},{b:3}.
            
            Hashtable<String, Integer> State = new Hashtable<String, Integer>();
            Scanner Alpha = new Scanner(alphabet);
            while(Alpha.hasNext()){
                String letter = Alpha.nextLine();
                Scanner a = new Scanner(table[i]);
                
                State.put(letter, states);
            }
            //Scanner b = new Scanner(numberOfStates);
            //Scanner c= new Scanner(numChar);
            
            String states = input.nextLine();
            //now I need a for loop here
            //I need to to read in the the strings of characters and compare them
            //to my Hashtable. If the last value ends up landing on an accepted
            //key:value pair, then the state will be accepted. and I will print that
            //out here. If they are rejected, they will be prompted to print "rejected"
            //if the nextline is zzz, then the loop will terminate and I will then have
            //to repeat my initial for loop. This will repeat until
            //remainingDFA = numDFA
          
            
                

            
            
            
            //for alphabet parse < alphabet.length    
                
                
                

                //State[Integer][Integer] nextStates;
                //public int nextState(char letter){
                   //return nextStates.get(Integer.valueOf(letter));
                //}
                
                //int index = alphabet.indexOf(x);
                //int state = table [state][index];
            }
        }
}

//I worked with Chris Bennett on this assignment. The two of us put in a good
//5 hours working on it together. If there are simularities, that is why.