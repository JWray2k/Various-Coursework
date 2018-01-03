/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jw91482
 */
public interface BalanceCheckerInterface {
    
    /**
     * Adds a pair of matching characters. For example '(' matches with ')' and '{' matches with '}'.
     * Parameters:
     * open - An opening character
     * close - The corresponding closing character
     * @param open
     * @param close
     */
    void addPair(Character open, Character close);
    
    
    /**
     * Checks the given string and uses the pairs of symbols previously 
     * added with addPair to see if the string has balanced symbols. 
     * If the string does have balanced symbols, this method returns true, otherwise it returns false.
     * 
     * Parameters: s - The string to be checked for balanced symbols
     * 
     * Returns: true if the string s has balanced symbols, returns false otherwise
     * 
     * @param s
     * @return  true if the string s has balanced symbols, returns false otherwise
     */
    boolean isBalanced(String s);
    
    
    /**
     * Checks to see if the given character has been added as an opening character.
     * 
     * Parameters: c - The symbol to check
     * 
     * Returns: true if the given character has been added as an opening character, returns false otherwise.
     * @param c
     * @return true if the given character has been added as an opening character, returns false otherwise.
     */
    boolean isOpening(Character c);
    
    /**
     * Checks to see if the given character has been added as a closing character.
     * 
     * Parameters: c - The symbol to check
     * 
     * Returns: true if the given character has been added as a closing character, returns false otherwise.
     * @param c
     * @return true if the given character has been added as a closing character, returns false otherwise.
     */
    boolean isClosing(Character c);
    
    
    /**
     * Returns true if the two given characters are a pair of matching characters 
     * that have been previously added with the addPair method.The first symbol 
     * is assumed to be an opening character (this is not checked). The method 
     * returns true if the second character is the closing character that 
     * corresponds to the first.
     * 
     * Parameters:
     * c1 - The first character to check
     * c2 - The second character to check
     * 
     * Returns: true if the symbols are a matching pair that has been previously added with the addPair method.
     * @param c1
     * @param c2
     * @return true if the symbols are a matching pair that has been previously added with the addPair method.
     */
    boolean match(Character c1, Character c2);
       
    
}
