/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.pcp;

import java.util.concurrent.ArrayBlockingQueue;

public class Storage
{
    private final ArrayBlockingQueue<Integer> queue;
    
    private int fetchedCounter;
    private int storedCounter;
    private int underflowCounter;
    private int overflowCounter;
    private boolean productionComplete;
    
    public Storage() {
        this.queue = new ArrayBlockingQueue<>(10);
        this.fetchedCounter = 0;
        this.storedCounter = 0;
        this.underflowCounter = 0;
        this.overflowCounter = 0;
        this.productionComplete = false;
    }
    
    public synchronized boolean put(Integer data)
    {
        if(queue.size() >= 10)
        {
            overflowCounter++;
            return false;
        }
        else
        {
            try
            {
                queue.put(data);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            storedCounter++;
        }
        return true;
    }
 
    public synchronized Integer get() {
        if(queue.isEmpty())
        {
            underflowCounter++;

        }
        else
        {
            fetchedCounter++;
            storedCounter--;
        }
        return queue.poll();

    }

    public boolean isProductionComplete()
    {
        return productionComplete;
    }

    public void setProductionComplete() {
        productionComplete = true;
    }

    public int getFetchedCounter() {
       return fetchedCounter;
    }

    public int getStoredCounter() {
        return storedCounter;
    }

    public int getUnderflowCounter() {
        return underflowCounter;
    }

    public int getOverflowCounter() {
        return overflowCounter;
    }
}
