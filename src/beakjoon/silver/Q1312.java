package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//소수
public class Q1312 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		// 소숫점 윗 부분 다 나눠주고
		int ans = A / B;
		A %= B;
		// 소숫점 부분
		for (int i = 1; i <= N; i++) {
			A *= 10; // 0 붙여주고
			ans = A / B;
			A %= B;
		}
		System.out.println(ans);
	}
}
