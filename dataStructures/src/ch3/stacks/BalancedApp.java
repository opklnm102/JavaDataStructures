package ch3.stacks;

import java.util.Scanner;

public class BalancedApp {
	public static void main(String[] args){
		Scanner conIn = new Scanner(System.in);
		Balanced bal = new Balanced("([{",")]}");
		
		int result;  //0균형됨, 1균형되지 ㅇ낳음, 2미리끝나는 표현식
		
		String expression = null;  //평가되는 표현식
		String more = null;  //처리를 중지할지 계속할지에 사용
		do{
			//처리할 다음 표현식을 얻음
			System.out.println("Error an expression to be evaluated: ");
			expression = conIn.nextLine();
			
			//균형 검사의 결과를 얻고 출력
			result = bal.test(expression);
			if(result == 1)
				System.out.println("Unbalanced symbols");
			else
				if(result == 2)
					System.out.println("Premature  end of expression");
				else
					System.out.println("The symbol balanced.");
			//처리할 다른 표현식이 있는지 결정
			System.out.println();
			System.out.println("Evaluate another expression? (Y=Yes): ");
			more = conIn.nextLine();
			System.out.println();
		}while(more.equalsIgnoreCase("Y"));
	}
}
