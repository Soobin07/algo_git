package sw.d3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA2930_2 {
	static int[] arr;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/sw/input2930.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int T = sc.nextInt();
		
		for(int t = 1 ; t <= T ; t++) {
			sb.append("#").append(t);
			int N = sc.nextInt();
			int[] arr = new int[N+1];
			int size = 0;	//현재 갯수
			
			for(int n = 0 ; n < N ; n++) {
				int sel = sc.nextInt();
				if(sel == 1) {
					//size가 0이면 그냥 넣기
					if(size == 0) {
						size++;
						arr[size] = sc.nextInt();
						continue;
					}
					//0이 아니면, 가장 마지막에 넣고 비교하여 올라가기
					size++;
					arr[size] = sc.nextInt();
					int tmp = size; //현재 위치
					while(true) {
						//만약 tmp가 1까지 오면 ? 종료
						if(tmp == 1) break;
						
						//루트가 아니면? 부모노드와 비교해서
						if(arr[tmp] > arr[tmp/2]) {
							//현재 노드가 크면 부모노드와 자리 바꿈
							int tmp2 = arr[tmp/2];
							arr[tmp/2] = arr[tmp];
							arr[tmp] = tmp2;
							
							//위치 변경 반영
							tmp = tmp/2;
						}else {
							//현재노드가 작으면 그 자리에 멈춤
							break;
						}
					}
				}else {
					if(size == 0) {
						//처음부터 있는게 없으면 -1
						sb.append(" ").append(-1);
						continue;
					}
					
					//빼기
					sb.append(" ").append(arr[1]);	//루트 빼주기
					size--;	//달라진 사이즈 반영

					//가장 뒤의 숫자를 루트로 끌어 올리기
					arr[1] = arr[size+1];
					arr[size+1] = 0;
					
					//현재 위치 반영
					int tmp = 1;
					while(true) {
						int biggerIdx = 0;	//둘 중 사이즈 큰 자식 확인
						//자식 있나 확인
						if(tmp*2+1 <= size) {	//오른쪽 자식까지 있음
							if(arr[tmp*2+1] > arr[tmp*2]) biggerIdx = tmp*2+1;
							
																				//여기다!!!
							else biggerIdx = tmp*2;
						}else if(tmp*2 <= size){//왼쪽 자식만 있음
							biggerIdx = tmp*2;
						}else {	//자식 없음
							break;
						}
						
						//자식중 큰 값과 현재 값 비교
						if(arr[tmp] > arr[biggerIdx]) {
							//현재 값이 더 크다면, 안내려가도 된다
							break;
						}else {
							//현재 값이 더 작다면 둘의 위치를 바꿔준다.
							int tmp2 = arr[tmp];
							arr[tmp] = arr[biggerIdx];
							arr[biggerIdx] = tmp2;
							
							//위치 반영
							tmp = biggerIdx;
						}
					}
				}
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
