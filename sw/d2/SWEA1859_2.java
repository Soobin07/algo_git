package sw.d2;

import java.io.FileInputStream;
import java.util.Scanner;

//swea에서 본 코드. 배열을 만들어서 쉽게 접근하도록 했다.
public class SWEA1859_2 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input1859.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int T = sc.nextInt();
		for(int t = 1 ; t <= T ; t++) {
			int max = 0;
            long profit = 0;
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] maxs = new int[n];	//최대값 모아놓은 것
            
            for(int i = 0 ; i < n ; i++){
                arr[i] = sc.nextInt();
            }
            for(int i =  n-1 ; i >= 0 ; i--){
                max = Math.max(max, arr[i]);
                maxs[i] = max;		//그때까지 가장 큰 값 넣는다
            }
            for(int i = 0 ; i < n ; i++) {
            	profit+= maxs[i]-arr[i];
            }
			sb.append("#").append(t).append(" ").append(profit).append("\n");
		}
		System.out.print(sb.toString());
	}
}
