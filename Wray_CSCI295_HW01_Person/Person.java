/**
 * Jonathan Wray
 * HW01 - Person
 * August 25th 2016
 */
//Instance Variables

//Your class should have exactly two instance variables, both of which are Strings.
public class Person {
    //Person class contains the instance variables FirstName and LastName.
    private String FirstName;
    private String LastName;
    
//Cosntructors
    //Your class is to have two constructors:
    
    //This is the default constructor. It sets firstName to "First" and lastName to "Last".
    public Person(){
        FirstName = "First";
        LastName = "Last";
    }
    
    //This constructor provides initial values for both instance variables.
    public Person(String first, String last){
        FirstName = first;
        LastName = last;
    }
    
    
//Methods
    //Below are the method signatures along with descriptions for each method that you must include in your Person class.
    
    //Returns the value of the instance variable firstName.
    public String getFirstName(){
        return FirstName;
    }
    
    //Returns the value of the instance variable lastName.            
    public String getLastName(){
        return LastName;
    }
    
    //Sets the instance variable firstName to the specified name.
    public void setFirstName(String first){
        first = FirstName;
    }

    //Sets the instance variable lastName to the specified name.
    public void setLastName(String last){
        last = LastName;
    }

    //Sets both instance variables to the specified names.
    public void setName(String first, String last){
        first = FirstName;
        last = LastName;
    }

    //Returns a string containing the first and last names. For example, if the person's 
    //name is Ralph Kramden, then the following would be returned by the toString() method: Ralph Kramden
    public String toString(){
        String s = "";
        s += FirstName;
        s += " " + LastName;
        //s += "Person[";
        //s += "First Name is " + FirstName;
        //s += "Last Name is " + LastName + "]";
        return s;        
    }
}



