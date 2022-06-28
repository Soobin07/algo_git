package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q10989 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		int[] arr = new int[N];
		int[] cnt = new int[10001];
		
		
		int start = Integer.MAX_VALUE;
		int end = Integer.MIN_VALUE;
		
		//배열 받기
		//처음값 끝값 받기
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			cnt[arr[i]]++;
			if(start > arr[i]) {
				start = arr[i];
			}
			if(end < arr[i]) {
				end = arr[i];
			}
		}
		
		//누적합
		int sums = 0;
		for(int i = start ; i <= end ; i++) {
			sums += cnt[i];
			cnt[i] = sums;
		}
		
		//뒤에서부터 가져오기
		int[] tmpArr = new int[N];
		for(int i = N-1 ; i >= 0 ; i--) {
			int idx = cnt[arr[i]]--;
			tmpArr[idx-1] = arr[i];
		}
		
		for(int i = 0 ; i < N ; i++) {
			sb.append(tmpArr[i]).append("\n");
		}
		System.out.println(sb);
	}
}
