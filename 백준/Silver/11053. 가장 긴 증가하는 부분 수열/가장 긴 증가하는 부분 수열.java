import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] cnt = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
		}	// 입력
		
		int max = 0;
		for(int i = N-1 ; i >= 0 ; i--) {
			if(i == N-1) cnt[N-1] = 1;
			boolean flag = true;
			for(int j = i+1 ; j < N ; j++) {
				if(arr[i] < arr[j]) {
					cnt[i] = Math.max(cnt[i], cnt[j]+1);
					flag = false;
				}
			}
			if(flag) cnt[i] = 1;
			max = Math.max(max, cnt[i]);
		}
		
		System.out.println(max);
	}
}
