import com.sun.jdi.StringReference;

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_1926 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] Dist;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Dist = new int[N][M];
        visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                Dist[i][j] = num;
            }
        }

        int ground = 0; //땅 개수
        int maxCount = 0; //땅 최대크기

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (Dist[i][j] == 0 || visited[i][j]) continue; //갈 곳이 아니야
                //이제부터 갈 곳
                ground++;
                visited[i][j] = true;
                q.offer(new int[] {i,j}); //현 위치 q에 추가
                int count = 0; //현재 땅 크기 셀거야

                while(!q.isEmpty()){
                    count++; //현 위치 땅을 크기 세는 값에 더해주자
                    int[] now = q.poll(); //지금 위치 q에서 꺼내
                    int x = now[0];
                    int y = now[1];
                    for(int d=0; d<4; d++){
                        int nx = x+dx[d];  //다음 상하좌우 칸 x
                        int ny = y+dy[d];  //다음 상하좌우 칸 y

                        if(nx<0 || ny<0 || nx>=N || ny>=M) continue; // 요 조건 칸은 안갈거임
                        if(visited[nx][ny] || Dist[nx][ny] != 1) continue; //요 조건도 안감.
                        //이 외 조건은 간다는 뜻이겠죠?
                        visited[nx][ny] = true;
                        q.offer(new int[] {nx,ny});
                    }
                }
                //q가 비었어 -> 인접한 땅들을 다 돌았어 -> 1개의 큰 땅이 생긴거야
                maxCount = Math.max(maxCount, count); //땅 크기값들 중에 최댓값을 출력해야되니까..
            }
        }
        System.out.println(ground);
        System.out.println(maxCount);
    }
}