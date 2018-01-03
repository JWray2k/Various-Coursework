
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Jonathan Wray
 * CSCI310 - HW09 - Word Ladder Game
 * 5/3/2017

HW 09 - Word Ladder Game
http://cis4.sau.edu/lillis/csci310/2016Spring/assignments/hw09_ladder-game/hw09_ladder-game.html

Ammendment

Here is my StringGraph.java class from homework assignment 08. If you wish, you 
may use this class as a starting point for this assignment.

Original Assignment

This assignment differs from the previous graph assignments. In this assignment 
you will not be modifying your StringGraph class. Instead, you will be using 
that class to write a program.

A Word Ladder consists of a starting word and and ending word that are connected 
by a "ladder" between the two words. A ladder is a sequence of words that starts 
at the starting word, ends at the ending word, and each word in the sequence 
(except the first) is obtained from the previous word by changing a letter in a 
single position. For example, suppose the starting word is braid and the ending 
word is clown, then a ladder between these two words is: braid, brain, brawn, 
brown, blown, clown.

In this assignment you will use the StringGraph class you wrote for HW 08 to 
construct a graph in which each vertex is a word and there is an edge between two 
words if they differ in exactly one position. Here is a file called words.txt that 
contains 5757 five letter English words. These are the words you should use for 
this assignment. Your program should prompt for two five-letter words and then 
display the word ladder starting from the first word and ending at the second 
word. Your program should check the input and act accordingly. The sample runs 
below provide additional details.

Output

The output of your program should match the sample runs. This includes the 
prompts, the quotes around the words, the indentation of the words in the ladder, 
the error messages, etc.

 */

public class WordLadder { //I can't use extends for my string graph... how the heck can I use ladder.shortestPath?
    //create StringGraph ladder - need to use this for StringGraph methods
    StringGraph ladder = new StringGraph(5757);
    public String[] data;
   
    
    //Constructs the Wordladder
    public WordLadder() throws FileNotFoundException, IOException{
    
    
    
    
    //read from the file and put iit into an araylist - this way, you can read just one at a time.
    ArrayList<String> list;
        try (Scanner s = new Scanner(new File("words.txt"))) {
            list = new ArrayList<String>();
            while (s.hasNext()) {
                list.add(s.next());
            }
        }


    //If you want to convert to a String[] - you must use toArray[String]
    data = list.toArray(new String[]{});
    
    //add Verticies to the string graph.
    for(int i = 0; i <= data.length-1; i++){
        ladder.addVertex(data[i]); // I can probably read this straight in during the constructor
    }
        
    //create a character array to compare words against one another...
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray(); //http://stackoverflow.com/questions/17575840/better-way-to-generate-array-of-all-letters-in-the-alphabet
       
        
        //using the array data instead of ladder.labels because labels is a private array. Both addVertex and addEdge still manipulate the StringGraph though.
    for(int i = 0; i <= data.length-1; i++){

            //for now I need to use this String... for the sake of add edge... but I wonder if I could change that...
            String tempWordString = data[i]; 

            //using stringBuilder for the sake of changing a single Char
            StringBuilder tempWord = new StringBuilder(data[i]); 

            //this keeps me from having to parse the entire array of data... it'll save a lot of time once I get closer to the end of the file.
            int count = i; 

            //parses through the temp word one character at a time
            for(int j = 0; j <= 4; j++){ 

                //set up an exclusion so the same word doesn't make an edge with itself.
                String exclusion = tempWordString;

                //this is changing a single letter at a time... this could perhaps be more efficient... how could I just compare the words for one letter difference?
                for(int a = 0; a <= alphabet.length-1; a++){ 

                    //sets the temp words character to the current indext of the alphabet array
                    tempWord.setCharAt(j, alphabet[a]);  //this isn't what I'm comparing against at the moment

                    //casting the StringBuilder to my tempWordString variable with the set alphabet letter
                    tempWordString = tempWord.toString();

                    //now that my temp word has been adjusted, it will compare itself to all the other words in the data array (starting from count)
                    for(int w = count; w <= data.length-1; w++){ 

                        //If the tempWordString equals my current data index, but is not the same as the exclusion case, it will proceed to add an edge
                        if(tempWordString.equals(data[i]) && !tempWordString.equals(exclusion)){ 

                            //adding this edge should alter the the data structure (string graph) - labels
                            ladder.addEdge(tempWordString, data[i]); 
                        }
                }
            } //this currently runs 5757 x 5 x 26 x 5757(-count) times... not to mention the IF statement
        } 

    }

}



