import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        int[] arr = new int[N];
        int[] sum = new int[N];
        int max = -100*N;

        str = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(str[i]);
            if(i == 0)
                sum[i] = arr[i];
            else
                sum[i] = sum[i-1] + arr[i];
            
            if(i==K-1){
                max = sum[i];
            }
            if(i>K){
                max = Math.max(max, sum[i]-sum[i-K]);
            }
        }

        System.out.println(max);
        
    }
}
