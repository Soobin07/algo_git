package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q3190 {
	static int[][] apples;
	static boolean[] useApples;
	static Deque<int[]> snake;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		//보드 크기
		int N = Integer.parseInt(br.readLine());
		//사과 갯수
		int K = Integer.parseInt(br.readLine());
		
		//사과 넣기
		apples = new int[K][2];
		useApples = new boolean[K];
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine());
			apples[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		
		//뱀의 방향 전환 횟수
		int L = Integer.parseInt(br.readLine());
		//뱀의 이동 방향
		int[] times = new int[L];
		char[] sides = new char[L];
		for(int i = 0 ; i < L ; i++) {
			st = new StringTokenizer(br.readLine());
			times[i] = Integer.parseInt(st.nextToken());
			sides[i] = st.nextToken().charAt(0);
		}
		
		//0:오른쪽(초기 방향), -1 => 왼쪽으로 90도, 1 : 오른쪽으로 90도
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		//게임 시간
		int time = 0;
		//현재 방향
		int banghyang = 0;
		int l = 0;
		//뱀 머리부터 꼬리를 넣은 Queue
		snake = new LinkedList<>();
		//뱀 처음 위치
		snake.addLast(new int[]{1, 1});
		while(true) {
			time++;
			//머리 있는 곳
			int[] tmp = snake.getLast();
			//이동하는 방향 확인
			if(l < L && times[l] == time - 1) {
				if(sides[l] == 'D') {
					banghyang += 1;
				}else {
					banghyang -= 1;
				}
				if(banghyang < 0)
					banghyang += 4;
				else if(banghyang >= 4)
					banghyang -= 4;
				//다음거 찾기 위해 l 올리기
				l++;
			}
			//전진하는 위치
			int[] go = new int[] {tmp[0] + dr[banghyang], tmp[1] + dc[banghyang]};
			//벽에 부딪쳤을 때
			if(go[0] <= 0 || go[0] > N || go[1] <= 0 || go[1] > N)
				break;
			//몸에 부딪쳤을 때
			if(snakeBoom(go))
				break;
			//간 곳에 사과 없을 때
			if(!hasApple(go))
				snake.pollFirst();
			
			snake.addLast(go);
		}
		System.out.println(time);
	}
	static boolean hasApple(int[] now) {
		for(int i = 0 ; i < apples.length ; i++) {
			if(!useApples[i] && Arrays.equals(now, apples[i])) {
				useApples[i] = true;
				return true;
			}
		}
		return false;
	}
	static boolean snakeBoom(int[] now) {
		int[][] tmp = snake.toArray(new int[0][]);
		for(int i = 0 ; i < snake.size() ; i++) {
			if(Arrays.equals(tmp[i], now)) {
				return true;
			}
		}
		return false;
	}
}
