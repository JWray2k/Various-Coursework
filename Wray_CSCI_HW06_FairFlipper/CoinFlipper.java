/*
 * Jonathan Wray
 * CSCI295
 * HW06 - Fair Flipper
 * 9/30/2015
 */

public class CoinFlipper {
    public static void main(String[] args) {
        int headCount = 0;
        int tailCount = 0;
        int total = 0;
        
        CoinValue flipValue;        
        int n = 100000;
        
        BiasedCoin coin = new BiasedCoin(.4);
        //first solution was to change BiasedCoin into a value of .5

        
        
        

            for (int i = 0; i < n; i++) {
                flipValue = coin.flip();
                //force the program to only log a coin flip if it's different form the last.
                if(coin.flip() != flipValue){
                    if(flipValue == CoinValue.HEADS){
                        headCount++;
                    } else {
                        tailCount++;
                    }
                }
                //total needed due to coinflip amount change - used it to divide coin chances.
                total = (headCount+tailCount);
            }

        System.out.printf("Heads: %4.2f %%%n", (((double)headCount/total)*100));
        System.out.printf("Tails: %4.2f %%%n", (((double)tailCount/total)*100));
        
        System.out.println("-------------------");
        //System.out.println(total);
        //System.out.println(((double)headCount/total)*100);
        //System.out.println((double)tailCount/total);
        System.out.println(coin.flip());
        
    }
}

        //from old program
        //for (int i = 0; i < n; i++) {
        //    flipValue = coin.flip();
        //    if(flipValue == CoinValue.HEADS){
        //        headCount++;
        //    } else {
        //        tailCount++;
        //    }
        //}

        //public static CoinFlipper fairFlip(BiasedCoin()){
            //double r = Math.random();
            //currentFlip == CoinValue.HEADS; (DO I NEED A METHOD?)