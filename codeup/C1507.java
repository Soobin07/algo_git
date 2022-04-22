package codeup;

import java.util.Scanner;

public class C1507 {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean[][] map = new boolean[100][100];
        for(int i = 0 ; i < 4 ; i++) {
        	int x1 = sc.nextInt();
        	int y1 = sc.nextInt();
        	int x2 = sc.nextInt();
        	int y2 = sc.nextInt();
        	
        	for(int j = x1 ; j < x2 ; j++) {
        		for(int k = y1 ; k < y2 ; k++) {
        			map[j][k] = true;
        		}
        	}
        }
        int sum = 0;
        for(int i = 0 ; i < 100; i++) {
        	for(int j = 0 ; j < 100 ; j++) {
        		if(map[i][j]) sum++;
        	}
        }
        
        System.out.println(sum);
    }
}
