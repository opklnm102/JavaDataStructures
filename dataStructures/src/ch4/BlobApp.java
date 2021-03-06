package ch4;

import java.util.Scanner;

public class BlobApp {
	public static void main(String[] args) {
		Scanner conIn = new Scanner(System.in);
		
		final int GRIDR = 10;
		final int GRIDC = 40;
		
		//블롭 문자의 백분율 확률을 얻음
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
		
		//격자를 생성
		Grid grid = new Grid(GRIDR,GRIDC,percentage);
		
		//격자를 보이고 블롭을 계산
		System.out.println(grid.toString());
		System.out.println("\nThere are " + grid.blobCount() + " blobs.\n");
	}
}
