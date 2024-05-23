import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int k = 0; k < T; k++){

            String[] str = br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
    
            int[] A = new int[N];
            str = br.readLine().split(" ");
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(str[i]);
            
            int[] B = new int[M];
            str = br.readLine().split(" ");
            for(int i = 0; i < M; i++)
                B[i] = Integer.parseInt(str[i]);
            
            Arrays.sort(B);
            //8, 1, 7, 3, 1
            //1, 3, 6 
            int cnt = 0;
    
            for(int i = 0; i < N; i++){
                int tmp = A[i];
                int left = 0;
                int right = M-1;
                int tmp_cnt = 0;
                while(left<=right){
                    int mid = (left+right)/2;
                    if(B[mid] >= tmp){
                        right = mid-1;
                    }if(B[mid] < tmp){
                        tmp_cnt = mid+1;
                        left = mid+1;
                    }
                }
                cnt +=tmp_cnt;
            }
            sb.append(cnt);
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
