package sw.d1;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA2063_2 {
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("data/sw/input2063.txt"));
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner("5 \n2 3 2 1 6");
		int N = sc.nextInt();
		int[] count = new int[101];
		for(int i = 0 ; i <N ; i++) {
			count[sc.nextInt()]++;
		}
		int idx  = 0;
		int sum = 0;
		for(idx = 0 ; idx < 101 ; idx++) {
			if(count[idx] != 0) {
				sum += count[idx];
				if(sum >= (N / 2 + 1)) break;
			}
		}
		System.out.println(idx);
    }
}
