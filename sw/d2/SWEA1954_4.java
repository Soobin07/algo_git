package sw.d2;

import java.io.FileInputStream;
import java.util.Scanner;

//쌤 코드
// 이런 문제는 규칙을 찾아라

// (수평) 왼-> 오 : N=4이면 4칸 이동

// (수직) 위 -> 아 : 3칸 이동 
// (수평) 오 -> 왼 : 3칸 이동

// (수직) 아 -> 위 : 2칸 이동
// 다시 (수평) 왼 -> 오 : 2칸 이동

// 다시 (수직) 위 -> 아 : 1칸 이동
// 다시 (수평) 오 -> 왼 : 1칸 이동

// 다시 (수직) 아-> 위 ... 0칸 이동

//수평 -> 수직으로 갈때 이동 칸수 감소

//왼->오, 위-> 아 = 값이 증가
//오->왼, 아-> 위 = 값이 감소

//이동 칸수 0이 되면 종료

public class SWEA1954_4 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/sw/input1954.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			int k = N;	//반복횟수
			int change = 1;	//증감
			int x = 0, 
				y =-1; //증감 적용해서 갈 것이기 때문에
			int num = 0;
			//숫자 입력
			while(true) {
				for(int i = 0 ; i < k ; i++) {	//수평
					y += change;
					arr[x][y] = ++num; 
				}
				k--;	
				if(k == 0) break;
				for(int i = 0 ; i < k ; i++) {	//수직
					x += change;
					arr[x][y] = ++num;
				}
				change *= -1;	//수평-수직 이후에 값의 증감 변경
			}
			
			sb.append("#").append(t).append(" ").append("\n");
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}
