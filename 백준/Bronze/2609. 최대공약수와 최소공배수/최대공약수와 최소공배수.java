import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		//최대공약수
		for(int i = Math.min(A, B) ; i >= 1 ; i--) {
			if(A%i == 0 && B%i == 0) {
				System.out.println(i);
				break;
			}
		}
		
		//최소공배수
		for(int i = Math.max(A, B) ; i <= A*B ; i++) {
			if(i%A == 0 && i%B == 0) {
				System.out.println(i);
				break;
			}
		}
	}
}
