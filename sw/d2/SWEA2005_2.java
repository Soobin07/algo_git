package sw.d2;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA2005_2 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input2005.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int T = sc.nextInt();
		int t = T;
		while(t-->0) {
			sb.append("#").append(T-t).append("\n").append(1).append("\n");	//1은 항상 가장 위니까..
			int N = sc.nextInt();
			int[] up = {1};
			int[] down;
			for(int i = 1 ; i < N ; i++) {
				down = new int[i+1];
				for(int j = 0 ; j < down.length; j++) {
					if(j == 0 || j == down.length-1) {
						down[j] = 1;
						sb.append(down[j]).append(" ");
						continue;
					}
					down[j] = up[j-1]+up[j];
					sb.append(down[j]).append(" ");
				}
				up = down;
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());
	}
}
