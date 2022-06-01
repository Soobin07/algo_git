package sw.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//StringBuffer, BufferedReader, StringTokenizer 쓰는 방법 알았으니 이제 빼자^^
public class SWEA1208 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/sw/input1208.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int T = 10; //테스트 케이스
		for(int t = 1 ; t <= T ; t++) {
			int[] map = new int[100];
			int dumpLimit = Integer.parseInt(br.readLine());	//dump횟수
			
			st = new StringTokenizer(br.readLine());
			//맵 넣어주기, 가로길이 100 고정
			for(int i = 0 ; i < 100 ; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			
			//최고높이 찾는다 / 최저높이 찾는다, 증감시킨다,  dumpLimit회 반복한다
			//dumpLimit회 이전에 끝나면 dump중지
			for(int j = 0 ; j < dumpLimit ; j++) {
				int maxIdx = 0;
				int minIdx = 0;
				for(int i = 0 ; i < 100 ; i++) {
					if(map[i] > map[maxIdx]) maxIdx = i;
					if(map[i] < map[minIdx]) minIdx = i;
				}
				
				if(map[maxIdx]-map[minIdx] <= 1) break;	//횟수 전에 평탄화 완료(최진호님)

				//최고높이--, 최저높이++
				map[maxIdx]--;
				map[minIdx]++;
			}
			
			//최고높이, 최저높이 찾는다. (최고높이 100, 최저높이 1)
			int max = 1;
			int min = 100;
			for(int i = 0 ; i < 100 ; i++) {
				if(map[i] > max) max=map[i];
				if(map[i] < min) min=map[i];
			}
			sb.append("#").append(t).append(" ").append(max-min).append("\n");
		}
		System.out.print(sb);
	}
}
