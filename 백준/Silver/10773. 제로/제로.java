import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		
		int[] arr = new int[K];
		int index = 0;
		for(int i = 0 ; i < K ; i++) {
			int tmp = sc.nextInt();
			if(tmp == 0) {
				index--;
			}else {
				arr[index++] = tmp;
			}
		}
		
		int sum = 0;
		for(int i = 0 ; i < index ; i++) {
			sum += arr[i];
		}
		
		System.out.println(sum);
	}
}
