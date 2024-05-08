import java.util.*;
import java.io.*;
import java.awt.Point;

public class App {
    static int N;
    static int L;
    static int R;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int [N][N];
        visited = new boolean[N][N];
        //초기화하기    
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        boolean flag = true; //flag를 세운다 

        while(flag){
            if(movePeople() == 0)
                flag = false;
            else
                result++;
        }
        System.out.println(result);

    }
    
    static int movePeople(){
        int unionCount = 0; 

        for(int x = 0; x < N; x++){
            for(int y = 0; y < N; y++){
                if(!visited[x][y]){//방문한적 없으면
                    Queue<Point> queue = new LinkedList<>();
                    Point point = new Point(x, y);
                    queue.add(point);

                    List<Point> list = new ArrayList<>();
                    list.add(point);

                    visited[point.x][point.y] = true;

                    int unionSum = map[point.x][point.y];

                    while(!queue.isEmpty()){
                        Point cur_point = queue.poll();

                        for(int i = 0; i < 4; i++){
                            int nx = cur_point.x + dx[i];
                            int ny = cur_point.y + dy[i];

                            if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                                if(!visited[nx][ny] && checkBoundary(cur_point.x, cur_point.y, nx, ny)){
                                    queue.add(new Point(nx, ny));
                                    list.add(new Point(nx, ny));
                                    visited[nx][ny] = true;
                                    unionCount++;
                                    unionSum += map[nx][ny];
                                }
                            }
                        }
                    }

                    if(unionCount > 0){
                        int avr = unionSum / list.size();
                        for(int i = 0; i < list.size(); i++){
                            Point current = list.get(i);
                            map[current.x][current.y] = avr;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < N; i++){
            Arrays.fill(visited[i], false);
        }
        return unionCount;
    }

    static boolean checkBoundary(int cx, int cy, int nx, int ny){
        int sub = Math.abs(map[cx][cy] - map[nx][ny]);

        if(sub>=L && sub <= R){
            return true;
        }
        return false;
    }
}
