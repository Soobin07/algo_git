package sw.d3;

import java.io.FileInputStream;
import java.util.Scanner;

//while문으로
public class SWEA1213 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input1213.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int T = 10;
		for(int t = 1 ; t <= T ; t++) {
			int tc = Integer.parseInt(sc.nextLine());
			String pattern = sc.nextLine();
			String text = sc.nextLine();
			
			int N = text.length();
			int M = pattern.length();
			int count = 0;
			
			int t_idx = 0;
			int p_idx = 0;
			
			char c , p;
			while(t_idx < N) {
				c = text.charAt(t_idx);
				p = pattern.charAt(p_idx);
				
				if(c != p) {
					t_idx -= p_idx;
					p_idx = -1;
				}else if(p_idx == M-1) {
					count++;
					p_idx = -1;
				}
				t_idx++;
				p_idx++;
				
			}
			System.out.printf("#%d %d%n", tc, count);
//			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
//		System.out.print(sb.toString());
	}
}
