import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		StringBuffer sb = new StringBuffer();
		sb.append("<");
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1 ; i <= N ; i++) {
			q.add(i);
		}
		
		int cnt = 0;
		while(!q.isEmpty()) {
			cnt++;
			int tmp = q.poll();
			if(cnt == K) {
				sb.append(tmp).append(",").append(" ");
				cnt = 0;
			}else {
				q.add(tmp);
			}
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.print(sb.toString());
	}
}
