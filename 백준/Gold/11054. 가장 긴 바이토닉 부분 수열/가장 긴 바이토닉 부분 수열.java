import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr, fCnts, bCnts;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		fCnts = new int[N];
		bCnts = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}//원 수 넣기
		
		//카운트
		for(int i = 0 ; i < N ; i++) {
			front(i);
			back(i);
		}
		
		int max = -1;
		for(int i = 0 ; i < N ; i++) {
			max = Math.max(fCnts[i]+bCnts[i], max);
		}
		System.out.println(max-1);
	}
	public static int front(int n) {
		if(fCnts[n] == 0) {
			fCnts[n] = 1;
			
			for(int i = n - 1 ; i >= 0 ; i--) {
				if(arr[i] < arr[n]) {
					fCnts[n] = Math.max(fCnts[n], front(i)+1);
				}
			}
		}
		return fCnts[n];
	}
	public static int back(int n) {
		if(bCnts[n] == 0) {
			bCnts[n] = 1;
			
			for(int i = n + 1 ; i < bCnts.length ; i++) {
				if(arr[i] < arr[n]) {
					bCnts[n] = Math.max(bCnts[n], back(i)+1);
				}
			}
		}
		return bCnts[n];
	}
}
