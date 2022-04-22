package beakjoon.silver;

import java.util.Scanner;

//시간초과
public class Q2579 {
	
	static int N;
	static int[] scores;
	static int max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		scores = new int[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			scores[i] = sc.nextInt();
		}
		
		sumScore(0,0,0,false);
		
		System.out.println(max);
	}
	
	/**
	 * @param index : 현재 몇번째 계단인가
	 * @param sum : 지금까지 얻은 점수의 합
	 * @param continueCnt : 몇번 연속으로 계단을 밟았나
	 * @param beforePassed : 바로 직전 계단을 뛰어넘었나
	 */
	public static void sumScore(int index, int sum, int continueCnt, boolean beforePassed) {
		//종료부. index가 7이면 종료. static의 max와 sum을 비교하여 최고점을 찾는다
		if(index == N) {
			if(continueCnt <= 1) {
				sum += scores[index];
				max = Math.max(max, sum);
			}
			return;
		}
		
		//지금까지 연속으로 밟은 계단의 수가 2라면 이번 계단은 무조건 건너뛴다
		if(continueCnt == 2) {
			sumScore(index+1, sum, 0, true);
		}else if(beforePassed){
			//직전 계단을 밟지 않았으면 이번 계단은 무조건 밟는다
			sumScore(index+1, sum+scores[index], continueCnt+1, false);
		}else {
			//그 외는 마음대로 해라. 밟든지 말든지

			//안밟아
			sumScore(index+1, sum, 0, true);
			//밟아
			sumScore(index+1, sum+scores[index], continueCnt+1, false);
		}
	}
}
