using System;

public class Program
{
    public static void Main(string[] args)
    {
        int TC = int.Parse(Console.ReadLine());
        for(int i = 0 ; i < TC ; i++){
            String[] arr = Console.ReadLine().Split(" ");
            int sum = 0;
            foreach(string n in arr){
                sum += int.Parse(n);
            }
            
            Console.WriteLine(sum);
        }
    }
}
