
import java.util.ArrayList;

/*
 * Jonathan Wray
 * CSCI310 - HW 05 - Balanced Symbols
 * 2/23/2017
 */

/**
 *
 * @author jw91482
 */
public class BalanceChecker implements BalanceCheckerInterface {
    
    private char open;
    private char close;
    
    char validOpenSymbol[] = {'(', '{', '<', '['}; //need to make a string or arrayList to parse through
    char validCloseSymbol[] = {')', '}', '>', ']'}; //need to make a string or arrayList to parse through 
    
    ArrayList<Character> openSymbol;
    ArrayList<Character> closeSymbol;
    
    
    //Constructs a new BalanceChecker with empty lists for opening and closing characters.
    public BalanceChecker(){
        openSymbol = new ArrayList<>();
        closeSymbol = new ArrayList<>();
    }

    //Adds a pair of matching characters. For example '(' matches with ')' and '{' matches with '}'.
    @Override
    public void addPair(Character open, Character close) {
        int index;
//        if(open not in validOpenSybol || close not in validCloseSymbol)
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for (int i = 0; i < validOpenSymbol.length; i++) {
            if (validOpenSymbol[i] == open) {
                index = i;
                break;
            }          
            if (validCloseSymbol[i] == close) {
                openSymbol.add(open);
                closeSymbol.add(close);
                break;
            }
        }
    }
    

    //Checks the given string and uses the pairs of symbols previously added with addPair to see if the string has balanced symbols. 
    //If the string does have balanced symbols, this method returns true, otherwise it returns false.
    @Override
    public boolean isBalanced(String s) {
        //create stack here
        for (char ch : s.toCharArray()){
                if(openSymbol.indexOf(ch) >= 0){ //need to parse through the openSymbol Array of string objects - opensymbol(i)
                    //build out push logic here
                    push(ch); //pushes character into stack (created by LinkedStack)?
                } else if (closeSymbol.indexOf(ch) >= 0){ //need to parse through the closeSymbol array of string objects closesymbol(i)
                    //instead of isEmpty() - check size of stack created
                    if (isEmpty()){ //checks stack for isEmpty() (created by LinkedStack)?
                        System.out.println("Stack is empty.");
                        return false;
                    }else{
                        //create logic for pop here
                        p = pop(); //pops character into stack (created by LinkedStack?
                        if (p != ch){ //wrong thing in top of stack
                            System.out.println("Not a supported character.");
                            return false;
                        }
                    }
                }
            //check to see if anything is still in our stack - use a .length or .size()
            if (!isEmpty()){ //if the stack has anything left over once done
                System.out.println("The string is not empty - not balanced.");
                return false;
            }
        }
        return true;
    }

    //Checks to see if the given character has been added as an opening character.
    @Override
    public boolean isOpening(Character c) {
//        if(openSymbol[i] >= 0)){ //need to parse through the openSymbol array
//            return true;

    int elementsCount = openSymbol.size();

        for (int i = 0; i < elementsCount; i++) {
         //for (char ch : openSymbol.toCharArray()){
            if(openSymbol.indexOf(i) == c) {
                return true;
            }
        }
        return false;
    }

    //Checks to see if the given character has been added as a closing character.
    @Override
    public boolean isClosing(Character c) {     
   
        int elementsCount = closeSymbol.size();

        for (int i = 0; i < elementsCount; i++) {
         //for (char ch : openSymbol.toCharArray()){
            if(closeSymbol.indexOf(i) == c) {
                return true;
            } 
        }
        return false;
    }

    
    //Returns true if the two given characters are a pair of matching characters that have been previously 
    //added with the addPair method. The first symbol is assumed to be an opening character (this is not checked). 
    //The method returns true if the second character is the closing character that corresponds to the first.
    @Override
    public boolean match(Character c1, Character c2) {
        int index = openSymbol.indexOf(c1);
        Character ch = closeSymbol.get(index);
        return close == ch;
    }
    
}
