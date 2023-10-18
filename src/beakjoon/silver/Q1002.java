package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1002 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			bw.append(getAns(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	static int getAns(int x1, int y1, int r1, int x2, int y2, int r2) {
		// 중심점 거리 차이
		long dis_pow = (long) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

		// 똑같은 원 => 있을 수 있는 위치 무한대
		if (x1 == x2 && y1 == y2 && r1 == r2) {
			return -1;
		}
		// 멀어서 안만남
		if (dis_pow > Math.pow(r1 + r2, 2)) {
			return 0;
		}
		// 하나가 안만나게 안에 들어있는 원 => 안만남
		if (dis_pow < Math.pow(r2 - r1, 2)) {
			return 0;
		}

		// 한 점에서 만날 때 (내접)
		if (dis_pow == Math.pow(r2 - r1, 2)) {
			return 1;
		}
		// 밖에서 만날 때 (외접)
		if (dis_pow == Math.pow(r1 + r2, 2)) {
			return 1;
		}
		return 2;
	}
}
