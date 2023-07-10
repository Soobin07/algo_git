package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5430 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuffer ansStr = new StringBuffer();
		StringBuffer commends = new StringBuffer();
		StringTokenizer st = null;
		int n = 0;
		int start = 0;
		int end = 0;
		boolean flow = true;
		
		label : for(int t = 0 ; t < TC ; t++) {
			// 초기화
			commends.setLength(0);
			commends.append(br.readLine());
			n = Integer.parseInt(br.readLine());
			start = 0;
			end = n-1;
			flow = true;
			
			// 배열
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine(), "\\[\\,\\]");
			for(int i = 0 ; i < n ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0 ; i < commends.length() ; i++) {
				if(commends.charAt(i) == 'R') {
					flow = !flow;
				}else if(commends.charAt(i) == 'D') {
					if(start > end) {
						ansStr.append("error\n");
						continue label;
					}else if(flow){
						start++;
					}else if(!flow) {
						end--;
					}
				}
			}
			
			// 마무리
			ansStr.append("[");
			if(start <= end) {
				if(flow) {
					for(int i = start ; i <= end ; i++) {
						ansStr.append(arr[i]+",");
					}
				}else {
					for(int i = end ; i >= start ; i--) {
						ansStr.append(arr[i]+",");
					}
				}
				ansStr.setLength(ansStr.length()-1);
			}
			ansStr.append("]\n");
		}
		
		System.out.print(ansStr.toString());
	}
}
