package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q10830 {
	static int N;
	static long B;
	static HashMap<Long, int[][]> memory;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());

		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		memory = new HashMap<>();
		memory.put(1L, map);

		int[][] ans = solution(B);
		print(ans);
	}

	static int[][] solution(long b) {
		if (b == 1) {
			return memory.get(1L);
		}
		if (b % 2 == 0) {
			if (memory.containsKey(b / 2)) {
				return multiple(memory.get(b / 2), memory.get(b / 2));
			} else {
				int[][] tmp = solution(b / 2);
				memory.put(b / 2, tmp);
				return multiple(tmp, tmp);
			}
		} else {
			if (!memory.containsKey(b / 2)) {
				int[][] tmp = solution(b / 2);
				memory.put(b / 2, tmp);
			}
			if (!memory.containsKey(b - (b / 2))) {
				int[][] tmp = solution(b - (b / 2));
				memory.put(b - (b / 2), tmp);
			}
			return multiple(memory.get(b / 2), memory.get(b - (b / 2)));
		}
	}

	static int[][] multiple(int[][] A, int[][] B) {
		int[][] tmp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 어디에 넣을 것인지 => tmp[i][j]
				int sum = 0;

				// 더할것
				for (int k = 0; k < N; k++) {
					sum += ((1L * A[i][k] * B[k][j]) % 1000);
				}

				tmp[i][j] = sum % 1000;
			}
		}
		return tmp;
	}

	static int[][] copy(int[][] map) {
		int[][] tmp = new int[map.length][];
		for (int i = 0; i < map.length; i++) {
			tmp[i] = new int[map[i].length];
			for (int j = 0; j < map[i].length; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		return tmp;
	}

	static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] % 1000 + " ");
			}
			System.out.println();
		}
	}
}
