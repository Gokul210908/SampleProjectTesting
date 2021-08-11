package org.test;

public class ReturnTestingB {
	
	public static void main(String[] args) {
		
		ReturnTestingA a = new ReturnTestingA();

		int add = a.add(30, 20);
		
		if (add==50) {
		
			System.out.println("Valid");
		}
		
		else {
			System.out.println("Invalid");
		}
		
	}

}
