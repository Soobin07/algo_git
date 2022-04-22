package beakjoon.bronze;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Q1268 {
	static String input1 = "5\r\n" + 
			"2 3 1 7 3\r\n" + 
			"4 1 9 6 8\r\n" + 
			"5 5 2 4 4\r\n" + 
			"6 5 2 6 7\r\n" + 
			"8 4 2 2 2";	//4
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input1);
		StringTokenizer st;
		
		int N = Integer.parseInt(sc.nextLine());
		int[][] student_log = new int[N][5];
		boolean[][] same_class = new boolean[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(sc.nextLine());
			for(int j = 0 ; j < 5 ; j++) {
				student_log[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		for( int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(i == j ) continue;
				for(int g = 0 ; g < 5 ; g++) {
					if(student_log[i][g] == student_log[j][g] && !same_class[i][j]) {
						same_class[i][j] = true;
					}
				}
			}
		}
		
		int max = 0;
		int std_no = 0;
		for(int i = 0 ; i < N ; i++) {
			int count = 0;
			for(int j = 0 ; j < N ; j++) {
				if(same_class[i][j]) count++;
			}
			if(count > max) {
				max = count;
				std_no = i;
			}
		}
		
		System.out.println(std_no+1);
	}
}
