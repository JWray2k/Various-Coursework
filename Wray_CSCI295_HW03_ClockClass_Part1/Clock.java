/*
    * Jonathan Wray
    * CSCI-295: HW03
    * Sept 9, 2016
 */

/**
HW 03 - Clock Class

Part I

*Create a class called Clock that represents a simple military style clock in which 
* hours range from 0 to 23. This class should store the time using three integers:
* one each for hours, minutes and seconds. The Clock class should have the following 
* public interface:
* 
* Constructors
*
*There should be four constructors:
*
*A default constructor that sets the time to midnight, which is 0:0:0.
*A constructor that takes one parameter which specifies the hour h. The time should be set to h:0:0.
*A constructor that takes two parameters, specifying the hour h and the minute m. The time should be set to h:m:0.
*A constructor that takes three parameters, specifying the hour h, the minute m, and the second s. The time should be set to h:m:s.
*If an invalid value is provided to any of the constructors, a value of zero should be used instead..
 */

public class Clock {
    
    private int seconds;
    private int minutes;
    private int hours;
    public static final int DEFAULT_SECONDS = 0;
    public static final int DEFAULT_MINUTES = 0;
    public static final int DEFAULT_HOURS = 0;
    
       // Constructors
    public Clock(){
        this(DEFAULT_HOURS, DEFAULT_MINUTES, DEFAULT_SECONDS);
    }
    
    public Clock(int h){
        this(h, DEFAULT_MINUTES, DEFAULT_SECONDS);
        //Clock c = new Clock();
        if(h > 0 && h < 24){
            hours = h;
            //return c(h,DEFAULT_MINUTES,DEFAULT_HOURS);
        } else {
            hours = DEFAULT_HOURS;
            //this(DEFAULT_HOURS, DEFAULT_MINUTES, DEFAULT_SECONDS);
        }
    }
    
    public Clock(int h, int m){
        this(h, m, DEFAULT_SECONDS);
        if(h > 0 && h < 24){
            hours = h;
            //this(h, DEFAULT_MINUTES, DEFAULT_HOURS);
        }else {
            hours = DEFAULT_HOURS;
        }
        if(m > 0 && m < 60){
            minutes = m;
            //this(h, m, DEFAULT_SECONDS);
        }else{
            minutes = DEFAULT_MINUTES;
        }
    }
      
    public Clock(int h, int m, int s){
        //this(h, m, s);
        if(h > 0 && h < 24){
            hours = h;
            //this(h, DEFAULT_MINUTES, DEFAULT_HOURS);
        }else {
            hours = DEFAULT_HOURS;
        }
        if(m > 0 && m < 60){
            minutes = m;
            //this(h, m, DEFAULT_SECONDS);
        }else{
            minutes = DEFAULT_MINUTES;
        }
        if(s > 0 && s < 60){
            seconds = s;
            //this(h,m,s);
        }else{
            seconds = DEFAULT_SECONDS;
        }
    }

/* Accessors

*There should be a get method for the hour, minute, and second. 
*These should be called getHour, getMinute, and getSecond.
*/

public int getHour(){
    int h = hours;
    if(h > 0 && h < 24){
        return h;
    }else{
        h = DEFAULT_HOURS;
        return h;
    }
}
//Gets the hour-of-day field.
//Returns:
//the hour-of-day, from 0 to 23

public int getMinute(){
    int m = minutes;
    if(m > 0 && m < 60){
        return m;
    }else{
        m = DEFAULT_MINUTES;
        return m;
    }
}
//Gets the minute-of-hour field.
//Returns:
//the minute-of-hour, from 0 to 59

public int getSecond(){
    int s = seconds;
    if (s > 0 && s < 60){
        return s;
    }else{
        s = DEFAULT_SECONDS;
        return s;
    }
}
//Gets the second-of-minute field.
//Returns:
//the second-of-minute, from 0 to 59

/*
Mutators

There should be a set method for the hour, minute, and second. 
These methods should be called setHour, setMinute, and setSecond.

There should also be a method called set that has three overloaded versions as follows:

A set method that takes one parameter specifying the hour h. 
This method sets the hour to h and leaves the minutes and seconds unchanged.

A set method that takes two parameters, specifying the hour h and the minute m. 
This method sets the hour to h and the minute to m. The seconds are left unchanged.

A set method that takes three parameters, specifying the hour h, the minute m, and the second s. 
This method sets the hour to h, the minute to m, and the second to s.

There should be a method called reset that sets the time to midnight, which is 0:0:0.

If an invalid value is provided to any of the set methods, the corresponding value 
(hour, minute, or second) should not be changed.
*/
public void setHour(int hour){
    if(hour > 0 && hour < 24){
        hours = hour;
    }
}

public void setMinute(int minute){
    if(minute > 0 && minute < 60){
        minutes = minute;
    }
    
}

public void setSecond(int second){
     if(second > 0 && second < 60){
        seconds = second;
    }
}

public void set(int h){
    if(h > 0 && h < 24){
        hours = h;
}
}
public void set(int h, int m){
    if(h > 0 && h < 24){
        hours = h;
    }
    if(m > 0 && m < 60){
        minutes = m;
}
} 
public void set(int h, int m, int s){
    if(h > 0 && h < 24){
        hours = h;
    }
    if(m > 0 && m < 60){
        minutes = m;
    }
    if(s > 0 && s < 60){
        seconds = s;
    }
}

public void reset(){
    hours = 0;
    minutes = 0;
    seconds = 0;
}
/*
Special Method

Provide a toString method that returns the current time as a String. 
The string that is returned should be in the format (h:m:s). For example (22:9:15). 
Notice that the time is enclosed in parenthesis and leading zeros are not included.

You should test your Clock class using the program ClockTester.java. 
This program uses only the public interface for the Clock class described above. 
This is the program I will use to grade your homework assignment. 
If you Clock class is working right, the output of the tester will be

All Tests Passed
*/

    @Override
    public String toString(){
      String s = "(";
        s += getHour() + ":";
        s += getMinute() + ":";
        s += getSecond();
        s += ")";
        return s;
}

}



//final static int SEC_IN_MIN = 60;
//final static int SEC_IN_HOUR = SEC_IN_MIN * 60;
//int secFromMidnight = hour * SEC_IN_HOUR + minute * SEC_IN_MIN + second;
//int secToMidnight = (24 * SEC_IN_HOUR) - secFromMidnight;
//
//System.out.println("Number of seconds since midnight:" +(second + (minute*60) + (hour*3600)));
//System.out.println("Number of seconds to midnight:" +((60-second) + ((60-1-minute)*60) + (24-1-hour)*3600));
//
//http://stackoverflow.com/questions/18974729/how-to-get-the-time-since-midnight-in-seconds
