import java.io.*;
import java.util.*;
public class BJ_15649 {
    static int N;
    static int M;
    static int[] arr = new int[10];
    static boolean[] visited = new boolean[10];
    public static StringBuilder sb = new StringBuilder(); 

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        function(0);
        System.out.println(sb);
    }
    public static void function(int start){
        if(start == M){
            for(int i=0; i<M; i++){
                sb.append(arr[i]).append(" ");
            }
            
            sb.append("\n");
            return;
        }
        for(int i=1; i<=N; i++){
            if(!visited[i]){
                arr[start] = i;
                visited[i] = true;
                function(start+1);
                visited[i] = false;
            }
        }
    }
}
