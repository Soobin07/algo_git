package sw.d2;

import java.util.Scanner;

//다시 푸는 삼육구
public class SWEA1926_3 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int N = sc.nextInt();
		int clap;
		for(int i = 1; i <= N ; i++) {
			clap = 0;
			char[] arr = String.valueOf(i).toCharArray();
			for(int j = 0 ; j < arr.length ; j++) {
				if(arr[j] == '3' || arr[j] == '6' || arr[j] == '9') {
					clap++;
				}
			}
			switch(clap) {	//n은 10 이상 1000 이하이므로 3이 4개 이상 나오지 않는다.
				case 0 : sb.append(i); break;
				case 1 : sb.append("-"); break;
				case 2 : sb.append("--"); break;
				case 3 : sb.append("---"); break;
			}
			sb.append(" ");
		}
		System.out.print(sb);
	}
}
