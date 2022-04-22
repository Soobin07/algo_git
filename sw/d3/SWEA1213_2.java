package sw.d3;

import java.io.FileInputStream;
import java.util.Scanner;

//for문으로
public class SWEA1213_2 {
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
			
			char c , p;
			
			//1안
//			for(int i = 0 ; i < N-M+1 ; i++) {
//				for(int j = 0 ; j < M ; j++) {
//					if(text.charAt(i+j) != pattern.charAt(j)) {
//						break;
//					}else if(j == M-1) {
//						count++;
//					}
//				}
//			}
			
			//2안
			for(int i = 0 ; i < N-M+1 ; i++) {
				boolean flag = true;
				for(int j = 0 ; j < M ; j++) {
					if(text.charAt(i+j) != pattern.charAt(j)) {
						flag = false; break;
					}
				}
				if(flag) count++;
			}
			
			System.out.printf("#%d %d%n", tc, count);
		}
	}
}
