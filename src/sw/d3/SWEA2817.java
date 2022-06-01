package sw.d3;

import java.util.Scanner;

public class SWEA2817 {
	static int count;
	static int[] arr;
	static int K, N;
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("data/sw/input2817.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb= new StringBuffer();
		
		int T = sc.nextInt();
		for(int t = 1 ; t <= T ; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N];
			
			//배열 넣기
			for(int i = 0 ; i < N ; i++) {
				arr[i] = sc.nextInt();
			}
			
			//경우의 수 초기화
			count=0;
			
			//재귀 돌리기
			sum();
			
			sb.append("#").append(t).append(" ").append(count).append("\n");
		}
		System.out.println(sb.toString());
	}
	static void sum() {
		sum(0,0);
	}
	static void sum(int sum, int index) {
		if(sum == K) {
			count++;
			return;
		}
		if(sum > K || index >= N) return;
		
		//더할때
		sum(sum, index+1);
		//안더할때
		sum(sum+=arr[index], index+1);
	}
}
