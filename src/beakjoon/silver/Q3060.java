package beakjoon.silver;

import java.util.Scanner;

public class Q3060 {
	static String input1 = "2\r\n" + 
			"21\r\n" + 
			"1 2 3 4 5 6\r\n" + 
			"21\r\n" + 
			"1 2 3 4 5 7";
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input1);
		
		//테스트케이스 갯수
		int T = sc.nextInt();
		for(int t = 1 ; t <= T ; t++) {	//갯수만큼 돌림
			
			//하루 사료 양 (기준)
			int N = sc.nextInt();
			//하루 소비 사료 양
			int sum = 0;
			
			//6마리 돼지
			int[] oldAm = new int[6];
			for(int n = 0 ; n < 6 ; n++) {
				oldAm[n] = sc.nextInt();
				sum+= oldAm[n];
			}
			
			//몇번째 날인가
			int day = 1;
			
			//사료가 부족해질 때 까지 돌린다
			while(sum <= N) {
				//다음날
				day++;
				//소비사료양 초기화
				sum = 0;
				
				//새로운 요구 양 계산
				int[] newAm = new int[6];
				for(int i = 0 ; i < 6 ; i++) {
					newAm[i] = oldAm[i-1 >= 0? i-1 : 5] + oldAm[i] + oldAm[(i+1)%6] + oldAm[(i+3)%6];
					sum += newAm[i];
				}
				oldAm = newAm;
			}
			System.out.println(day);
		}
	}
}
