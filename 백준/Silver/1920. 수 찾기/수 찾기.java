import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		//존재하는지 확인할 수 
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < M ; i++) {
			int target = Integer.parseInt(st.nextToken());
			if(arr[0] > target || arr[N-1] < target) {
				sb.append(0).append("\n");
			}else
				find(0, N, target);
		}
		System.out.print(sb.toString());
	}
	
	public static void find(int st, int ed, int target) {
		if(st >= ed) {	//없다
			sb.append(0).append("\n");
			return;
		}
		
		int mid = ( st + ed ) / 2;
		if(arr[mid] == target) {
			sb.append(1).append("\n");
			return;
		}else if(arr[mid] > target) {
			find(st, mid, target);
		}else {
			find(mid+1, ed, target);
		}
	}
}
