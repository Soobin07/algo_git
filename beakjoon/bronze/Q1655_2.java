package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

//https://gh402.tistory.com/32 에서 가져온 코드. 이해는 가능함
public class Q1655_2 {
	public static void main(String[] args) throws Exception{
		//정수 하나 input > 중간값 output
		//짝수일 경우 두 수중 작은 수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//input 중 가장 빠른 bufferedReader 사용
		int n = Integer.parseInt(br.readLine()); 	//br에서 line을 읽어 integer로 변환
		
		PriorityQueue<Integer> minPQ = new PriorityQueue<>(Comparator.reverseOrder());	//큰 수가 가장 아래 쌓이는 queue (작은 애들을 넣을 것)
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>();							//작은 수가 가장 아래 쌓이는 queue(큰 애들을 넣을 것)
		int input;
		
		StringBuilder sb = new StringBuilder();	//String만드는 것을 빠르게 할 수 있는 stringBuilder
		for(int i = 0 ; i < n ; i++) {		//n번 돌린다.
			input = Integer.parseInt(br.readLine());	//br에서 라인을 읽어 int화 한다
			
			if(minPQ.size() == maxPQ.size()) {	//만약 작은 애들과 큰 애들을 모아놓은 수가 같다면
				minPQ.add(input);	//작은 애들을 모아놓은 곳에 새로운 수를 넣는다
				if(!maxPQ.isEmpty() && minPQ.peek() > maxPQ.peek()) {	//만약 큰 수를 모아놓는 곳이 비어있지 않고, 작은 애들 중 가장 큰 애가 큰 애들 중 가장 작은 애보다 크면
					maxPQ.add(minPQ.poll());	//작은 애들중 가장 큰 애를 뽑아서 큰 애들 노는 물에 넣고 
					minPQ.add(maxPQ.poll());	//반대로 큰 애들 중 가장 작은 애를 뽑아서 작은 애들 노는 물에 넣는다
				}
			}else {		//만약 작은 애들 모아놓은 곳에 수가 더 많다면
				maxPQ.add(input);	//큰 애들 모아놓는 곳에 수를 던져놓고
				if(minPQ.peek() > maxPQ.peek()) {	//역시 작은수중 가장 큰 수와 큰수중 가장 작은 수를 비교하여, 작은수중 가장 큰 수가 더 크다면
					maxPQ.add(minPQ.poll());	//서로 바꿔준다
					minPQ.add(maxPQ.poll());
				}
			}
			sb.append(minPQ.peek()).append("\n");	//작은 수중 가장 큰 수를 스트링버퍼에 넣는다 (짝수라면 작은수를 넣는다 했으니까)
		}
		System.out.println(sb);	//출력
	}

}
