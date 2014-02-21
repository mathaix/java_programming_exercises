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
    
    
    private void initialize()
    {
        //initiazlise with one element
        pq = new Priority[1000];
    }
    
    private boolean less(int i, int j){
        if (pq[i].priority > pq[j].priority){
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
    
    private void resize(int len){
        //create new array
        Priority[] pq_temp = new Priority[len];
        for (int i = 0; i< N; i++){
            pq_temp[i] = pq[i];   
        }
        pq = pq_temp;
    }
    
    
    @Override
    public synchronized int size()
    {
        notifyAll();
        return N;
    }

    @Override
    public synchronized boolean isEmpty()
    {
        boolean result = (N == 0);
        notifyAll();
        return result;
    }

    @Override
    public synchronized void clear()
    {
        //re-initialize
        initialize();
        notifyAll();
        
    }

    @Override
    public synchronized boolean add(Priority<X> e)
    {
        //make array larger; start inserting at 1.. element 0 is not used. 
        if (N == pq.length-1) resize(2 * pq.length);
        pq[++N] = e;
        swim(N);
        notifyAll();
        return true;
    }

    @Override
    public synchronized Priority<X> poll()
    {
        if (isEmpty()){
            notifyAll();
            return null;
        } else{
            Priority<X> max = (Priority<X>) pq[1];
            exch(1, N--);
            pq[N+1] = null;
            sink(1);
            //make array smaller
            //if (N > 0 && N == pq.length/4 ) resize(pq.length/4);
            notifyAll();
            return max; 
        }
    }

    @Override
    public synchronized Priority<X> peek()
    {
        if (isEmpty()){
            notifyAll();
            return null;
        } else{
            Priority<X> max = (Priority<X>) pq[1];
            notifyAll();
            return max;
        }
    }

    @Override
    public synchronized boolean contains(Priority<X> x)
    {
        //walk array to find element.
        for (int i=1; i <= N; i++){
            if (pq[i].hashCode()==x.hashCode()){
                notifyAll();
                return true;
            }
        }
        notifyAll();
        return false;
    }
}
