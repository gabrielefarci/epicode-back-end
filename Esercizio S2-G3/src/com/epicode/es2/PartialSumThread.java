package com.epicode.es2;

public class PartialSumThread extends Thread{
	private int[] array;
    private ResultContainer resultContainer;
    
    public PartialSumThread(int[] array, ResultContainer resultContainer) {
        this.array = array;
        this.resultContainer = resultContainer;
    }
    
    public void run() {
        int partialSum = 0;
        for (int num : array) {
            partialSum += num;
        }
        resultContainer.addPartialSum(partialSum);
    }
}
