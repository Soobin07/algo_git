package beakjoon.golds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1717 {
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		for(int i = 0 ; i <= n ; i++) {
			arr[i] = i;
		}
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			if(st.nextToken().equals("0"))
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			else
				bw.append(isUnion(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))?"YES\n":"NO\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void union(int a, int b) {
		if(!isUnion(a, b)) {
			arr[findUnion(b)] = findUnion(a);
		}
	}
	static boolean isUnion(int a, int b) {
		if(findUnion(a) == findUnion(b))
			return true;
		return false;
	}
	static int findUnion(int a) {
		if(arr[a] == a)
			return a;
		else 
			return arr[a] = findUnion(arr[a]);
	}
}
