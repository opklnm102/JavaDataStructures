package ch4;

import java.util.Scanner;

public class Towers {

	private static String indent = ""; // 추적을 위한 들여쓰기(indentation)

	public static void main(String[] args) {
		Scanner conIn = new Scanner(System.in);

		// 사작 펙에 있는 링의 개수
		int n;
		System.out.print("Input the number of rings: ");
		if (conIn.hasNextInt())
			n = conIn.nextInt();
		else {
			System.out.println("Error: you must enter an integer.");
			System.out.println("Terminating program.");
			return;
		}

		System.out.println("Towers of Hanoi with " + n + " rings\n");
		doTowers(n, 1, 2, 3);
	}

	public static void doTowers(int n, // 이동시킬 링의 개수
			int startPeg, // 이동시킬 링을 가진 기둥
			int auxPeg, // 임시적으로 링을 가지는 기둥
			int endPeg) // 이동시킬 링을 받는 기둥
	{
		if (n > 0) {
			indent = indent + "  ";
			System.out.println(indent + "Get " + n + " rings moved from peg "
					+ startPeg + " to peg " + endPeg);
			// n-1개의 링을 시작 기둥에서 보조 기둥으로 이동
			doTowers(n - 1, startPeg, endPeg, auxPeg);

			// n번째 링을 시작 기둥에서 목적지 기둥으로 이동
			System.out.println(indent + "Move ring " + n + " from peg "
					+ startPeg + " to peg " + endPeg);
			// n-1개의 링을 보조 기둥에서 목적지 기둥으로 이동
			doTowers(n - 1, auxPeg, startPeg, endPeg);

			indent = indent.substring(2);
		}
	}
}
