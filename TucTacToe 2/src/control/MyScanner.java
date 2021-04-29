package control;

import java.util.Scanner;

public class MyScanner {
	private Scanner scanner;
	
	
	public MyScanner() {
		this.scanner = new Scanner(System.in);
	}
	
	
	public String readString(String prompt) {		
		System.out.println(prompt+": ");
		String input = scanner.next();
		return input;
	}
	
	
	public int readInt(String prompt) {		
		System.out.println(prompt+": ");
		int input = scanner.nextInt();
		return input;
	}
	
	
	public void close() {
		scanner.close();
	}
}