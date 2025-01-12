import java.util.*;
import java.io.*;
public class BJ_2178 {
    static int[][] Map;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
     public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
       
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map = new int[N][M];
        visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<N; i++){  //map 초기화
            String str = br.readLine();
            for(int j=0; j<M; j++){
                char c = str.charAt(j);
                Map[i][j] = c - '0';
            }
        }

        //시작점은 0,0    //도착점은 N,M
        visited[0][0] = true;
        q.offer(new int[] {0,0});

        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for(int d=0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(visited[nx][ny] || Map[nx][ny] != 1) continue;

                visited[nx][ny] = true;
                q.offer(new int[] {nx,ny});
                Map[nx][ny] += Map[x][y];
            
            }
        }
        System.out.println(Map[N-1][M-1]);
    }
}
