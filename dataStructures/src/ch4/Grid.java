package ch4;

import java.util.Random;

public class Grid {
	protected int rows; // ���� ���� ����
	protected int cols; // ���� ���� ����
	protected boolean[][] grid; // ������ �����ϴ� ����
	boolean[][] visited; // blobCount�� ���� ����

	public Grid(int rows, int cols, int percentage)
	// ��������:rows and cols>0
	// 0<=percentage<=100	
	// rows, cols ũ���� ���ڸ� ����, ��ġ�� ����� Ȯ���� ����� ���� ���ڷ� ������
	{
		this.rows = rows;
		this.cols = cols;
		grid = new boolean[rows][cols];
		// ���� ���ڸ� �����ϱ� ����
		int randInt;
		Random rand = new Random();
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++) {
				randInt = rand.nextInt(100); // ���� ���� 0..9
				if (randInt < percentage)
					grid[i][j] = true;
				else
					grid[i][j] = false;
			}
	}

	public String toString() {
		String gridString = "";
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j])
					gridString = gridString + "X";
				else
					gridString = gridString + "-";
			}
			gridString = gridString + "\n"; // ���� ��
		}
		return gridString;
	}

	public int blobCount() {
		// ���ڿ��� ������ ������ ������
		int count = 0;
		visited = new boolean[rows][cols]; // ��ġ�� �湮�Ǿ����� ��
		// visited�� �ʱ�ȭ
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				visited[i][j] = false;

		// ������ ���
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				if (grid[i][j] && !visited[i][j]) {
					count++;
					markBlob(i, j);
				}
		return count;
	}

	private void markBlob(int row, int col)
	// �湮�ϸ鼭 row, col��ġ�� ��ũ
	// Ȯ���ϰ� �����ϸ� �� ��ġ�� ��, �Ʒ�, ����, ������ ��ġ�� ��ũ
	{
		visited[row][col] = true;

		//���� Ȯ��
		if ((row - 1) >= 0) // ���ڿ� �ְ�
			if (grid[row - 1][col]) // ���� ���ڸ� ������
				if (!visited[row - 1][col]) // �׸��� �湮���� �ʾ�����
					markBlob(row - 1, col); // ��ũ��

		//�Ʒ��� Ȯ��
		if ((row + 1) < rows) // ���ڿ� �ְ�
			if (grid[row + 1][col]) // ���� ���ڸ� ������
				if (!visited[row + 1][col]) // �׸��� �湮���� �ʾ�����
					markBlob(row + 1, col); // ��ũ��

		//������ Ȯ��
		if ((col - 1) >= 0) // ���ڿ� �ְ�
			if (grid[row][col - 1]) // ���� ���ڸ� ������
				if (!visited[row][col - 1]) // �׸��� �湮���� �ʾ�����
					markBlob(row, col - 1); // ��ũ��

		//�������� Ȯ��
		if ((col + 1) < cols) // ���ڿ� �ְ�
			if (grid[row][col + 1]) // ���� ���ڸ� ������
				if (!visited[row][col + 1]) // �׸��� �湮���� �ʾ�����
					markBlob(row, col + 1); // ��ũ��
	}
}