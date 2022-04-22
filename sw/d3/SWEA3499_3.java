package sw.d3;

import java.util.Scanner;

//코딩 규칙
//연산자 기준으로 한칸씩 띄어쓰기 해라
//의미 기능별로 엔터로 떨어트려놓으면 좋다
//문서화주석문 잘 달아라(/** */) -> 클래스, 멤버변수, 메서드 위 (자바 api같이 달아라) // 파일제일 위에는 만든 사람, 저작권에 관해 달려있다


//클래스 위에서 alt +shift +j (주석을 제너레이트)
/**
 * @author soo
 *
 */
public class SWEA3499_3 {
	
	static String input1 = "3\r\n" + "6\r\n" + "A B C D E F\r\n" + "4\r\n" + "JACK QUEEN KING ACE\r\n" + "5\r\n"
			+ "ALAKIR ALEXSTRASZA DR-BOOM LORD-JARAXXUS AVIANA";

	// N/2만큼 받아서 그 다음꺼 받을 때 부터 같이 뱉어줄 수 도 있겠구나
//	public static void main(String[] args) {
////		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(input1);
//		StringBuffer sb = new StringBuffer();
//		
//		int T = sc.nextInt();
//		for(int t = 1 ; t <= T ; t++) {
//			int N = sc.nextInt();
//			
//			Queue<String> queue = new LinkedList<>();
//			int first = (N+1)/2;
//			for(int i = 0 ; i < first ; i++) {
//				queue.add(sc.next());
//			}
//
//			sb.append("#").append(t).append(" ");
//			for(int i = first ; i < N ; i++) {
//				sb.append(queue.poll()).append(" ");
//				sb.append(sc.next()).append(" ");
//			}
//			while(!queue.isEmpty()) {
//				sb.append(queue.poll()).append(" ");
//			}
//			
//			sb.append("\n");
//		}
//		System.out.print(sb.toString());
//	}
	// 1. 큐 사용(2개로 나눠 받음)
//	public static void main(String[] args) {
////		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(input1);
//		StringBuffer sb = new StringBuffer();
//		
//		int T = sc.nextInt();
//		for(int t = 1 ; t <= T ; t++) {
//			int N = sc.nextInt();
//			
//			Queue<String> queue = new LinkedList<>();
//			Queue<String> queue2 = new LinkedList<>();
//			int first = (N+1)/2;
//			for(int i = 0 ; i < first ; i++) {
//				queue.add(sc.next());
//			}
//			for(int i = first ; i < N ; i++) {
//				queue2.add(sc.next());
//			}
//			
//			sb.append("#").append(t).append(" ");
//			while(!queue.isEmpty() && !queue2.isEmpty()) {
//				sb.append(queue.poll()).append(" ");
//				sb.append(queue2.poll()).append(" ");
//			}
//			while(!queue.isEmpty()) {
//				sb.append(queue.poll()).append(" ");
//			}
//			
//			sb.append("\n");
//		}
//		System.out.print(sb.toString());
//	}

	// 2. 배열 사용
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
////		Scanner sc = new Scanner(input1);
//		StringBuffer sb = new StringBuffer();
//		
//		int T = Integer.parseInt(sc.nextLine());
//		for(int t = 1 ; t <= T ; t++) {
//			sb.append("#").append(t).append(" ");
//			int N = Integer.parseInt(sc.nextLine());
//			String[] cards = sc.nextLine().split(" ");
//			
//			for(int i = 0 ; i < (N+1)/2 ; i++) {
//				sb.append(cards[i]).append(" ");
//				if((N+1)/2+i < N)
//					sb.append(cards[(N+1)/2+i]).append(" ");
//			}
//			sb.append("\n");
//		}
//		System.out.print(sb.toString());
//	}

	// 쌤은 배열로
	// 짝수 : i, i+N/2
	// 홀수 : i, i+N/2+1 하고 마지막에 N/2 출력
//	public static void main(String[] args) {
////		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(input1);
//		StringBuffer sb = new StringBuffer();
//		
//		int T = sc.nextInt();
//		for(int t = 1 ; t <= T ; t++) {
//			int N = sc.nextInt();
//			String[] cards = new String[N];
//			for(int i = 0 ; i < N ; i++) {
//				cards[i] = sc.next();
//			}
//			
//			int half = N/2;	//반복시, 두번재값의 인덱스 구할때 사용
//			int remain = N%2; //짝수홀수
//
//			sb.append("#").append(t).append(" ");
//			for(int i = 0 ; i < half ; i++) {	//절반만큼 반복
//				sb.append(cards[i]).append(" ");
//				sb.append(cards[i+half+remain]).append(" ");
//			}
//			if(remain == 1) sb.append(cards[half]);
//			sb.append("\n");
//		}
//		System.out.print(sb.toString());
//	}

	// 종환
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input1);
		StringBuffer sb = new StringBuffer();

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			String[] cards = new String[N];
			for (int i = 0; i < N; i++) {
				cards[i] = sc.next();
			}

			int half = (N + 1) / 2; // 반복시, 두번재값의 인덱스 구할때 사용

			sb.append("#").append(t).append(" ");
			for (int i = 0; i < N; i++) { // 절반만큼 반복
				sb.append(cards[i % 2 * half + i / 2 % half]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
