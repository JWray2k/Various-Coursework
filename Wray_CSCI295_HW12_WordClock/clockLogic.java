/*
 * Jonathan Wray
 * CSCI-295 - Object Oriented II
 * HW12 - Word Clock
 * 11/16/2016
 */



/*
HW 12 - Word Clock

I came across this meme a few weeks ago and thought it would make a great 
programming assignment. The assignment is to write a JavaFX application that 
displays time using a clock like the one in the picture. You can run my solution 
by downloading it and double clicking on the downloaded file.

Detailed Requirements

There are a lot of specific requirements, some of which we haven't see how to do 
in class. You'll have to do some research to figure some of it out. You can also 
ask questions in class next week.

1. Your program should run in two separate stages (windows), that are arranged 
one above the other, as shown in the screen shot.
2. The stage for the clock itself (the top one) should have no visible title bar or buttons.
3. The arrangement of the words should be as shown.
4. When the Time Entry window is closed the entire application should terminate (i.e. both stages must be closed).
5. When the program first starts the time should be set randomly and the Random Time button should be selected.
6. You are free to use a font and colors of your choice for the clock. Just make sure it's easy to read.
7. The Show the Time button should display the time that is currently entered in the two text fields.
8. If an invalid time is entered (such as a String like "dog" or a number that isn't a 
valid time) then all of the words should be turned off. You'll have to use exceptions here.
9. The minutes shown in the TextField should always have two digits.
10. The Random Time button should set the time randomly.
11. Like we discussed in class, the time of "Twenty Five" minutes should be used (like in the screen shot).
12. The details about which words go with which minutes are shown below.

------- HW Tips 11/8 ---------

- word Past = new word("Past"); ****
Past.TurnOn();
Past.TurnOff();

- handlers will turn on the correct labels / colors
- reads words from text box
- visit every single word and turn it off
- put in the logic from the text box and turn in what ought to be turned on

- TurnAllOff - for each word in array
    word.turnOff;

- variables / constants

---------------------------

------- HW Tips 11/10 ---------

Words[FIVE[].TurnOn(); ??
Words[5] - index 5
Words[6] - index 6 - there are two 5's

- you can user lables instead of text if you want (but it'll be harder)
- x coorinate - multiply by 4...
    - layout with text may be easier - tex - x,y coordinate
- I think this is what I've been having trouble with - I need to set it up with (x, y, Word);

- you can always ever return 1 thing
    -> if you want to return 2 things, it must be an object.

if(o <= m && m <= 2 || 58 <= m && m <= 59){
    oclock.turnOn();
}elseif{
    //next range....3-7...(     &&      )||(    &&     ){
    five.turnOn();
}
    if(____________) //new if statement
        twenty.TurnOn();
        five.TurnOn();

if              *At some point...

*look at p. 614 - Timeline
    -> also p. 1105 - Case Study: Flashing Text

-------------------------------

11/15:

-------- HW Tips ------------
- wrong input exception - put into handler to throw wrong input exceptions

Systen.out.printf(______, ____, ____, _ _);
                    ^ = Format String
String SMin = String.format("%2d", m, n) - can use this to add decimals

- Can use a Try > Catch around the whole body of If statements to catch an exception that isn't a number.

- look up entering only enabling integers in a text box - also how to limit it.

 */

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class clockLogic extends Application{
    
    @Override
    public void start(Stage buttonStage) {
        
        //The button Stage/Scene's Pane (set to be a Grid Pane)
        GridPane buttonPane = new GridPane();
        buttonPane.setPadding(new Insets(15));
        buttonPane.setHgap(5);
        buttonPane.setVgap(5);
        buttonPane.setAlignment(Pos.CENTER);
        
        //The first stage - set to buttonStage (for handling labels / text fields / buttons
        //Scene scene = new Scene(new Button("Primary Stage Button"), 200, 250);
        buttonStage.setTitle("WordClock");
        Scene buttonScene = new Scene(buttonPane, 400, 200);
        buttonStage.setScene(buttonScene);
        buttonStage.show();
        
        //add a Label for Hour
        buttonPane.add(new Label("Hour "), 0, 0);
        
        //add a textfield for hour entry
        TextField hourField = new TextField();
        buttonPane.add(hourField, 1, 0);
        
        //add a Label for Minute
        buttonPane.add(new Label("Minute "), 0, 1);

        //add a textfield for minute entry //t
        TextField minuteField = new TextField(); //Adrian said that her text fields are private initial constructors - and that they live between
        //your first public class (her's was called ButtonReaderClock extends Application) and a second one. - this way methods you create can access it.
        buttonPane.add(minuteField, 1, 1);
        
        //add a button for determining which GUI words should be on or off - I'll need handlers
        Button calculateButton = new Button("Show The Time");
        buttonPane.add(calculateButton, 1, 2);
        GridPane.setHalignment(calculateButton, HPos.CENTER);       

        //add a button for randomizing which GUI words should be on or off - I'll need to use math.random and a range
            //for the random button, you'll need to assign a math.Random value to h between 1 and 12
            //and then a value for minutes between => 0 and <= 59
        Button randomButton = new Button("RandomTime");
        buttonPane.add(randomButton, 1, 3);
        GridPane.setHalignment(randomButton, HPos.CENTER);

        //for the second words - could use 8 grid pains with showchildren
        //potentially could do VBox or HBox...
        
        //switch statement - case statement...
        
        // Create and register the handler
        //calculateButton.setOnAction(new calculateHandler()); //I need to read in the hours and minute values from the textFields
        //randomButton.setOnAction(new randomHandler()); //I need to set hours and minute value randomly

        //I potentially need an ArrayList up here
        
        //The Word Clock Stage/Scene's Pane (formatted to be flow - so text wrapping happens)
        //I need to adjust the dimenstions and position to make sure my word wrapping is set up properly.
        FlowPane wordClockPane = new FlowPane();
        wordClockPane.setPadding(new Insets(15));
        wordClockPane.setHgap(5);
        wordClockPane.setVgap(5);
        wordClockPane.setAlignment(Pos.CENTER);
        
        //I don't that the stages should be resizable - check the .isResizable() under Stage documentation
        //add a second stage for the word clock - the handlng will need to be done in buttonStage
        Stage wordClock = new Stage();
        Scene wordClockScene = new Scene(wordClockPane, 400, 200);
        wordClock.setScene(wordClockScene);
        //wordClock.setTitle("Other Stage");
        //wordClock.setScene(new Scene(new Button("Other Stage Button"), 400, 100));
        wordClock.show();
        
        //all the Word Objects needed for this program
        Word itIs = new Word("IT IS"); //these need to be added to a pane
        Word half = new Word("HALF");
        Word tenM = new Word("TEN"); //ten associated with minutes
        Word quarter = new Word("QUARTER");
        Word twenty = new Word("TWENTY");
        Word fiveM = new Word("FIVE"); //five associated with minutes
        Word minutesTo = new Word("MINUTES TO");
        Word past = new Word("PAST");
        Word one = new Word("ONE");
        Word two = new Word("THREE");
        Word three = new Word("TWO");
        Word four = new Word("FOUR");
        Word fiveH = new Word("FIVE"); //five associated with hours
        Word six = new Word("SIX");
        Word seven = new Word("SEVEN");
        Word eight = new Word("EIGHT");
        Word nine = new Word("NINE");
        Word tenH = new Word("TEN"); //ten associated with hours
        Word eleven = new Word("ELEVEN");
        Word twelve = new Word("TWELVE");
        Word oClock = new Word("O'CLOCK"); //I need to figure out how to enter in strings as Word(text) objects
        
        
        //Below, I am adding all my created Words to the array - I'll have to parse through it to light it up.
        //ArrayList<Word> wordArray = [itIs, half];
        ArrayList<Word> wordArray = new ArrayList<>(); //does this need to be private? also - should it be in a constructor?
        wordArray.add(itIs);
        wordArray.add(half);
        wordArray.add(tenM);
        wordArray.add(quarter);
        wordArray.add(twenty);
        wordArray.add(fiveM);
        wordArray.add(minutesTo);
        wordArray.add(past);
        wordArray.add(one);
        wordArray.add(three);
        wordArray.add(two);
        wordArray.add(four);
        wordArray.add(fiveH);
        wordArray.add(six);
        wordArray.add(seven);
        wordArray.add(eight);
        wordArray.add(nine);
        wordArray.add(tenH);
        wordArray.add(eleven);
        wordArray.add(twelve);
        wordArray.add(oClock);
        
        //Adrian mentioned that she had some kind of method called AddList which added all of her text values
        //to the list in order she specified by the inded. - She called this method ater settin gher fonts and added them to the pane in the main method.
        
        //for (Word i=0; i<wordArray.length; i++) {
        //    sum = sum + nums[i];
        //}
        
        //potentially usable for creating the labels themselves:
//        public void setMatrix() {
//            for (int i = 0; i < wordArray.length; i++) {
//                for (int j = 0; j < wordArray[i].length; j++) {
//                    label[i][j] = new Label(); // This is missing in the original code
//                    label[i][j].setText("1");
//                    matrix.add(label[i][j], i, j);
//                }
//        }
        
    //I may need a getHour - but if I go off of my GUI logic from waterTemp, I shouldn't need it.
//        public static int getHour{){
//            Integer hour = Integer.valueOf(hourField.getText());
//        }
        
        
        //I need a handler for taking a random number and assigning to both hours and minutes and then entering them into the text field
        //from there, it will need to go ahead and also run the calculateButton action.

        //the handling for button
        calculateButton.setOnAction(e -> { //apparently this works now... I had an issue with brakets.
            Integer hour = Integer.valueOf(hourField.getText()); //I need a get method for hourField
            Integer minute = Integer.valueOf(minuteField.getText()); //I also need a get method for mintueField
            //String waterType = "unspecified";
            
            //need to figure out that if preceeding 0's are entered - the app still recognizes it as being just 1
            if(0 <= hour){
                //I only want to turn off the hour Words if I have a zero, I need an array copy in that case...
                //ArrayList<Word> wordArrayHourRange = Arrays.copyOfRange(wordArray, 8, 19); //doesn't work for ArrayLists...
                wordArray.get(8).turnOff(); //One
                wordArray.get(10).turnOff(); //Two
                wordArray.get(9).turnOff(); //Three
                wordArray.get(11).turnOff(); //Four
                wordArray.get(12).turnOff(); //Five
                wordArray.get(13).turnOff(); //Six
                wordArray.get(14).turnOff(); //Seven
                wordArray.get(15).turnOff(); //Eight
                wordArray.get(16).turnOff(); //Nine
                wordArray.get(17).turnOff(); //Ten
                wordArray.get(18).turnOff(); //Eleven
                wordArray.get(19).turnOff(); //Twelve
                      
            }else if(hour == 1){ //
                wordArray.get(8).turnOn(); //One
                
            }else if(hour == 2){
                wordArray.get(10).turnOn(); //Two
                
            }else if(hour == 3){
                wordArray.get(9).turnOn(); //Three
                
            }else if(hour == 4){
                wordArray.get(11).turnOn(); //Four
                
            }else if(hour == 5){
                wordArray.get(12).turnOn(); //Five
                
            }else if(hour == 6){
                wordArray.get(13).turnOn(); //Six - I don't understand why this can by anonymous
                
            }else if(hour == 7){
                wordArray.get(14).turnOn(); //Seven
                
            }else if(hour == 8){
                wordArray.get(15).turnOn(); //Eight
                
            }else if(hour == 9){
                wordArray.get(16).turnOn(); //Nine
                
            }else if(hour == 10){
                wordArray.get(17).turnOn(); //Ten
                
            }else if(hour == 11){
                wordArray.get(18).turnOn(); //Eleven
                
            }else if(hour == 12){
                wordArray.get(19).turnOn(); //Twelve
                
            }else{
                //for (int i = 0; i < wordArray.length; i++) { - unsure why this doesn't work..
                //wordArray.get(All).turnOff(); //need to work this logic
            }
            //minute.setText(waterType);
            
            //I'll need to make sure this doesn't turn on unless hour is 1-12
            if(0 <= minute && minute <= 2 || 58 <= minute && minute <= 59){ 
                wordArray.get(0).turnOn(); //O'Clock
                
            }else if(3 <= minute && minute <= 7 || 53 <= minute && minute <= 57){ 
                wordArray.get(5).turnOn(); //First Five
                
            }else if(8 <= minute && minute <= 12 || 48 <= minute && minute <= 52){ 
                wordArray.get(2).turnOn(); //First Ten
                
            }else if(13 <= minute && minute <= 17 || 43 <= minute && minute <= 47){ 
                wordArray.get(3).turnOn(); //Quarter
                
            }else if(18 <= minute && minute <= 22 || 38 <= minute && minute <= 42){ 
                wordArray.get(4).turnOn(); //Twenty
                
            }else if(23 <= minute && minute <= 27 || 33 <= minute && minute <= 37){ 
                wordArray.get(4).turnOn(); //Twenty 
                wordArray.get(5).turnOn(); //Five
                
            }else if(28 <= minute && minute <= 30 || 30 <= minute && minute <= 32){ 
                wordArray.get(1).turnOn(); //Half
            }
            
            if(3 <= minute && minute <= 32){ 
                wordArray.get(7).turnOn(); //Past
                
            }else if(33 <= minute && minute <= 57){ 
                wordArray.get(6).turnOn(); //Minutes To
            }
        
        });//end of calculateButton
   

                }


    
        //Word sList = new Word();
        //String [] pricearray =  sList.wordArray(); //you call a method by its name, not return type.
   
    
    public static void main(String[] args) {
        launch(args);
    }

}


