import java.util.*;
import java.io.*;
import java.awt.Point;
import java.lang.Math;

public class App {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int R;
    static int C;
    static char[][] map;
    
    static int[][] dist1; //불의 전파 시간 (시간)
    static int[][] dist2; //지훈이의 이동 시간 
    static Queue<Point> Q1 = new LinkedList<>();
    static Queue<Point> Q2 = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        dist1 = new int[R][C];
        dist2 = new int[R][C];
        
        for(int i = 0; i < R; i++){
            String s = br.readLine(); //String으로 받아와서 String을 쪼개는거
            for(int j = 0; j < C; j++){
                map[i][j] = s.charAt(j);
                dist1[i][j] = -1;
                dist2[i][j] = -1;
                if(map[i][j] == 'F'){
                    Q1.offer(new Point(i,j));
                    dist1[i][j] = 0; //시작은 0초
                }
                if(map[i][j] == 'J'){
                    Q2.offer(new Point(i,j)); 
                    dist2[i][j] = 0; //시작은 0초
                }
            }
        }
        //불 BFS (1)
        while(!Q1.isEmpty()){
            Point cur_point = Q1.poll();
            for(int dir = 0; dir < 4; dir++){
                int nx = cur_point.x + dx[dir];
                int ny = cur_point.y + dy[dir];
                if(nx<0 || nx >= R || ny < 0 || ny >= C)
                    continue;
                if(dist1[nx][ny] >= 0 || map[nx][ny] == '#') //벽이거나, dist1이 차있으면 못감 
                    continue;
                dist1[nx][ny] = dist1[cur_point.x][cur_point.y] + 1;
                Q1.offer(new Point(nx, ny));
            }
        }

        while(!Q2.isEmpty()){
            Point cur_point = Q2.poll();
            for(int dir = 0; dir < 4; dir++){
                int nx = cur_point.x + dx[dir];
                int ny = cur_point.y + dy[dir];

                if(nx<0 || nx >= R || ny < 0 || ny >= C){
                    //성공
                    System.out.println(dist2[cur_point.x][cur_point.y]+1);
                    return;
                }
                if(dist2[nx][ny] >= 0 || map[nx][ny] == '#') //지나간곳 or 벽이면 가기
                    continue;
                if(dist1[nx][ny] <= dist2[cur_point.x][cur_point.y] + 1) //불이 먼저 와잇으면 안됨
                    continue;
                dist2[nx][ny] = dist2[cur_point.x][cur_point.y] + 1;
                Q2.offer(new Point(nx, ny));
                 
            }
        }
        System.out.println("IMPOSSIBLE");

    }

}
