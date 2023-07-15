package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q9613 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());
		
		
		for(int tc = 0 ; tc < TC ; tc++) {
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[Integer.parseInt(st.nextToken())];
			for(int i = 0 ; i < arr.length ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			long sum = 0L;
			for(int i = 0 ; i < arr.length - 1 ; i++) {
				for(int j = i+1 ; j < arr.length; j++) {
					for(int k = arr[i] ; k > 0 ; k--) {
						if(arr[i] % k == 0 && arr[j] % k == 0) {
							sum += k;
							break;
						}
					}
				}
			}
			System.out.println(sum);
		}
	}
}
