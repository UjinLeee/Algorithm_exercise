import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int H = Integer.parseInt(str[0]);
        int W = Integer.parseInt(str[1]);
        int[][] result = new int[H][W];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < H; i++){
            char[] arr = br.readLine().toCharArray();
            int tmp = -1;
            for(int j = 0; j < W; j++){
                if(arr[j] == 'c'){
                    tmp = 0;
                    result[i][j] = tmp;
                }else{
                    if(tmp >= 0){
                        tmp++;
                        result[i][j] = tmp;
                    }if(tmp == -1){
                        result[i][j] = tmp;
                    }
                }
                sb.append(result[i][j]);
                sb.append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
