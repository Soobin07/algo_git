package codeup;

import java.util.Scanner;

public class C1180 {
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        num = (num%10*10+num/10)*2;
        if(num > 100) num -=100;
        String msg = "OH MY GOD";
        if(num <= 50) msg = "GOOD";
        System.out.println(num);
        System.out.println(msg);
    }
}
