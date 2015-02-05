package ch4;

import java.util.Scanner;

public class BlobApp {
	public static void main(String[] args) {
		Scanner conIn = new Scanner(System.in);
		
		final int GRIDR = 10;
		final int GRIDC = 40;
		
		//���� ������ ����� Ȯ���� ����
		int percentage;
		System.out.println("Input percentage probability (0 to 100): ");
		if(conIn.hasNextInt())
			percentage = conIn.nextInt();
		else
		{
			System.out.println("Error: you must enter an integer.");
			System.out.println("Terminating program.");
			return;
		}
		System.out.println();
		
		//���ڸ� ����
		Grid grid = new Grid(GRIDR,GRIDC,percentage);
		
		//���ڸ� ���̰� ������ ���
		System.out.println(grid.toString());
		System.out.println("\nThere are " + grid.blobCount() + " blobs.\n");
	}
}