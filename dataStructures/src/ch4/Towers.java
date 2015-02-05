package ch4;

import java.util.Scanner;

public class Towers {

	private static String indent = ""; // ������ ���� �鿩����(indentation)

	public static void main(String[] args) {
		Scanner conIn = new Scanner(System.in);

		// ���� �忡 �ִ� ���� ����
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

	public static void doTowers(int n, // �̵���ų ���� ����
			int startPeg, // �̵���ų ���� ���� ���
			int auxPeg, // �ӽ������� ���� ������ ���
			int endPeg) // �̵���ų ���� �޴� ���
	{
		if (n > 0) {
			indent = indent + "  ";
			System.out.println(indent + "Get " + n + " rings moved from peg "
					+ startPeg + " to peg " + endPeg);
			// n-1���� ���� ���� ��տ��� ���� ������� �̵�
			doTowers(n - 1, startPeg, endPeg, auxPeg);

			// n��° ���� ���� ��տ��� ������ ������� �̵�
			System.out.println(indent + "Move ring " + n + " from peg "
					+ startPeg + " to peg " + endPeg);
			// n-1���� ���� ���� ��տ��� ������ ������� �̵�
			doTowers(n - 1, auxPeg, startPeg, endPeg);

			indent = indent.substring(2);
		}
	}
}