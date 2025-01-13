import java.io.*;
import java.util.*;
public class BJ_7576 {
    static int[][] Map;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int num = 1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map = new int[M][N];
        visited = new boolean[M][N];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){ //출발점
                    visited[i][j] = true; //방문함
                    q.offer(new int[] {i,j}); //q에 저장
                }
                else if(num == -1){
                    visited[i][j] = true; //방문했다고 쳐서 BFS할때 방문할 곳에서 배제시킴
                }
                Map[i][j] = num;
            }
        }

        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for(int d=0; d<4; d++){
                int nx = x+dx[d];
                int ny = y+dy[d];

                if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
                if(visited[nx][ny] || Map[nx][ny] != 0) continue;

                visited[nx][ny] = true;
                q.offer(new int[] {nx,ny});
                Map[nx][ny] = Map[x][y] + 1;
                num = Map[nx][ny];
            }
        }
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(Map[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(num-1);
    }
}
