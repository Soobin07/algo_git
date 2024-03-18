package beakjoon.golds;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

//합분해
public class Q2225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int N = Integer.parseInt(st.nextToken()); // N까지 정수, 합이 N
		int K = Integer.parseInt(st.nextToken()); // K개 더해서

		// K개 숫자를 이용하여 N을 만든다
		long[][] map = new long[K + 1][N + 1];

		// 초기화
		// 1개 이용하여 i를 만들 수 있는 숫자는 i 1개밖에 없다
		for (int i = 0; i <= N; i++) {
			map[1][i] = 1;
		}
		for(int i = 0 ; i <= K ; i++) {
			// 숫자를 i개 더하여 0을 만들 수 있는 경우는 1개밖에 없다
			map[i][0] = 1;
		}

		for (int i = 2; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = (map[i][j - 1] + map[i - 1][j]) % 1_000_000_000;
			}
		}

		System.out.println(map[K][N]);
	}
}
