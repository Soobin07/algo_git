package sw.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA6485 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input6485.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int T = sc.nextInt();
		for(int t = 1 ; t <= T ; t++) {
			int[] station = new int[5001];
			int N = sc.nextInt();
			for(int n = 0 ; n < N ; n++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				for(int j = A ; j <= B ; j++) {
					station[j]++;
				}
			}
			int P = sc.nextInt();
			sb.append("#").append(t).append(" ");
			for(int p = 1 ; p <= P ; p++) {
				int c = sc.nextInt();
				sb.append(station[c]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
