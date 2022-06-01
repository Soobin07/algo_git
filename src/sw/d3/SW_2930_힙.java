package sw.d3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SW_2930_힙 {	//d3
	static class MaxHeap {
		int[] data;
		int pos;

		public MaxHeap() {
			this(10);
		}

		public MaxHeap(int size) {
			data = new int[size + 1]; // 0번 안쓰니까
		}

		private boolean isFull() {
			return pos == data.length - 1;
		}

		private void swap(int idx1, int idx2) {
			int temp = data[idx1];
			data[idx1] = data[idx2];
			data[idx2] = temp;
		}

		public void offer(int val) {
			if (isFull()) {
				// data의 length 증가시킴
				data = Arrays.copyOf(data, data.length * 2);
			}
			data[++pos] = val;
			int idx = pos;
			while (idx > 1 && data[idx] > data[idx / 2]) {
				swap(idx, idx / 2);
				idx /= 2;
			}
		}

		public void print() {
			System.out.println(Arrays.toString(data));
		}

		public int poll() {
			if (pos == 0)
				return -1;
			int result = data[1];
			data[1] = data[pos]; // 데이터 트리 깨지지 말라고 가장 끝 값 가져오기
			data[pos--] = 0;

			// 힙의 재정렬
			heapify();

			return result;
		}

		private void heapify() {
			int idx = 1;
			while (idx * 2 <= pos) { // 자식이 있으면
				if (data[idx] >= data[idx * 2] && data[idx] >= data[idx * 2 + 1]) {
					break;
				}
				if (data[idx * 2] > data[idx * 2 + 1]) {
					swap(idx, idx * 2);
					idx = idx * 2;
				} else {
					swap(idx, idx * 2 + 1);
					idx = idx * 2 + 1;
				}
			}
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/input2930.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1 ; t <= T ; t++) {
			MaxHeap heap = new MaxHeap();
			StringBuffer sb = new StringBuffer();
			sb.append("#").append(t);
			int N = sc.nextInt();
			for(int i = 0 ; i < N ; i++) {
				int op = sc.nextInt();
				if(op == 1) {
					heap.offer(sc.nextInt());
				}else {
					sb.append(" ").append(heap.poll());
				}
			}
			
			System.out.println(sb.toString());
		}
	}
}
