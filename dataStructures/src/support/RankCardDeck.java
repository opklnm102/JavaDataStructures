package support;

import java.util.Random;

//카드의 덱을 모델
//요청되면 임의의 카드를 리턴
//카드는 0부터 12까지의 정수인 순위에 의해 표현됨
public class RankCardDeck {
	private static final int numCards =52;
	protected int[] carddeck = new int[numCards];
	protected int curCardPos = 0;  //처리될 다음 카드의 위치
	
	protected Random rand = new Random();  //임의 숫자를 발생시키기 위함
	
	public RankCardDeck(){
		for(int i=0; i<numCards; i++)
			carddeck[i] = i/4;  //각 순위에 4개의 카드가 있음		
	}
	
	public void shuffle(){
		//덱에 있는 카드의 순서를 임의로 하고
		//현재 카드의 위치를 카드 0으로 지정
		int randLoc;
		int temp;
		for(int i=(numCards - 1); i>0; i--){
			randLoc = rand.nextInt(i);  //0과 i-1사이의 임의 정수
			temp = carddeck[randLoc];
			carddeck[randLoc]=carddeck[i];
			carddeck[i]=temp;
		}
		curCardPos=0;
	}
	
	public boolean hasMoreCards(){
		//처리할 남은 카드가 아직 있으면 참을 리턴
		//그렇지 않으면 거짓을 리턴
		return (curCardPos != numCards);
	}
	
	public int nextCard(){
		//사전조건: curCardPos != numCards
		//순위를 표시하느 정수를 리터하고 현재 카드의 위치를
		//증가시킴으로써 딜이 되고 있는 카드를 모델
		curCardPos = curCardPos+1;
		return (carddeck[curCardPos -1]);
	}
}
