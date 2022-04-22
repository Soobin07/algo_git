package beakjoon.bronze;

import java.util.Scanner;
//https://firework-ham.tistory.com/8
//https://loosie.tistory.com/267
public class Q1929_2 {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        boolean [] arr = new boolean[N+1];
        arr[0] = arr[1] = true;				//why? prime을 false로 표시함


        for(int i=2; i*i<=N; i++) {	//i*i를 넘는 애는 i로 나눠지는지 확인하면 된다
            if(!arr[i]) {
                for(int j=i*i; j<=N; j+=i) {	//i*i이하는 이미 지워졌으니 신경X, i배 씩 해서 넣어줌
                    arr[j] = true;
                }
            }
        }

        for(int i=M; i<=N; i++) {
            if(!arr[i]) { 
                System.out.println(i);
            }
        }
    }
}
