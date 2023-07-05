package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2217 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		
		// 로프 중량 리스트 받기
		int[] arr = new int[Integer.parseInt(br.readLine())];
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// sort
		Arrays.sort(arr);
		
		// 뒤에서부터
		for(int i = 0 ; i < arr.length ; i++) {
			if(ans < arr[arr.length - 1 - i]*(i+1)) {
				ans = arr[arr.length - 1 - i]*(i+1);
			}
		}
		
		System.out.println(ans);
	}
}
