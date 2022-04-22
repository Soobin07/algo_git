package beakjoon.bronze;

import java.util.Scanner;

public class Q3052 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int[] rs = new int[42];	//42로 나누니까 42이상은 나머지가 나올 수 없음
        int count = 0;
        
        while(sc.hasNextInt()){
            int r = sc.nextInt()%42;
            rs[r]++;
        }
        
        for(int i = 0 ; i < 42 ; i++){
            if(rs[i] > 0) count++;
        }
        
        System.out.println(count);
        
    }
}
