package beakjoon.bronze;

import java.util.Scanner;

public class Q10996 {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        
//        if(n == 1) {
//        	sb.append("*");
//        }else {
        	for(int i = 0 ; i < n*2 ; i++){
        		for(int j = 0 ; j < n ; j++){
        			if(i % 2 != 0){
        				if(j % 2 == 0){
        					sb.append(" ");
        				}else{
        					sb.append("*");
        				}
        			}else{
        				if(j % 2 == 0){
        					sb.append("*");
        				}else{
        					sb.append(" ");
        				}
        			}
        		}
        		sb.append("\n");
        	}
//        }
        System.out.println(sb);
    }
}
