package sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA1860_2 {

	//쌤 아이디어 2 : 시간 전체 체크
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T; tc++) {
			int N = sc.nextInt();	//손님수
			int M = sc.nextInt();	//붕어빵 제작시간
			int K = sc.nextInt();	//붕어빵 갯수
			String ans = "Possible";	//가능해로 초기화
			
			int[] sell = new int[11112];
			//해당 시간에 온 사람들 체크
			for(int i = 0 ; i < N ; i++) {
				int time = sc.nextInt();
				sell[time]++;
			}
			
			int bread = 0; //실제 빵의 갯수
			
			//실제로 매 초마다 생각을 해보자....
			for(int i = 0 ; i < sell.length ; i++) {
				//빵을 일단 만들자
				if(i%M==0) {
					bread += K;
				}
				
				bread -= sell[i];	//1초에 온 사람수 만큼 빵을 팔겠다
				if(bread < 0) {
					ans = "Impossible";
					break;
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	//준혁님 아이디어, 쌤 아이디어 : 붕어빵 갯수 = 몫/시간 * 갯수, 사람번호 > 붕어빵 갯수 ==> Impossible 
	public static void sol1(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T; tc++) {
			int N = sc.nextInt();	//손님수
			int M = sc.nextInt();	//붕어빵 제작시간
			int K = sc.nextInt();	//붕어빵 갯수
			String ans = "Possible";	//가능해로 초기화
			
			//손님 입력
			int[] person = new int[N];
			for(int i = 0 ; i < N ; i++) {
				person[i] = sc.nextInt();
			}
			//손님까지 입력을 다 받았어!!
			
			//진기가 줄을 서시오!! 예약한 초 대로!!
			Arrays.sort(person);
			//해당 손님이 도착했을 때 줄 수 있는지 없는지를 판단하겠다.
			for(int i = 0 ; i < N ; i++) {	//손님은 1명부터 시작
				//빵의 갯수 판단
				int bread = (person[i]/M)*K;
				if(bread < i+1) {	//빵의 갯수는 1명부터 세야하니까
					//(해당시간까지 만들 수 있는 빵보다, 해당 시간까지 온 손님의 수가 더 많으면.. 불가능하다 출력!)
					ans = "Impossible";
					break;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}

//시간 전부 돌기 도 가능
//
