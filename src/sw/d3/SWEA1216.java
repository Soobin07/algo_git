package sw.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

//선생님이 풀어주신 방법 그대로..흑흑
public class SWEA1216 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/sw/input1216.txt"));
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = 10;
		for (int t = 1; t <= T; t++) {
			int tc = Integer.parseInt(br.readLine());
			int max = 1;
			
			char[][] map1 = new char[101][101];
			char[][] map2 = new char[101][101];
			for(int i = 1 ; i <= 100 ; i++) {
				String line = br.readLine();
				for(int j = 1 ; j <= 100 ; j++) {
					map1[i][j] = map2[j][i] = line.charAt(j-1);
				}
			}
			
			//회문 최대값 구하기
			for(int i = 100 ; i > 0 ; i--) {
				if((isPalin(map1, i)||isPalin(map2, i)) && max < i) {
					max = i;
					break;
				}
			}
			
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.print(sb);
	}
	private static boolean isPalin(char[][] map, int palinCnt) {
		int half = palinCnt /2 ;
		int rest = palinCnt % 2;
		for(int i = 1 ; i <= 100 ; i++) {
			outer : for(int j = half+rest ; j <= 100 - half ; j++) {
				for(int depth = 0 ; depth < half ; depth ++) {
					if(map[i][j - depth - rest] != map[i][j+depth + 1]) continue outer;
				}
				return true;
			}
		}
		return false;
	}
	
	
	//틀림.. 아까워서..
//	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("data/sw/input1216.txt"));
////		Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuffer sb = new StringBuffer();
//
//		int T = 10;
//		for (int t = 1; t <= T; t++) {
//			int tc = Integer.parseInt(br.readLine());
//			int max = 1;
//			
//			//map 1개만 사용
//			char[][] map = new char[100][]; 
//			for(int i = 0 ; i < 100 ; i++) {
//				map[i] = br.readLine().toCharArray();
//			}
//			
//			for(int i = 0 ; i < 100 ; i++) {
//				char[] line = map[i];
//				findJ : for(int j = 0 ; j < 100 ; j++) {	//시작점 잡기
//					char st = line[j];
//					
//					int count = 0;
//					for(int k = 0 ; k < 100 ; k++) { //같은 글자 있나?
//						if(st == line[k]) count++;
//					}
//					if(count == 0) continue findJ;
//						
//					int[] idx = new int[count];
//					count = 0;
//					for(int k = 0 ; k < 100 ; k++) { //같은 글자 인덱스
//						if(st == line[k]) {
//							idx[count] = k;
//							count++;
//						}
//					}
//					
//					findK :for(int k = 0 ; k < idx.length ; k++) {	//같은 글자 idx를 끝으로 하여 회문 확인
//						int index = idx[k];
//						for(int l = 0 ; l < index + 1 ; l++) {
//							if(j+l < index-l && line[j+l] != line[index-l]) continue findK; 
//						}
//						if(max < index-j) max = index-j;
//					}
//				}
//			}
//			sb.append("#").append(t).append(" ").append(max).append("\n");
//		}
//		System.out.print(sb);
//	}
}
