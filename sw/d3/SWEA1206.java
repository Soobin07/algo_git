package sw.d3;

import java.util.Scanner;

public class SWEA1206 {
	public static void main(String[] args) {
		int T = 10;
		Scanner sc = new Scanner(System.in);
		
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[] arr = new int[N];
            int count = 0;
             
            for(int i = 0 ; i < N ; i++){
                arr[i] = sc.nextInt();
            }
            int[] d = {-2,-1,1,2};
            for(int i = 2 ; i < N-2 ; i++){
                int max = 0;
                for(int j = 0 ; j < 4 ; j++){
                    if(max < arr[i+d[j]]) max = arr[i+d[j]];
                }
                if(arr[i] > max) count += arr[i]-max;
            }
            System.out.printf("#%d %d\n", test_case, count);
        }
	}
}