//I need to create a new class under Word - it needs to have additional turnOn() and turnOff() methods
class Word extends Text{
    Text word = null;
    
    public Word(){
        word = new Text(); //apparently a text object isn't a string
    }
    
    public Word(Text word){
        this.word = word;
    }
    
    //create an array of words:
    //wordArray = new String[21]; - this array contains 21 items 
    //wordArray[0].turnOn() should call the turn on method for the string IT IS  
    //for each item in the array, I need to format it and put it on a pane (with spacing)
    
    //a string array of all the contents I'll need to have in my class
//    String[] wordArray = {"IT IS", "HALF", "TEN", "QUARTER", "TWENTY", "FIVE", 
//    "MINUTES TO", "PAST", "ONE", "THREE", "TWO", "FOUR", "FIVE", "SIX", "SEVEN",
//    "EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE", "O'CLOCK"};
    
    
    //Adrian created a public void TurnOn(int x, Text y) method - so when her Minite/Hour method was called,
    //it would call (TurnOn, Index of her word, name of her word
    //public void TurnOn(int, Text y){
    //  list.set(x,y).setFont(Font.font("Century Gothic", FontWeight.BOLD, 20));
    //  list.set(x,y).setFill(Color.BLUEVIOLET);
    //}
    
    
    
    
    //TurnOn() must make the text red - should be a handler?
    void turnOn(Text t){ //maybe this isn't working because text hasn't been declared.
        t.setFill(Color.RED); //apparently I can't change text object to paint object w/e that means 
        t.setFont(Font.font("Verdana", FontPosture.ITALIC, 36));
        }
    //- blah, this is literally how the book does it.
    
