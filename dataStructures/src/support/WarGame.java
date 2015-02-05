package support;

import ch5.queues.ArrayBndQueue;
import ch5.queues.BoundedQueueInterface;
import ch5.queues.QueueUnderflowException;

//War카드 게임을 모델
//몇번의 전투가 행해지는지 추적함
public class WarGame {
	BoundedQueueInterface player1; // 선수 1의 손
	BoundedQueueInterface player2; // 선수 2의 손

	int maxNumBattles; // 게임이 끝나기전에 허용되는 최대 전투의 수

	int numBattles = 0; // 현재 게임에서 행해지는 전투의 수

	RankCardDeck deck; // 카드 덱

	BoundedQueueInterface prize; // 현재 전투에서 얻어진 카드

	static final int numCards = 52; // 덱에 있는 카드의 수

	public WarGame(int maxNumBattles) {
		this.maxNumBattles = maxNumBattles;
		deck = new RankCardDeck();
	}

	public int getNumBattles() {
		return numBattles;
	}

	public boolean play() {
		// 한 게임을 시뮬레이션
		// 행해진 전투의 수가 maxNumBattles에 도달하면 게임은 중단됨
		// 게임이 정상적으로 끝나면 참, 중단되면 거짓을 리턴

		// 선수의 손을 생성
		player1 = new ArrayBndQueue(numCards);
		player2 = new ArrayBndQueue(numCards);

		// 상 더미를 생성
		prize = new ArrayBndQueue(numCards);
		boolean gameOver = false; // 게임이 종료되면 참이됨
		boolean gameOK = true; // 게임이 중단되면 거짓이 됨

		// 원래 손에 딜함
		deck.shuffle();
		while (deck.hasMoreCards()) {
			player1.enqueue(deck.nextCard());
			if (deck.hasMoreCards())
				player2.enqueue(deck.nextCard());
		}

		// 한 선수가 카드를 소진할때 까지
		// 또는 전투의 수가 최대해 달할 때까지 행함
		numBattles = 0;
		while (!gameOver) {
			try {
				numBattles = numBattles + 1;
				battle();
			} catch (QueueUnderflowException exceptionVar) {
				gameOver = true;
			}
			if (numBattles == maxNumBattles) {
				gameOver = true;
				gameOK = false;
			}
		}
		return gameOK;
	}
	
	private void battle(){
		//player1과 player2간의 전투를 모델
		//전투가 전쟁으로 되면 각 선수로부터 세 카드가 상 더미에 놓여지고
		//전투는 재귀적으로 계속됨
		
		//이 전투를 위한 카드들
		int p1card;
		int p2card;
		
		//선수들로부터 카드를 얻어 상 더미에 놓음
		p1card=(Integer)player1.dequeue();
		prize.enqueue(p1card);
		p2card=(Integer)player2.dequeue();
		prize.enqueue(p2card);
		
		//전투의 결과를 결정하고 처리함
		if(p1card > p2card)  //선수 1이 이김
			 while(!prize.isEmpty())
				 player1.enqueue(prize.dequeue());
		else{
			if(p2card>p1card)  //선수 2가 이김
				while(!prize.isEmpty())
					player2.enqueue(prize.dequeue());
			else{  //전쟁임
				//각 선수가 3개의 카드를 상 더미에 놓음
				for(int i=0; i<3; i++){
					prize.enqueue(player1.dequeue());
					prize.enqueue(player2.dequeue());
				}
				
				//누가 상을 얻는지 결정하기 위해 전투를 계속
				battle();			
			}				
		}			
	}
}
