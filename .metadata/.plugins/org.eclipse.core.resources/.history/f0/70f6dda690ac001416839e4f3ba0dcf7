package ch3.stacks;

import java.util.Scanner;

public class BalancedApp {
	public static void main(String[] args){
		Scanner conIn = new Scanner(System.in);
		Balanced bal = new Balanced("([{",")]}");
		
		int result;
		
		String expression = null;
		String more = null;
		do{
			System.out.println("Error an expression to be evaluated: ");
			expression = conIn.nextLine();
			
			result = bal.test(expression);
			if(result == 1)
				System.out.println("Unbalanced symbols");
			else
				if(result == 2)
					System.out.println("Premature  end of expression");
				else
					System.out.println("The symbol balanced.");
		}
	}

}