    //TurnOff() must make the text black - should be a handler?
    void turnOff(Text t){
        t.setFill(Color.DARK_GRAY); //apparently I can't change text object to paint object w/e that means
        t.setFont(Font.font("Verdana", FontPosture.ITALIC, 36));
        }
    
    
    //potentially can be used to add to an array
    /*  Pulled from DataSet 
        public void add(Object x){
        sum += measurer.measure(x);
        if(count == 0 || measurer.measure(x) > measurer.measure(maximum)){
            maximum = x;
        }
        count++;
    }
    */
    
    
    
    /*  //Text from my picture assignment
        // First Text
        Text text1 = new Text(20, 20, "Helvetica is a very nice font");
        text1.setFont(Font.font("Hevetica", FontWeight.BOLD,
                FontPosture.ITALIC, 15));
        pane.getChildren().add(text1);
        
        // Second Text
        Text text2 = new Text(20, 400, "...But Garamond is my favorite");
        text2.setFont(Font.font("Garamond", 15));
        pane.getChildren().add(text2);
            
    */    

    
//on Secondthought ... I dont think that I need to look through an array until I get to my textfield logic
//    public void turnOn(String word){
//        
//        for (String element : wordArray) {
//            System.out.println( element );
//        }//        this.word = word;
//        Text text1 = new Text(20, 20, "Helvetica is a very nice font");
//        text1.setFont(Font.font("Garamond", FontWeight.BOLD,
//                FontPosture.ITALIC, 15));
//        word.setFont(Font.font("Garamond", 15));

