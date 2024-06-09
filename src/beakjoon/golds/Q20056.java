package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q20056 {
	static class FireBall implements Comparable<FireBall> {
		// 맵 안에서 돌게 하기 위해 r,c는 함수 통해서만 변경 가능
		private int r, c;
		// m, s, d는 쉽게 접근 가능
		int m, s, d;

		public FireBall(int r, int c, int m, int s, int d) {
			setR(r);
			setC(c);
			this.m = m;
			this.s = s;
			this.d = d;
		}

		public int getR() {
			return r;
		}

		public void setR(int r) {
			this.r = r;
			if (this.r > N) {
				this.r %= N;
			} 
			if (this.r <= 0) {
				this.r = N - Math.abs(this.r % N);
			}
		}

		public int getC() {
			return c;
		}

		public void setC(int c) {
			this.c = c;
			if (this.c > N) {
				this.c %= N;
			} 
			if (this.c <= 0) {
				this.c = N - Math.abs(this.c % N);
			}
		}

		@Override
		public int compareTo(FireBall o) {
			if (this.r < o.getR())
				return -1;
			else if (this.r == o.getR()) {
				if (this.c < o.getC())
					return -1;
				if (this.c == o.getC())
					return 0;
			}
			return 1;
		}

		@Override
		public String toString() {
			return "[r=" + r + ", c=" + c + ", m=" + m + ", s=" + s + ", d=" + d + "]";
		}
	}

	static int N, M, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 기본 조건 받기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		ArrayList<FireBall> balls = new ArrayList<>();
		// 파이어볼 개체 받기
		for (int i = 0; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			balls.add(new FireBall(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		// 이동 방향 설정
		int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
		// 이동
		PriorityQueue<FireBall> pq = new PriorityQueue<>();
		ArrayList<FireBall> tmp = new ArrayList<>();
		while (K-- > 0) {
			pq.clear();
			// 모든 파이어볼이 이동한다
			for (FireBall b : balls) {
				// d * s 만큼 이동
				b.setR(b.getR() + dr[b.d] * b.s);
				b.setC(b.getC() + dc[b.d] * b.s);
				pq.add(b);
			}
			balls.clear();

			// 파이어볼 겹치는거 찾아서 처리하기
			int i = pq.size();
			for (; i > 0; i--) {
				FireBall now = pq.poll();
				// 같은 위치에 있는 것을 찾아라
				// 비교 대상 없는 경우 비교 대상을 넣어준다
				if (tmp.size() == 0) {
					tmp.add(now);
					continue;
				}
				// 비교 대상이 있는 경우
				// 같은 위치에 있으면
				if (tmp.get(0).getR() == now.getR() && tmp.get(0).getC() == now.getC()) {
					tmp.add(now);
				} else {
					// 다른 위치면
					// 2개 이상이었는지 확인하기
					simul(tmp, balls);
					tmp.add(now);
				}
			}
			// 끝나면 마지막 남은거 돌리기
			simul(tmp, balls);
		}
		long ans = 0;
		for (FireBall b : balls) {
			ans += b.m;
		}
		System.out.println(ans);
	}

	static void simul(ArrayList<FireBall> tmp, ArrayList<FireBall> balls) {
		// 다른 위치면
		// 2개 이상이었는지 확인하기
		if (tmp.size() >= 2) {
			// 같은 칸 파이어볼을 하나로 만들기
			int r = tmp.get(0).getR();
			int c = tmp.get(0).getC();
			int m = 0;
			int s = 0;
			int d = tmp.get(0).d;
			boolean sameD = true;
			for (FireBall b : tmp) {
				m += b.m;
				s += b.s;
				if (d % 2 != b.d % 2)
					sameD = false;
			}
			// 질량을 5로 나누고
			m /= 5;
			// 질량이 0 초과일 경우에만 나눠주고 0인 경우에는 무시한다(소멸)
			if (m > 0) {
				// 속력을 파이어볼 갯수로 나누고
				s /= tmp.size();
				// 모두 모두 짝수나 홀수면 짝수방향, 아니면 홀수방향
				int d_start = sameD ? 0 : 1;
				// 파이어볼을 4개로 나누기
				for (int f = 0; f < 4; f++) {
					balls.add(new FireBall(r, c, m, s, f * 2 + d_start));
				}
			}
		} else {
			// 1개였으면 파이어볼을 리스트에 넣기
			if(!tmp.isEmpty())
				balls.add(tmp.get(0));
		}
		// tmp 초기화 후 다시 넣기
		tmp.clear();
	}
}
