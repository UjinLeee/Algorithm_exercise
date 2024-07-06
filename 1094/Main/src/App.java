import java.io.*;
import java.util.*;

public class App {

    static int X;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());

        if(X==64){
            System.out.println(1);
            return;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(64);
        int sum = 64;
        int ans = 0;
        while(true){
            int min = pq.poll(); //작은거
            int a1 = min / 2; // 절반으로 자른거
            if(sum - a1 > X){
                pq.add(a1);
                sum -= a1;
                continue;
            }
            if(sum - a1 < X){
                pq.add(a1);
                pq.add(a1);
                continue;
            }
            if(sum - a1 == X){
                ans = pq.size()+1;
                break;
            }
        }

        System.out.println(ans);
        return;
        
    }
}
