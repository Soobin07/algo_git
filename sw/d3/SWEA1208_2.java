package sw.d3;

import java.io.FileInputStream;
import java.util.Scanner;

//StringBuffer, BufferedReader, StringTokenizer 쓰는 방법 알았으니 이제 빼자^^
public class SWEA1208_2 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/sw/input1208.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuffer sb = new StringBuffer();
//		StringTokenizer st;
		Scanner sc= new Scanner(System.in);
		
		int T = 10; //테스트 케이스
		for(int t = 1 ; t <= T ; t++) {
			int[] box = new int[101];
			int dumpLimit = sc.nextInt();	//dump횟수
			
			
			int max = 1;
			int min = 100;
			//1-100 카운트 && 최초 최대값/최소값 찾기
			for(int i = 0 ; i < 100 ; i++) {
				int n = sc.nextInt(); 
				box[n]++;
				if(max < n) max = n;
				if(min > n) min = n;
			}
			
			while(dumpLimit > 0 && min < max-1) {
				dumpLimit--;	//리밋관리
				
				box[max]--;		//박스 옮기기
				box[max-1]++;
				box[min]--;
				box[min+1]++;
				
				if(box[max] == 0) max--;	//박스 없어졌니? 그럼 다음으로 큰거
				if(box[min] == 0) min++;				//다음으로 작은거
			}
			System.out.printf("#%d %d%n", t, (max-min));
		}
	}
}
