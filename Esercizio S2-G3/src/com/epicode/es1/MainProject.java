package com.epicode.es1;

public class MainProject {

	public static void main(String[] args) {
		
		CustomThread thread1 = new CustomThread("*");
        CustomThread thread2 = new CustomThread("#");
        
        thread1.run();
        thread2.run();

	}

}
