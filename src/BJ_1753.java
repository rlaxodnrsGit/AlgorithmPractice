import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{ //인접리스트에 에지와 가중치를 넣기 위한 자료구조조
    int v,w;
    
    public Edge(int v, int w){
        this.v = v; //에지
        this.w = w; //가중치
    }
    public int compareTo(Edge E){
        return this.w-E.w;
    }
}

public class BJ_1753 {
    static int V;
    static int E;
    static int K;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[V+1]; //방문여부
        int[] answer = new int[V+1]; //거리배열
        List<Edge>[] list = new List[V+1]; //인접리스트트

        for(int i=1; i<=V; i++){
            list[i] = new ArrayList<>();
            answer[i] = Integer.MAX_VALUE;  //모두 무한대로 저장.
        }

        for(int j=0; j<E; j++){
            st = new StringTokenizer(br.readLine(), " "); 
            int u = Integer.parseInt(st.nextToken()); //출발점
            int v = Integer.parseInt(st.nextToken()); //도착점
            int w = Integer.parseInt(st.nextToken()); //가중치치
            list[u].add(new Edge(v,w));
        }

        //다익스트라.
        PriorityQueue<Edge> pq = new PriorityQueue<>(); 
        //우선순위 큐에서 시작점이 먼저 수행하도록 만들어야 해서 노드와 가중치를 뒤집음.
        //가중치값이 0이니까 가장 먼저 수행됨. 
        answer[K] = 0; //출발점은 가중치 0
        pq.add(new Edge(0, K));

        while(!pq.isEmpty()){ //큐가 빌떄까지지
            Edge n = pq.poll();
            int current_v = n.w; //처음에 우선순위 큐에 (0,K)로 넣었기 때문에
                                 //현재 노드값은 w에 있다.

            if(visited[current_v]){ //방문한 코드는 넘어가가
                continue;
            }
            visited[current_v] = true; //방문한 곳이 아니라면 아래를 계속 수행행

            for(int i=0; i<list[current_v].size(); i++){
                Edge next = list[current_v].get(i); //현 노드에 인접한 노드를 가져와
                
                //최단거리를 구하기 위하기.
                //가져온 인접한 노드의 가중치 > 거리배열의 현재 노드 가중치 + 다음 노드로의 가중치
                if(answer[next.v] > answer[current_v] + next.w){ 
                    answer[next.v] = next.w + answer[current_v];
                    pq.add(new Edge(answer[next.v], next.v)); 
                }
            }
        }
        for(int i=1; i<=V; i++){
            if(visited[i]){
                sb.append(answer[i]).append('\n');
            }
            else{
                sb.append("INF").append('\n');
            }
        }
        System.out.println(sb);
    }
}
