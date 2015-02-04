package ch3.postfix;

import java.util.Scanner;

public class PFixConsole {
	public static void main(String[] args) {
		Scanner conIn = new Scanner(System.in);
		String line = null;  //계산될 문자열
		String more = null;  //처리를 중할할지 계속할지에 사용
		int result;  //계산의 결과
		do{
			//처리할 다음 수식을 가져옴
			System.out.println("Enter a postfix expression to be evaluated: ");
			line=conIn.nextLine();
			
			//수식 계산의 결과를 얻고 출력함
			try{
				result = PostFixEvaluator.evaluate(line);
				
				//결과를 출력
				System.out.println();
				System.out.println("Result = "+result);
			}
			catch(PostFixException error){
				//오류 메시지를 출력
				System.out.println();
				System.out.println("Error in expression -"+error.getMessage());
			}
			
			//처리할 다음 수식이 있는지 결정
			System.out.println();
			System.out.print("Evalute another expression? (Y = Yes): ");
			more = conIn.nextLine();
			System.out.println();			
		}
		while(more.equalsIgnoreCase("y"));
		
		System.out.println("Program completed.");
	}
}
