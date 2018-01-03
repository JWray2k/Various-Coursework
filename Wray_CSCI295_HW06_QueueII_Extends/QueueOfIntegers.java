/*
 * Jonathan Wray
 * CSCI295 - HW06 - Queue II - Extends
 * 9/23/2016
 */

/*
HW 06 - Queue II

For this assignment you are to repeat HW 05, only this time your class should 
extend ArrayList<Integer> as well as implement MyQueOfIntegers. That means your 
class definition will be public class QueueOfIntegers extends ArrayList<Integer> 
implements MyQueueOfIntegers. Here is my solution for HW 05. The interface and 
the tester are the same. Below is a link to each.

MyQueueOfIntegers.java — The interface
QueueTester.java — The tester

This uses solution to the QueueOfIntegers provided by Dr. Lillis
*/


import java.util.ArrayList;

public class QueueOfIntegers extends ArrayList<Integer> implements MyQueueOfIntegers {
    //private ArrayList<Integer> list; - I shouldn't need any instance variables.
    
    public QueueOfIntegers(){
        //list = new ArrayList<>(); - need to call default super constructor.
        super();
    }
//I went through the below and changed anything that referenced list and replaced it with super.
    
    @Override
    public Integer dequeue() {
        if(super.size() == 0){
            return null;
        } else {
            return super.remove(0);
        }
    }

    @Override
    public void enqueue(Integer element) {
        super.add(element);
    }

    @Override
    public Integer front() {
        if(super.size() == 0){
            return null;
        } else {
            return super.get(0);
        }
    }
//these two should be found in ArrayList<>() - the tester should find them in the superclass.
   /*
    public boolean isEmpty() {
        return super.isEmpty();
    }

 
    public int size() {
        return super.size();
    }
*/
    @Override
    public String toString(){
        String s = "Front ";
        s = s + super.toString();
        s = s + " Rear";
        
        return s;
    }
}

/*
Notes from 9/20/2016
    public Integer dequeue(){
        if(size() == 0){
            return null;
        }else{
            return list.remove(0); //able to do both a return and remove in a single line.
        }
    }
- We'll be doing this same thing again with Arrays - increment and decriment will be different.

Superclass and Subclass (p.410):
- reusing code (main objective of OOP)

- A superclass may be referenced by more than one subclass
- Subclasses inherit methods in a superclass.
- Subclasses extend the superclass.

- If a method isn't found in a subclass, the program will look in the superclass for the method.
- You may also override superclass methods in the subclass.
**You may not override superclass instance variables in the subclass.**

An example of a superclass may be vehicle()
- the subclasses may be passangerCar(), pickupTruck(), dumpTruck(), garbageTruck(),
sportsCar(), SUV() - in which each of them still uses methods within the vehicle class,
but they also have additional unique methods which aren't shared with other subclasses.
- A garbageTruck() may be the subclass of truck(), which may be the subclass of vehicle().

An example of a subclass:
    public class car extends vehicle{}

- the toString() method overrides the method toString within the superclass object() - which tracks position.

- right-clicking the top area of the class (when implementing an interface) 
    - will allow you to import all interface methods with a single click. (USEFUL)

- toString() and equals() are some examples of Object() class methods that can be overwritten.

- Object() is extended automatically.

Heirarchy:
Object() -> BankAccount() - superclass -> CheckingAccount() + SavingsAccount() - both subclasses of BankAccount()

BankAccount{
double balance; //instance variable
deposit(){}
withdraw(){}
getBalance(){}

SavingsAccount{
double interestRate; //instance variable
addInterest(){}

CheckingAccount{
int allowedFreeTransactions;
double transactionFee; //instance variables
deductedFees(){}
deposit(){}
withdraw(){}
- both deposit() and withdraw() call the superclass methods and make a very small change.


Public class BankAccount{
    private double balance;

    public BankAccount(){
        this(0);
    }
    public BankAccount(double initialBalance){
        balance = initialBalance;
    }
    public void deposit(double amount){
        if(amount > 0){
            balance = balance + amount;
        }
    }
    public void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance = balance - amount;
        }
    }
    public double getBalance(){
        return balance;
    }
    public String toString(){
        return "" + balance;
    }
//We followed this with a bankAccountTester() to check for functionality.

//Below are the subclasses
Public class SavingsAccount extends BankAccount{
    private double interestRate;

    public SavingsAccount(double initialInterestRage){
        super(); //calls superclass constructor - the one without set parameters
        //call to super() must be the fitst thing in the method call body.
        interestRate - initialInterestRate;
    }
    public SavingsAccount(){
        this(0.05);
        //'this' calls from constructor in same class and 'super()' calls from constructor in superclass.
    }
    public void addInterest(){
        double interestAmount = interestRate * getBalance(); //pulls getBalance() method from superclass
        deposit(interestAmount);
    }
}

- Programmer time is more valuable than processing time - use sub/superclass to
save your own time vs the processing time it may take to run through searching for super methods.

**When using the super() call, you only always go up a single level in the heirarchy**
- this is in the case of java - C++ is different.



Notes from 9/22/2016:
In reference to the HW06 assignment:
- No new instance variables needed to be declared in the subclass - they should
be pulled from the superclass.

    public QueueofInteger(){
        list = newArray

- variable list
- your class shouldn't have an ArrayList<>() - this should be extended
- extending java's build-in ArrayList<>(), and by doing so, you should delete
redundant methods. (Figure out the built-in methods in ArrayList<>())
- front(), enqueue(), and dequeue() are still needed

    public void endque(Integer n){
        add(n);
    } //inheritance is easy and reuses the code.

- Recurrsion assignment is on its way.

Review the Bank Account Program:
- is the number of transactions more than what your withdraws allow?
    - if so, apply fees.

public class CheckingAccount extends BankAccount{
    public static final int FREE_TRANSACTIONS = 3;
    public static final double TRANSACTION_FEE = .2;
    private int transactionCount;

    public CheckingAccount(){
        super(0);
        //there are three ways to set to 0 - super(0); this(0); or super(); - pulls default from super
    }
    public CheckingAccount(double initialBalance){
        super(initalBalance);
    }

    public void deposit(double amount){
        super.deposit(amount);
        transactionCount++;
    }
    public void withdraw(double amount){
        super.withdraw(amount);
        transactionCount++;
    }
    public void deductFees(){
        if(transactionCount > FREE_TRANASCTIONS){
            int extraTransactions = transactionCount - FREE_TRANSACTIONS;
            double fees = extraTransactions * TRANSACTION_FEE;
            super.withdraw(fees); 
            //doesn't touch transaction count - just incase fee 
            //deduction tries to count as a transactionCount.
        }
        transactionCount = 0; //reset count to 0 for monthly allowed transactions.
    }
    public class BankAccountTester{
        public static void main(String[] args){
            CheckingAccount Check1 = new CheckingAccount(100);
            //first CheckingAccount is the object reference - if this was changed to 
            //BankAccount, deductFees() method wouldn't be seen.
            //second CheckingAccount() indicates this is an instance of this class - it is executed
            System.out.println("Num Free: " + CheckingAccount.FREE_TRANSACTIONS)

            Check1.deposit(10);
            Check1.deposit(30);
            Check1.deposit(10);
            Check1.deposit(25);

            System.out.println(Check1);
            Check1.deductFees();
            System.out.println(Check1); //shows the deducted fee
        }
    }
- If you change the object reference, you're changing how much of an object you can actually see.
- The kind of object that was actually created is wher ethe method search actually functions.



*/