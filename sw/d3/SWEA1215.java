package sw.d3;

import java.util.Scanner;

//완전탐색 (for문 3개..)
//회문 탐색시 같은 글자를 또 사용할 수 있는가.. 이런건 input보고 판단해야 한다
public class SWEA1215 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("data/sw/input1215.txt"));
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
			
			//가로
			for(int i = 0 ; i < 8 ; i++) {
				for(int j = 0 ; j < 8 - p_len + 1 ; j++) {	//시작점 잡기
					boolean flag = true;
					for(int k = 0 ; k < p_len/2 ; k++) {
						if(map[i][j+k] != map[i][j+p_len-1-k]) {
							flag = false;
							break;
						}
					}
					if(flag) count++;
				}
			}
			
			//세로
			for(int j = 0 ; j < 8 ; j++) {
				for(int i = 0 ; i < 8 - p_len + 1 ; i++) {	//시작점 잡기
					boolean flag = true;
					for(int k = 0 ; k < p_len/2 ; k++) {
						if(map[i+k][j] != map[i+p_len-1-k][j]) {
							flag = false;
							break;
						}
					}
					if(flag) count++;
				}
			}
			
			System.out.printf("#%d %d%n", t, count);
		}
	}
}
