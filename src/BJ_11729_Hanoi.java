import java.io.*;
import java.util.*;
public class BJ_11729_Hanoi {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        sb.append((int)(Math.pow(2,N)-1)).append('\n');
        Hanoi(1,3,N);
        System.out.println(sb);
    }
    public static void Hanoi(int a, int b, int n){ //a=출발막대, b=도착막대, n=원판개수
        if(n==1) {
            sb.append(a+" "+b).append('\n');
            return;
        }

        //1 2 3 막대가 있다. a=1 ,b=3이므로 중앙막대는 6-a-b=2가 된다.
        Hanoi(a, 6-a-b, n-1); //n개 중 n-1개를 중앙막대로 옮긴다.
        sb.append(a+" "+b).append('\n'); //맨밑 n번째 원판을 맨 끝으로 옮긴다.
        Hanoi(6-a-b, b, n-1); //n-1개의 원판들을 맨 끝으로 옮긴다. 
    }
}
