import java.util.Scanner;

public class Main {
	private static int[] f;
	private static int J, D;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		f = new int[N];
		fib(N);
		fibo(N,N);
		System.out.println(J + " " + D);
	}
	//재귀호출
	public static int fib(int n) {
		if( n == 1 || n == 2) {
			J++;
			return 1;
		}else {
			return (fib(n-1) + fib(n-2));
		}
	}

	//dp
	public static int fibo(int n, int N) {
		f[0] = f[1] = 1;
		for(int i = 2 ; i < N ; i++) {
			f[i] = f[i-1]+f[i-2];
			D++;
		}
		return f[N-1];
	}
	
}
