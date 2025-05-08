package beakjoon.silver;

import java.util.Scanner;
import java.util.Stack;

public class Q16173 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		Stack<int[]> stack = new Stack<int[]>();
		stack.add(new int[] { 0, 0 });
		boolean[][] visit = new boolean[N][N];
		visit[0][0] = true;

		boolean flag = false;
		while (!stack.isEmpty()) {
			int[] now = stack.pop();
			int r = now[0];
			int c = now[1];

			int jump = map[r][c];
			if (jump == -1) {
				flag = true;
				break;
			}

			if (r + jump < N && !visit[r + jump][c]) {
				visit[r + jump][c] = true;
				stack.push(new int[] { r + jump, c });
			}
			if (c + jump < N && !visit[r][c + jump]) {
				visit[r][c + jump] = true;
				stack.push(new int[] { r, c + jump });
			}
		}

		System.out.println(flag ? "HaruHaru" : "Hing");
	}
}
