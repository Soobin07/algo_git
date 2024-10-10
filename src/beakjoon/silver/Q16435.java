package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//스네이크버드
public class Q16435 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 과일의 개수
		int N = Integer.parseInt(st.nextToken());
		// 초기 길이
		int L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] fruit = new int[N];
		for (int i = 0; i < N; i++) {
			fruit[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(fruit);

		for (int i = 0; i < N; i++) {
			if (L >= fruit[i])
				L++;
			else
				break;
		}
		System.out.println(L);
	}
}
