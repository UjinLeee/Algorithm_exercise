import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        //list에 N이하의 소수들을 다 넣는다. 
        for(int i = 2; i<= N; i++){
            if(isPrime(i) == 1){
                list.add(i);
            }
        }

        int count = 0;
        int start = 0;
        int end = 0;
        int interval_sum = 0;

        while(start < list.size() && end < list.size()){
            if(start == end){
                interval_sum = list.get(start);
            }
            if(interval_sum < N ){
                //end를 증가시킨다.
                end ++;
                if(end >= list.size())
                    break;

                interval_sum += list.get(end);
                continue;
            }
            if(interval_sum >=N){
                if(interval_sum == N){
                    count++;
                }
                if(start+1 >= list.size())
                    break;
                interval_sum -= list.get(start);
                start ++;
                continue;
            }
        }
        System.out.println(count);
    }

    public static int isPrime(int n){
        //소수면 1, 소수가 아니면 0을 return 
        for(int i = 2; i <= (int)Math.sqrt(n); i++){
            if(n%i==0)
                return 0;
        }
        return 1;
    }
}
