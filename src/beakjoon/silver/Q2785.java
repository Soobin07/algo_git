package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//체인
public class Q2785 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] list = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list);

		int cnt = 0;
		int first_idx = 0;
		int last_idx = N - 1;
		while (true) {
			// 제일 앞까지 묶었으면 종료
			if (first_idx >= last_idx)
				break;

			// 제일 짧은 체인에서 하나를 빼서
			list[first_idx]--;
			// 제일 뒤의 체인 두개를 이어준다
			last_idx--;
			// 하나 여닫는 작업을 했다
			cnt++;

			// 제일 짧은 체인이 0이 되면 다음 체인을 사용한다
			if (list[first_idx] == 0)
				first_idx++;

		}
		System.out.println(cnt);
	}
}
