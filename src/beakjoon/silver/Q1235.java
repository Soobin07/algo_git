package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

//학생 번호
public class Q1235 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 학생 수
		String[] arr = new String[N];

		int ans = 0; // 학생을 구별 할 수 있는 최소 자리수

		// 입력
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}

		int max = arr[0].length(); // 최대 자리수

		HashSet<String> num = new HashSet<>();
		next: for (int i = 1; i <= max; i++) { // 자리수 갯수
			for (int j = 0; j < N; j++) { // 각 학생 번호
				String tmp = arr[j].substring(max - i, max);
				if (!num.contains(tmp)) {
					num.add(tmp);
				} else {
					num.clear();
					continue next;
				}
			}
			ans = i;
			break next;
		}
		
		System.out.println(ans);
	}
}
