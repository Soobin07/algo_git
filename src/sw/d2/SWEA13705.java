package sw.d2;

import java.io.FileInputStream;
import java.util.Scanner;

//1. 1,1부터 시작하는 map ==> 한칸 더 크게 만든다  /or/ 좌표계산할 때 -1하고 생각할게
public class SWEA13705 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input13705.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int T = sc.nextInt();
		for(int t = 1 ; t <= T ; t++) {
			sb.append("#").append(t).append(" ");
			int N = sc.nextInt();
			int M = sc.nextInt();
			int R = sc.nextInt();
			int C = sc.nextInt();
			int D = sc.nextInt();
			
			int[][] map = new int[N][N];
			map[R-1][C-1] = M;
			
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					int max = Math.max(Math.abs(i-(R-1)), Math.abs(j-(C-1)));
					if(M+D*max < 0) {
						map[i][j] = 0;
					}else if(M+D*max > 255) {
						map[i][j] = 255;
					}else {
						map[i][j] = M+D*max;
					}
				}
			}
			
			for(int i = 0 ; i < N ; i++) {
				int sum = 0;
				for(int j = 0 ; j < N ; j++) {
					sum += map[i][j];
				}
				sb.append(sum).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
