package ch5.queues;

import java.util.Scanner;

public class PalindromeApp {
	public static void main(String[] args) {
		Scanner conIn = new Scanner(System.in);
		String candidate = null;  //�򰡵Ǵ� ��Ʈ��
		String more = null;  //ó���� ���� ������ ����� ������ �����ϴµ� ���
		
		do{
			//ó���� ���� �ĺ� ��Ʈ���� ����
			System.out.println("Enter a string to be evaluated: ");
			candidate = conIn.nextLine();
			
			//ȸ�� �׽�Ʈ�� ����� ��� ���
			if(Palindrome.test(candidate))
				System.out.println("is a palindrome.");
			else
				System.out.println("is NOT a palindrome.");
			
			//ó���� �ٸ� �ĺ� ��Ʈ���� �ִ��� ����
			System.out.println();
			System.out.println("Evaluate another string? (Y=Yes): ");
			more = conIn.nextLine();
			System.out.println();			
		}
		while(more.equalsIgnoreCase("y"));
	}
}
