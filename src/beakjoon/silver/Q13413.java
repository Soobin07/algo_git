package src.beakjoon.silver;

import java.util.*;

class Q13413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        for(int t = 0 ; t < T ; t++){
            int N = sc.nextInt();
            String A = sc.next();
            String B = sc.next();
            
            int black = 0;
            int white = 0;
        
            for(int i = 0 ; i  < N ; i++){
                if(A.charAt(i) != B.charAt(i)){
                    if(A.charAt(i) == 'B'){
                        black++;
                    }else{
                        white++;
                    }
                }
            }
            
            int sum = black + white - Math.min(black, white);
            System.out.println(sum);
        }
        
    }
}
