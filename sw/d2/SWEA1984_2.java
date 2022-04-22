package sw.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA1984_2 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input1984.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int t = 0;
		while(t++<T) {
			int sum = 0;
			int max = 0;	//0이상
			int min = 10000;	//10000이하
			
			for(int i = 0 ; i < 10 ; i++) {
				int num = sc.nextInt();
				if(max < num) max = num;
				if(min > num) min = num;
				sum+=num;
			}
			System.out.printf("#%d %.0f%n", t, (sum-max-min)/8d);
		}
	}
}
