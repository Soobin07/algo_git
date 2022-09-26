package beakjoon.silver;

import java.util.Scanner;

public class Q2960 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		boolean[] arr = new boolean[N+1];
		arr[0]=arr[1]=true;	//true : 소수아님
		
		int cnt = 0;	//지워진 숫자 수
		int answer = 0;	//지워진 수
		outer : for(int i = 2 ; i <= N ; i++) {
			//false (소수임) 이면
			if(!arr[i]) {
				//소수 아닌 것 지움
				for(int j = 1 ; j*i <= N ; j++) {
					if(arr[j*i]) continue;
					arr[j*i] = true;
					//몇번째 지워지나 확인
					cnt++;
					//K번째 지워진 수면
					if(cnt == K) {
						answer = j*i;
						break outer;
					}
				}
			}
		}
		System.out.println(answer);
	}
}
