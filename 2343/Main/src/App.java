import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException { // 순열 돌리기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        
        int N = Integer.parseInt(str[0]); // 강의의 수
        int M = Integer.parseInt(str[1]); //블루레이의 수

        int[] arr = new int[N];
        str = br.readLine().split(" ");

        int sum = 0; //강의 수의 총합 
        int max = 0;

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(str[i]);
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }

        int left = max;
        int right = N*max;
        int min = right;
        
        int mid;
        int cnt;
        int tmp_sum;

        while(left<=right){

            mid = (left+right)/2; //mid: 체크할 것 
            // System.out.println(mid);
            cnt = 0;
            tmp_sum = 0;
            //개수를 구해야한다 
            for(int j = 0; j < N; j++){
                tmp_sum += arr[j];
                if(tmp_sum == mid){
                    //mid랑 같으면
                    tmp_sum = 0;
                    cnt++;
                }
                if(tmp_sum > mid){
                    tmp_sum = arr[j];
                    cnt++;
                }
            }
            if(tmp_sum > 0)
                cnt++;

            if(cnt <= M){ //M과 같다면 case이다  
                min = Math.min(min, mid); 
                right = mid-1; //더 작은걸 찾기 위해서 
                // System.out.println(min);
            }
            if(cnt > M){ //너무 잘게 쪼갬 
                left = mid+1;
            }
        }
        
        System.out.println(min);
  
    }

}
