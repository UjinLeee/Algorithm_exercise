import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int num_A = Integer.parseInt(str[0]);
        int num_B = Integer.parseInt(str[1]);

        int[] A = new int[num_A];
        str = br.readLine().split(" ");
        for(int i = 0; i < num_A; i++){
            A[i] = Integer.parseInt(str[i]);
        }

        int[] B = new int[num_B];
        str = br.readLine().split(" ");
        for(int i = 0; i < num_B; i++){
            B[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(B);
        int cnt = 0;

        for(int i = 0; i < num_A; i++){
            int chk = A[i];
            int left = 0;
            int right = num_B-1;
            while(left<=right){
                int mid = (left+right)/2;
                if(B[mid] == chk){
                    cnt++;
                    break;
                }
                if(B[mid] < chk){
                    left = mid+1;
                }
                if(B[mid] > chk){
                    right = mid - 1;
                }
            }
        }

        int ans = num_A - cnt + num_B - cnt;
        System.out.println(ans);

    }
}