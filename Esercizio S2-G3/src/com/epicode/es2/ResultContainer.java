package com.epicode.es2;

public class ResultContainer {
private int totalSum = 0;
    
    public synchronized void addPartialSum(int partialSum) {
        totalSum += partialSum;
    }
    
    public int getTotalSum() {
        return totalSum;
    }
}
