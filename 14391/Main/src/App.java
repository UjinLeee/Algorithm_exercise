import java.io.*;
import java.util.*;
public class App {
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            str = br.readLine().split("");
            for(int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(str[j]);
        }
        
    }
}
