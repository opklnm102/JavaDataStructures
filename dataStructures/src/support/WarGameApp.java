package support;

import java.util.Scanner;

public class WarGameApp {
	public static void main(String[] args) {
		Scanner conIn = new Scanner(System.in);
		
		WarGame game;
		
		int numGames;  //시뮬레이션 할 게임의 수
		int maxNumBattles;  //게임에 허용되는 전투의 최대 수
		int numDiscont=0;  //중단된 게임의 수
		int numCompleted=0;  //완성된 게임의 수
		
		int totBattles=0;  //완성된 게임에서 전체 전투의 수
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
		
		//결과를 출력
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
