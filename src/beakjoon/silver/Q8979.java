package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//compareTo는 quick sort라서 좋지 않다고.. => 제대로 sort 하지 않는다고 한다
public class Q8979 {
	static class Country // implements Comparable<Country> {
	{
		int no, gold, silver, bronze;

		public Country() {
		}

		public Country(int no, int gold, int silver, int bronze) {
			super();
			this.no = no;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}

		/*
		 * @Override public int compareTo(Country o) { if(gold > o.gold) return -1; else
		 * if(gold == o.gold) { if(silver > o.silver) { return -1; }else if(silver ==
		 * o.silver) { if(bronze > o.bronze) { return -1; }else if(bronze == o.bronze) {
		 * return 0; } } } return 1; }
		 */

		@Override
		public String toString() {
			return "no=" + no + ", gold=" + gold + ", silver=" + silver + ", bronze=" + bronze;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 입력 => 삽입정렬 하자
		Country[] arr = new Country[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Country tmp = new Country(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			arr[i] = tmp;
			int j = i;
			for (; j > 0; j--) {
				if (arr[j - 1].gold < arr[j].gold) {
					swap(arr, j - 1, j);
				} else if (arr[j - 1].gold == arr[j].gold) {
					if (arr[j - 1].silver < arr[j].silver) {
						swap(arr, j - 1, j);
					} else if (arr[j - 1].silver == arr[j].silver) {
						if (arr[j - 1].bronze < arr[j].bronze) {
							swap(arr, j - 1, j);
						}
					}
				}
			}
		}

		// 답 찾는 부분
		for (int i = 0; i < N; i++) {
			if (arr[i].no == K) {
				if (i == 0) {
					System.out.println(i + 1);
					break;
				}
				for (int j = 0; j <= i; j++) {
					if (arr[i - j].gold != arr[i].gold || arr[i - j].silver != arr[i].silver
							|| arr[i - j].bronze != arr[i].bronze) {
						System.out.println(i - j + 2);
						break;
					}
				}
				break;
			}
		}
	}

	static void swap(Country[] arr, int idx_a, int idx_b) {
		Country tmp = arr[idx_a];
		arr[idx_a] = arr[idx_b];
		arr[idx_b] = tmp;
	}
}
