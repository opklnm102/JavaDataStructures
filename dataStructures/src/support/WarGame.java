package support;

import ch5.queues.ArrayBndQueue;
import ch5.queues.BoundedQueueInterface;
import ch5.queues.QueueUnderflowException;

//Warī�� ������ ��
//����� ������ ���������� ������
public class WarGame {
	BoundedQueueInterface player1; // ���� 1�� ��
	BoundedQueueInterface player2; // ���� 2�� ��

	int maxNumBattles; // ������ ���������� ���Ǵ� �ִ� ������ ��

	int numBattles = 0; // ���� ���ӿ��� �������� ������ ��

	RankCardDeck deck; // ī�� ��

	BoundedQueueInterface prize; // ���� �������� ����� ī��

	static final int numCards = 52; // ���� �ִ� ī���� ��

	public WarGame(int maxNumBattles) {
		this.maxNumBattles = maxNumBattles;
		deck = new RankCardDeck();
	}

	public int getNumBattles() {
		return numBattles;
	}

	public boolean play() {
		// �� ������ �ùķ��̼�
		// ������ ������ ���� maxNumBattles�� �����ϸ� ������ �ߴܵ�
		// ������ ���������� ������ ��, �ߴܵǸ� ������ ����

		// ������ ���� ����
		player1 = new ArrayBndQueue(numCards);
		player2 = new ArrayBndQueue(numCards);

		// �� ���̸� ����
		prize = new ArrayBndQueue(numCards);
		boolean gameOver = false; // ������ ����Ǹ� ���̵�
		boolean gameOK = true; // ������ �ߴܵǸ� ������ ��

		// ���� �տ� ����
		deck.shuffle();
		while (deck.hasMoreCards()) {
			player1.enqueue(deck.nextCard());
			if (deck.hasMoreCards())
				player2.enqueue(deck.nextCard());
		}

		// �� ������ ī�带 �����Ҷ� ����
		// �Ǵ� ������ ���� �ִ��� ���� ������ ����
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
		//player1�� player2���� ������ ��
		//������ �������� �Ǹ� �� �����κ��� �� ī�尡 �� ���̿� ��������
		//������ ��������� ��ӵ�
		
		//�� ������ ���� ī���
		int p1card;
		int p2card;
		
		//������κ��� ī�带 ��� �� ���̿� ����
		p1card=(Integer)player1.dequeue();
		prize.enqueue(p1card);
		p2card=(Integer)player2.dequeue();
		prize.enqueue(p2card);
		
		//������ ����� �����ϰ� ó����
		if(p1card > p2card)  //���� 1�� �̱�
			 while(!prize.isEmpty())
				 player1.enqueue(prize.dequeue());
		else{
			if(p2card>p1card)  //���� 2�� �̱�
				while(!prize.isEmpty())
					player2.enqueue(prize.dequeue());
			else{  //������
				//�� ������ 3���� ī�带 �� ���̿� ����
				for(int i=0; i<3; i++){
					prize.enqueue(player1.dequeue());
					prize.enqueue(player2.dequeue());
				}
				
				//���� ���� ����� �����ϱ� ���� ������ ���
				battle();			
			}				
		}			
	}
}
