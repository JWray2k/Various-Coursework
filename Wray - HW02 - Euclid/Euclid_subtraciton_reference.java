/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jwray
 */
public class Euclid_subtraciton_reference {
    
   int gcd(int K, int M) {
      int k = K;   // In order to state a simple, elegant loop invariant,
      int m = M;   // we keep the formal arguments constant and use 
                   // local variables to do the calculations.
      // loop invariant: GCD(K,M) = GCD(k,m)
      while (k != m) {
         if (k > m) 
            { k = k-m; }
         else 
            { m = m-k; }
      }
      // At this point, GCD(K,M) = GCD(k,m) = GCD(k,k) = k
      return k;
   }

}
//referenced from http://people.cis.ksu.edu/~schmidt/301s12/Exercises/euclid_alg.html