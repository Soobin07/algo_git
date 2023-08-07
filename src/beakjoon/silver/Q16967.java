package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q16967 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//HWXY 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] CONS = new int[4]; // HWXY
		for(int i = 0 ; i < 4 ; i++) {
			CONS[i] = Integer.parseInt(st.nextToken());
		}
		
		//배열B 받기
		int[][] B = new int[CONS[0]+CONS[2]][CONS[1]+CONS[3]];
		for(int i = 0 ; i < CONS[0]+CONS[2] ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < CONS[1]+CONS[3] ; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//배열A 찾기
		int[][] A = new int[CONS[0]][CONS[1]];
		//반복계산 피하기 위함
		boolean[][] visit = new boolean[CONS[0]][CONS[1]];
		
		//가로부분
		//1. [0+X] 전까지는 A원본 그대로다 (1 <= X 이므로 무조건 한줄 이상 있을 것이다)
		for(int i = 0 ; i < CONS[2] ; i++) {
			for(int j = 0 ; j < CONS[1] ; j++) {
				if(!visit[i][j]) {
					A[i][j] = B[i][j];
					visit[i][j] = true;
				}
			}
		}
		//2. [H][Y] 부터 [H - 1 + X][W - 1 + Y]는 A 원본 그대로다
		for(int i = CONS[0] ; i < B.length ; i++) {
			for(int j = CONS[3] ; j < B[i].length ; j++) {
				if(!visit[i - CONS[2]][j - CONS[3]]) {
					A[i - CONS[2]][j - CONS[3]] = B[i][j];
					visit[i - CONS[2]][j - CONS[3]] = true;
				}
			}
		}
		
		//세로부분
		//1. [0][0] ~ [H][0 + Y - 1]까지는 A 원본 그대로다
		for(int i = 0 ; i < CONS[0] ; i++) {
			for(int j = 0 ; j < CONS[3] ; j++) {
				if(!visit[i][j]) {
					A[i][j] = B[i][j];
					visit[i][j] = true;
				}
			}
		}
		//2. [X][W] ~ [H + X - 1][W + Y - 1]까지는 A원본 그대로다
		for(int i = CONS[2]; i < B.length ; i++) {
			for(int j = CONS[1] ; j < B[i].length ; j++) {
				if(!visit[i-CONS[2]][j-CONS[3]]) {
					A[i-CONS[2]][j-CONS[3]] = B[i][j];
					visit[i - CONS[2]][j - CONS[3]] = true;
				}
			}
		}
		
		
		//겹치는 부분 계산
		//3. [X][0]부터 [W - 1 - Y]까지는 두 배열의 겹치는 부분들을 더해준다
		// =>  한쪽을 알면 다른 쪽은 쉽게 구할 수 있을 것이다
		for(int i = CONS[2] ; i < B.length - CONS[2] ; i++) {
			for(int j = CONS[3] ; j < B[i].length - CONS[3] ; j++) {
				if(!visit[i][j]) {
					//A[i][j] = B[i][j] - A[i-CONS[2]][j-CONS[3]]
					A[i][j] = B[i][j] - A[i-CONS[2]][j-CONS[3]];
					visit[i][j] = true;
				}
			}
		}
		
		
		//출력
		for(int i = 0 ; i < A.length ; i++) {
			for(int j = 0 ; j < A[i].length ; j++) {
				bw.append(A[i][j]+"");
				if(j != A[i].length - 1)
					bw.append(" ");
			}
			bw.append("\n");
		}
		bw.flush();
	}
}
