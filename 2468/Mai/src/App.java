import java.io.*;
import java.util.*;

public class App {
    static int N;
    static int max;
    static int max_height;
    static int[][] map;
    static int tmp_max;
    static boolean[][] visited; //얘만 초기화해주면 된다 
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        //dfs로 짜기 
        //높이가 최대인 것도 인자 받기 
        //max 인자도 받기 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //map 초기화하기
        map = new int[N][N];
        max_height = -1;
        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(str[j]);
                max_height = Math.max(max_height, map[i][j]); 
            }
        }

        max = 0;

        for(int height = 0; height <= max_height; height++){ //0부터 해야함. (반례) -> 비가 오지 않는 경우도 고려해야하므로!
            //height에 따라서 하기
            tmp_max = 0;
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j] && map[i][j] > height){
                        //방문한적 없고 height가 더 큰 경우!
                        visited[i][j] = true;
                        tmp_max ++;
                        dfs(i,j, height);
                    }
                }
            }
            max = Math.max(max, tmp_max);
        }
        System.out.println(max);

    }    

    public static void dfs(int x, int y, int height){
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;
            if(visited[nx][ny]) //방문했다면 
                continue;
            if(map[nx][ny] <= height) //물에 잠기는 거니까 
                continue;
            visited[nx][ny] = true;
            dfs(nx, ny, height);
        }
        return;
    }

}
