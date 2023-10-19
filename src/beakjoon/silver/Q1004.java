package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1004 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			// 시작점
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			// 도착점
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			// 행성별 지나가야 하나?
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			
			//행성 안에 있나?
			boolean[] in = new boolean[N];
			
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				int x3 = Integer.parseInt(st.nextToken());
				int y3 = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int a1 = getAns(x1, y1, x3, y3, r, n, in);
				int a2 = getAns(x2, y2, x3, y3, r, n, in);
				
				if(in[n]) {
					cnt += (a1 + a2);
				}
			}

			bw.append(cnt + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	static int getAns(int x, int y, int x3, int y3, int r, int n, boolean[] in) {
		// 점과 행성의 중심점 간의 거리
		long dis_pow = (long)(Math.pow(x3 - x, 2) + Math.pow(y3 - y, 2));

		// xy가 원 안에 있을 때
		if (dis_pow <= Math.pow(r,2)) {
			//둘 다 같은 행성 안에 있으면 패스하기
			if(!in[n]) {
				in[n] = true;
				return 1;
			}else {
				in[n] = false;
			}
		}
		return 0;
	}
}
