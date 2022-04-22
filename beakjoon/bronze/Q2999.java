package beakjoon.bronze;

import java.util.Scanner;

public class Q2999 {
	static String input1 = "bok";	//bok
	static String input2 = "koaski";	//kakosi
	static String input3 = "boudonuimilcbsai";
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input2);
		StringBuffer sb = new StringBuffer();
		
		String line = sc.nextLine();
		
		//가능한 R, C 구하기	(j >= i이면서 i가 가장 큰 수)
		int length = line.length();
		int r = 0;
		int c = 0;
		for(int j = 1 ; j <= length ;j++) {
			for(int i = 1 ; i <= j ; i++) {
				if(j*i == length && r < i) {
					r = i;
					c = j;
				}
			}
		}

		char[][] map = new char[r][c];
		int index = 0;
		for(int j = 0 ; j < c ; j++) {
			for(int i = 0 ; i < r ; i++) {
				map[i][j] = line.charAt(index++);
			}
		}
		for(int i = 0 ; i < r ; i++) {
			for(int j = 0 ; j < c ; j++) {
				sb.append(map[i][j]); 
			}
		}
		
		System.out.println(sb.toString());
	}
}
