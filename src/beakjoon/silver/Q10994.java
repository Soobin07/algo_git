package beakjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 별 찍기 - 19 S4
public class Q10994 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		// 총 Map size
		int size = 1 + (N - 1) * 4;
		// 그림 맵
		char[][] map = new char[size][size];

		// 가운데
		int mid = size / 2;
		map[mid][mid] = '*';

		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { mid, mid });

		int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
		int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

		while (!q.isEmpty()) {
			int[] now = q.poll();
			char ch = map[now[0]][now[1]] == ' ' ? '*' : ' ';
			for (int i = 0; i < dr.length; i++) {
				int r = now[0] + dr[i];
				int c = now[1] + dc[i];
				if (r >= size || r < 0 || c >= size || c < 0 || map[r][c] != '\u0000')
					continue;
				map[r][c] = ch;
				q.add(new int[] { r, c });
			}
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
