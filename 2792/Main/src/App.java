import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException { // 순열 돌리기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        int[] arr = new int[M];
        int right = Integer.MIN_VALUE;
        int left = 1; //1부터 시작 
        for(int i = 0; i < M ; i++){
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]); //최대 찾기 
        }

        int ans = right;
        while(left<=right){
            int mid = (left+right)/2; //절반! 
            int sum = 0;
            for(int i= 0; i < M; i++){
                if(arr[i]%mid == 0){
                    sum += arr[i]/mid;
                }else{
                    sum += arr[i]/mid + 1;
                }
            }

            if(sum <= N){
                //가능한 case 
                ans = Math.min(mid, ans);
                right = mid-1;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(ans);
        return;

    }

}
