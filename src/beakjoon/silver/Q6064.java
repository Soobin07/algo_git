package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//카잉 달력
public class Q6064 {
	// M과 N보다 작거나 같은 두개의 자연수 x, y
	// 각 년도 x, y
	// 첫 번째 해는 <1:1> , 두 번째 해는 <2:2>
	// <x:y> 다음 해 <x':y'>

	// x<M이면 x' = x+1 else x' = 1
	// y<N이면 y' = y+1 else y' = 1
	// <M:N> 마지막 해
	// <x:y>는 몇번째 해?

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine()); // TC 갯수
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int ans = -1; // default = -1(답 없을 때)
			int max = lcm(M, N); // <M:N>이면 멸망 : 둘 다 최대 숫자 = 둘의 최소공배수
			// x, y 중 x 를 맞춰서 시작한다
			for (int i = x; i <= max; i += M) { // 이렇게 하면 x는 항상 동일, y만 바꾸며 확인 가능
				int tmp_y = i % N;
				if (tmp_y == 0)
					tmp_y = N;

				if (tmp_y == y) {
					ans = i;
					break;
				}
			}

			bw.append(ans + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	// 최대공약수
	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	// 최소공배수
	static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}
}
