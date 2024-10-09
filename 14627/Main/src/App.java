import java.io.*;
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int S = Integer.parseInt(str[0]);
        int C = Integer.parseInt(str[1]);
        long sum = 0;
        int[] arr_S = new int[S];
        for(int i = 0; i < S; i++){
            int tmp = Integer.parseInt(br.readLine());
            arr_S[i] = tmp;
            sum += tmp;
        }

        int L = 1;
        int R = 1000000000;
        int ans = 0;

        while(L<=R){
            int mid = (L+R)/2;
            int num = 0;
            for(int i = 0; i < S; i++){
                //long tmp_num = arr_S[i]/mid; //몫
                num += arr_S[i]/mid;
            }
            if(num < C){
                R = mid-1;
                continue;
            }
            if(num >= C){
                ans = mid;
                L = mid+1;
                continue;
            }
        }
        //ans: 파 길이 
        // ans2 = 0;
        int result = (int)(sum - C*ans);
        System.out.println(result);
    }
}
