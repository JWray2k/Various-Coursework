/**
 * Jonathan Wray
 * HW01 - Person
 * August 25th 2016
 */

public class PersonTester {
    public static void main(String[] args){
        Person P1 = new Person("John", "Wray");
        System.out.println("The name of Person P1 is "
         + P1.getFirstName() + " " + P1.getLastName());
    
        //P1.setName("John", "Wray");
        //P1.setFirstName = "John";
        //P1.setLastName = "Wray";
        //System.out.println("P1 name is: " + P1.FirstName + P1.LastName);
    }
}
