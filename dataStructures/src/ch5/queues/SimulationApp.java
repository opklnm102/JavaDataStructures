package ch5.queues;

import java.util.Random;
import java.util.Scanner;

public class SimulationApp {
	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);

		int minIAT; // �ּ� ���� �� �ð�
		int maxIAT; // �ִ� ���� �� �ð�
		int minST; // �ּ� ���� �ð�
		int maxST; // �ִ� ���� �ð�
		int numQueues;  //ť�� ��
		int numCust;  //���� ��
		String skip;  //������ ���� �� ���� ���� �ѱ�
		String more = null;  //ó���� ������ �� ����� ���� ���
		
		System.out.println("Enter minumum inter-arrival time: ");
		minIAT = sin.nextInt();
		System.out.println("Enter maximum inter-arrival time: ");
		maxIAT = sin.nextInt();
		System.out.println("Enter minumum service time: ");
		minST = sin.nextInt();
		System.out.println("Enter maximum service time: ");
		maxST = sin.nextInt();
		
		//�ùķ��̼��� ������ ��ü�� ����
		Simulation sim = new Simulation(minIAT, maxIAT, minST, maxST);
		
		do{
			//ó���� ���� �ùķ��̼� �ν��Ͻ��� ����
			System.out.println("Enter number of queues: ");
			numQueues = sin.nextInt();
			System.out.println("Enter number of custoners: ");
			numCust = sin.nextInt();
			skip = sin.nextLine();  //���� ���� �ѱ�
			
			//�ùķ��̼��� �����ϰ� ��� ��� �ð��� ���
			sim.simulate(numQueues,numCust);
			System.out.println("Average waiting time is " + sim.getAvgWaitTime());
			
			//ó���� �ٸ� �ùķ��̼� �ν��Ͻ��� �ִ��� ����
			System.out.println();
			System.out.print("Evaluate another simulation instance? (Y=Tes): ");
			more = sin.nextLine();
			System.out.println();			
		}
		while(more.equalsIgnoreCase("y"));
		System.out.println("Program completed.");
	}
}
