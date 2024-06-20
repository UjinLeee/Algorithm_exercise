import java.util.*;
import java.io.*;

public class App {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int K = Integer.parseInt(br.readLine());
        
        int start = 1;
        int end = M;
        
        int cnt = 0;

        for(int i = 0; i < K; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp>=start && tmp<=end){
                continue;
            }
            if(tmp < start){
                cnt += start - tmp;
                start = tmp;
                end = start + M -1;
                continue;
            }
            if(tmp > end){
                cnt += tmp - end;
                end = tmp;
                start = end - M +1;
                continue;
            }
        }
        System.out.println(cnt);
    }
}
