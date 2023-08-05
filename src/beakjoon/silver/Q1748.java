package beakjoon.silver;

import java.util.Scanner;

public class Q1748 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int jarisu = 0;
		for(jarisu = 0 ; jarisu < 9 ; jarisu++) {
			if(N / (int)Math.pow(10, jarisu + 1) == 0)
				break;
		}
		
		int ans = 0;
		for(int i = 0 ; i < jarisu ; i++) {
			ans += (Math.pow(10,i+1) - Math.pow(10, i)) * (i+1);
		}
		ans += (N - (Math.pow(10, jarisu) - 1)) * (jarisu+1);
		System.out.println(ans);
	}
}