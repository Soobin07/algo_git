package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//이분탐색 사용해보자 => 1440ms 로 그렇게 드라미틱하게 바뀌지는 않았다
public class Q2776 {
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int TC = Integer.parseInt(st.nextToken());
		for(int tc = 0 ; tc < TC ; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < M ; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(arr[0] > tmp || arr[N-1] < tmp)
					bw.append("0\n");
				else
					bw.append(find(0, N-1, tmp));
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static String find(int start, int end, int findOne) {
		//없음
		if(start>end)
			return "0\n";
		int mid = (start+end)/2;
			
		//찾는중
		if(arr[mid] == findOne)
			return "1\n";
		else if(arr[mid] > findOne)
			return find(start, mid-1, findOne);
		else
			return find(mid+1, end, findOne);
		
		//start, mid 에서 start, mid-1 하는 것으로 stack over flow 해결 (start, mid가 계속 같은 값이 나왔나보다. 더 작을 때 없도록 해야겠다) 
	}
}
