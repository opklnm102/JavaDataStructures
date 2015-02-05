package support;

import java.util.Scanner;

public class WarGameApp {
	public static void main(String[] args) {
		Scanner conIn = new Scanner(System.in);
		
		WarGame game;
		
		int numGames;  //�ùķ��̼� �� ������ ��
		int maxNumBattles;  //���ӿ� ���Ǵ� ������ �ִ� ��
		int numDiscont=0;  //�ߴܵ� ������ ��
		int numCompleted=0;  //�ϼ��� ������ ��
		
		int totBattles=0;  //�ϼ��� ���ӿ��� ��ü ������ ��
		System.out.println("How many games should be simulated? ");
		numGames = conIn.nextInt();
		
		System.out.println("What is the maxumum number of battles per game? ");
		maxNumBattles = conIn.nextInt();
		
		game = new WarGame(maxNumBattles);
		
		for(int i=0; i<numGames; i++){
			if(game.play()){
				numCompleted = numCompleted+1;
				totBattles = totBattles + game.getNumBattles();
			}
			else
				numDiscont = numDiscont + 1;
		}
		
		//����� ���
		System.out.println("Number of Games Simulated: " + numGames);
		System.out.println("Number of Discontinued Games: " + numDiscont);
		System.out.println("Number of Completed Games: " + numCompleted);
		System.out.println();
		
		if(numCompleted>0){
			System.out.println("In the completed games");
			System.out.println("Total Number of Battles " + totBattles);
			System.out.println(" Average Number of Battle " + totBattles/numCompleted);
		}
		System.out.println("\nProgram completed.");
	}
}
