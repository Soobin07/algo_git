package beakjoon.silver;

import java.util.Scanner;

//어딘가 놓쳤음. 예제는 맞는데 9%에서 틀렸다고 한다.
public class Q2567 {
	static String input ="4\r\n" + 
			"3 7\r\n" + 
			"5 2\r\n" + 
			"15 7\r\n" + 
			"13 14";
	public static void main(String[] args) {
		Scanner sc= new Scanner(input);
//		Scanner sc = new Scanner(System.in);
		int[][] map = new int[101][101];	//정상 (인덱스 편하게 쓰려고.. +1)
		int[][] map2 = new int[101][101];	//세로
		int count = 0;	//답
		int N = sc.nextInt();
		
		// 색종이 붙이기
		for(int n = 0 ; n < N ; n++) {
			int c = sc.nextInt();	//색종이 c값
			int r = sc.nextInt();	//색종이 r값
			for(int i = 0 ; i < 10 ; i++) {
				for (int j = 0; j < 10 ; j++) {
					map2[r+j][c+i] = map[c+i][r+j] = 1;
				}
			}
		}
		
		//색종이 붙인 후 검은부분과 도화지 경계 찾기
		//셀 하나씩 탐색, 오른쪽, 아래 방향만 보자.. (사방탐색 하면 두번씩 얻으니까..)
		for(int i = 1 ; i < 101 ; i++) {
			for(int j = 1 ; j < 101 ; j++) {
				if(map[i-1][j]!=map[i][j])count++;		//가로방향 경계
				if(map2[j-1][i] != map2[j][i]) count++;	//세로방향 경계
			}
		}
		System.out.println(count);
	}
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(input);
////	Scanner sc = new Scanner(System.in);
//		int[][] map = new int[101][101];
//		
//		int count = 0;
//		int N = sc.nextInt();
//		int[] dc = {0, 1, 0, -1};
//		int[] dr = {-1, 0, 1, 0};
//		for(int n = 0 ; n < N ; n++) {
//			int c = sc.nextInt();
//			int r = sc.nextInt();
//			
//			//
//			for(int i = 0 ; i < 10 ; i++) {
//				for (int j = 0; j < 10 ; j++) {
//					map[c+i][r+j] = 1;
//				}
//			}
//			
//		}
//		
//		//사방탐색. 주위에 3개 이상 2가 있으면 count-- (맞닿은 부분이라 생각)
//		for(int i = 1 ; i < 101; i++) {
//			for(int j = 1 ; j < 101 ; j++) {
//				if(map[i][j] == 1) {
//					for(int k = 0 ; k < 4 ; k++) {
//						if(map[i+dr[k]][j+dc[k]] == 0) {
//							count++;
//							break;
//						}
//					}
//				}
//			}
//		}
//		for(int i = 1 ; i < 101 ; i++) {
//			for(int j = 1 ; j < 101 ; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println(count);
//	}
//	
//}
	
	//3번째.. 시작점들에서 10까지 따라가면서 사방탐색하여 다 막힌 부분을 끝이라 가정. 제일 앞에서 끝까지의 길이를 구하여 더하려 했음
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(input);
//		int[][] map = new int[101][101];	//맵. 0:빈칸 1:(둘레 제외한)검은부분 2:둘레
//		
//		int count = 0;	//둘레 카운트
//		int N = sc.nextInt();	//색종이 장수
//		int[][] loc = new int[N][2];	//색종이의 시작점 위치
//		
//		//N개의 색종이를 붙인다
//		for(int n = 1 ; n <= N ; n++) {	
//			loc[n-1][1] = sc.nextInt();
//			loc[n-1][0] = sc.nextInt();
//			
//			//시작 좌표
//			int r = loc[n-1][0];
//			int c = loc[n-1][1];
//			
//			//색종이 올리기
//			for(int dr = r ; dr < 10+r ; dr++) {
//				for(int dc = c ; dc < 10+c ; dc++) {	
//					map[dr][dc] = 1;
//				}
//			}
//		}
//		
////		int[][] d = {{-1,0},{1,0},{
//		//둘레 찾기
////		for(int n = 1 ; n <= N ; n++) {
////			int st = -1;	//둘레 시작
////			int ed = -1;	//둘레 종료
////			
////			//시작좌표
////			int r = loc[n-1][0];
////			int c = loc[n-1][1];
////			
////			for(int dr = 0 ; dr < 10 ; dr++) {
////				for(int dc = 0 ; dc < 10 ; dc++) {	
////					
////				}
////			}
////			
////			
////		}
//		
//		for(int i = 1 ; i < 101 ; i++) {
//			for(int j = 1 ; j < 101 ; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//		
//		System.out.println(count);	//출력
//	}
//}
	
	//2번째 실패.. 테두리 구하기. 맞닿은 부분때문에 실패
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(input);
////		Scanner sc = new Scanner(System.in);
//		int[][] map = new int[101][101];
//		
//		int count = 0;
//		int N = sc.nextInt();
//		int[] dc = {0, 1, 0, -1};
//		int[] dr = {-1, 0, 1, 0};
//		for(int n = 0 ; n < N ; n++) {
//			int c = sc.nextInt();
//			int r = sc.nextInt();
//			
//			//맞닿은 부분때문에 틀린다
////			for(int i = 0 ; i < 10 ; i++) {
////				for (int j = 0; j < 10 ; j++) {
////					if(map[c+i][r+j] != 1) {
////						if(i == 0 || i == 9 || j == 0 || j == 9) map[c+i][r+j] = 2; 
////						else map[c+i][r+j] = 1;
////					}
////				}
////			}
//			
//		}
////		for(int i = 1 ; i < 101; i++) {
////			for(int j = 1 ; j < 101 ; j++) {
////				if(map[i][j] == 1) {
////					for(int k = 0 ; k < 4 ; k++) {
////						if(map[i+dr[k]][j+dc[k]] == 0) {
////							count++;
////							break;
////						}
////					}
////				}
////			}
////		}
//		
//		for(int i = 1 ; i < 101 ; i++) {
//			for(int j = 1 ; j < 101 ; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//		
//		System.out.println(count);
//	}
	
	//틀렸지만 열심히 해서 남겨놓음.. 영역 구한 다음 8방탐색으로 하나라도 빈칸 보이면 그건 테두리라고 생각
//	public static void main(String[] args) {
////		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(input);
//		int[][] map = new int[101][101];
//		
//		int count = 0;
//		int N = sc.nextInt();
//		int[] dr = {-1,-1,-1,0,0,1,1,1};
//		int[] dc = {-1,0,1,-1,1,-1,0,1};
//		for(int n = 0 ; n < N ; n++) {	//색종이 반복
//			int y = sc.nextInt();
//			int x = sc.nextInt();
//			
//			 
//		}
//		for (int i = 1; i <= 100; i++) {	//8방탐색, 0이 하나라도 있으면 count++, 모서리에 있으면 count
//			for (int j = 1; j <= 100; j++) {
//				if(map[i][j] == 1) {
//					for(int k = 0 ; k < 8 ; k++) {
//						if(i+dr[k] == 1 || i+dr[k] == 100 || j+dc[k] == 1 || j+dc[k] == 100 || map[i+dr[k]][j+dc[k]] == 0) {
//							count++;
//							break;
//						}
//					}
//				}
//			}
//		}
//		for (int i = 0; i < 100; i++) {
//			for (int j = 0; j < 100; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println(count);
//	}
}