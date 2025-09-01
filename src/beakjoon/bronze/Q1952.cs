using System;

public class Program
{
    public static void Main(string[] args)
    {
        string[] arr = Console.ReadLine().Split(" ");
        int M = int.Parse(arr[0]);
        int N = int.Parse(arr[1]);
        
        if (M <= N){
            if (M == 1){
                Console.WriteLine(0);
            }else{
                Console.WriteLine(2 * M -2);
            }
        }else{
            Console.WriteLine(2 * N - 1);
        }
    }
}
