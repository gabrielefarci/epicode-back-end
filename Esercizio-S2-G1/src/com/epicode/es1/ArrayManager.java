package com.epicode.es1;

import java.util.Random;

public class ArrayManager {
    private int[] array;
    private Random random;

    public ArrayManager() {
        array = new int[5];
        random = new Random();
        initializeArray();
    }

    private void initializeArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10) + 1;
        }
    }

    public int[] getArray() {
        return array;
    }

    public void updateArray(int numero, int posizione) {
        if (posizione < 0 || posizione >= array.length) {
            throw new ArrayIndexOutOfBoundsException("Posizione non valida.");
        }

        array[posizione] = numero;
    }
}
