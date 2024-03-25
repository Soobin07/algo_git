package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

//우체국
public class Q2141 {
	static class Town implements Comparable<Town> {

		int loc, p_cnt;

		public Town() {
		}

		public Town(int loc, int p_cnt) {
			this.loc = loc;
			this.p_cnt = p_cnt;
		}

		@Override
		public int compareTo(Town o) {
			return loc - o.loc;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine()); // 마을 갯수
		Town[] arr = new Town[N]; // 마을 배열

		// 입력
		BigInteger sum = new BigInteger("0"); // 최대가 마을 * 최대인원수 = 100_000 * 1_000_000_000
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Town(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			sum = sum.add(new BigInteger("" + arr[i].p_cnt));
		}

		// 거리 순으로
		Arrays.sort(arr);
		sum = sum.add(new BigInteger("1"));
		sum = sum.divide(new BigInteger("2"));

		// 반절정도 되면 간다
		BigInteger tmp = new BigInteger("0");
		for (int i = 0; i < N; i++) {
			tmp = tmp.add(new BigInteger("" + arr[i].p_cnt));
			if (sum.compareTo(tmp) <= 0) {
				System.out.println(arr[i].loc);
				break;
			}
		}
	}
}
