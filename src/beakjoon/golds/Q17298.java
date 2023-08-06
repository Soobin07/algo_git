package beakjoon.golds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q17298 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] ans = new int[N];
		Arrays.fill(ans, -1);
		Stack<Integer> s = new Stack<>();
		s.add(arr[N-1]);
		for(int i = 2 ; i <= N ; i++) {
			if(arr[N-i] >= arr[N-i+1]) {
				//현재 숫자가 더 크면
				//이전 나온 것들 중 현재 숫자보다 큰 숫자가 나올 때 까지
				while(!s.isEmpty()) {
					int tmp = s.peek();
					if(arr[N-i] < tmp) {
						ans[N-i] = tmp;
						break;
					}
					s.pop();
				}
				s.add(arr[N-i]);
			}else {
				//현재 숫자가 더 작으면
				ans[N-i] = arr[N-i+1];
				s.add(arr[N-i]);
			}
		}
		
		bw.append(Arrays.toString(ans).replaceAll("[\\[,\\]]", ""));
		bw.flush();
		bw.close();
		br.close();
	}
}
