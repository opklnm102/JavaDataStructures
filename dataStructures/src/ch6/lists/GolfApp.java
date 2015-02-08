package ch6.lists;

import java.util.Scanner;

import support.Golfer;

//���ĸ���Ʈ�� ���۵� ����
public class GolfApp {
	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);
		
		String name;
		int score;
		
		SortedListInterface golfers = new ArraySortedList(20);
		Golfer golfer;
		String skip;
		System.out.print("Golfer name (press Enter to end): ");
		name = sin.nextLine();
		while(!name.equals("")){
			System.out.print("Score: ");
			score = sin.nextInt();
			skip = sin.nextLine();
			
			golfer = new Golfer(name,score);
			golfers.add(golfer);
			
			System.out.print("Golfer name (press Enter to end): ");
			name = sin.nextLine();		
		}
		System.out.println();
		System.out.println("The final results are");
		System.out.println(golfers);
	}
}
