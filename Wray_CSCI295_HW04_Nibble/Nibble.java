/*
 * Jonathan Wray
 * CSCI-295: HW04
 * Sept 11, 2016
 */

/*
HW 04 - Nibble Class

Write an immutable class called Nibble that represents a positive four-bit number. 
The class should only store the four individual bit values as instance variables. 
For this class we are not interested in doing mathematical operations such as addition, 
subtraction, multiplication, division, modulus, etc. We are more interested in exploring bit operations.
 */
public class Nibble {
    private int a0;
    private int a1;
    private int a2;
    private int a3;

/*
Restrictions

Your Nibble class must adhere to the following restrictions: Your class:

May not use any loops, including for, while, do or recursion
May not use any boolean variables
May not use any boolean operators (&&, ||, !, ^)
May not use any bitwise operators (&, |, ~, ^)
May not use any bit shift operators (<<, >>, >>>)
May only use the equality comparison operator (==) and may not use any others (<, <=, >=, >, !=)
May not use any methods from the Integer class
*/
    
/*
Public Interface

The public interface for the Nibble class is described below

Constructors

There should be two constructors:

A default constructor that sets each of the the four bit values to zero.
A constructor that takes an int as a parameter and sets to four bits of the Nibble to the last four bits of the int.

*/
    public Nibble(){
        a3 = a2 = a1 = a0 = 0;
    }

