package jungol;

import java.util.Scanner;

public class C1037 {
	static String input1 = "4\r\n" + 
			"1 0 1 0\r\n" + 
			"0 0 0 0\r\n" + 
			"1 1 1 1\r\n" + 
			"0 1 0 1";	//OK
	static String input2 = "4\r\n" + 
			"1 0 1 0\r\n" + 
			"0 0 1 0\r\n" + 
			"1 1 1 1\r\n" + 
			"0 1 0 1";	//Change bit (2,3)
	static String input3 = "4\r\n" + 
			"1 0 1 0\r\n" + 
			"0 1 1 0\r\n" + 
			"1 1 1 1\r\n" + 
			"0 1 0 1";	//Corrupt
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input3);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		int icorr = -1;
		int jcorr = -1;
		String ans = "Corrupt";
		
		//맵 넣기
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		//가로 확인
		for(int i = 0 ; i < N ; i++) {
			int tmp = 0;
			for(int j = 0 ; j < N ; j++) {
				tmp+=map[i][j];
			}
			if(tmp%2 == 1) {
				if(icorr == -1) icorr = i;
				else {
					System.out.println(ans); 
					return;
				}
			}
		}
		//세로 확인
		for(int j = 0 ; j < N ; j++) {
			int tmp = 0;
			for(int i = 0 ; i < N ; i++) {
				tmp+=map[i][j];
			}
			if(tmp%2 == 1) {
				if(jcorr == -1) jcorr = j;
				else {
					System.out.println(ans); 
					return;
				}
			}
		}
		//오케이
		if(icorr == -1 && jcorr == -1) ans="OK";
		//둘 다 아닌경우
		if(icorr != -1 && jcorr != -1) {
			ans = "Change bit ("+(icorr+1)+","+(jcorr+1)+")";
		}
		System.out.println(ans);
	}
}