    //Netbeans isn't recognizing the turnOn and turnOff that I've made - perhaps it's because they're broken?
    void turnOff() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void turnOn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    
    
}


/*


    ----  minutes  -----
    if(0 <= m && m <= 2 || 58 <= m && m <= 59){
        oclock.turnOn();
    }elseif(3 <= m && m <= 7) || (53 <= m && m <= 57){
        five.turnOn();
    }elseif(8 <= m && m <= 12) || (48 <= m && m <= 52){
        ten.turnOn();
    }elseif(13 <= m && m <= 17) || (43 <= m && m <= 47){
        quater.turnOn();
    }elseif(18 <= m && m <= 22) || (38 <= m && m <= 42){
        twenty.turnOn();
    }elseif(23 <= m && m <= 27) || (33 <= m && m <= 37){
        twenty.turnOn();
        five.turnOn();
    }elseif(28 <= m && m <= 30) || (30 <= m && m <= 32){
        half.turnOn();
    
    if(3 <= m && m <= 32){
        past.turnOn();
    }elseif(33 <= m && m <= 57){
        to.turnOn*();
    }
    
    --- hours ---
    if(h = 1){ //need to figure out that if preceeding 0's are entered - the app still recognizes it as being just 1
        one.turnOn();
    }elseif(h = 2){
        two.turnOn();
    }elseif(h = 3){
        three.turnOn();
    }elseif(h = 4){
        four.turnOn();
    }elseif(h = 5){ //I wonder if i should make it fiveM and fiveH or maybe five1 and five2
        five.turnOn();
    }elseif(h = 6){
        six.turnOn();
    }elseif(h = 7){
        seven.turnOn();
    }elseif(h = 8){
        eight.turnOn();
    }elseif(h = 9){
        nine.turnOn();
    }elseif(h = 10){
        ten.turnOn();
    }elseif(h = 11){
        eleven.turnOn();
    }elseif(h = 12){
        twelve.turnOn();
    }else{
        All.turnOff();
    }
    
    //review hw assignment 11 for figuring out how to set the buttons...
    //Hours text field will be something like:
    pane.add(new Label("Hour "), 0, 0);
    TextField hourValue = new TextField();
    pane.add(hourValue, 1, 0);
    
    //minutes text field will be something like:
    pane.add(new Label("Minute "), 0, 1);
    TextField minuteValue = new TextField();
    pane.add(minuteValue, 1, 1);
    
    //Show the time button will be something like:
    Button showTimeButton = new Button("Show The Time");    
    pane.add(showTimeButton, 2, 1);
    GridPane.setHalignment(showTimeButton, HPos.LEFT);
    
    //show the time button logic:
    showTimeButton.setOnAction(e -> {
            Integer hours = Integer.valueOf(hourValue.getText());
            String waterType = "unspecified";
            if (degrees <= 32){
                waterType = "frozen";
            }
            else if (degrees > 32 && degrees < 212){
                waterType = "liquid";
            }
            else if (degrees >= 212){
                waterType = "boiling";
            }
            result.setText(waterType);
        });
    
    //for the random button, you'll need to assign a math.Random value to h between 1 and 12
    //and then a value for minutes between => 0 and <= 59
    
    
    
    //next range....3-7...(     &&      )||(    &&     ){
    five.turnOn();
}
    if(____________) //new if statement
        twenty.TurnOn();
        five.TurnOn();    
    
    */
    


