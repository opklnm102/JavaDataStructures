package support;

import java.util.Random;

//������ ������ �ּ� �ִ� ���� �� �ð��� ���� �ð��� ����� ������ Customer �Ϸ��� ��ü�� ����
//���� �� �ð��� ���� �ð��� ������ Ȯ�� ������ ���´ٰ� ����
//�ð��� 0���� �������� ����
public class CustomerGenerator {
	protected int minIAT;  //�ּ� ���� �� �ð�
	protected int maxIAT;  //�ִ� ���� �� �ð�
	protected int minST;  //�ּ� ���� �ð�
	protected int maxST;  //�ִ� ���� �ð�
	protected int currTime=0;  //���� �ð�
	Random rand = new Random();  //���� ���ڸ� �����ϱ� ����
	
	public CustomerGenerator(int minIAT, int maxIAT, int minST, int maxST) {
		//������� >=0
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
		//���� ���ǰ����� �����ϰ� ����
		int IAT;
		int ST;
		IAT = minIAT + rand.nextInt(maxIAT - minIAT + 1);
		ST = minST + rand.nextInt(maxST - minST +1);
		currTime = currTime + IAT;  //���� �ð��� ���� ������ ���� �ð����� ����
		
		Customer next = new Customer(currTime,ST);
		return next;
	}
}