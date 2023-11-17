package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q20125 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int N = Integer.parseInt(br.readLine());
		char[][] cookie = new char[N][N];

		int[] heart = null;
		int[] lengths = { 0, 0, 0, 0, 0 };
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				cookie[i][j] = str.charAt(j);
				if (heart == null && cookie[i][j] == '*') {
					heart = new int[] { i + 1, j };
				}
			}
		}
		// heart 중심으로 아래, 좌, 우 확인
		// 허리
		for (int i = 1; i < N; i++) {
			if (cookie[heart[0] + i][heart[1]] == '*') {
				lengths[2]++;
			} else {
				break;
			}
		}
		// 왼팔
		for (int i = 1; i < N; i++) {
			if (heart[1] - i < 0) {
				break;
			}
			if (cookie[heart[0]][heart[1] - i] == '*') {
				lengths[0]++;
			} else {
				break;
			}
		}
		// 오른팔
		for (int i = 1; i < N; i++) {
			if (heart[1] + i >= N) {
				break;
			}
			if (cookie[heart[0]][heart[1] + i] == '*') {
				lengths[1]++;
			} else {
				break;
			}
		}
		// 왼다리
		for (int i = 1; i < N; i++) {
			if (heart[0] + lengths[2] + i >= N) {
				break;
			}
			if (cookie[heart[0] + lengths[2] + i][heart[1] - 1] == '*') {
				lengths[3]++;
			} else {
				break;
			}
		}

		// 오른다리
		for (int i = 1; i < N; i++) {
			if (heart[0] + lengths[2] + i >= N) {
				break;
			}
			if (cookie[heart[0] + lengths[2] + i][heart[1] + 1] == '*') {
				lengths[4]++;
			} else {
				break;
			}
		}

		sb.append((heart[0] + 1) + " " + (heart[1] + 1) + "\n");
		for (int i = 0; i < 5; i++) {
			sb.append(lengths[i] + " ");
		}
		System.out.println(sb.toString());
	}
}
