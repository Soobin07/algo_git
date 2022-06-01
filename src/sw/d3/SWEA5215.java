package sw.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA5215 {
	static int L;    //칼로리 제한
	static int[][] ingredient;	//[i][0] : i의 맛 점수(T) , [i][1] : i의 칼로리(L) 
	static int maxT; // 가장 맛있는 버거의 점수
	static int N;	 //재료의 갯수
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input5215.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1 ; t <= T ; t++) {
			maxT = 0;
			N = sc.nextInt();
			L = sc.nextInt();
			ingredient = new int[N][2];
			
			//재료 표 채우기
			for(int i = 0 ; i < N ; i++) {
				ingredient[i][0] = sc.nextInt();
				ingredient[i][1] = sc.nextInt();
			}
			findMDBurger(0, 0, 0);
			
			System.out.printf("#%d %d%n",t,maxT);
		}
	}
	
	static void findMDBurger(int index, int sumT , int sumL) {
		if(index == N && sumL < L) {	//재료 전부 다 넣을지 말지 결정 했는데, 
										//넣은 재료의 칼로리를 다 더한 칼로리가 L보다 작을 경우
			maxT = maxT > sumT ? maxT : sumT;
			return;
		}else if(sumL >= L){
			return;
		}
		
		//버거 만드는 중
		//버거에 index 재료 안넣을 때
		findMDBurger(index+1, sumT, sumL);
		//버거에 index 재료 넣을 때
		findMDBurger(index+1, sumT+ingredient[index][0], sumL+ingredient[index][1]);
	}
	//주성님 방법(좀 더 똑똑)
	static void findMDBurger2(int index, int sumT , int sumL) {
		if(index == N && sumL < L) {	//재료 전부 다 넣을지 말지 결정 했는데, 
										//넣은 재료의 칼로리를 다 더한 칼로리가 L보다 작을 경우
			maxT = maxT > sumT ? maxT : sumT;
			return;
		}else if(sumL >= L){
			return;
		}
		
		//버거 만드는 중
		for(int i = index ; i < N ; i++) {
			findMDBurger2(i+1, sumT+ingredient[index][0], sumL+ingredient[index][1]);
		}
	}
}
