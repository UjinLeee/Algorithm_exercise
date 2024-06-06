import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int[][][] DP = new int[N][N][3];//0:가로, 1:세로, 2:대각선

        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        DP[0][1][0] = 1;
        DP[0][1][1] = 0;
        DP[0][1][2] = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1) 
                    continue;
                //가로
                if(j>=1) 
                    DP[i][j][0] += DP[i][j-1][0] + DP[i][j-1][2];
                //세로
                if(i>=1) 
                    DP[i][j][1] += DP[i-1][j][1] + DP[i-1][j][2];
                //대각선
                if(i>=1 && j>=1 && map[i-1][j] == 0 && map[i][j-1] == 0)
                    DP[i][j][2] += DP[i-1][j-1][0] + DP[i-1][j-1][1] + DP[i-1][j-1][2];
            }
        }
        int ans = DP[N-1][N-1][0] +DP[N-1][N-1][1] + DP[N-1][N-1][2];
        System.out.println(ans);
    }
}
