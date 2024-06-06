import java.io.*;
import java.util.*;

public class App {
    static String[][] map;
    static int[][] DP;
    static boolean isCycle;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int max = -1;
    static boolean[][] visited;
    static int N, M;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        isCycle = false;
        visited = new boolean[N][M];
        map = new String[N][M];
        DP = new int[N][M];

        for(int i = 0; i < N; i++){
            map[i] = br.readLine().split("");
        }

        DP[0][0] = 0;
        visited[0][0] = true;
        dfs(0, 0);
        
        if(isCycle == true){
            System.out.println(-1);
        }else{
            System.out.println(max);
        }

    }

    public static void dfs(int x, int y){

        int len = Integer.parseInt(map[x][y]);
        
        for(int i = 0; i < 4; i++){

            int nx = x + dx[i]*len;
            int ny = y + dy[i]*len;
           
            if(nx < 0 || ny<0 || nx>=N || ny>= M || map[nx][ny].equals("H")){ //기저 ){ //기저사례1 
                max = Math.max(max, DP[x][y]+1);
                continue;
            }
            if(visited[nx][ny] == true){
                //다시 돌아온 것이므로 
                isCycle = true;
                return;
            }
            if(DP[nx][ny] > DP[x][y] + 1) //이미 더 큰 값이 존재하는 경우 -> DP를 사용하는 이유이다. 
                continue;
            else{
                visited[nx][ny] = true;
                DP[nx][ny] = DP[x][y] + 1;
                dfs(nx, ny);
                visited[nx][ny] = false;
            }
        }
    }
}