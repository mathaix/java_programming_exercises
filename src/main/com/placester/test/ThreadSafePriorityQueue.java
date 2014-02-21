package com.placester.test;
// NOTE: we are aware that there is a PriorityQueue in
// java.util. Please do not use any containers from
// java.util in your solution, as this is a test of data
// structure knowledge, rather than a test of java library knowledge
/*
 * The task is as follows: implement this class as you see fit (modulo
 * not using any collections classes from java.util or
 * java,util.collections, and get the unit test in
 * src/test/com/placester/test/PriorityQueueTest to pass. This class
 * must allow dynamic resizing as elements are added. What the
 * strategy is to do this is entirely up to you modulo the previously
 * stated constraint.
 */
public class ThreadSafePriorityQueue<X> implements SimpleQueue<Priority<X>>
{
    //store queue elements on a heap orderd array
    private Priority[] pq;
    private int N = 0;
    
    public ThreadSafePriorityQueue()
    {
        initialize();
    }
    
    
    public void initialize()
    {
        //initiazlise with one element
        pq = new Priority[1];
    }
    
    private boolean less(int i, int j){
        if (pq[i].priority() <= pq[j].priority()){
          return true;   
        }
        else return false;
        
    }
    
    private void exch(int i, int j){
        Priority temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        
    }
    
    private void swim(int k){
        while (k > 1 && less(k/2,k)){
            exch(k/2, k);
            k = k/2;
        }   
    }
    
    private void sink(int k){
        while (2*k <=N){
           int j=2*k;
           if (j <N && less (j, j+1)){
             j++;   
           }
           if (!less(k,j)) break;
           exch(k,j);
           k = j;
        }
    }
    
    private void resize(){
        
        
    }
    
    
    @Override
    public int size()
    {
        return N;
    }

    @Override
    public boolean isEmpty()
    {
        return N == 0;
    }

    @Override
    public void clear()
    {
        //re-initialize
        initialize();
        
    }

    @Override
    public boolean add(Priority<X> e)
    {
        pq[++N] = e;
        swim(N);
        return true;
    }

    @Override
    public Priority<X> poll()
    {
        if (isEmpty()){
            return null;
        } else{
            Priority<X> max = (Priority<X>) pq[1];
            exch(1, N--);
            sink(1);
            return max; 
        }
    }

    @Override
    public Priority<X> peek()
    {
        if (isEmpty()){
            return null;
        } else{
            Priority<X> max = (Priority<X>) pq[1];
            return max;
        }
    }

    @Override
    public boolean contains(Priority<X> x)
    {
        //walk array to find element.
        for (int i=0; i < pq.length; i++){
            if (pq[i].item() == X){
                return true;
            }
        }
        
        return false;
    }
}
