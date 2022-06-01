package beakjoon.bronze;

import java.util.Scanner;

//동적 계획법
public class Q12865_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();			//물건의 갯수
		int k = sc.nextInt();			//버틸 수 있는 무게
		
		int[] arr = new int[k+1];	//해당 무게에서 가장 높은 value => 아래에서 arr[j-w]을 사용(w일때 arr[0] = 0 나와야 하니까 k+1)
		
		for(int i = 0 ; i < n ; i++) {	//n번 반복하기 위한 for문
			int w = sc.nextInt();		//현재 물건의 무게
			int v = sc.nextInt();		//현재 물건의 가치
			
			/*
			 	if(arr[w] < v) {		//아 j-w = w일 경우 arr[w]와 arr[w]+v 를 비교하게 되므로 이거 없어야 한다
					arr[w] = v; 
				}
			 */
			
			for(int j = k ; j >= w ; j--) {	//최대 무게부터 w와 같아질 때 까지 뒤에서부터 하나씩
				//정방향으로 가면 (j-w),w로 최적화한 값을 다시 사용하여 ((j+1)-w),w를 구할 수도 있으니까
				arr[j] = Math.max(arr[j],arr[j-w]+v);//j와 (j-w)무게+w를 비교하여 최대 value 찾기
			}
		}
		
		System.out.println(arr[k]);
	}
}