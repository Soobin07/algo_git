package src.beakjoon.bronze;

import java.util.*;

class Q2966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        //N을 ARR[n] - 'A' 하면 그 위치
        char[] sg = {'A', 'B', 'C'};
        //n % 2 != 0이면 B, 아니면 4로 나누어떨어질경우 C
        char[] cy = {'B', 'A', 'B', 'C'};
        //n%6해서 <=1면 C, <=3 A, <=5 B
        char[] hj = {'C', 'C', 'A', 'A', 'B', 'B'};
        
        char[] ans = sc.next().toCharArray();
        int sg_ans = 0;
        int cy_ans = 0;
        int hj_ans = 0;
        for(int n = 0 ; n < N ; n++){
            char a = ans[n];
            
            if(n % 3 == (a - 'A')){
                sg_ans++;
            }
            
            if(n % 2 == 0 && ans[n] == 'B'){
                cy_ans++;
            }else{
                if(n % 4 == 1 && ans[n] == 'A'){
                    cy_ans++;
                }
                if(n % 4 == 3 && ans[n] == 'C'){
                    cy_ans++;
                }
            }
            
            int wari = n % 6;
            if(wari <= 1 && ans[n] == 'C'){
                hj_ans++;
            }else if(wari > 1 && wari <= 3 && ans[n] == 'A'){
                hj_ans++;
            }else if(wari > 3 && wari <= 5 && ans[n] == 'B'){
                hj_ans++;
            }
        }
        
        int max = Math.max(hj_ans, Math.max(sg_ans, cy_ans));
        System.out.println(max);
        if(max == sg_ans){
            System.out.println("Adrian");
        }
        if(max == cy_ans){
            System.out.println("Bruno");
        }
        if(max == hj_ans){
            System.out.println("Goran");
        }
    }
}
