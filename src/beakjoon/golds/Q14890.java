package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14890 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//조건 받기
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		//맵 받기
		int[][] map = new int[N][N];
		for(int r = 0 ; r < N ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < N ; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		
		//가로길
		outer : for(int r = 0 ; r < N ; r++) {
			//이미 사용된 칸인지 확인
			boolean[] visit = new boolean[N];
			
			//같은 수 갯수 확인해야 하는지 여부
			boolean flag = false;
			//같은 수 갯수
			int tmp = 0;
			
			//칸 하나씩 확인
			for(int c = 1 ; c < N ; c++) {
				//이전 칸과 차 확인
				int diff = map[r][c-1] - map[r][c];
				
				if(diff == 0) {
					//같은 수 갯수 확인해야 하는 경우
					if(flag) {
						//이미 사용된 칸이면 중복해서 경사로 들어가니까 못만든다
						if(visit[c])
							continue outer;
						tmp++;
						visit[c] = true;
						
						//같은 수 갯수 전부 채운 경우
						if(tmp == L)
							flag = false;
					}
				}else if(diff == 1) {
					//flag 있으면 중복 계단
					if(flag)
						continue outer;
					
					//L개 같은 수 이후에 나오는지 확인
					tmp = 1;
					flag = true;
					//이미 사용된 칸이면 중복해서 경사로 들어가니까 못만든다
					if(visit[c])
						continue outer;
					visit[c] = true;
					//같은 수 갯수 전부 채운 경우
					if(tmp == L)
						flag = false;
				}else if(diff == -1) {
					//flag 있으면 중복 계단
					if(flag)
						continue outer;
					//이전 칸이 더 작다. 앞쪽으로 확인해야 한다.
					for(int i = 1 ; i <= L ; i++) {
						//앞쪽에 확인할 길이 없다
						if(c-i < 0)
							continue outer;
						//높이가 다르다 -> L 부족하다
						if(map[r][c-1] != map[r][c-i])
							continue outer;
						//L이 들어가야 할 곳에 이미 다른 경사로 있으면 불가능
						if(visit[c-i])
							continue outer;
					}
				}else {
					//2이상 차이가 나면 그냥 못쓴다.
					continue outer;
				}
			}
			//flag가 다 끝나있으면 ans 추가하자
			if(!flag) {
				ans++;
			}
		}
		//세로길
		outer : for(int c = 0 ; c < N ; c++) {
			//이미 사용된 칸인지 확인
			boolean[] visit = new boolean[N];
			
			//같은 수 갯수 확인해야 하는지 여부
			boolean flag = false;
			//같은 수 갯수
			int tmp = 0;
			
			//칸 하나씩 확인
			for(int r = 1 ; r < N ; r++) {
				//이전 칸과 차 확인
				int diff = map[r-1][c] - map[r][c];
				
				if(diff == 0) {
					//같은 수 갯수 확인해야 하는 경우
					if(flag) {
						//이미 사용된 칸이면 중복해서 경사로 들어가니까 못만든다
						if(visit[r])
							continue outer;
						tmp++;
						visit[r] = true;
						
						//같은 수 갯수 전부 채운 경우
						if(tmp == L)
							flag = false;
					}
				}else if(diff == 1) {
					//flag 있으면 중복 계단
					if(flag)
						continue outer;
					
					//L개 같은 수 이후에 나오는지 확인
					tmp = 1;
					flag = true;
					//이미 사용된 칸이면 중복해서 경사로 들어가니까 못만든다
					if(visit[r])
						continue outer;
					//같은 수 갯수 전부 채운 경우
					if(tmp == L)
						flag = false;
					visit[r] = true;
				}else if(diff == -1) {
					//flag 있으면 중복 계단
					if(flag)
						continue outer;
					//이전 칸이 더 작다. 앞쪽으로 확인해야 한다.
					for(int i = 1 ; i <= L ; i++) {
						//앞쪽에 확인할 길이 없다
						if(r-i < 0)
							continue outer;
						//높이가 다르다 -> L 부족하다
						if(map[r-1][c] != map[r-i][c])
							continue outer;
						//L이 들어가야 할 곳에 이미 다른 경사로 있으면 불가능
						if(visit[r-i])
							continue outer;
					}
				}else {
					//2이상 차이가 나면 그냥 못쓴다.
					continue outer;
				}
			}
			//flag가 다 끝나있으면 ans 추가하자
			if(!flag) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
