using System;
using System.Collections.Generic;

public class Program
{
    public static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        
        while(n != 0){
            Dictionary<string, string> dict = new Dictionary<string, string>();
            string[] arr = new string[n];
        
            for (int i = 0 ; i < n ; i++){
                string ori = Console.ReadLine();
                arr[i] = ori.ToLower();
                dict[arr[i]] = ori;
            }
            
            Array.Sort(arr);
            Console.WriteLine(dict[arr[0]]);
            
            n = int.Parse(Console.ReadLine());
        }
    }
}
