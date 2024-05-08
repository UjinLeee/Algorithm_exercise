import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.*;
import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class App {
    static int[][] map;
    static int N; 
    static int M;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        int[][] visited = new int[N][M];
        
        map = new int[N][M];
        for(int i = 0; i < N; i++){
            str = br.readLine().split("");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(str[j]);
                visited[i][j] = -1;
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0));
        visited[0][0] = 1; // 0 에서 시작 
        while(!queue.isEmpty()){
            Point tmp = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if(map[nx][ny] == 0)
                    continue;
                if(visited[nx][ny] == -1){
                    visited[nx][ny] = visited[tmp.x][tmp.y] + 1;
                    queue.add(new Point(nx,ny));
                }
            }
        }
        System.out.println(visited[N-1][M-1]);
    }

}

