import java.io.*;
import java.awt.Point;

/*
 * 가로 세로를 조심하자!
 * TestCase가 있는 경우 -> 초기화 조심하기
 * Connected Component 찾는 문제 -> DFS로
 * 
 * visited와 map 확인하는 방법.
 */
public class App {
    static int M; 
    static int N;
    static int K;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int min;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());

      for(int i = 0; i < T; i++){
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]); //가로길이 10
        M = Integer.parseInt(str[1]); //세로길이 8
        K = Integer.parseInt(str[2]); //배추가 심어진 개수
        min = 0;

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int j = 0; j < K; j++){//초기화하기 
            str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            map[x][y] = 1;
            // System.out.println(x + "+" + y);
        }

        for(int x = 0; x < N; x++){
            for(int y = 0; y < M; y++){
                if(!visited[x][y] && map[x][y] == 1){
                    //방문한 적 없다면
                    visited[x][y] = true;
                    min ++ ; //영역 한개 추가하기
                    dfs(new Point(x,y));
                }
            }
        }
        System.out.println(min);
      }
      return;
    }

    public static void dfs(Point point){ //point와 인접한 것들 찾아서 dfs 돌리기 
        //순회하기
        for(int i = 0; i < 4; i++){
            int nx = point.x + dx[i];
            int ny = point.y + dy[i];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) 
                continue;
            if(visited[nx][ny]) //방문한적 있으면
                continue;
            if(map[nx][ny] == 0) //배추 x
                continue; 
            visited[nx][ny] = true;
            dfs(new Point(nx,ny));
        }
        return;
    }

}
