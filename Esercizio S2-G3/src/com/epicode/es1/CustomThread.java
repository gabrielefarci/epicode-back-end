package com.epicode.es1;

public class CustomThread {
private final String symbol;
    
    public CustomThread(String symbol) {
        this.symbol = symbol;
    }
    
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print(symbol);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
