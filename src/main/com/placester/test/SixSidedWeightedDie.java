package com.placester.test;


/*
 * Implement a 6 sided die with weights on the sides, so that we don't have an even probability distribution, but it is 
 * weighted by a list of weights passed in at construction time
 * 
 * After 10k iterations of throwing this die, the results should closely match the desired distribution, and this should
 * be reproducible in the unit test in
 * 
 * src/test/com/placester/test/WeightedDiceTest
 */
public class SixSidedWeightedDie extends WeightedDie
{
    //NOTE: since these are weights on a probability distribution, these should sum to one, and the incoming array
    // should be of length 6. You should throw if either of these preconditions is false
    //final float[] dice_weights;
    final int[] dices = new int[100];
    
    public SixSidedWeightedDie(float[] weights) throws Exception
    {
        super(weights);
        float sum = 0f;
        
        if (weights.length != 6){
            throw new Exception ("invalid array lenght");
        }
        
        for (int i = 0;  i< weights.length; i++) {
            sum = sum + weights[i];
        }
        
        if (sum != 1.0){
           
           throw new Exception("invalid distribution"); 
        }
        
        int counter = 1;
        for (int i = 0; i<weights.length; i++){
              int count = Math.round(weights[i] * 100);
              for (int j = i; j < i+count; j++)
                  dices[j] = counter;
              counter = counter +1;
        }
        
    }
    
    private int uniform_random(int N){
        return (int) Math.random() * N;
    }
    
    private void shuffle(){
        //shuffle the dices
        int N = dices.length;
        for (int i = 0; i < N ; i++){
            int r = i + uniform_random(N-1);
                
            int temp = dices[i];
            dices[i] = dices[r];
            dices[r] = temp;
                
        }
    }

    //Throw the die: this should produce a value in [1,6]
    @Override
    public int throwDie()
    {
        shuffle();
        return dices[0];
    }

}
