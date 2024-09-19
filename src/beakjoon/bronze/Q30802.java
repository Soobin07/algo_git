package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 웰컴 키트
public class Q30802 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine()); // 참가자의 수

		int[] size = new int[6]; // S,M,L,XL,XXL,XXXL
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			size[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken()); // 티셔츠 묶음 수
		int P = Integer.parseInt(st.nextToken()); // 펜 묶음 수

		int t_cnt = 0;
		for (int i = 0; i < 6; i++) {
			t_cnt += Math.ceil(1.0 * size[i] / T);
		}
		System.out.println(t_cnt);
		System.out.println(N / P + " " + N % P);
	}
}
