import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            HashMap<String, Integer> hashmap = new HashMap<>();
            for(int j = 0; j < N; j++){
                String[] str = br.readLine().split(" ");
                if(hashmap.containsKey(str[1])){
                    hashmap.replace(str[1], hashmap.get(str[1])+1);
                }else{
                    hashmap.put(str[1], 1);
                }
            }
            int result = 1;
            for(String key : hashmap.keySet()){
                int n = hashmap.get(key);
                result *= (n+1);
            }
            result -= 1;
            sb.append(result);
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
