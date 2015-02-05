package ch5.queues;

import java.util.Scanner;

public class PalindromeApp {
	public static void main(String[] args) {
		Scanner conIn = new Scanner(System.in);
		String candidate = null;  //평가되는 스트링
		String more = null;  //처리를 멈출 것인지 계속할 것인지 결정하는데 사용
		
		do{
			//처리될 다음 후보 스트링을 얻음
			System.out.println("Enter a string to be evaluated: ");
			candidate = conIn.nextLine();
			
			//회문 테스트의 결과를 얻고 출력
			if(Palindrome.test(candidate))
				System.out.println("is a palindrome.");
			else
				System.out.println("is NOT a palindrome.");
			
			//처리할 다른 후보 스트링이 있는지 결정
			System.out.println();
			System.out.println("Evaluate another string? (Y=Yes): ");
			more = conIn.nextLine();
			System.out.println();			
		}
		while(more.equalsIgnoreCase("y"));
	}
}
