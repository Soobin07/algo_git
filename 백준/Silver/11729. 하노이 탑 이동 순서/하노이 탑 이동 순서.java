import java.util.Scanner;

public class Main {
	static StringBuffer sb = new StringBuffer();
	static int moveCnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		hanoi(N, 1, 3, 2);
		System.out.println(moveCnt);
		System.out.println(sb.toString());
	}
	public static void move(int N, int start, int to) {
		sb.append(start).append(" ").append(to).append("\n");
	}
	public static void hanoi(int N, int start, int to, int via) {
		moveCnt++;
		if(N == 1) {
			move(1, start, to);
		}else {
			hanoi(N-1, start, via, to);
			move(N, start, to);
			hanoi(N-1, via, to, start);
		}
	}
}
