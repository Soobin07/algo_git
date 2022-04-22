package beakjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Q2667 {
	static String input1 = "7\r\n" + 
			"0110100\r\n" + 
			"0110101\r\n" + 
			"1110101\r\n" + 
			"0000111\r\n" + 
			"0100000\r\n" + 
			"0111110\r\n" + 
			"0111000";
	static String input2 = "3\r\n" + 
			"101\r\n" + 
			"101\r\n" + 
			"111";
	static String input3 = "5\r\n" + 
			"11000\r\n" + 
			"00000\r\n" + 
			"00111\r\n" + 
			"00000\r\n" + 
			"10000";
	static int[] counts = new int[626];
	static char[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(input3);
		N = Integer.parseInt(sc.nextLine());
		
		map = new char[N][];
		
		for(int i = 0 ; i < N ; i++) {
			String line = sc.nextLine();
			map[i] = line.toCharArray();
		}
		
//		for(int i = 0 ; i < N ; i++) {
//			for(int j = 0 ; j < N ; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		int count = 0;		// 몇번째 단지인가!
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {	//첫칸 잡기
				
				char c = map[i][j];
				
				if(c == '1') {	//그 칸이 집이면
					count++;//동 하나 추가
					searchAround(i, j, count);//주변을 찾는다
				}
			}
		}
		System.out.println(count);
		int[] result = Arrays.copyOf(counts, count+1);
		Arrays.sort(result);
		for(int i = 1 ; i <= count ; i++) {
			System.out.println(result[i]);
		}
	}
	
	public static void searchAround(int r, int c, int count) {

		//집이면 해당 동의 집 수를 하나 올리고
		if(map[r][c] == '1') {
			counts[count]++;
			//사용한 집은 2로 바꾼다
			map[r][c] = '2';
		}else {
			//집이 아니면 끝낸다
			return;
		}
		
		//사방탐색
		for(int i = 0 ; i < 4 ; i++) {
			//인덱스 확인 (인덱스 넘치면 다음걸로 넘어가자)
			if(r+dr[i] < 0 || r+dr[i] >= N || c+dc[i] < 0 || c+dc[i] >= N) continue;
			
			//해당 인덱스를 가진 곳으로 보내자
			searchAround(r+dr[i], c+dc[i], count);
		}
	}
}