    public Nibble(int x){
        a0 = x%2;
        x = x/2; //this may not work if an odd number is recieved as an input 
        a1 = x%2; //- may need to change x value to an even # -i.e, subtract 1.
        x = x/2;
        a2 = x%2;
        x = x/2;
        a3 = x%2;
    }
    

//Public Methods
        
//The public methods of the Nibble class are described below.

//Logic Operations

//And - Returns a Nibble whose value is (this & otherNibble). The method signature is

public Nibble and(Nibble otherNibble){
    Nibble c = new Nibble();
    c.a3 = and(this.a3, otherNibble.a3);
    c.a2 = and(this.a2, otherNibble.a2);
    c.a1 = and(this.a1, otherNibble.a1);
    c.a0 = and(this.a0, otherNibble.a0);
    return c;
}

//Or - Returns a Nibble whose value is (this | otherNibble). The method signature is

public Nibble or(Nibble otherNibble){
    Nibble c = new Nibble();
    c.a3 = or(this.a3, otherNibble.a3);
    c.a2 = or(this.a2, otherNibble.a2);
    c.a1 = or(this.a1, otherNibble.a1);
    c.a0 = or(this.a0, otherNibble.a0);
    return c;
}

//Not - Returns a Nibble whose value is (~this). The method signature is

public Nibble not(){
    Nibble c = new Nibble();
    c.a3 = not(this.a3);
    c.a2 = not(this.a2);
    c.a1 = not(this.a1);
    c.a0 = not(this.a0);
    return c;
}

//Exclusive Or - Returns a Nibble whose value is (this ^ otherNibble). The method signature is

public Nibble xor(Nibble otherNibble){
    Nibble c = new Nibble();
    c.a3 = xor(this.a3, otherNibble.a3);
    c.a2 = xor(this.a2, otherNibble.a2);
    c.a1 = xor(this.a1, otherNibble.a1);
    c.a0 = xor(this.a0, otherNibble.a0);
    return c;
}

//Shift Operations

//Shift Left Distance 1 - Returns a Nibble whose value is (this << 1). The method signature is

public Nibble shiftLeft(){
    Nibble nib = new Nibble();
    nib.a3 = a2;
    nib.a2 = a1;
    nib.a1 = a0;
    nib.a0 = 0;
    return nib;
}

//Shift Left distance n - Returns a Nibble whose value is (this << n). 
//The shift distance, n, may be negative, in which case this method performs a right shift. The method signature is

public Nibble shiftLeft(int n){
    Nibble nib = new Nibble();
    //need a shiftRight for a negative value.
    if(n==0){
        nib.a3 = a3; //(Nibble with some bit values as This)
        nib.a2 = a2;
        nib.a1 = a1;
        nib.a0 = a0;
    }else if(n==1){
        nib.a3 = a2;
        nib.a2 = a1;
        nib.a1 = a0;
        nib.a0 = 0;
    }else if(n==2){
        nib.a3 = a1;
        nib.a2 = a0;
        nib.a1 = 0;
        nib.a0 = 0;
    }else if(n==3){
        nib.a3 = a0;
        nib.a2 = nib.a1 = nib.a0 = 0;
    }else{
        nib.a3 = nib.a2 = nib.a1 = nib.a0 = 0;
    }
    return nib;
    //include a ShiftRight if IsNegative
}

//Shift Right Distance 1 - Returns a Nibble whose value is (this >> 1). The method signature is
public Nibble shiftRight(){
    Nibble nib = new Nibble();
    nib.a3 = 0;
    nib.a2 = a3;
    nib.a1 = a2;
    nib.a0 = a1;
    return nib;
}

//Shift Left distance n - Returns a Nibble whose value is (this >> n). 
//The shift distance, n, may be negative, in which case this method performs a left shift. The method signature is

public Nibble shiftRight(int n){
    Nibble nib = new Nibble();
    //need a shiftLeft to be engaged with a negative value
    if(n==0){
        nib.a3 = a3;
        nib.a2 = a2;
        nib.a1 = a1;
        nib.a0 = a0;
    }else if(n==1){
        nib.a3 = 0;
        nib.a2 = a3;
        nib.a1 = a2;
        nib.a0 = a1;
    }else if(n==2){
        nib.a3 = 0;
        nib.a2 = 0;
        nib.a1 = a3;
        nib.a0 = a2;
    }else if(n==3){
        nib.a3 = nib.a2 = nib.a1 = 0; 
        nib.a0 = a3;
    }else{
        nib.a3 = nib.a2 = nib.a1 = nib.a0 = 0;
    }
    return nib;
}


//Rotate Operations

//Rotate Left Distance 1 - Returns a Nibble whose value is rotated left a distance of 1. The method signature is

public Nibble rotateLeft(){
    //Nibble otherNibble = new Nibble(b3, b2, b1, b0);
    //what type is a Nibble? (figure this out) - also, you need to figure out
    //the return statement... maybe it's that whole otherNibble thing.
    Nibble nib = new Nibble();
        nib.a3 = a2;
        nib.a2 = a1;
        nib.a1 = a0;
        nib.a0 = a3;
    return nib;
}

//Rotate Left Distance n - Returns a Nibble whose value is rotated left a distance of n. 
//The rotate distance, n, may be negative, in which case this method performs a right rotate. The method signature is

public Nibble rotateLeft(int n){ //there can only be four states... figure out the situations mathematically.
  Nibble nib = new Nibble();
    if(isNegative(n) == true){
        rotateRight(n);
    }else if(n==0){
        nib.a3 = a3;
        nib.a2 = a2;
        nib.a1 = a1;
        nib.a0 = a0;
    }else if(n==1){
        nib.a3 = a2;
        nib.a2 = a1;
        nib.a1 = a0;
        nib.a0 = a3;
    }else if(n==2){
        nib.a3 = a1;
        nib.a2 = a0;
        nib.a1 = a3;
        nib.a0 = a2;
    }else if(n==3){ //needs to be multiples of 3...
        nib.a3 = a0;
        nib.a2 = a3;
        nib.a1 = a2;
        nib.a0 = a1;
    }else if(n%4==1){
        nib.a3 = a3;
        nib.a2 = a2;
        nib.a1 = a1;
        nib.a0 = a0;
    }else if(n%3==1){
        nib.a3 = a0;
        nib.a2 = a3;
        nib.a1 = a2;
        nib.a0 = a1;
    }else if(n%2==1){
        nib.a3 = a1;
        nib.a2 = a0;
        nib.a1 = a3;
        nib.a0 = a2;
    }else if(n%1==1){
        nib.a3 = a2;
        nib.a2 = a1;
        nib.a1 = a0;
        nib.a0 = a3;
    }
    //else{ //need to figure out hoe to accept any integer value for rotate
     //   System.out.println("number is 4 or greater");
    
    return nib;
} //This method isn't being called in the tester....

//Rotate Right Distance 1 - Returns a Nibble whose value is rotated right a distance of 1. The method signature is

public Nibble rotateRight(){
    Nibble nib = new Nibble();
    nib.a3 = a0;
    nib.a2 = a3;
    nib.a1 = a2;
    nib.a0 = a1;
    return nib;
}

//Rotate Right Distance n - Returns a Nibble whose value is rotated right a distance of n. 
//The rotate distance, n, may be negative, in which case this method performs a left rotate. The method signature is

public Nibble rotateRight(int n){
  Nibble nib = new Nibble();
    if(isNegative(n) == true){
        rotateLeft(n);
    }else if(n==0){
        nib.a3 = a3;
        nib.a2 = a2;
        nib.a1 = a1;
        nib.a0 = a0;
    }else if(n==1){
        nib.a3 = a0;
        nib.a2 = a3;
        nib.a1 = a2;
        nib.a0 = a1;
    }else if(n==2){ //maybe making % operator division in decending order...
        nib.a3 = a1;
        nib.a2 = a0;
        nib.a1 = a3;
        nib.a0 = a2; //stays the same for both left and right
    }else if(n==3){ //needs to be multiples of 3...
        nib.a3 = a2;
        nib.a2 = a1;
        nib.a1 = a0;
        nib.a0 = a3;
    }else if(n%4==1){
        nib.a3 = a3;
        nib.a2 = a2;
        nib.a1 = a1;
        nib.a0 = a0;
    }else if(n%3==1){
        nib.a3 = a2;
        nib.a2 = a1;
        nib.a1 = a0;
        nib.a0 = a3;
    }else if(n%2==1){
        nib.a3 = a1;
        nib.a2 = a0;
        nib.a1 = a3;
        nib.a0 = a2;
    }else if(n%1==1){
        nib.a3 = a0;
        nib.a2 = a3;
        nib.a1 = a2;
        nib.a0 = a1;
    }
        //I think I'll need to inclde the helper methods here.
        //leave all of the positions in the Nibble the same.
        //System.out.println("number is 4 or greater");
    return nib;
}//this method isn't being called in the tester

//the below two methods were created because I noticed a flaw in the NibbleGrader.
public Nibble rotateRotate(){
    Nibble nib = new Nibble();
    nib.a3 = a3;
    nib.a2 = a2;
    nib.a1 = a1;
    nib.a0 = a0;
    nib = rotateRight(1);
    return nib;   
}

public Nibble rotateRotate(int n){
    Nibble nib = new Nibble();
    nib.a3 = a3;
    nib.a2 = a2;
    nib.a1 = a1;
    nib.a0 = a0;
    nib = rotateRight(n);
    return nib;   
}
//Other Methods

//Convert to int Value - Converts this Nibble to an int. The method signature is

public int intValue(){
    int result = (a0*1)+(a1*2)+(a2*4)+(a3*8);
    return result;
    
}

//String Representation - Returns a String representation of this Nibble. 
//The string should just contain the four bit values. The method signature is

public String toString(){
    String s = "";
    s += a3;
    s += a2;
    s += a1;
    s += a0;
    return s;
}


    
//below are the helper methods that Dr. Lillis has provided.
 private int and(int x, int y){
        if(x == 0){
            return 0;
        }
        
        if(y == 0){
            return 0;
        }
        
        return 1;
    }

