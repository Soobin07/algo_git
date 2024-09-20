package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

//피보나치 수4
public class Q10826 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		BigInteger[] arr = new BigInteger[N + 1];
		arr[0] = new BigInteger("0");
		if (N >= 1)
			arr[1] = new BigInteger("1");
		for (int i = 2; i <= N; i++) {
			arr[i] = new BigInteger("0").add(arr[i - 1]).add(arr[i - 2]);
		}
		System.out.println(arr[N]);
	}
}
