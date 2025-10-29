package src.beakjoon.bronze;

import java.util.*;

class Q26068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 0;
        for(int n = 0 ; n < N ; n++){
            String str = sc.next();
            int time = Integer.parseInt(str.substring(2));
            if(time <= 90){
                ans++;
            }
        }
        
        System.out.println(ans);
    }
}
