/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jwray
 */
public class Euclid_reference {

    // recursive implementation
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }

    // non-recursive implementation
    public static int gcd2(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }

    public static void main(String[] args) {
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        int d  = gcd(p, q);
        int d2 = gcd2(p, q);
        System.out.println("gcd(" + p + ", " + q + ") = " + d);
        System.out.println("gcd(" + p + ", " + q + ") = " + d2);
    }
    //referenced from http://introcs.cs.princeton.edu/java/23recursion/Euclid.java.html
}

//**Here's some great info: http://www.challenge.nm.org/archive/08-09/kickoff/classes/Algorithms_in_Java-Euclids_Algorithm.pdf

//Here's another http://www.vogella.com/tutorials/JavaAlgorithmsEuclid/article.html

//Here's a video https://www.youtube.com/watch?v=DTlDmlZzYJQ