import java.io.*;
import java.util.*;
public class BJ_1074 {
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int result = zzz(N,r,c);
        System.out.println(result);
    }
    public static int zzz(int N, int r, int c){
        if(N==0){
            return 0;
        }

        int half = (int)(Math.pow(2,N-1));
        if(r<half && c<half) return zzz(N-1, r, c);
        if(r<half && c>=half) return half*half+zzz(N-1,r,c-half);
        if(r>=half && c<half) return 2*half*half + zzz(N-1, r-half, c);
        return 3*half*half + zzz(N-1,r-half,c-half);
    }
}
