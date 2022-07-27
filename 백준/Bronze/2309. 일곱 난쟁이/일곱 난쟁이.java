import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] sel, arr;
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		for(int i = 0 ; i < 9 ; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		sel = new int[7];
		//하나씩 더해보며 100인것 출력
		
		select(0, 0);
		
	}
	public static void select(int idx, int sidx) {
		if(flag) {
			return;
		}
		if(sidx >= 7) {
			int sum = 0;
			for(int i = 0 ; i < 7 ; i++) {
				sum += sel[i];
			}
			if(sum == 100) {
				//출력?
				for(int i = 0 ; i < 7 ; i++) {
					System.out.println(sel[i]);
				}
				flag = true;
			}
			return;
		}
		if(idx >= 9) {
			return;
		}
		
		sel[sidx] = arr[idx];
		//포함
		select(idx+1, sidx+1);
		//포함X
		select(idx+1, sidx);
	}
}
