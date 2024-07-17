import java.io.*;
import java.util.*;
import java.awt.Point;

public class App {

    public static int[][] map; //담는 Map
    public static int[][] visited;
    //1: 서, 2: 북, 4: 동, 8: 남 
    public static int dx[] = {0, -1, 0, 1};
    public static int dy[] = {-1, 0, 1, 0};
    public static int N, M;
    public static int max_room = -1; //최대 넓이의 방을 구하기 위함 
    //public static ArrayList<Integer> room_list = new ArrayList<>();
    public static HashMap<Integer, Integer> room_list = new HashMap<>(); 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]); //7
        M = Integer.parseInt(str[1]); //4

        map = new int[M][N]; //M*N 4*7
        visited = new int[M][N]; //어떤 room 번호인지 확인하기 위함 

        //초기화 하기 
        for(int i = 0; i < M; i++){
            str = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(str[j]);
                visited[i][j] = -1;
            }
        }
        
        int roomNum = 0; //roomNumber는 0부터 
        
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j] == -1){
                    int tmp_size = bfs(i, j, roomNum); //roomSize 
                    room_list.put(roomNum, tmp_size);
                    roomNum ++;
                }
            }
        }

        int combMax = -1;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                int cur_roomNum = visited[i][j];
                for(int k = 0; k < 4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx < 0 || ny < 0 || nx >= M || ny >= N)
                        continue;
                    int cmp_roomNum = visited[nx][ny];
                    if(cur_roomNum == cmp_roomNum)
                        continue;
                    int tmpSize = room_list.get(cur_roomNum) + room_list.get(cmp_roomNum);
                    combMax = Math.max(combMax, tmpSize);
                }

            }
        }


        System.out.println(room_list.size()); //방의 개수 
        System.out.println(max_room);
        System.out.println(combMax);
    }

    public static int bfs(int x, int y, int roomNum){ //size return 
        System.out.print("bfs start!, roomNum: ");
        System.out.println(roomNum);
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        int roomSize = 0;

        while(!queue.isEmpty()){
            Point tmp = queue.poll();
            if(visited[tmp.x][tmp.y] != -1)
                continue;
            roomSize ++; //한 칸이 나온 것이므로 
            visited[tmp.x][tmp.y] = roomNum;
            int chk = map[tmp.x][tmp.y]; //어디에 벽이 있는지 확인하기 위함 
            
            for(int i = 0; i < 4; i++){ 
                if((chk & (1<<i)) > 0)
                    continue;
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx < 0 || nx >= M || ny < 0 || ny >= N){
                    continue;
                }
                queue.add(new Point(nx, ny));
            }   
        }
        
        max_room = Math.max(max_room, roomSize);
        return roomSize;
    }
}
