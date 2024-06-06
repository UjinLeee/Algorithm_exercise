import java.util.*;
import java.io.*;
public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int K = Integer.parseInt(str[2]);
        int[] arr = new int[N];
        int[] dp = new int[N];
        StringBuilder stb = new StringBuilder();
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(i==0)
                dp[i] = arr[i];
            else
                dp[i] = dp[i-1] + arr[i];
        }

        for(int j = 0; j < M+K; j++){
            str = br.readLine().split(" ");
            if(str[0].equals("1")){
                //1은 교체한다. 
                int tmp = Integer.parseInt(str[1])-1;
                int change = Integer.parseInt(str[2]);
                int len = change - arr[tmp];
                arr[tmp] = change;
                for(int i = tmp; i<N; i++)
                    dp[i] = dp[i] + len;
            }
            if(str[0].equals("2")){
                int a1 = Integer.parseInt(str[1])-1;
                int a2 = Integer.parseInt(str[2])-1;
                if(a1==0){
                    stb.append(dp[a2]);
                    stb.append('\n');
                }else{
                    int tmp = dp[a2] - dp[a1-1];
                    stb.append(tmp);
                    stb.append('\n');
                }
            }
        }
        System.out.print(stb.toString());
    }
}