    //main method - this is important
public static void main(String[] args) throws IOException{ 

    WordLadder fiveLetter = new WordLadder();

    
    String[] inputWords = new String[2];
    

     Scanner s = new Scanner(System.in);
     for(int i = 0; i < inputWords.length; i++) { //why is i coming up weirdly? I think this needs to be a method call
        System.out.print("Enter a five letter word: ");
        boolean success = false;
        while (!success) {
            try {
                String temp = s.next();
                System.out.println("You entered " + temp);
                if(fiveLetter.ladder.vertexExists(temp)){
                    success = true;
                    inputWords[i] = temp;
                    inputWords[i] = inputWords[i].toLowerCase();
                }
            } catch (InputMismatchException e) { //http://www.javawithus.com/tutorial/exception-handling
                s.next();
                System.out.println("You have entered invalid data");
            }
        }
    }
    //String[] wordLadder = new String[100];
    //wordLadder = 
    
    String[] res = fiveLetter.ladder.shortestPath(inputWords[0], inputWords[1]); 
    for(String str : res)
        System.out.println(str);  //Will print the strings in the array that
                                 //was returned from the method demo()
    //got super stuf on this this .shortestPath method call - referenced http://stackoverflow.com/questions/15360170/returning-string-array-to-the-method-and-print-returned-array

    System.out.println(fiveLetter.data.length);
    System.out.println(inputWords[0]);
    System.out.println(inputWords[1]);

//    for(int l = 0; l <= wordLadder.length-1; l++){
//        System.out.println(wordLadder[l]);
//    }
//    
//    System.out.println(wordLadder.length);


}

    //user input
//    Scanner scanner = new Scanner(System.in);
//    String input = scanner.nextLine();//get the next input line
//    scanner.close();
//    String value = null;
//    try
//    {
//        value = String.valueOf(input); //if value cannot be parsed, a NumberFormatException will be thrown
//    }
//    catch (final NumberFormatException e)
//    {
//        System.out.println("Please enter an integer");
//    }
//
//
//    if(value != null)//check if value has been parsed or not
//    {
//        //do something with the integer
//
//    }
    

    
//        System.out.println("Enter a five letter word: ");
//        String input = sc.nextLine();
//        
//        try{
//            if (input.length() == 5) {
//                inputWords[i] = sc.next();
//                inputWords[i] = inputWords[i].toLowerCase(); //I need to set the user input to lower case to compare against my word ladder...
//            
//            } else {
//                throw new StringTooLongException("'" + input + "' is longer than 20");
//    }
//} catch(StringTooLongException e){
//    System.out.println ("Exceeds string length: " + input);
//}
//        try{
//        if (input.next().length() != 5){
//            throw new illegal arument exception("The entered word does not contain 5 letters"); //not sure I need this connectionCount thing...
//        }
//        else if(input.next() != String){
//                    toClient.print("Your guess is too low.\n");
//                    toClient.flush();
//                }
//                else if(guess > secretNumber){
//                    toClient.print("Your guess is too high.\n");
//                    toClient.flush();
//                }
//        
//    }

    //my string graph is final... how the heck do I get a the shortestPath method to work?
    //static and non-static conflict is happening here

