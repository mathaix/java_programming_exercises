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
    public ThreadSafePriorityQueue()
    {
        initialize();
    }
    
    
    public void initialize()
    {
        
    }
    
    private boolean less(int i, int j){
        
    }
    
    private void exch(int i, int j){
        
    }
    
    private void swim(int k){
        
    }
    
    private void sink(int k){
        
    }
    
    private void resize(){
        
        
    }
    
    
    @Override
    public int size()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEmpty()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear()
    {
  
        
    }

    @Override
    public boolean add(Priority<X> e)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Priority<X> poll()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Priority<X> peek()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean contains(Priority<X> x)
    {
        // TODO Auto-generated method stub
        return false;
    }
}
