package beakjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q5014 {
	static int F,S,G,U,D;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();	//최고층
		S = sc.nextInt();	//현재층
		G = sc.nextInt();	//목표층
		U = sc.nextInt();	//위
		D = sc.nextInt();	//아래
		int[] ans = bfs();
		if(ans != null) {
			System.out.println(ans[1]);
		}else {
			System.out.println("use the stairs");
		}
	}
	
	static int[] bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {S, 0});
		int[] now = null;
		boolean flag = false;
		boolean[] visit = new boolean[F+1];
		visit[S] = true;
		while(!q.isEmpty()) {
			now = q.poll();
			if(now[0] == G) {
				flag = true;
				break;
			}
			if(now[0] + U <= F && !visit[now[0] + U]) {
				visit[now[0] + U] = true;
				q.add(new int[] {now[0]+U, now[1]+1});
			}
			if(now[0] - D >= 1 && !visit[now[0] - D]) {
				visit[now[0] - D] = true;
				q.add(new int[] {now[0]-D, now[1]+1});
			}
		}
		if(!flag) now = null;
		return now;
	}
}
