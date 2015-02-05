package support;

import java.util.Random;

//ī���� ���� ��
//��û�Ǹ� ������ ī�带 ����
//ī��� 0���� 12������ ������ ������ ���� ǥ����
public class RankCardDeck {
	private static final int numCards =52;
	protected int[] carddeck = new int[numCards];
	protected int curCardPos = 0;  //ó���� ���� ī���� ��ġ
	
	protected Random rand = new Random();  //���� ���ڸ� �߻���Ű�� ����
	
	public RankCardDeck(){
		for(int i=0; i<numCards; i++)
			carddeck[i] = i/4;  //�� ������ 4���� ī�尡 ����		
	}
	
	public void shuffle(){
		//���� �ִ� ī���� ������ ���Ƿ� �ϰ�
		//���� ī���� ��ġ�� ī�� 0���� ����
		int randLoc;
		int temp;
		for(int i=(numCards - 1); i>0; i--){
			randLoc = rand.nextInt(i);  //0�� i-1������ ���� ����
			temp = carddeck[randLoc];
			carddeck[randLoc]=carddeck[i];
			carddeck[i]=temp;
		}
		curCardPos=0;
	}
	
	public boolean hasMoreCards(){
		//ó���� ���� ī�尡 ���� ������ ���� ����
		//�׷��� ������ ������ ����
		return (curCardPos != numCards);
	}
	
	public int nextCard(){
		//��������: curCardPos != numCards
		//������ ǥ���ϴ� ������ �����ϰ� ���� ī���� ��ġ��
		//������Ŵ���ν� ���� �ǰ� �ִ� ī�带 ��
		curCardPos = curCardPos+1;
		return (carddeck[curCardPos -1]);
	}
}
