package beakjoon.silver;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Q1018 {
	static String input1 = "8 8\r\n" + 
			"WBWBWBWB\r\n" + 
			"BWBWBWBW\r\n" + 
			"WBWBWBWB\r\n" + 
			"BWBBBWBW\r\n" + 
			"WBWBWBWB\r\n" + 
			"BWBWBWBW\r\n" + 
			"WBWBWBWB\r\n" + 
			"BWBWBWBW";	//1
	static String input2 = "10 13\r\n" + 
			"BBBBBBBBWBWBW\r\n" + 
			"BBBBBBBBBWBWB\r\n" + 
			"BBBBBBBBWBWBW\r\n" + 
			"BBBBBBBBBWBWB\r\n" + 
			"BBBBBBBBWBWBW\r\n" + 
			"BBBBBBBBBWBWB\r\n" + 
			"BBBBBBBBWBWBW\r\n" + 
			"BBBBBBBBBWBWB\r\n" + 
			"WWWWWWWWWWBWB\r\n" + 
			"WWWWWWWWWWBWB";//12
	static String input3 = "8 8\r\n" + 
			"BWBWBWBW\r\n" + 
			"WBWBWBWB\r\n" + 
			"BWBWBWBW\r\n" + 
			"WBWBWBWB\r\n" + 
			"BWBWBWBW\r\n" + 
			"WBWBWBWB\r\n" + 
			"BWBWBWBW\r\n" + 
			"WBWBWBWB";//0
	static String input4 = "9 23\r\n" + 
			"BBBBBBBBBBBBBBBBBBBBBBB\r\n" + 
			"BBBBBBBBBBBBBBBBBBBBBBB\r\n" + 
			"BBBBBBBBBBBBBBBBBBBBBBB\r\n" + 
			"BBBBBBBBBBBBBBBBBBBBBBB\r\n" + 
			"BBBBBBBBBBBBBBBBBBBBBBB\r\n" + 
			"BBBBBBBBBBBBBBBBBBBBBBB\r\n" + 
			"BBBBBBBBBBBBBBBBBBBBBBB\r\n" + 
			"BBBBBBBBBBBBBBBBBBBBBBB\r\n" + 
			"BBBBBBBBBBBBBBBBBBBBBBW";//31
	static String input5 = "10 10\r\n" + 
			"BBBBBBBBBB\r\n" + 
			"BBWBWBWBWB\r\n" + 
			"BWBWBWBWBB\r\n" + 
			"BBWBWBWBWB\r\n" + 
			"BWBWBWBWBB\r\n" + 
			"BBWBWBWBWB\r\n" + 
			"BWBWBWBWBB\r\n" + 
			"BBWBWBWBWB\r\n" + 
			"BWBWBWBWBB\r\n" + 
			"BBBBBBBBBB";//0
	static String input6 = "8 8\r\n" + 
			"WBWBWBWB\r\n" + 
			"BWBWBWBW\r\n" + 
			"WBWBWBWB\r\n" + 
			"BWBBBWBW\r\n" + 
			"WBWBWBWB\r\n" + 
			"BWBWBWBW\r\n" + 
			"WBWBWWWB\r\n" + 
			"BWBWBWBW";//2
	static String input7 = "11 12\r\n" + 
			"BWWBWWBWWBWW\r\n" + 
			"BWWBWBBWWBWW\r\n" + 
			"WBWWBWBBWWBW\r\n" + 
			"BWWBWBBWWBWW\r\n" + 
			"WBWWBWBBWWBW\r\n" + 
			"BWWBWBBWWBWW\r\n" + 
			"WBWWBWBBWWBW\r\n" + 
			"BWWBWBWWWBWW\r\n" + 
			"WBWWBWBBWWBW\r\n" + 
			"BWWBWBBWWBWW\r\n" + 
			"WBWWBWBBWWBW";//15
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input7);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//board 만들기
		char[][] board = new char[N][M];
		for(int i = 0 ; i < N ; i++) {
			String list = sc.nextLine();
			board[i] = list.toCharArray();
		}
		
		int min = 64;	//8*8에서 나롱 수 있는 최대 값
		
		//첫칸 찾기
		for(int i = 0 ; i < N-7 ; i++) {
			for(int j = 0 ; j < M-7 ; j++) {
				//첫칸 색 
				char color = board[i][j];
				int change = 0;
				//8칸 보기
				for(int r = 0 ; r < 8 ; r++) {
					for(int c = 0 ; c < 8 ; c++) {
						if((r+c)%2 == 0 && board[i+r][j+c] != color) change++;
						if((r+c)%2 != 0 && board[i+r][j+c] == color) change++;
					}
				}
				//바꿀 값과 현재 최소값 비교. 바꿀 값은 현재 첫번째 색을 그대로 가져갈 경우, 바꿀 경우
				min = Math.min(min, Math.min(change, 64-change));
			}
		}
		System.out.println(min);
	}
}
