import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[] idx;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		arr = new int[5][8];
		idx = new int[5];
		
		for(int i = 1 ; i <= 4 ; i++) {
			String tmp = br.readLine();
			for(int j = 0 ; j < 8 ; j++) {
				arr[i][j] = tmp.charAt(j)-'0';
			}
		}//입력
		
		int K = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine());
			int no = Integer.parseInt(st.nextToken());
			move(no, Integer.parseInt(st.nextToken()), 1 << no);
		}
		
		int score = 0;
		for(int i = 1 ; i <= 4 ; i++) {
			score += arr[i][idx[i]]*Math.pow(2, i-1);
		}
		
		System.out.println(score);
	}
	//no : 톱니바퀴, dir : 방향
	public static void move(int no, int dir, int visit) {
		if(no == 0 || no == 5 ) return;
		
		//오른쪽, 왼쪽 닿는곳
		int right = (8 + 2 +  idx[no])%8;
		int left = (8 + 6 +  idx[no])%8;
		
		//해당 바퀴 돌리기
		idx[no] = (8 + dir*-1 + idx[no]) % 8;
		
		//오른쪽
		if(no < 4 
				&& ((visit & 1<<(no+1)) == 0) 
				&& arr[no+1][(8 + 6 +  idx[no+1])%8] != arr[no][right]) {
			move(no+1, dir*-1, visit|1<<(no+1));
		}
		
		//왼쪽
		if(no > 1 
				&& ((visit & 1<<(no-1)) == 0) 
				&& arr[no-1][(8 + 2 +  idx[no-1])%8] != arr[no][left]) {
			move(no-1, dir*-1, visit|1<<(no-1));
		}
	}
}
