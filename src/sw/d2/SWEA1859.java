package sw.d2;

import java.io.FileInputStream;
import java.util.Scanner;

//내가 이전에 풀었던 방식.
//배열을 뒤에서부터 돌면서, 최대값이면 최대값을 교환해주고
//최대값이 아니면 최대값-현재값 을 이익에 더해준다.
public class SWEA1859 {
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
            
            for(int i = 0 ; i < n ; i++){
                arr[i] = sc.nextInt();
            }
            for(int i =  n-1 ; i >= 0 ; i--){
                if(arr[i] > max){
                    max = arr[i];
                }else{
                    profit += max-arr[i];
                }
            }
			sb.append("#").append(t).append(" ").append(profit).append("\n");
		}
		System.out.print(sb.toString());
	}
}
