package sw.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1220 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input1220.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int T = 10;	//테스트케이스
		
		for(int t = 1 ; t <= T ; t++) {	//테스트케이스만큼 반복
			
			int N = Integer.parseInt(br.readLine());	//맵 크기
			int[][] map = new int[N][N];				//맵 2차원 배열 생성
			
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());	//맵 생성
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			
			int answer = 0;
			for(int i = 0 ; i < N ; i++) { //세로로 한줄씩	
				boolean has1 = false;		//1 있으면 2 찾는다
				for(int j = 0 ; j < N ; j++) {
					if(map[j][i] == 1) {
						has1 = true;
					}
					if(map[j][i] == 2 && has1) {
						answer++;
						has1 = false;
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
//실패. 근데 열심히 해서 남겨놨어
//	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("data/sw/input1220.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuffer sb = new StringBuffer();
//		StringTokenizer st;
//		
//		int T = 10;	//테스트케이스
//		
//		for(int t = 1 ; t <= T ; t++) {	//테스트케이스만큼 반복
//			
//			int N = Integer.parseInt(br.readLine());	//맵 크기
//			int[][] map = new int[N][N];				//맵 2차원 배열 생성
//			
//			for(int i = 0 ; i < N ; i++) {
//				st = new StringTokenizer(br.readLine());	//맵 생성
//				for(int j = 0 ; j < N ; j++) {
//					map[i][j] = Integer.parseInt(st.nextToken()); 
//				}
//			}
//			
//			boolean isMove = true;
//			while(isMove) {
//				isMove = false;
//				for(int i = 0 ; i < N ; i++) {
//					for(int j = 0 ; j < N ; j++) {
//						if(map[i][j] == 1) {
//							if(i-1 < 0) {
//								map[i][j]=0;
//							}else if(map[i-1][j] == 3 || map[i-1][j] == 4 ||map[i-1][j] == 2){
//								map[i][j]=3;
//							}else {	//아래 1이면?ㅋㅋ ㄱㅊ! 두개 겹쳐도 ㄱㅊ
//								map[i][j] = 0;
//								map[i-1][j] = 1;
//							}
//							isMove = true;
//						}else if(map[i][j] == 2) {
//							if(i+1 >= N) {
//								map[i][j]=0;
//							}else if(map[i+1][j] == 3 || map[i+1][j] == 4 || map[i+1][j] == 1){
//								map[i][j]=4;
//							}else {
//								map[i][j] = 0;
//								map[i+1][j] = 2;
//							}
//							isMove = true;
//						}
//					}
//				}
//			}
//			
//			int deadlockCnt = 0;
//			for(int i = 0 ; i < N-1 ; i++) {
//				for(int j = 0 ; j < N ; j++) {
//					if(map[i][j] == 4 && map[i+1][j] == 3) {
//						deadlockCnt++;
//					}
//				}
//			}
//			
//			sb.append("#").append(t).append(" ").append(deadlockCnt).append("\n");
//		}
//		System.out.println(sb);
//	}
}
