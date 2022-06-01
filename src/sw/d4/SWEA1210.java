package sw.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SWEA1210 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input1210.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		Scanner sc= new Scanner(System.in);
		
		int T = 10; 
		for(int t = 1 ; t <= T ; t++) {
			int tc = sc.nextInt(); //testcase No
			
			//도착점의 좌표
			int r = -1;
			int c = -1;
			
			//맵
			int[][] map = new int[100][100];
			//맵 만들기 + 2의 좌표 찾기
			for(int i = 0 ; i < 100 ; i++) {
				for(int j = 0 ; j < 100 ; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 2) {
						r = i;
						c = j;
					}
				}
			}
			
			//한줄씩 올라감(한줄 위부터 0까지)
			outer : for(int i = r-1 ; i >= 0 ; i--) {
				if(c > 0 && map[i][c-1] == 1) {
					//제일 왼쪽이 아니고 왼쪽에 길이 있는 경우
					for(int j = c-1 ; j >= 0 ; j--) {
						if(map[i][j] == 0) {
							c = j+1; //0나오기 이전까지가 이동한 좌표다
							continue outer;
						}
						if(j == 0) c = 0;	//끝까지 안나오면 c = 0
					}
				}
				if(c < 99 && map[i][c+1] == 1){
					//제일 오른쪽이 아니고 오른쪽에 길이 있는 경우
					for(int j = c+1 ; j < 100 ; j++) {
						if(map[i][j] == 0) {
							c = j-1; //0나오기 전이 이동한 좌표다 
							continue outer;
						}
						if(j == 99) c = j;	//끝까지 안나오면 c = 99
					}
				}
			}
			
			System.out.printf("#%d %d%n", tc, c);
		}
	}
}
