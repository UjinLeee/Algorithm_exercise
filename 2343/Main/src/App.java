import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]); //학생 수 
        int M = Integer.parseInt(str[1]); //블루레이 개수
        int[] arr = new int[N];

        str = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        
    }
}
