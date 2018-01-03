/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jwray
 */
public class Euclid_iteration_reference {
    
   int gcd(int K, int M) {
      int k = Math.max(K,M);
      int m = Math.min(K,M);
      // loop invariant: k ≥ m ∧ GCD(K,M) = GCD(k,m)
      while (m != 0) {
         int r = k % m;
         k = m;
         m = r;
      }
      // At this point, GCD(K,M) = GCD(k,m) = GCD(k,0) = k
      return k;
   }

}
//referenced from http://people.cis.ksu.edu/~schmidt/301s12/Exercises/euclid_alg.html