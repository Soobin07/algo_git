package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10431 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuffer sb = new StringBuffer();

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			// arr 넣기
			int[] arr = new int[20];
			st = new StringTokenizer(br.readLine());
			sb.append(st.nextToken() + " "); // 버리는 TC 수, 답안 위한 곳에 넣기
			int ans = 0;
			label: for (int i = 0; i < 20; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				// arr 안에 나보다 더 큰 수 있어?
				for (int j = 0; j < i; j++) {
					// 있어
					if (arr[j] > tmp) {
						// j앞에 서고 뒤의 애들 하나씩 뒤로
						for (int k = i; k > j; k--) {
							arr[k] = arr[k - 1];
						}
						// j자리에 이 수를 넣자
						arr[j] = tmp;
						// 이전까지 있었던 모든 숫자가 한칸씩 뒤로 간거니까
						ans += i - j;
						// 다음 숫자 넣으러 가자
						continue label;
					}
				}
				// 없으면 제일 뒤에 넣고 넘기자
				arr[i] = tmp;
			}
			sb.append(ans + "\n");
		}
		// 마지막 엔터 지우기
		sb.setLength(sb.length() - 1);
		System.out.print(sb.toString());
	}
}
