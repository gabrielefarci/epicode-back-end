package com.epicode.es2;

import java.util.Random;

public class MainProject {

	public static void main(String[] args) throws InterruptedException {
		
		int[] array = generateRandomArray(3000);
        int[][] partitions = partitionArray(array, 3);
        
        PartialSumThread[] threads = new PartialSumThread[3];
        ResultContainer resultContainer = new ResultContainer();
        
        for (int i = 0; i < 3; i++) {
            threads[i] = new PartialSumThread(partitions[i], resultContainer);
            threads[i].run();
        }
        
        for (PartialSumThread thread : threads) {
            thread.join();
        }
        
        int totalSum = resultContainer.getTotalSum();
        System.out.println("Somma totale: " + totalSum);
    }
    
    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }
        
        return array;
    }
    
    private static int[][] partitionArray(int[] array, int partitions) {
        int partitionSize = array.length / partitions;
        int[][] result = new int[partitions][];
        
        for (int i = 0; i < partitions; i++) {
            int startIndex = i * partitionSize;
            int endIndex = (i == partitions - 1) ? array.length : startIndex + partitionSize;
            result[i] = new int[endIndex - startIndex];
            
            System.arraycopy(array, startIndex, result[i], 0, endIndex - startIndex);
        }
        
        return result;
    }

}


