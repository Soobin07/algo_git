import java.util.*;
import java.io.*;

class Q24444 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++){
            arr[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            arr[u].add(v);
            arr[v].add(u);
        }
        
        for(int i = 1 ; i <= N ; i++){
            Collections.sort(arr[i]);
        }
        
        int[] order = new int[N+1];
        Queue<Integer> q = new LinkedList<>();
        int count = 1;
        order[R] = count;
        q.add(R);
        
        while(!q.isEmpty()){
            int now = q.poll();
            for(int tmp : arr[now]){
                if(order[tmp] > 0)
                    continue;
                order[tmp] = ++count;
                q.add(tmp);
            }
        }
        
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < N ; i++){
            sb.append(order[i+1]+"\n");
        }
        System.out.print(sb.toString());
    }
}
