package src.beakjoon.bronze;

import java.util.*;
import java.io.*;

class Q5613 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long ans = sc.nextInt();

        while(true){
            String str = sc.next();
            if(str.equals("+")){
                ans += sc.nextInt();
            }else if(str.equals("-")){
                ans -= sc.nextInt();
            }else if(str.equals("*")){
                ans *= sc.nextInt();
            }else if(str.equals("/")){
                ans /= sc.nextInt();
            }else if(str.equals("=")){
                break;
            }
        }
        
        System.out.println(ans);
    }
}
