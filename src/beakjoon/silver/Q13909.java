package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//창문 닫기
public class Q13909 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		int num = 1;
		while (num * num <= N) {
			num += 1;
			ans += 1;
		}
		System.out.println(ans);
	}
}
