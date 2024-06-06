package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//확실히 Queue보다 array가 빠르다. array를 우선적으로 활용하는 것이 성능면에서 더 좋을 것 같다.
public class Q21610_3 {
	static int N, M;
	static int[][] map;
	static int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1}; //[0]안씀
	static int[] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1}; //[0]안씀
	static boolean[][] cloud, visit;	//구름, 이전 구름
	static int[] dirs, lens;	//방향, 거리
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//맵 크기, 이동 크기 받기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//초기 구름 설정
		cloud = new boolean[N+1][N+1];
		cloud[N][1] = cloud[N][2] = cloud[N-1][1] = cloud[N-1][2] = true;
		
		//맵 받기
		map = new int[N+1][N+1];
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//이동 받기
		dirs = new int[M];
		lens = new int[M];
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			dirs[i] = Integer.parseInt(st.nextToken());
			lens[i] = Integer.parseInt(st.nextToken());
		}
		
		//이동 끝나면 종료
		for(int m = 0 ; m < M ; m++) {
			visit = new boolean[N+1][N+1];
			//1. 이동
			for(int i = 1 ; i <= N ; i++) {
				for(int j = 1 ; j <= N ; j++) {
					if(cloud[i][j]) {
						int x = (i + dr[dirs[m]]*lens[m]) % N;
						if(x <= 0) x += N;
						int y = (j + dc[dirs[m]]*lens[m]) % N;
						if(y <= 0) y += N;
						//1. 구름이 di, si움직임
						visit[x][y] = true;
						//2. 현재 구름 칸에 비 양이 늘어난다
						map[x][y]++;
					}
				}
			}
			//3. 구름 다 사라짐 => 사실 위에서 끝났지만 한번 더 명시
			cloud = new boolean[N+1][N+1];
			
			//4. 2에서 물 증가한 [r][c]의 대각선에 물이 있는 칸의 갯수만큼 물 증가
			for(int i = 1 ; i <= N ; i++) {
				for(int j = 1 ; j <= N ; j++) {
					if(visit[i][j]) {
						int cnt = 0;
						for(int k = 1 ; k <= 4 ; k++) {
							int tmp_r = i + dr[k * 2];
							int tmp_c = j + dc[k * 2];
							if(tmp_r > N || tmp_r <= 0 || tmp_c > N || tmp_c <= 0)
								continue;
							if(map[tmp_r][tmp_c] > 0)
								cnt++;
						}
						map[i][j] += cnt;
					}
				}
			}
			
			//5. 초기 구름 설정
			for(int i = 1 ; i <= N ; i++) {
				for(int j = 1 ; j <= N ; j++) {
					if(map[i][j] >= 2 && !visit[i][j]) {
						map[i][j] -= 2;
						cloud[i][j] = true;
					}
				}
			}
		}
		
		//전체 더한 값 가져오기
		long ans = 0L;
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				ans += map[i][j];
			}
		}
		
		System.out.println(ans);
	}
}
