package beakjoon.bronze;

import java.util.Scanner;

public class Q15649 {
	//1-3까지 하드코딩 해봤다.
	//앞이 1일때부터 출력하도록 하였고
	//2일 경우에는 2번, 3일땐 3번 for문이 돌아가도록 했다.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer(); 

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		for(int i = 1 ; i <= n ; i++) {
			if(m == 1) {
				sb.append(i).append(" ");
				sb.append("\n");
			}else if(m == 2){
				for(int j = 1 ; j <= n ; j++) {
					if( i != j) {
						sb.append(i).append(" ");
						sb.append(j).append(" ");
						sb.append("\n");
					}
				}
			}else if(m == 3) {
				for(int j = 1 ; j <= n ; j++) {
					if( i != j) {
						for(int k = 1 ; k <= n ; k++) {
							if(k!= i && k!= j) {
								sb.append(i).append(" ");
								sb.append(j).append(" ");
								sb.append(k).append(" ");
								sb.append("\n");
							}
						}
					}
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}
