import java.util.Scanner;

public class Main {
	static int[][] map, cango;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//정점 갯수
		map = new int[N][N];	//간선 맵
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = sc.nextInt();
			}
		}//인접행렬
		
		cango = new int[N][N];	//갈수있나
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(map[i][j] == 1)
					find(i, i, j);
			}
		}
		
		//출력
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				System.out.print(cango[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	//갈 수 있는 곳 표시
	public static void find(int start, int std, int next) {
		if(cango[start][next] == 1) return;	//이미 표시되어 있으면 종료
		cango[start][next] = 1;	//갈 수 있다 표시
		
		for(int i = 0 ; i < map.length ; i ++) {	//돌면서 갈 수 있는곳 표시
			if(map[next][i] == 1) {
				find(start, next, i);
			}
		}
	}
}