    private int or(int x, int y){
        if(x == 1){
            return 1;
        }
        
        if(y == 1){
            return 1;
        }
        
        return 0;
    }
    
    private int xor(int x, int y){
        if(x == y){
            return 0;
        } else {
            return 1;
        }
    }    
    
    private int not(int x){
        if(x == 0){
            return 1;
        } else {
            return 0;
        }
    }   
    
    private boolean isPositive(int x){
        if(x == 0 || x == -2147483648){
            return false;
        } else {
            return isNegative(-x);
        }
    }
    
    private boolean isNegative(int x){
        if(x == -1){
            return true;
        } else {
            if(x % (x+1) == x){
                return false;
            } else {
                return true;
            }
        }
    } 
}
/* Notes from 9/8/2016:

Nibble n = new Nibble(); (this will contain 4 integers)

x n << 1;
__ __ __ __ <- each of these will contain an int value of - or 1.
b3 b2 b1 b0 - printing nibble results in binary
-> String should contain the 4 bit values
b0 => 0
b1 => 0
b3 => 1
b3 => 1
- this results in 1100, or "1100" in the toString method.

The Nibble objects: (think of them as bit values
This - NibbleA
otherNibble - NibbleB
- A total of 8 bits - This (consisting of 4 bits) and otherNibble (also consisting as 4 bits)
A0 = This.n0
A1 = This.n1
A2 = This.n2
A3 = This.n3
B0 = otherNibble.n0
B1 = otherNibble.n1
B2 = otherNibble.n2
B3 = otherNibble.n3
- then there could be a result (NibbleC)
__ __ __ __
c3 c2 c1 c0 - Result
if(A0==0 && B0==0){
    C0 = 0;
else
    c0 = 1;
(this can't be used because it uses &&)

private methods exist as helper methods (review what Dr. Lillis shared).
- these won't be in the public interface (they are to be used only by the stand-alone program).

Private boolean OR(int p, int q){ (not returning boolean variable, just a boolean type)
    if (p + q == 0){
        return 0;
    }else{
        return 1;
    }
}

-nested if statements are allowed for this assignment

if(OR(A0,B0)){
    C0 = 0;
}else{
    c0 = 1;
- same thing for C1, C2 and C3

-there should be two methods for OR - One is public and the other is private.

***Think about stratigically reusing your methods***

Nibble result - new Nibble();
result.b0 = c0;
result.b1 = c1;....
return result;

-> taking an int variable and using that to set the 4 bits (this'll be difficult)
- int from Binary String(string binString)(
    int n = 0;
    int twoPower = 1;
    int bitValue = 0;
    char bit;
    int len = binString.length();
    
    for (int i = 0; i<len; i++){
        bit = binString.charAt(len-i-1);
        bitValue - Character.digit(bit, 10);
        n += bitValue * twoPower;
        twoPower *= 2;
    }

- As you are shifiting right, pull th 1's and 0's.
b1 = x%2
x = x/2
b2 = 2%2
x = x/2
b3 = x%2

int result = b0*1+b1*2+b2*4+b3*8;
return result;

- if%4 = 1 - rotate 4 positions;
- if n% = 0 - dont change for a rotate

Public Nibble ShiftLeft(int n){
    if(n==0){
        return Nibble (with some bit values as This)
    }else if(n==1){
        b3 = b2;
        b2 = b1;
        b1 = b0;
        b0 = 0;
    }else if(n==2){
        b3 = b1;
        b2 = b0;
        b1 = 0;
        b0 = 0;
    }else if(n==3){
        b3 = b0;
        b2 = b1 = b0 = 0;
    }else{
        b3 = b2 = b1 = b0 = 0;
}
*/