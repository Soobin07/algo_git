package beakjoon.golds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q14499 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		//조건 받기
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//맵 받기
		int[][] map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//주사위 설정
		int[] dice = new int[7];	//값
		int[] now = new int[] {1, 4, 3, 5, 2, 6}; //front,동서북남,뒤
		
		//이동 설정
		int[] dr = {0, 0, 0, -1, 1};	//[0]안씀 동서북남
		int[] dc = {0, 1, -1, 0, 0};	//[0]안씀 동서북남
		//이동 하기
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < K ; i++) {
			int move = Integer.parseInt(st.nextToken());
			//지도 밖으로 나가려면 무시해라
			if(x + dr[move] < 0 || x + dr[move] >= N || y + dc[move] < 0 || y + dc[move] >= M)
				continue;
			//옮겨라
			x += dr[move];
			y += dc[move];
			//주사위 굴러간다
			now = move_dice(now, move);
			bw.append(dice[now[0]]+"\n");
			//적혀있는 수가 0인가
			if(map[x][y] == 0) {
				//바닥면을 칸에 복사해라
				map[x][y] = dice[now[5]];
			}else {
				//0아니면 칸을 바닥면에 복사하고 칸은 0으로 만들어라
				dice[now[5]] = map[x][y];
				map[x][y] = 0;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static int[] move_dice(int[] now, int move) {
		int[] moved = new int[6];
		switch(move) {
			case 1:
				moved[0] = now[1];
				moved[1] = now[5];
				moved[2] = now[0];
				moved[5] = now[2];
				moved[3] = now[3];
				moved[4] = now[4];
				break;
			case 2: 
				moved[0] = now[2];
				moved[1] = now[0];
				moved[2] = now[5];
				moved[5] = now[1];
				moved[3] = now[3];
				moved[4] = now[4];
				break;
			case 3: 
				moved[0] = now[3];
				moved[1] = now[1];
				moved[2] = now[2];
				moved[5] = now[4];
				moved[3] = now[5];
				moved[4] = now[0];
				break;
			case 4: 
				moved[0] = now[4];
				moved[1] = now[1];
				moved[2] = now[2];
				moved[5] = now[3];
				moved[3] = now[0];
				moved[4] = now[5];
				break;
		}
		return moved;
	}
}