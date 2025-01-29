import java.util.*;
import java.io.*;
public class BJ_1780 {
    static int N;
    static int[][] Map;
    static int A; //-1로 채워진 종이 개수
    static int B; // 0으로 채워진 종이 개수
    static int C; // 1로 채워진 종이 개수수

    static int tmp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        Map = new int[N][N];

        for(int i=0; i<N; i++){     //Map초기화
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Cutting(0,0,N);

        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
    }

    public static void Cutting(int s, int e, int k){
        if(Search(s,e,k) == true){ //안에 수가 다 같으면
            if(tmp == -1){
                A++;
            }
            else if(tmp == 0){
                B++;
            }
            else{
                C++;
            }
            return;
        }

        // 안에 수 중에 다른게 있어. 변절자새끼
        int cutK = k/3;

        Cutting(s,e,cutK);
        Cutting(s,e+cutK,cutK);
        Cutting(s,e+2*cutK,cutK);

        Cutting(s+cutK,e,cutK);
        Cutting(s+cutK,e+cutK,cutK);
        Cutting(s+cutK,e+2*cutK,cutK);

        Cutting(s+2*cutK,e,cutK);
        Cutting(s+2*cutK,e+cutK,cutK);
        Cutting(s+2*cutK,e+2*cutK,cutK);
    
    }

    public static boolean Search(int s, int e, int k){
        tmp = Map[s][e];

        for(int i=s; i<s+k; i++){
            for(int j=e; j<e+k; j++){
                if(tmp != Map[i][j]){
                    return false;  //false면 Cutting
                }
            }
        }

        return true; //true면 count.
    }

}


//1. 아이디어
// 재귀로 풀어야할듯. 
// 1) 9개 조각으로 자른다 -> {0 ~ N/3}, {N/3 ~ 2N/3}, {2N/3 ~ N}
// 2) 모두 같은지 다른지 판단? -> BFS?
//2. 시간복잡도
//3. 자료구조