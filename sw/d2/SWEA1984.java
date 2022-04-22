package sw.d2;

import java.util.Scanner;

public class SWEA1984 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int minIdx = 0;
            int maxIdx = 0;
            int sum = 0;
            int[] scores = new int[10];
            
            for(int i = 0 ; i < 10 ; i++){
                scores[i] = sc.nextInt();
                if(scores[minIdx] > scores[i]) minIdx = i;
                if(scores[maxIdx] < scores[i]) maxIdx = i;
            }
            
            for(int i =0 ; i < 10 ; i++){
                if(minIdx != i && maxIdx != i){
                    sum += scores[i];
                }
            }
            
            System.out.printf("#%d %.0f%n", test_case, sum/8.0);
		}
	}
}
