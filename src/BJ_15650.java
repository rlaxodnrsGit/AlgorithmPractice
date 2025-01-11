import java.util.*;
import java.io.*;
public class BJ_2587 {
    static int N; //4
    static int M; //2
    static int[] result = new int[9]; // 0 1
    static boolean[] visited = new boolean[9]; // 0 1 2 3 4
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        DFS(1,0);
    }
    public static void DFS(int n, int m){
        if(m == M){
            for(int i=0; i<M; i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=n; i<N+1; i++){
            if(!visited[i]){
                visited[i] = true;
                result[m] = i;
                DFS(i+1, m+1);
                visited[i] = false;
            }
        }
    }
}
