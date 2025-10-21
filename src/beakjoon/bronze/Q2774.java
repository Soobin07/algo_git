package src.beakjoon.bronze;

import java.util.*;

class Q2774 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0 ; t < T ; t++){
            char[] X = sc.next().toCharArray();
            Set<Character> set = new HashSet<>();
            for(int x = 0 ; x < X.length ; x++){
                set.add(X[x]);
            }

            System.out.println(set.size());
        }
    }
}
