import java.io.*;
import java.util.*;

public class App {
    static int N;
    static int[][] map;
    static int min;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        min = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            boolean[] chk = new boolean[N];
            chk[i] = true; //탐색했다! 
            //i부터 시작! 
            dfs(0, i, chk, 1, i);
            chk[i] = false;
        }
        System.out.println(min);
    }

    public static void dfs(int len, int idx, boolean[] chk, int num, int first){
        //len: 현재까지의  길ㅣ
        //idx: 현재 index 
        //num: 현재까지 방문한 개수 
        //chk: 방문했는지 
        if(num == N){ //N개 다 탐색! 
            if(map[idx][first] != 0){ //가는 길이 있다면 
                int tmp = len+map[idx][first];
                min = Math.min(min, tmp);
                return;
            }
        }else{
            //아직 탐색해야하는게 남았다 

            for(int i = 0; i < N; i++){
                if(chk[i] == false && map[idx][i] != 0){
                    chk[i] = true; //탐색했다 
                    dfs(len+map[idx][i], i, chk, num+1, first);
                    chk[i] = false;
                }
            }
        }
    }
}
