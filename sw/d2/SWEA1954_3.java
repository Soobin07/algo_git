package sw.d2;

import java.io.FileInputStream;
import java.util.Scanner;

//박준혁님 코드
public class SWEA1954_3 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/sw/input1954.txt"));
		Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			//현재 나의 좌표
			int r = 0;
			int c = 0;
			int count = 1;
			
			arr[0][0] = 1;
			int len = N-1;
			while(len >= 0) {
				arr[r][c] = count;
				for(int i = 0; i < len; i++) arr[r][c++] = count++; // L
	            for(int i = 0; i < len; i++) arr[r++][c] = count++; // D
	            for(int i = 0; i < len; i++) arr[r][c--] = count++; // R
	            for(int i = 0; i < len; i++) arr[r--][c] = count++; // R
	            r++;
	            c++;
	            len -= 2;
			}
			sb.append("#").append(t).append(" ").append("\n");
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
