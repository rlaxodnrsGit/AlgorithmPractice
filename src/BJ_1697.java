import java.io.*;
import java.util.*;
public class BJ_1697 {
    static int[] Map = new int[100001];
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();

        q.offer(N);
        Map[N] = 0;
        while(!q.isEmpty()){
            int now = q.poll();
            int next1 = now+1;
            int next2 = now-1;
            int next3 = now*2;

            if(now == K){
                break;
            }

            if(next1 <= 100000 && next1 >= 0){
                if(!visited[next1]){
                    Map[next1] = Map[now]+1;
                    visited[next1] = true;
                    q.offer(next1);
                }
            }
            if(next2 <= 100000 && next2 >= 0){
                if(!visited[next2]){
                    Map[next2] = Map[now]+1;
                    visited[next2] = true;
                    q.offer(next2);
                }
            }
            if(next3 <= 100000 && next3 >= 0){
                if(!visited[next3]){
                    Map[next3] = Map[now]+1;
                    visited[next3] = true;
                    q.offer(next3);
                }
            }
        }
        System.out.println(Map[K]);
    }
}
