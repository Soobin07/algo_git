package beakjoon.silver;

import java.util.Scanner;

public class Q2992 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[] arr = sc.next().toCharArray();

		int i = arr.length - 1;
		while (i > 0 && arr[i - 1] >= arr[i]) {
			i--;
		}
		if (i == 0) {
			System.out.println(0);
			return;
		}

		int pivot = i - 1;

		int j = arr.length - 1;
		while (arr[j] <= arr[pivot]) {
			j--;
		}

		char tmp = arr[pivot];
		arr[pivot] = arr[j];
		arr[j] = tmp;

		int left = i;
		int right = arr.length - 1;
		while (left < right) {
			char t2 = arr[left];
			arr[left++] = arr[right];
			arr[right--] = t2;
		}

		System.out.println(new String(arr));
	}
}
