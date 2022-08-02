import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n > 2) {
			int[] arr = new int[n+1];
			arr[0] = 0;
			arr[1] = arr[2] = 1;
			
			for(int i = 3 ; i < n+1 ; i++) {
				arr[i] = arr[i-2]+arr[i-1];
			}
			
			System.out.println(arr[n]);
		}else if(n == 1 || n == 2) {
			System.out.println(1);
		}
	}
}
