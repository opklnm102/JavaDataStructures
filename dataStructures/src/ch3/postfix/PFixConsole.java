package ch3.postfix;

import java.util.Scanner;

public class PFixConsole {
	public static void main(String[] args) {
		Scanner conIn = new Scanner(System.in);
		String line = null;  //���� ���ڿ�
		String more = null;  //ó���� �������� ��������� ���
		int result;  //����� ���
		do{
			//ó���� ���� ������ ������
			System.out.println("Enter a postfix expression to be evaluated: ");
			line=conIn.nextLine();
			
			//���� ����� ����� ��� �����
			try{
				result = PostFixEvaluator.evaluate(line);
				
				//����� ���
				System.out.println();
				System.out.println("Result = "+result);
			}
			catch(PostFixException error){
				//���� �޽����� ���
				System.out.println();
				System.out.println("Error in expression -"+error.getMessage());
			}
			
			//ó���� ���� ������ �ִ��� ����
			System.out.println();
			System.out.print("Evalute another expression? (Y = Yes): ");
			more = conIn.nextLine();
			System.out.println();			
		}
		while(more.equalsIgnoreCase("y"));
		
		System.out.println("Program completed.");
	}
}