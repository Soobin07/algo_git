package sw.d3;

import java.io.FileInputStream;
import java.util.Scanner;

//완전탐색 (while문 사용)
public class SWEA1215_2 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input1215.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for(int t = 1 ; t <= 10 ; t++) {
			int count = 0;
			int p_len = Integer.parseInt(sc.nextLine());
			char[][] map = new char[8][8];
			
			//map 넣기
			for(int i = 0 ; i < 8 ; i++) {
				String tmp = sc.nextLine();
				for(int j = 0 ; j < 8 ; j++) {
					map[i][j] = tmp.charAt(j);
				}
			}
			System.out.printf("#%d %d%n", t, count);
		}
	}
}
