import java.io.*;
import java.util.*;

public class App {
    static int N;
    static int M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max;
    // static boolean[][] chk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N,M 입력받기 
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        map = new int[N][M];
        for(int i = 0; i < N; i++){ //초기화하기
            String[] arr = br.readLine().split("");
            for(int j = 0; j < M; j++){
                if(arr[j].equals("W")){
                    //0: 바다 1: 육지기
                    map[i][j] = 0;
                }else{
                    map[i][j] = 1;
                }
            }
        }

        max = -1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1){//육지면
                    boolean[][] visited = new boolean[N][M];
                    int[][] chk_map = new int[N][M]; //최단 거리를 위한  
                    chk_map[i][j] = 0;
                    visited[i][j] = true;
                    dfs(map, visited, chk_map, i, j);
                }
               
            }
        }
        System.out.println(max);

    }

    public static void dfs(int[][] map, boolean[][] visited, int[][] chk_map, int cur_x, int cur_y){
        //cur_x: 현재 x
        //cur_y: 현재 y
        //상하좌우만 가능하다 
        //for문 돌면서 탐색하기 
       
        for(int i = 0; i < 4; i++){
            int next_x = cur_x + dx[i];
            int next_y = cur_y + dy[i];
            if(next_x < 0 || next_x >= N ||next_y < 0 || next_y >= M)
                continue;
            else if(map[next_x][next_y] == 0) //바다면 
                continue; 
            else if(visited[next_x][next_y] && chk_map[next_x][next_y] < chk_map[cur_x][cur_y] +1){ //true인데 
                // if(chk_map[next_x][next_y] < chk_map[cur_x][cur_y] +1) //작으면 할 필요가 없다 
                    continue;
            }
            //다 해당 안되면 
            else{
                visited[next_x][next_y] = true;
                chk_map[next_x][next_y] = chk_map[cur_x][cur_y] + 1; //바꾸기 
                dfs(map, visited, chk_map, next_x, next_y);
                
            }
        }
        if(max < chk_map[cur_x][cur_y] ){
            max = chk_map[cur_x][cur_y];
            System.out.println("현재 max는 " + max);
        }
            
    }
}
