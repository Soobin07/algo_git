package src.beakjoon.golds;

import java.util.*;

class Q11758 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] a = {sc.nextLong(), sc.nextLong()};
        long[] b = {sc.nextLong(), sc.nextLong()};
        long[] c = {sc.nextLong(), sc.nextLong()};
        
        long tmp = (b[0] - a[0])*(c[1] - a[1]) - (c[0] - a[0])*(b[1] - a[1]);
        System.out.println(tmp == 0 ? 0 : tmp > 0 ? 1 : -1);
    }
}
