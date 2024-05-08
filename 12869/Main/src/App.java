import java.io.*;
import java.util.*;

public class App {
    
    static int[][] deltas = {{-9,-3,-1},{-9,-1,-3},{-3,-9,-1},{-3,-1,-9},{-1,-9,-3},{-1,-3,-9}};
    static int[][][] dp;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] scv = new int[3];//scv들

        for(int i = 0; i < N; i++){
            scv[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[61][61][61];
        min = Integer.MAX_VALUE; //오 이런게 있다니

        dfs(scv, 0);
        System.out.println(min);
    }

    public static void dfs(int[] scv, int cnt){
        int s1 = scv[0];
        int s2 = scv[1];
        int s3 = scv[2];

        if(min <= cnt) return; //현재 공격수가 클 경우 중단 

        if(dp[s1][s2][s3] != 0 && dp[s1][s2][s3] <= cnt) return;

        dp[s1][s2][s3] = cnt;

        if(s1 == 0 && s2 == 0 && s3 == 0){
            min = Math.min(min, cnt);
            return;
        }
        
        for(int i = 0; i < 6; i++){
            dfs(new int[] {Math.max(s1 + deltas[i][0], 0),Math.max(s2 + deltas[i][1], 0),Math.max(s3 + deltas[i][2], 0)}, cnt+1);
        }
    }
}
