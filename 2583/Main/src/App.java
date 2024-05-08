import java.io.*;
import java.util.*;

public class App {
    static int M, N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int cnt;
    static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        M = Integer.parseInt(str[0]);
        N = Integer.parseInt(str[1]);
        int K = Integer.parseInt(str[2]);
        map = new int[M][N];
        visited = new boolean[M][N];
        num = 0;
        
        for(int i = 0; i < K; i++){ //초기화하기 
            str = br.readLine().split(" ");
            int x1 = Integer.parseInt(str[0]); //0
            int y1 = Integer.parseInt(str[1]); //2
            int x2 = Integer.parseInt(str[2]); //4
            int y2 = Integer.parseInt(str[3]); //4
            for(int x = y1 ; x < y2 ; x++)
                for(int y = x1; y < x2; y++)
                    map[x][y] = 1;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < M; i++){
            cnt = 0;
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && map[i][j] !=1){
                    visited[i][j] = true;
                    cnt = 1;
                    num++;
                    dfs(i,j);
                    list.add(cnt);
                }
            }
        }
        System.out.println(num);
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }    

    public static void dfs(int x, int y){
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx  >= M || ny < 0 || ny >= N)
                continue;
            if(visited[nx][ny])
                continue;
            if(map[nx][ny] == 1)
                continue;
            visited[nx][ny] = true;
            dfs(nx, ny);
            cnt++;
        }


    }
}
