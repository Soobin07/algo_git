import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dh = { 0, 0, 0, 0, -1, 1 };
	static int[] dr = { -1, 1, 0, 0, 0, 0 };
	static int[] dc = { 0, 0, -1, 1, 0, 0 };

	static class Node{
		int m, n, h, c;

		public Node(int m, int n, int h, int c) {
			this.m = m;
			this.n = n;
			this.h = h;
			this.c = c;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + h;
			result = prime * result + m;
			result = prime * result + n;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (h != other.h)
				return false;
			if (m != other.m)
				return false;
			if (n != other.n)
				return false;
			return true;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 가로
		int N = Integer.parseInt(st.nextToken()); // 세로
		int H = Integer.parseInt(st.nextToken()); // 높이

		int minus = 0;
		int cnt = 0;
		boolean[][][] visit = new boolean[H][N][M]; // 간곳
		Queue<Node> q = new LinkedList<>(); // 주변
		int[][][] box = new int[H][N][M]; // 박스
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					box[h][n][m] = Integer.parseInt(st.nextToken());
					if (box[h][n][m] == 1) {
						Node tmp = new Node(m,n,h,0);
						visit[h][n][m] = true;
						q.add(tmp);
						cnt++;
					}else if(box[h][n][m] == -1) {
						minus++;
						visit[h][n][m] = true;
					}
				}
			}
		} // 박스 채우기, 익은거 모으기

		int biggest = 0;
		while(!q.isEmpty()) {
			Node now = q.poll();
			for(int i = 0 ; i < 6 ; i++) {	//delta
				int tmpm = now.m+dr[i]; 
				int tmpn = now.n+dc[i];
				int tmph = now.h+dh[i];
				
				//인덱스 확인
				if(tmpm < 0 || tmpn < 0 || tmph < 0 || tmpm >= M || tmpn >= N || tmph >= H) continue;
				//이미 간 곳인가
				Node tmp = new Node(tmpm, tmpn, tmph, now.c+1);
				if(visit[tmph][tmpn][tmpm]) continue;
				//안익은 토마토인가
				if(box[tmph][tmpn][tmpm] == 0) {
					box[tmph][tmpn][tmpm] = 1;
					q.add(tmp);
					visit[tmph][tmpn][tmpm] = true;
					biggest = Math.max(biggest, tmp.c);
					cnt++;
				}
			}
		}
		
		if(cnt+minus == M*N*H) {
			System.out.println(biggest);
		}else {
			System.out.println(-1);
		}
	}
}