    //I have to first construct my WordLadder (fiveLetter) and then I will reference the StringGraph (ladder) to get to the shortestPath there...
    
/*
    okay... so for starters, I need to read in words.txt and each word needs to
    be set up as a vertex. My labels array should consist of 5757 five letter words.
    I then need to parse through the list and construct a graph based on each word.
    
    I will construct the graph's edges - nodes will only connect if they are only
    a single letter different (bingo and dingo), (penny and punny)... this requires
    me to parse through my graph with something like the handshaking lemma I think...
    
    I need to figure out the most efficient way to ensure I've checked every possible
    connection. My adjacency matrix will be 5757 x 5757... that's a ton... keep in mind
    that if you figure out just the first word... you should be able to handle all of
    the rest with the same code.... one bite at a time.
    
    Okay... right now, I'm thinking that I should take 4 letters and parse through the
    whole text file for any words that contain those 4 letters (in those index locations)
    and then hold them all in an array that I'll parse through and compare them against my
    labels array / adjaceny matrix and make those connections.
    
    I'd like to be able to remove the words from the text file after finding all of the
    links, but I think that I could have exceptions to the rule... brain will be used against
    train, but also brain would also be connected to braid... so in this case, I can't
    reduce how many words I have to parse through my matching elements... but I could do it
    based on finding all words matching the initial comparitor... that's what I'll do.
    
    
    When I get a word from the user input... I will perform a depth first search
    using the method provided by Dr. Lillis called dfsOrder(String v)**
    
    I need to understand the isConnected() method call... I may need to throw exceptions based on this
    
    Investigate the difference of depth first search vs breadth first search...
    
    I have no idea what bfsSSSP(String v) does... look into it more - Perform BFS Single Source Shortest Path from specified vertex.
    - I think that I need this to step through the graph for my outputs... look again later... it takes just one...
    
    ShortestPath() method takes both the first and second word... I will have to use 
    this one in order to run my program - this is needed for the input / output...
    This method also calls bfsSSSP(s)... so it's possible that I won't need to call
    that one independently.
    
    
    There's a method for inputting an index for a vertex... and it will return all
    of the indecies of neighbors... not entirely sure where this is useful.
    
    What Dr. Lillis did with Degree stats is incredibly interesting... rather than
    what I did where I made three other method calls within my degree stats.
    I've also never return statements - in order to return NaN, he also wrote Double.NaN...
    He does make a call to the degreeSequence() method in order to populate the new array for stats

    New thoughts - once I've parsed through each of my words... I've figured out any possible word that can be connected to it,
    so I shouldn't be parsing again through the word array... I need to remove 1 word at a time, and not have it parsed.

    as I compare, I need to use the getNeighbors method call somehow...
    maybe I need to use getNeighbotsIndex also... this would return the index of where the new word is located


    I need to make a method call to the shortestPath() function... it will return a list of strings which
    I can then print off in a statement with \n to separate the lines.

    hmm... apparently labels is private... how to I compare my worlds in my file then?
    labels needs changed - need to create an exlusion using my exclusion char...
    hmm... so I've set the exclusion... now should I set the char i index equal to a new array of letters from the alphabet

    char tempChar = alphabet[a];
    tempWord.charAt(j) = tempChar; //changing the temp word's letter - I may have to concattonate instead...
    }
    for(ladder.labels[i]){ //ladder.labels[i] is my temp word - actually, I don't need this for loop
    
    Review the following in the method of arraySequence (it's very much like using a stack...
                    degrees[v] += edgeMatrix[v][i] ? 1 : 0; //this has me a tad confused - what's the ? mark for... also review ranges
            }
        }

        Arrays.sort(degrees);

        // reverse becasue degre sequence needs to be in descending order
        int left = 0;
        int right = degrees.length - 1;
        int temp;
        while (left < right) {
            // exchange the left and right elements
            temp = degrees[left];
            degrees[left] = degrees[right];
            degrees[right] = temp;

            // move the bounds toward the center
            left++;
            right--;
        }
    
    Dr. Lillis's getNeighbors(String V) method makes the following call: this.getNeighborIndices(source)... this is in order
    to figure out where his indicies are located... it makes total sense...
    
    Understand why you have to do this twice... shouldn't it be the same? - draw it out
        edgeMatrix[i][j] = false;
        edgeMatrix[j][i] = false;
    ... oh i get it... for example, lets say i = b, and j = d
        a    b    c    d    e
    a [   ][   ][   ][   ][   ]
    b [   ][   ][   ][ f ][   ]
    c [   ][   ][   ][   ][   ]
    d [   ][ f ][   ][   ][   ]
    e [   ][   ][   ][   ][   ] - there are two locations that have that same intersection... (think points and lines)
    
    review both increase and decrease capacity.
    
    
    Handshaking Lemma tutorial (finding the degrees - https://www.youtube.com/watch?v=_K9piQoqQYY
    
    Not equals opperator - the ! needs to go at the beginning of the called method/variable - http://stackoverflow.com/questions/8365630/how-can-i-express-that-two-values-are-not-equal-to-eachother

    Multiple Conditions in a single IF statement

    Iterate through String array in java - http://stackoverflow.com/questions/6707695/iterate-through-string-array-in-java

    Excluding certain elements - http://stackoverflow.com/questions/6075894/how-to-exclude-certain-elements-from-a-list

    Exception Handling - http://www.javawithus.com/tutorial/exception-handling

    Ignoring cases - http://stackoverflow.com/questions/26997164/ignoring-upper-case-and-lower-case-in-java

    String Input Statement - http://stackoverflow.com/questions/22002412/using-string-name-input-next-then-making-an-if-statement

    Exception Handling - http://www.javawithus.com/tutorial/exception-handling

    Try / Catch in Java - http://beginnersbook.com/2013/04/try-catch-in-java/

    Reading a File into an Array List - http://stackoverflow.com/questions/5343689/java-reading-a-file-into-an-arraylist

    Java File IO - https://www.tutorialspoint.com/java/java_files_io.htm

    Path of Text File - http://stackoverflow.com/questions/17631111/netbeans-java-project-path-of-text-file

    Printing an array from method call - http://stackoverflow.com/questions/15360170/returning-string-array-to-the-method-and-print-returned-array

    public static void findPatient()
    {
        System.out.print("Enter part of the patient name: ");
        String name = sc.nextLine();

        System.out.print(myPatientList.showPatients(name));
    }


    //the other class
    ArrayList<String> patientList;

    public void showPatients(String name)
    {
        boolean match = false;

        for(matchingname : patientList)
        {
            if (matchingname.toLowerCase.contains(name.toLowerCase())) {
                match = true;
            }
        }
    }
    
    StringBilder toString() - https://www.tutorialspoint.com/java/lang/stringbuilder_tostring.htm
    
    */


    
}

//    
//    BufferedReader abc = new BufferedReader(new FileReader("words.txt")); //this may need to be moved to the constructor
//    List<String> lines = new ArrayList<String>();
//
//    
//    while((String line = abc.readLine()) != null){
//        lines.add(line);
//        //System.out.println(data);
//    }
//    abc.close();  
        
        //initial word - the word I'm starting with before I parse through the rest of the array
        //I'll need to parse through each character of the initial word and compare it to the word array
        //after I complete the word fully, I should remove it from futher compares
        
        //temp word
        
        
        //char temp = data[i].charAt(j); //I need syntax similar to this... I have to parse through the array of words... then parse
        //through the characters of each word and compare them to the initial word
 //I wonder if I must consider capital letter... actually... the txt file is all lower case... make an exception to take no capitals.
        
        
        //so after thinking about this more... I don't really want to use an array for my initial 5757 words I am comparing... i want both an array of words
        //(because I still need to parse through them), and I want a queue or stack... where I can pop or dequeue... actually... I would be parsing through my array still
        //I need to just parse through array[i] index to array[array.length-1] index... that's how I have to do it... not by removing... just changing what I parse...