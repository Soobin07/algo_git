package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q18870 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] copy = Arrays.copyOf(arr, N);
		Arrays.sort(copy);
		HashMap<Integer, Integer> rank = new HashMap<>();
		
		int cnt = 0;
		for(int i = 0 ; i < N ; i++) {
			if(!rank.containsKey(copy[i])) {
				rank.put(copy[i], cnt++);
			}
		}
		
		for(int i = 0 ; i < N-1 ; i++) {
			bw.append(rank.get(arr[i])+" ");
		}
		bw.append(rank.get(arr[N-1])+"");
		
		bw.flush();
		bw.close();
	}
}
