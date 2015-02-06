package support;

import java.util.Random;

//구성자 인자인 최소 최대 도착 간 시간과 서비스 시간에 기반한 임의의 Customer 일련의 객체를 생성
//도착 간 시간과 서비스 시간은 편편한 확률 분포를 갖는다고 가정
//시간이 0에서 시작함을 가정
public class CustomerGenerator {
	protected int minIAT;  //최소 도착 간 시간
	protected int maxIAT;  //최대 도착 간 시간
	protected int minST;  //최소 서비스 시간
	protected int maxST;  //최대 서비스 시간
	protected int currTime=0;  //현재 시간
	Random rand = new Random();  //임의 숫자를 생성하기 위한
	
	public CustomerGenerator(int minIAT, int maxIAT, int minST, int maxST) {
		//모든인자 >=0
		//minIAT<=maxIAT
		//minST<=maxST
		this.minIAT = minIAT;
		this.maxIAT = maxIAT;
		this.minST = minST;
		this.maxST = maxST;		
	}
	
	public void reset()
	  {
	    currTime = 0;
	  }
	
	public Customer nextCustomer(){
		//다음 임의고객을 생성하고 리턴
		int IAT;
		int ST;
		IAT = minIAT + rand.nextInt(maxIAT - minIAT + 1);
		ST = minST + rand.nextInt(maxST - minST +1);
		currTime = currTime + IAT;  //현재 시각을 다음 고객의 도착 시각으로 변경
		
		Customer next = new Customer(currTime,ST);
		return next;
	}
}
