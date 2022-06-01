package beakjoon.bronze;

import java.util.Scanner;

public class Q10162 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		
		if(T%10 == 0) {
			int tmp = T/(5*60); 
			sb.append(tmp).append(" ");
			tmp = (T % (5*60))/60;
			sb.append(tmp).append(" ");
			tmp = ((T % (5*60))%60)/10;
			sb.append(tmp).append(" ");
		}else {
			sb.append("-1");
		}
		System.out.println(sb.toString());
	}
}