/*
Hashing out the class notes:

11/1:

private CiclePane circlePane = new CirclePane(); //instance variable
- if a cariable or method is public, any class in a program can access it.

class CiclePane extends stackPane{
- contains a circle along with methods to elarge and shrink the circle
- pricate Circle circle new Circle(50);

public CirclePane(){
    Circle.setStroke
    Circle.setFill
    Circle.SetStrokeWidth(10); //all calling methods within the Application class
    get...

- CirclePane and Hbox(w/buttons) live within the BorderPane

public void enlarge(){
    circle.setRadius(Circle.getRadius()+2);
}

pubic void shrink(){
    double newRadius;
    if(circle.getRadius()>2){
        stuff.....

INNER-CLASS - a class within a class - can see private instance variables
in the outer-c;ass.

EventHandler handler = new EventHandler<Action Event>(){
                            ^ = describing class

public class OuterClass{
    private int x = 1;

    private int getX(){
        return x;
    }

    public void metodInOuterClass(){
    }


OuterClass.InnerClass inner; - calls OuterClass
inner = outer. new InnerClass(); - calls InnerClass

inner...
---------------------

ANONYMOUS:
ArrayList<coin> pause  = new ArrayList<>();

Coin c1 = new coin("Quarter", .25);
     ^ = has a name

Pause.add(c1); - this has a name and isn't anonymous.

Pause.add(new Coin("dime", .1)); - anonymous - make it / use it - all at once.

*Changing instance cariable on the fly - instance of anonymous class

EventHandler handler = new EventHandler<ActionEvent>(){ //no semi-colon
    @Override
    public void handle(ActionEvent e){
        System.out.println("Process New");
    }
}; <-- there is where the semi-colon goes...


LAMBDA EXPRESSIONS:
import java.util.Arrays;
import java.util.List;

Public class Lambdas_1{
}

System.out.println();

System.out.println("With Lambda Expressions ");
people.forEach((person)->System.out.println(person));
- works like a method without a name
    - java figures out the type
        - give parameters and what you want to do.

doSomething(String person){
    System.out.println(person);
}

//using double colon operator

//lambda - for only 1 thing
btPrint.setOnAction(e->System.out.println("ProcessPrint"));

- for more than 1, add brackets
btSae.setOnAction(e->{
    System.out.println("Process Save");
}; - pretty weird way to use brackets / parenthesis

double interest = Doulble.parseDouble(tfAnnualInterestRate.getText());
int year = integer.parseInt(tfNumberOfYears.getTest());
double loanAmount  Dou.....

//diplay monthy playment and table payment
tfMonthyPayment.setText.setText(String.format("$%.2f",


11/8:

-circle object + mouse events for making mac-like class buttons (those red, green, yellow)

-JavaFX application closes when the last stage is closed


------- HW Tips 11/8 ---------

- word Past = new word("Past"); ****
Past.TurnOn();
Past.TurnOff();

- handlers will turn on the correct labels / colors
- reads words from text box
- visit every single word and turn it off
- put in the logic from the text box and turn in what ought to be turned on

- TurnAllOff - for each word in array
    word.turnOff;

- variables / constants

---------------------------

MULTI-THREADED / PARELLEL PROGRAMMING:
- each progeam is running on its own thread
- a single-core program will run just one program at once

-impliment runna ble interface

Thread_1.start;
Thread_2.start;

run method

public class GreetingRunnable implements Runnable{
    public String message; //This will be private

public Greeting Runnable(String message){
    this.message = message;
}

//review notes

public class GreetingThreadTester{
    public static void main(String[] args){
        GreetingRunnable r1 = new GreetingRunnable("Message A");
        GreetingRunnable r2 = new GreetingRunnable("Message B");

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}
...prints the message.... goes to sleep for a second

BangeAccountUnsynchronized

- implements Runnable!

public class DespositRunnable implements Runnable{
    private int delay = 1; // 1 ms

    private BankAccount account;
    private int amount; //Amount of each deposit
    private int count; //Number of deposits

    //constuctor
    public DepositRunnable(BankAccount account, int amount, int count){
        this.amount = amount;
        this.account = account;
        this.count = count;
    }

    @Override
    public void run(){
        try{
            for(int i = 0; i < count; i++){
                account.deposit(amount);
                Thread.sleep(delay);
....check notes...

- need a lock on the BankAccount Class
    -> Atomic Operation -> indivisable -> must happen in total
- Withdraw Runnable - same as deposit runnable
    - just uses a bit of different logic / arithmetic

public class BankAccountThreadTester{
    publi static void main(String[] args){
        BankAccount myAccount = new BankAccount();
        int amount = 100;
        int repetition = 1000;

        DepositRunnable d = new DepositRunnable(myAccount, amount, repetion);
        WithdrawRunnable w = new WithdrawRunnable(myAccount, amount, repetion);
    }
}


11/10:

------- HW Tips 11/10 ---------

Words[FIVE[].TurnOn(); ??
Words[5] - index 5
Words[6] - index 6 - there are two 5's

- you can user lables instead of text if you want (but it'll be harder)
- x coorinate - multiply by 4...
    - layout with text may be easier - tex - x,y coordinate

- you can always ever return 1 thing
    -> if you want to return 2 things, it must be an object.

if(o <= m && m <= 2 || 58 <= m && m <= 59){
    oclock.turnOn();
}elseif{
    //next range....3-7...(     &&      )||(    &&     ){
    five.turnOn();
}
    if(____________) //new if statement
        twenty.TurnOn();
        five.TurnOn();

if              *At some point...

*look at p. 614 - Timeline
    -> also p. 1105 - Case Study: Flashing Text

-------------------------------

11/15:

-------- HW Tips ------------
- wrong input exception - put into handler to throw wrong input exceptions

Systen.out.printf(______, ____, ____, _ _);
                    ^ = Format String
String SMin = String.format("%2d", m, n) - can use this to add decimals

- Can use a Try > Catch around the whole body of If statements to catch an exception that isn't a number.

- look up entering only enabling integers in a text box - also how to limit it.






Book Stuff::

15.11.3 Timeline
PathTransition and FadeTransition define specialized animations. The Timeline
class can be used to program any animation using one or more KeyFrames. Each KeyFrame
is executed sequentially at a specified time interval. Timeline inherits from Animation.
You can construct a Timeline using the constructor new Timeline(KeyFrame...
keyframes). A KeyFrame can be constructed using
new KeyFrame(Duration duration, EventHandler<ActionEvent> onFinished)
The handler onFinished is called when the duration for the key frame is elapsed.
Listing 15.15 gives an example that displays a flashing text, as shown in Figure 15.20. The
text is on and off alternating to animate flashing.

LISTING 15.15 TimelineDemo.java
1 import javafx.animation.Animation;
2 import javafx.application.Application;
3 import javafx.stage.Stage;
4 import javafx.animation.KeyFrame;
5 import javafx.animation.Timeline;
6 import javafx.event.ActionEvent;
7 import javafx.event.EventHandler;
8 import javafx.scene.Scene;
9 import javafx.scene.layout.StackPane;
10 import javafx.scene.paint.Color;
11 import javafx.scene.text.Text;
12 import javafx.util.Duration;
13
14 public class TimelineDemo extends Application {
15 @Override // Override the start method in the Application class
16 public void start(Stage primaryStage) {
17 StackPane pane = new StackPane();
18 Text text = new Text(20, 50, "Programming is fun");
19 text.setFill(Color.RED);
20 pane.getChildren().add(text); // Place text into the stack pane
21
22 // Create a handler for changing text
23 EventHandler<ActionEvent> eventHandler = e -> {
24 if (text.getText().length() != 0) {
25 text.setText("");
26 }
27 else {
28 text.setText("Programming is fun");
29 }
30 };
31
32 // Create an animation for alternating text
33 Timeline animation = new Timeline(
34 new KeyFrame(Duration.millis(500), eventHandler));
35 animation.setCycleCount(Timeline.INDEFINITE);
36 animation.play(); // Start animation
37
38 // Pause and resume animation
39 text.setOnMouseClicked(e -> {
40 if (animation.getStatus() == Animation.Status.PAUSED) {
41 animation.play();
42 }
43 else {
44 animation.pause();
45 }
46 });
47
48 // Create a scene and place it in the stage
49 Scene scene = new Scene(pane, 250, 250);
50 primaryStage.setTitle("TimelineDemo"); // Set the stage title
51 primaryStage.setScene(scene); // Place the scene in the stage
52 primaryStage.show(); // Display the stage
53 }
54 }

FIGURE 15.20 The handler is called to set the text to Programming is fun or empty in turn.

The program creates a stack pane (line 17) and a text (line 18) and places the text into the pane
(line 20). A handler is created to change the text to empty (lines 24–26) if it is not empty or
to Progrmming is fun if it is empty (lines 27–29). A KeyFrame is created to run an action
event in every half second (line 34). A Timeline animation is created to contain a key frame
(lines 33 and 34). The animation is set to run indefinitely (line 35).
The mouse clicked event is set for the text (lines 39–46). A mouse click on the text resumes
the animation if the animation is paused (lines 40–42), and a mouse click on the text pauses
the animation if the animation is running (lines 43–45).
In Section 14.12, Case Study: The ClockPane Class, you drew a clock to show the current
time. The clock does not tick after it is displayed. What can you do to make the clock display a
new current time every second? The key to making the clock tick is to repaint it every second
with a new current time. You can use a Timeline to control the repainting of the clock with
the code in Listing 15.16. The sample run of the program is shown in Figure 15.21.

LISTING 15.16 ClockAnimation.java
1 import javafx.application.Application;
2 import javafx.stage.Stage;
3 import javafx.animation.KeyFrame;
4 import javafx.animation.Timeline;
5 import javafx.event.ActionEvent;
6 import javafx.event.EventHandler;
7 import javafx.scene.Scene;
8 import javafx.util.Duration;
9
10 public class ClockAnimation extends Application {
11 @Override // Override the start method in the Application class
12 public void start(Stage primaryStage) {
13 ClockPane clock = new ClockPane(); // Create a clock
14
15 // Create a handler for animation
16 EventHandler<ActionEvent> eventHandler = e -> {
17 clock.setCurrentTime(); // Set a new clock time
18 };
19
20 // Create an animation for a running clock
21 Timeline animation = new Timeline(
create a clock
create a handler
create a time line

create a key frame
set cycle count indefinite
play animation
22 new KeyFrame(Duration.millis(1000), eventHandler));
23 animation.setCycleCount(Timeline.INDEFINITE);
24 animation.play(); // Start animation
25
26 // Create a scene and place it in the stage
27 Scene scene = new Scene(clock, 250, 50);
28 primaryStage.setTitle("ClockAnimation"); // Set the stage title
29 primaryStage.setScene(scene); // Place the scene in the stage
30 primaryStage.show(); // Display the stage
31 }
32 }

FIGURE 15.21 A live clock is displayed in the window.
The program creates an instance clock of ClockPane for displaying a clock (line 13).
The ClockPane class is defined in Listing 14.21. The clock is placed in the scene in line 27.
An event handler is created for setting the current time in the clock (lines 16–18). This handler
is called every second in the key frame in the time line animation (lines 21–24). So the clock
time is updated every second in the animation.

2. The handler object’s class must implement the corresponding event-handler interface.
JavaFX provides a handler interface EventHandler<T extends Event> for every
event class T. The handler interface contains the handle(T e) method for handling
event e.

3. The handler object must be registered by the source object. Registration methods
depend on the event type. For an action event, the method is setOnAction. For a
mouse-pressed event, the method is setOnMousePressed. For a key-pressed event,
the method is setOnKeyPressed.

4. An inner class, or nested class, is defined within the scope of another class. An inner
class can reference the data and methods defined in the outer class in which it nests, so
you need not pass the reference of the outer class to the constructor of the inner class.

5. An anonymous inner class can be used to shorten the code for event handling. Furthermore,
a lambda expression can be used to greatly simplify the event-handling code for
functional interface handlers.


30.5 Case Study: Flashing Text
You can use a thread to control an animation.
The use of a Timeline object to control animations was introduced in Section 15.11, Animation.
Alternatively, you can also use a thread to control animation. Listing 30.2 gives an
example that displays flashing text on a label, as shown in Figure 30.6.
Key
Point
FIGURE 30.6 The text “Welcome” blinks.
LISTING 30.2 FlashText.java
1 import javafx.application.Application;
2 import javafx.application.Platform;
3 import javafx.scene.Scene;
4 import javafx.scene.control.Label;
5 import javafx.scene.layout.StackPane;
6 import javafx.stage.Stage;
7
8 public class FlashText extends Application {
9 private String text = "";
10
11 @Override // Override the start method in the Application class
12 public void start(Stage primaryStage) {
13 StackPane pane = new StackPane();
14 Label lblText = new Label("Programming is fun");
15 pane.getChildren().add(lblText);
16
17 new Thread(new Runnable() {
18 @Override
19 public void run() {
20 try {
21 while (true) {
22 if (lblText.getText().trim().length() == 0)
23 text = "Welcome";
24 else
25 text = "";
26
27 Platform.runLater(new Runnable() { // Run from JavaFX GUI
28 @Override
29 public void run() {
30 lblText.setText(text);
31 }
32 });
33
34 Thread.sleep(200);
35 }
36 }
37 catch (InterruptedException ex) {
38 }
39 }
40 }).start();
41
create a label
label in a pane
create a thread
run thread
change text
Platform.runLater
update GUI
sleep
42 // Create a scene and place it in the stage
43 Scene scene = new Scene(pane, 200, 50);
44 primaryStage.setTitle("FlashText"); // Set the stage title
45 primaryStage.setScene(scene); // Place the scene in the stage
46 primaryStage.show(); // Display the stage
47 }
48 }
The program creates a Runnable object in an anonymous inner class (lines 17–40). This
object is started in line 40 and runs continuously to change the text in the label. It sets a text
in the label if the label is blank (line 23) and sets its text blank (line 25) if the label has a text.
The text is set and unset to simulate a flashing effect.
JavaFX GUI is run from the JavaFX application thread. The flashing control is run from
a separate thread. The code in a nonapplication thread cannot update GUI in the application
thread. To update the text in the label, a new Runnable object is created in lines 27–32.
Invoking Platform.runLater(Runnable r) tells the system to run this Runnable object
in the application thread.

The anonymous inner classes in this program can be simplifed using lambda expressions
as follows:

new Thread(() -> { // lambda expression
    try {
        while (true) {
            if (lblText.getText().trim().length() == 0)
                text = "Welcome";
            else
                text = "";
            Platform.runLater(() -> lblText.setText(text)); // lambda exp
            Thread.sleep(200);
        }
    }
    catch (InterruptedException ex) {
    }
}).start();


*/