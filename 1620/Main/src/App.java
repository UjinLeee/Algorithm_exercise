import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        HashMap<Integer, String> map1 = new HashMap<>(); //key가 Integer
        HashMap<String, Integer> map2 = new HashMap<>();

        for(int i = 1; i < N+1; i++){
            String tmp = br.readLine();
            map1.put(i, tmp);
            map2.put(tmp, i);
        }

        StringBuilder sb = new StringBuilder();

        for(int j = 0; j < M; j++){
            String tmp = br.readLine();
            char c = tmp.toCharArray()[0];
            if(Character.isDigit(c)){
                //숫자면
                int a = Integer.parseInt(tmp);
                sb.append(map1.get(a));
            }else{
                sb.append(map2.get(tmp));
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
