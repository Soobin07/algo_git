package beakjoon.golds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

//환상의 짝궁
public class Q15711 {
	/*
	 * a+b를 소수 2개의 합으로 표현 가능한가?
	 */

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		//prime이면 false
		boolean[] isPrime = new boolean[2_000_001];	
		ArrayList<Long> prime = new ArrayList<>();

		// prime 찾기
		isPrime[0] = true;
		isPrime[1] = true;
		for (int i = 2; i < isPrime.length; i++) {
			if (isPrime[i])
				continue;
			prime.add((long) i);
			for (int j = i * 2; j < isPrime.length; j += i) {
				isPrime[j] = true;
			}
		}

		int TC = Integer.parseInt(br.readLine());
		outer : for (int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());

			long sum = a + b;
			if (sum <= 2) {
				bw.append("NO\n");
				continue;
			}
			// 짝수 -> 골드바흐 추측 (2이상 짝수는 두 소수의 합)
			if (sum % 2 == 0) {
				bw.append("YES\n");
				continue;
			}
			// 홀수 -> 2 + prime 일 경우만 prime (2 제외하고 모두 홀수라서..)
			sum -= 2;

			// isPrime 있는 애들
			if (sum == 1) {
				bw.append("NO\n");
				continue;
			} else if (sum < isPrime.length) {
				if (isPrime[(int) sum])
					bw.append("NO\n");
				else
					bw.append("YES\n");
				continue;
			}

			// isPrime 길이보다 긴 경우
			for (Long tmp : prime) {
				//isPrime으로 나눠지는 애들 = 소수 아님
				if (sum % tmp == 0) {
					bw.append("NO\n");
					continue outer;
				}
			}
			bw.append("YES\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
