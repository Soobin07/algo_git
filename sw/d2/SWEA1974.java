package sw.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1974 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("data/sw/input1974.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuffer sb = new StringBuffer();
		int[][] map = new int[9][9];	//가로 확인할 정상적인 판
		int[][] map2 = new int[9][9];	//세로 확인할 90도 회전한 판
		int T = Integer.parseInt(br.readLine());
		test : for(int t = 1 ; t <= T ; t++) {
			sb.append("#").append(t).append(" ");

			//맵 채워주기
			for(int i = 0; i < 9 ; i++) {

				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < 9 ; j++) {
					map2[j][i] = map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//가로 , 세로
			for(int i = 0 ; i < 9 ; i++) {
				if(isOk(map[i])*isOk(map2[i]) == 0) {
					sb.append(0).append("\n"); 
					continue test;
				}
			}
			//격자
			int[] tmp = new int[9];
			for(int i = 0 ; i < 9 ; i+= 3) {
				for(int j = 0 ; j < 9 ; j+= 3) {	//시작점 잡기
					if(isOk(map, i, j) == 0) {
						sb.append(0).append("\n");
						continue test;
					}
				}
			}
			sb.append(1).append("\n");
		}
		System.out.print(sb);
	}
	//가로세로 한 줄 괜찮아?
	public static int isOk(int[] ints) {
		int result = 1;
		boolean[] bols = new boolean[10];
		for(int i = 0 ; i < ints.length ; i++) {
			if(bols[ints[i]] == true) return 0;
			bols[ints[i]] = true;
		}
		return result;
	}
	//격자 괜찮아?
	public static int isOk(int[][] map, int r, int c) {
		int[] tmp = new int[9];
		int idx = 0;
		for(int k = r ; k < r+3 ; k++) {
			for(int k2 = c; k2 < c+3 ; k2++) {
				tmp[idx++] = map[k][k2];
			}
		}
		return isOk(tmp);
	}
}
