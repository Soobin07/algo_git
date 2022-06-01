package sw.d2;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA1954 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/sw/input1954.txt"));
		Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ").append("\n");
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			int num = 1;
			int idx = 0;	//몇번 순회?
			while(num <= N*N) {
				//상
				for(int i = 0 ; i < N ; i++) {
					if(arr[idx][i] == 0) arr[idx][i] = num++;
				}
				//우
				for(int i = 1 ; i < N ;i++) {	//맨 위는 찼을테니까
					if(arr[i][N-1-idx] == 0) arr[i][N-1-idx] = num++;
				}
				//하
				for(int i = 1 ; i < N ; i++) {	//제일 오른쪽은 찼으니까
					if(arr[N-1-idx][N-1-i] == 0) arr[N-1-idx][N-1-i] = num++;
				}
				//좌
				for(int i = 1 ; i < N ; i++) {	//제일 아래는 찼으니까
					if(arr[N-1-i][idx] == 0) arr[N-1-i][idx] = num++;
				}
				idx++;
			}
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}
