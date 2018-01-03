/*
 * Jonathan Wray
 * CSCI-295: HW03
 * Sept 9, 2016
 */

/**
HW 03 - Clock Class

/*
Part II

In class we discussed encapsulation, information hiding, and the importance of developing and using a class' 
public interface. This part of the assignment is intended to illustrate the importance of these concepts.

Start by making a copy of the NetBeans project folder from Part I. 
Using the copy you will change how the Clock class internally stores the time. 
The time should now be stored using only a single integer that represents the number of seconds since midnight. 
The public interface for the Clock class Should Not Change. 
The same ClockTester.java program from Part I, without being modified, should produce the same output as before.
*/

public class Clock {
    
    private int seconds;
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
            seconds = ((h*60)*60);
            //return c(h,DEFAULT_MINUTES,DEFAULT_HOURS);
        } else {
            seconds = DEFAULT_HOURS;
            //this(DEFAULT_HOURS, DEFAULT_MINUTES, DEFAULT_SECONDS);
        }
    }
    
    public Clock(int h, int m){
        //this(h, m, DEFAULT_SECONDS);
        if(h > 0 && h < 24){
            seconds += ((h*60)*60);
            //this(h, DEFAULT_MINUTES, DEFAULT_HOURS);
        }else {
            seconds = DEFAULT_HOURS;
        }
        if(m > 0 && m < 60){
            seconds += m*60;
            //this(h, m, DEFAULT_SECONDS);
        }else{
            seconds += DEFAULT_MINUTES;
        }
    }
      
    public Clock(int h, int m, int s){
        //this(h, m, s);
        if(h > 0 && h < 24){
            seconds += ((h*60)*60);
            //this(h, DEFAULT_MINUTES, DEFAULT_HOURS);
        }else {
            seconds = DEFAULT_HOURS;
        }
        if(m > 0 && m < 60){
            seconds += m*60;
            //this(h, m, DEFAULT_SECONDS);
        }else{
            seconds += DEFAULT_MINUTES;
        }
        if(s > 0 && s < 60){
            seconds += s;
            //this(h,m,s);
        }else{
            seconds += DEFAULT_SECONDS;
        }
    }
     
//        seconds += hours*3600;
//        seconds += minutes*3600;
//        if(hours > 0 && hours < 23){
//            hours = seconds / 3600;
//            minutes = 0;
//            seconds = 0;
//        } else {
//            hours = DEFAULT_HOURS;
        
    


/* Accessors

*There should be a get method for the hour, minute, and second. 
*These should be called getHour, getMinute, and getSecond.
*/

public int getHour(){
    int h = DEFAULT_HOURS;
    int m = DEFAULT_MINUTES;
    int s = seconds;
    if( s>= 60){
        m = s / 60;
    }
    if(m >= 60){
        h = m/60;
        return h;
    }
    //h = ((seconds/60)/60);
    //m = m - h*60;
    //if(h > 0 && h < 24){
    else{
        return h;
    //}else{
    //    h = DEFAULT_HOURS;
    //   return h;
    }
}

//Gets the hour-of-day field.
//Returns:
//the hour-of-day, from 0 to 23

public int getMinute(){
    int h = DEFAULT_HOURS;
    int m = DEFAULT_MINUTES;
    int s = seconds;
    if( s>= 60){
        m = s / 60;
    } 
    if(m>=60){
      h = m/60;
      m = m - h*60;
      return m;
    }else{
        return m;
    }

    //int m;
    //m = ((seconds/60)%60);
    //m = s/60; //this may need reworked
    //if(m > 0 && m < 60){
    //    return m;
    //}else{
    //    m = DEFAULT_MINUTES;
    //    return m;
    }

//Gets the minute-of-hour field.
//Returns:
//the minute-of-hour, from 0 to 59

public int getSecond(){
    int s = seconds;
    int m = DEFAULT_MINUTES;
    if(s >= 60){
        m = s/60;
        s = s - m*60;
        return s;
    }else{
        return s;
    }
    
    //seconds = seconds/60;
    //seconds = seconds%60;
    //s = (((seconds/60)%60)%60); //this may also need reworked
    //if (s > 0 && s < 60){
    //    return s;
    //}else{
    //    s = DEFAULT_SECONDS;
    //    return s;
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
        seconds = seconds - ((getHour()*60)*60);
        seconds = seconds + ((hour*60)*60);
    }
}

public void setMinute(int minute){
    if(minute > 0 && minute < 60){
        seconds = seconds - ((getMinute()*60));
        seconds = seconds + ((minute*60));
    }
    
}

public void setSecond(int second){
     if(second > 0 && second < 60){
        seconds = seconds - getSecond();
        seconds = seconds + second;
    }
}

public void set(int h){
    if(h > 0 && h < 24){
        seconds = seconds - ((getHour()*60)*60);
        seconds = seconds + ((h*60)*60);
}
}
public void set(int h, int m){
    if(h > 0 && h < 24){
        seconds = seconds - ((getHour()*60)*60);
        seconds = seconds + ((h*60)*60);
    }
    if(m > 0 && m < 60){
        seconds = seconds - ((getMinute()*60));
        seconds = seconds + ((m*60));
}
}
public void set(int h, int m, int s){
    if(h > 0 && h < 24){
        seconds = seconds - ((getHour()*60)*60);
        seconds = seconds + ((/*public*/h*60)*60);
    }
    if(m > 0 && m < 60){
        seconds = seconds - ((getMinute()*60));
        seconds = seconds + ((m*60));
    }
    if(s > 0 && s < 60){
        seconds = seconds - getSecond();
        seconds = seconds + s;
    }
}

public void reset(){
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
        //seconds = (seconds/60/60); (this didn't work)
        s += getMinute() + ":";
        //seconds = (seconds%60);
        s += getSecond();
        s += ")";
        return s;
}

}

/*
Part II

In class we discussed encapsulation, information hiding, and the importance of developing and using a class' 
public interface. This part of the assignment is intended to illustrate the importance of these concepts.

Start by making a copy of the NetBeans project folder from Part I. 
Using the copy you will change how the Clock class internally stores the time. 
The time should now be stored using only a single integer that represents the number of seconds since midnight. 
The public interface for the Clock class Should Not Change. 
The same ClockTester.java program from Part I, without being modified, should produce the same output as before.
*/


//final static int SEC_IN_MIN = 60;
//final static int SEC_IN_HOUR = SEC_IN_MIN * 60;
//int secFromMidnight = hour * SEC_IN_HOUR + minute * SEC_IN_MIN + second;
//int secToMidnight = (24 * SEC_IN_HOUR) - secFromMidnight;
//
//System.out.println("Number of seconds since midnight:" +(second + (minute*60) + (hour*3600)));
//System.out.println("Number of seconds to midnight:" +((60-second) + ((60-1-minute)*60) + (24-1-hour)*3600));
//
//http://stackoverflow.com/questions/18974729/how-to-get-the-time-since-midnight-in-seconds
