import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, -2, -1, -2, 1, 2, 1, 2};
	static int[] dc = {-2, -1, 2, 1, 2, 1, -2, -1};
	
	static class Dot {
		int x, y;

		public Dot() {
		}

		public Dot(int y, int x) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Dot other = (Dot) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Dot [x=" + x + ", y=" + y + "]";
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int T = sc.nextInt();	//tc수
		for(int t = 0 ; t < T ; t++) {	//tc만큼 반복
			
			int N = sc.nextInt();	// 한변의 길이
			Dot first = new Dot(sc.nextInt(), sc.nextInt());	//현재위치
			Dot objt = new Dot(sc.nextInt(), sc.nextInt());	//목표위치
			
			Queue<Dot> q = new LinkedList<>();
			Map<Dot, Integer> m = new HashMap<>();
			
			q.add(first);	//첫 자리 넣기
			m.put(first, 0);	//첫 자리 확인
			
			outer : while(!q.isEmpty()) {
				Dot now = q.poll();
				int tmp = m.get(now);
				if(now.equals(objt)) {	//가려는 곳과 같으면 끝내기
					sb.append(tmp).append("\n");
					break outer;
				}
				for(int i = 0 ; i < dc.length ; i++) {
					
					int tmpY = now.y+dr[i];
					int tmpX = now.x+dc[i];
					
					//index 넘어가는지 확인
					if(tmpY < 0 | tmpX < 0 || tmpY >= N || tmpX >= N) continue;
					
					Dot next = new Dot(tmpY, tmpX);
					if(m.containsKey(next)) {	//이미 있으면 지나가
						continue;
					}
					//없으면 넣어
					m.put(next, tmp+1);
					q.add(next);
				}
			}
		}//tc끝
		System.out.print(sb.toString());
	}
}
