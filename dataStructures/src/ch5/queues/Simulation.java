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
		//numQueue>0, numCustomers>0, simulation>MAXTIME면 어떤 시간도 발생하지 않음
		//numQueues개의 큐를 가진 큐잉 시스템을 들어가고 나가는 numCustomers 개의 고객을 시뮬레이션함		
		GlassQueue[] queues = new GlassQueue[numQueues];  //큐
		Customer nextCust;  //발생기로부터의 다음 고객
		Customer cust;  //임시 사용을 위한 고객을 저장
		int totWaitTime=0;  //전체 대기 시간
		int custInCount=0;  //지금까지 시작한 고객의 수
		int custOutCount=0;  //지금까지 종료한 고객의 수
		int nextArrTime;  //다음도착 시간
		int nextDepTime;  //다음출발 시각
		int nextQueue;  //다음 출발을 위한 큐의 색인
		
		int shortest;  //가장 짧은 큐의 색인
		int shortestSize;  //가장 짧은 큐의 크기
		Customer rearCust;  //가장 짧은 큐의 뒤(rear)에 있는 고객
		int finishTime;  //계산된 종료 시각
		
		//큐를 생성
		for(int i=0; i<numQueues; i++)
			queues[i] = new GlassQueue();
		
		//고객 발생기를 지정하고 첫 고객을 얻음
		custGen.reset();
		nextCust = custGen.nextCustomer();
		while(custOutCount<numCustomers){
			//다음 도착 시각을 얻음
			if(custInCount != numCustomers)
				nextArrTime = nextCust.getArrivalTime();
			else
				nextArrTime = MAXTIME;
			
			//다음 출발 시각을 얻고 nextQueue를 지정
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
				//도착하는 고객을 처리
				
				//가장짧은 고객을 결정
				shortest=0;
				shortestSize = queues[0].size();
				for(int i=1; i<numQueues; i++){
					if(queues[i].size() < shortestSize){
						shortest = i;
						shortestSize = queues[i].size();
					}
				}
				
				//종료 시각을 결정
				if(shortestSize == 0)
					finishTime = nextCust.getArrivalTime() + nextCust.getServiceTime();
				else{
					rearCust = (Customer)queues[shortest].peekRear();
					finishTime = rearCust.getFinishTime() + nextCust.getServiceTime();
				}
				
				//종료 시각을 지정하고 고객을 enqueue
				nextCust.setFinishTime(finishTime);
				queues[shortest].enqueue(nextCust);
				
				custInCount = custInCount+1;
				
				//필요하면 enqueue할 다음 고객을 얻음
				if(custInCount < numCustomers)
					nextCust = custGen.nextCustomer();
			}
			else{
				//떠나는 고객을 처리
				cust = (Customer)queues[nextQueue].dequeue();
				totWaitTime = totWaitTime+cust.getWaitTime();
				custOutCount = custOutCount+1;
			}
		}  //while의 끝
		
		avgWaitTime = totWaitTime/(float)numCustomers;	
	}
}
