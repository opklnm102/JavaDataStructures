package ch5.queues;

import java.util.Random;
import java.util.Scanner;

public class SimulationApp {
	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);

		int minIAT; // 최소 도착 간 시간
		int maxIAT; // 최대 도착 간 시간
		int minST; // 최소 서비스 시간
		int maxST; // 최대 서비스 시간
		int numQueues;  //큐의 수
		int numCust;  //고객의 수
		String skip;  //정수를 읽은 후 행의 끝을 넘김
		String more = null;  //처리를 중지할 지 계속할 지에 사용
		
		System.out.println("Enter minumum inter-arrival time: ");
		minIAT = sin.nextInt();
		System.out.println("Enter maximum inter-arrival time: ");
		maxIAT = sin.nextInt();
		System.out.println("Enter minumum service time: ");
		minST = sin.nextInt();
		System.out.println("Enter maximum service time: ");
		maxST = sin.nextInt();
		
		//시뮬레이션을 수행할 객체를 생성
		Simulation sim = new Simulation(minIAT, maxIAT, minST, maxST);
		
		do{
			//처리할 다음 시뮬레이션 인스턴스를 얻음
			System.out.println("Enter number of queues: ");
			numQueues = sin.nextInt();
			System.out.println("Enter number of custoners: ");
			numCust = sin.nextInt();
			skip = sin.nextLine();  //행의 끝을 넘김
			
			//시뮬레이션을 실행하고 평균 대기 시간을 출력
			sim.simulate(numQueues,numCust);
			System.out.println("Average waiting time is " + sim.getAvgWaitTime());
			
			//처리할 다른 시뮬레이션 인스턴스가 있는지 결정
			System.out.println();
			System.out.print("Evaluate another simulation instance? (Y=Tes): ");
			more = sin.nextLine();
			System.out.println();			
		}
		while(more.equalsIgnoreCase("y"));
		System.out.println("Program completed.");
	}
}
