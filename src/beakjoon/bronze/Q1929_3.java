package beakjoon.bronze;

import java.util.Scanner;
//https://firework-ham.tistory.com/8 : 에라어쩌고 설명
public class Q1929_3 {
	//에라토스테네스 체 직접 구현
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int m = sc.nextInt();	//m부터
		int n = sc.nextInt();	//까지
		
		boolean[] arr = new boolean[n+1];	//prime = false
		arr[0] = arr[1] = true;				//true로 prime에서 제외
		
		for(int i = 2 ; i*i <= n ; i++) {	//11^2 > 120 ==> 120일때 소수를 구하려면 11까지만 해봐도 답이 다 나온다.(소수가 아닌 애들은 i * ( 2-> i) 이면 걸러짐 )
			if(!arr[i]) {	//이미 true인 것은 볼 필요가 없다
				for(int j = 2 ; i*j <= n ; j++) {	//i의 배수는 모두 prime에서 제외
					if(!arr[i*j]) arr[i*j] = true;
				}
			}
		}
		
		for(int i = m ; i <= n ; i++) {
			if(!arr[i]) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
