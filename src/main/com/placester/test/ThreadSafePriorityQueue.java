package com.placester.test;
// NOTE: we are aware that there is a PriorityQueue in java.util. Please do not use it in your implementation

public class ThreadSafePriorityQueue<X> implements SimpleQueue<Priority<X>>
{
    public ThreadSafePriorityQueue()
    {
        initialize();
    }
    
    
    public void initialize()
    {
        //TODO: put your initialization code here
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
        // TODO Auto-generated method stub
        
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
