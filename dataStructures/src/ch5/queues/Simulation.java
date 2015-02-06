package ch5.queues;

import support.Customer;
import support.CustomerGenerator;

public class Simulation {
	final int MAXTIME = Integer.MAX_VALUE;
	
	CustomerGenerator custGen;
	float avgWaitTime=0.0f;
	
	public Simulation(int minIAT, int maxIAT, int minST, int maxST){
		custGen = new CustomerGenerator(minIAT, maxIAT, minST, maxST);
	}
	
	public float getAvgWaitTime(){
		return avgWaitTime;
	}
	
	public void simulate(int numQueues,int numCustomers){
		//numQueue>0, numCustomers>0, simulation>MAXTIME�� � �ð��� �߻����� ����
		//numQueues���� ť�� ���� ť�� �ý����� ���� ������ numCustomers ���� ���� �ùķ��̼���		
		GlassQueue[] queues = new GlassQueue[numQueues];  //ť
		Customer nextCust;  //�߻���κ����� ���� ��
		Customer cust;  //�ӽ� ����� ���� ���� ����
		int totWaitTime=0;  //��ü ��� �ð�
		int custInCount=0;  //���ݱ��� ������ ���� ��
		int custOutCount=0;  //���ݱ��� ������ ���� ��
		int nextArrTime;  //�������� �ð�
		int nextDepTime;  //������� �ð�
		int nextQueue;  //���� ����� ���� ť�� ����
		
		int shortest;  //���� ª�� ť�� ����
		int shortestSize;  //���� ª�� ť�� ũ��
		Customer rearCust;  //���� ª�� ť�� ��(rear)�� �ִ� ��
		int finishTime;  //���� ���� �ð�
		
		//ť�� ����
		for(int i=0; i<numQueues; i++)
			queues[i] = new GlassQueue();
		
		//�� �߻��⸦ �����ϰ� ù ���� ����
		custGen.reset();
		nextCust = custGen.nextCustomer();
		while(custOutCount<numCustomers){
			//���� ���� �ð��� ����
			if(custInCount != numCustomers)
				nextArrTime = nextCust.getArrivalTime();
			else
				nextArrTime = MAXTIME;
			
			//���� ��� �ð��� ��� nextQueue�� ����
			nextDepTime = MAXTIME;
			nextQueue = -1;
			for(int i=0; i<numQueues; i++)
				if(queues[i].size() != 0){
					cust = (Customer)queues[i].peekFront();
					if(cust.getFinishTime() < nextDepTime){
						nextDepTime = cust.getFinishTime();
						nextQueue = i;
					}
				}
			
			if(nextArrTime <= nextDepTime){
				//�����ϴ� ���� ó��
				
				//����ª�� ���� ����
				shortest=0;
				shortestSize = queues[0].size();
				for(int i=1; i<numQueues; i++){
					if(queues[i].size() < shortestSize){
						shortest = i;
						shortestSize = queues[i].size();
					}
				}
				
				//���� �ð��� ����
				if(shortestSize == 0)
					finishTime = nextCust.getArrivalTime() + nextCust.getServiceTime();
				else{
					rearCust = (Customer)queues[shortest].peekRear();
					finishTime = rearCust.getFinishTime() + nextCust.getServiceTime();
				}
				
				//���� �ð��� �����ϰ� ���� enqueue
				nextCust.setFinishTime(finishTime);
				queues[shortest].enqueue(nextCust);
				
				custInCount = custInCount+1;
				
				//�ʿ��ϸ� enqueue�� ���� ���� ����
				if(custInCount < numCustomers)
					nextCust = custGen.nextCustomer();
			}
			else{
				//������ ���� ó��
				cust = (Customer)queues[nextQueue].dequeue();
				totWaitTime = totWaitTime+cust.getWaitTime();
				custOutCount = custOutCount+1;
			}
		}  //while�� ��
		
		avgWaitTime = totWaitTime/(float)numCustomers;	
	}
}
