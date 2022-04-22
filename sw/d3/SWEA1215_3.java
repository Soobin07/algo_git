package sw.d3;

import java.io.FileInputStream;
import java.util.Scanner;

//쌤이 푸신 코드
public class SWEA1215_3 {

	//알고리즘에서는 여러번 쓰는 것은 static 선언하기도 한다
	static int ans;	//외부로 뺐을 때 주의점 : 테스트 케이스마다 초기화
	static int palinCnt;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/sw/input1215.txt"));
		Scanner sc = new Scanner(System.in);
		for(int t = 1 ; t <= 10 ; t++) {
			ans = 0;
			palinCnt = sc.nextInt();
			//계산의 편의 때문에 +1씩 해줌 
			char[][] pal1 = new char[9][9]; //가로방향 체크
			//가로방향 / 세로방향 맵을 그냥 하나 더 만들것임 (8x8 고정이라 데이터 얼마 안되니까)
			char[][] pal2 = new char[9][9]; //세로방향 체크
			//데이터 세팅
			for(int i = 1 ; i <= 8 ; i++) {
				String line = sc.next();	//문자 하나 가져옴
				for(int j = 1 ; j <= 8 ; j++) {
					pal1[i][j] = pal2[j][i] = line.charAt(j-1);
				}
			}
			//회문 카운트 세기
			countPalin(pal1);
			countPalin(pal2);
			System.out.println("#"+t+" "+ans);
		}
	}
	//회문길이가 홀수 : (ex 5 -> 3부터 의미 있음 (3부터 해야 앞,뒤 2개씩 봐도 인덱스 벗어나지 않음))
	//회문길이가 짝수 : (ex 4 -> 2부터 의미 있음)
	private static void countPalin(char[][] pal) {
		int half = palinCnt/2,
		    rest = palinCnt%2;		//,를 이용하여 int 선언 2개 한다.
		for (int i = 1; i <= 8; i++) {
			outer:
			for (int j = half+rest; j <= (8 - half); j++) {	//접근할 행 /열 처리
				for(int depth = 0; depth < half ; depth++) {
					if(pal[i][j - depth - rest] != pal[i][j + depth + 1]) continue outer;
					//continue가 아니라 break였으면 성공했으면 / 못했으면 조건 또 줘야 한다. 
					//but continue outer; 면, 실패하면 아래 문장 무시하고 outer의 다음으로 가니까 
				}
				//여기까지 내려왔으면 회문이라는 것
				//회문성공 체크여부...
				ans++;
			}
		}
	}
}
