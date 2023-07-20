package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11055 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		long[] sums = new long[N];	//해당 index 포함하는 가장 큰 증가하는 수열 합
		
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}	// 수열 기록하기
		
		sums[0] = arr[0];	//1개의 숫자로 수열 만들면 해당 수가.. 가장 크지?
		long max = sums[0];	//최댓값 가져오기
		
		for(int i = 0 ; i < N ; i++) {	
			for(int j = 0 ; j < i ; j++) {
				if(arr[i] > arr[j] && sums[i] < sums[j] + arr[i]) {	
					//arr[i] 포함하는 등차수열 && 지금 가진 합 보다 저 합에서 나를 더하면 더 커지나?
					sums[i] = sums[j] + arr[i];
					max = Math.max(max, sums[i]);
				} 
			}
			if(sums[i] == 0)
				sums[i] = arr[i];
		}
		
		System.out.println(max);
	}

}
