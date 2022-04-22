package beakjoon.silver;

import java.util.Scanner;

//실버3이래
public class Q1244 {
	static String input1 = "8\n" + 
			"0 1 0 1 0 0 0 1\n" + 
			"2\n" + 
			"1 3\n" + 
			"2 3";
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input1);
		int N = sc.nextInt(); // 스위치 개수
		int[] arr = new int[N+1];	//스위치들

		//스위치 상태 입력
		for(int i = 1 ; i <= N ; i++) {
			arr[i] = sc.nextInt();
		}
		
		int K = sc.nextInt(); //학생
		for(int k = 0 ; k < K ; k++) {
			int gender = sc.nextInt();
			int switchNo = sc.nextInt();
			//성별에 따라
			if(gender == 1) {//남학생
				for(int i = switchNo ; i <= N ; i+=switchNo) {
					arr[i] = (arr[i] == 1 ? 0 : 1); 
				}
			}else {	//여학생
				if(switchNo == 1 || switchNo == N || arr[switchNo-1] != arr[switchNo+1]) {
					arr[switchNo] = (arr[switchNo] == 1 ? 0 : 1);
					continue;
				}
				
				//어디까지 회문인지 확인
				int d = 1; //기준점으로부터 거리
				while(switchNo+d <= N && switchNo-d > 0) {
					if(arr[switchNo+d]!=arr[switchNo-d]) break;
					d++;
				}
				
				//회문구간 반대로 바꿔주기
				//본인부터 쭉 바꿔준다
				for(int i = 0 ; i < d ; i++) {
					arr[switchNo+i] = arr[switchNo-i] = arr[switchNo-i] == 1? 0 : 1;  
				}
			}
		}
		for(int i = 1 ; i <= N ; i++) {
			System.out.print(arr[i]+" ");
			if(i % 20 == 0) System.out.println();
		}
	}
}
