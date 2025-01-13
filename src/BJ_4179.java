import java.util.*;
import java.io.*;

public class BJ_4179 {
    static char[][] Map;
    static int[][] Fire;
    static int[][] Jihoon; 
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 행
        int M = Integer.parseInt(st.nextToken()); // 열
        Map = new char[N][M];
        Fire = new int[N][M];
        Jihoon = new int[N][M];
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> f = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = str.charAt(j);
                if (c == '#') { // 둘 다다 못지나간다.
                    Map[i][j] = c;
                    Fire[i][j] = -1;
                    Jihoon[i][j] = 1;
                } else if (c == 'F') { // 불났으니까 넌 못지나간다.
                    Map[i][j] = c;
                    Fire[i][j] = -1;
                    f.offer(new int[] { i, j });
                } else if (c == 'J') { // 출발점이니라.
                    Map[i][j] = c;
                    Jihoon[i][j] = 0;
                    q.offer(new int[] { i, j });
                } else { // 모찌 나가요~
                    Map[i][j] = c; // 딛을 때마다 더해주면 거리가 나오겠죠?
                    Fire[i][j] = 0; //그냥 0이상이면 불이 번질 수 있는 곳
                    Jihoon[i][j] = 1; //움직인 거리 계산 한번에 할거임
                }
            }
        }

        //불 번진다잉
        while (!f.isEmpty()) {
            int[] now = f.poll();
            int x = now[0];
            int y = now[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) //범위 넘어가지 못함.
                    continue;
                if (Map[nx][ny]=='#' || Fire[nx][ny] < 0) //불이 못번지는 곳 (벽) 
                    continue;
                
                //불이 번지게 되면
                f.offer(new int[] { nx, ny });
                Fire[nx][ny] = -1; //지훈이가 못 움직이게 하기 위함. 
            }
        }

        //지훈아 움직이자.
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) { // Map범위를 넘어서면 탈출
                    System.out.println(Jihoon[x][y] + 1);
                    return;
                }
                if (Map[nx][ny] == '#' || Fire[nx][ny] == -1) // 못가는 곳 (벽, 불이번진곳)
                    continue;

                //움직일 수 있는 곳이면면
                q.offer(new int[] { nx, ny });
                Jihoon[nx][ny] = Jihoon[x][y] + 1;            
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
