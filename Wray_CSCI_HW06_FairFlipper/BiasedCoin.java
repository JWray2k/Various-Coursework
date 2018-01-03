/*
 * Jonathan Wray
 * CSCI295
 * HW06 - Fair Flipper
 * 9/30/2015
 */

public class BiasedCoin {
    private double probHeads;
    private CoinValue value;
    
    // Constructors
    public BiasedCoin(){
        this(Math.random());
    }   
    
    public BiasedCoin(double probHeads){
        this.probHeads = probHeads;
        flip();
    }
    
    public CoinValue flip(){
        double r = Math.random();
        
        if(r <= probHeads){
            value = CoinValue.HEADS;
        } else {
            value = CoinValue.TAILS;
        }
        
        return value;
    }
    
    public CoinValue getValue(){
        return value;
    }

}