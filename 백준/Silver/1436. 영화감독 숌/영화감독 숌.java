import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int cnt = 0;
		int num = 0;
		while(true) {
			if(Integer.toString(num).contains("666")) {
				cnt++;
			}
			if(cnt == N) {
				break;
			}
			num++;
		}
		
		System.out.println(num);
	}
}
