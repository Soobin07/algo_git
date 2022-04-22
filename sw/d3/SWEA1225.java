package sw.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1225 {
	// 1. tc 입력이 없으면 종료
	// 2. idx == 5 일때마다 한싸이클 종료 => idx = 0으로 초기화 (++idx해서 사용할 것)
	// 3. queue.poll() - idx == 0 이면, 해당 값 queue에 넣고 종료
	// 4. 출력 (#tc 암호 8개)

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("data/sw/input1225.txt"));		// 테스트케이스 입력받는다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer(); // 답을 적을 stringBuffer을 미리 만든다
		StringTokenizer st; // 암호 8개를 한줄에 받게 되니까 미리 준비

		String tc; // tc를 밖에 선언한다. (아래 이용하기 위해)
		while ((tc = br.readLine()) != null) { // tc를 읽었을 때 null이면 종료한다
			Queue<Integer> queue = new LinkedList<>(); // 암호 8개 담아줄 큐

			st = new StringTokenizer(br.readLine()); // 8개 받아서 나눠준다
			for (int i = 0; i < 8; i++) {
				queue.add(Integer.parseInt(st.nextToken())); //띄어쓰기 하나에 숫자 하나, 변환해서 넣어준다
			}

			int idx = 0;	//한 사이클 인지하기 위해 idx를 넣는다
			while (true) {	//무한반복
				++idx;	//idx에 +1 (1부터 빼니까)
				int num = queue.poll() - idx;	//제일 앞 수에서 idx를 뺀 수로 판단해야 하니까 
				if(num <= 0) {
					num = 0;	//0이하면 모두 0으로 초기화 해줘야 한다.
					queue.add(num);	//맨 뒤에 넣는다
					break;	//멈춰!
				}
				if(idx == 5) {	//5가 되면 0으로 초기화 해준다(한 사이클 돌았다)
					idx = 0;
				}
				queue.add(num);	//큐 맨 뒤로 넣어준다.
			}
			
			
			sb.append("#").append(tc).append(" ");	//답에 테스트케이스 입력
			//queue에 있는거 다 꺼내기
			for(int i : queue) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
