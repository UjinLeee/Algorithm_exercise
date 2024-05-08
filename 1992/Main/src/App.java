import java.io.*;
import java.util.*;

public class App {
    static int N;
    static int[][] map;
    static StringBuilder stb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N]; //size=8
        
        for(int i = 0; i < N; i++){ //map 초기화 하기
            String[] str = br.readLine().split("");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        quard(0,0, N);
        System.out.println(stb.toString());
    }

    public static void quard(int x, int y, int size){
        if(isPossible(x, y, size)){
            stb.append(map[x][y]);
            return;
        }

        int new_size = size/2;
        stb.append('(');
        quard(x, y, new_size);
        quard(x, y+new_size, new_size);
        quard(x+new_size, y, new_size);
        quard(x+new_size , y+new_size, new_size);
        stb.append(')');
    }

    public static boolean isPossible(int x, int y, int size){
        int chk = map[x][y];
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y+size; j++){
                if(map[i][j] != chk)
                    return false;
            }
        }
        return true;
    }
}
