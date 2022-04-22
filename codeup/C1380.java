package codeup;

import java.util.Scanner;

public class C1380 {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        
        for(int i = 1 ; i < 7 ; i++){
            if(k-i >= 1 && k-i <= 6)
            System.out.println(i+" "+(k-i));
        }
    }
}
