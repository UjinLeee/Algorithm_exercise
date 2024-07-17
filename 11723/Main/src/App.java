import java.io.*;
import java.util.*;

public class App {
    public static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split(" ");

            String command = str[0];
            
            if(command.equals("add")){
                int num = Integer.parseInt(str[1]);
                set.add(num);
                continue;
            }
            if(command.equals("remove")){
                int num = Integer.parseInt(str[1]);
                if(set.contains(num)){
                    set.remove(num);
                }
                continue;
            }
            if(command.equals("check")){
                int num = Integer.parseInt(str[1]);
                if(set.contains(num)){
                    sb.append("1" + "\n");
                }else{
                    sb.append("0" + "\n");
                }
                continue;
            }
            if(command.equals("toggle")){
                int num = Integer.parseInt(str[1]);
                if(set.contains(num)){
                    set.remove(num);
                }else{
                    set.add(num);
                }
                continue;
            }
            if(command.equals("all")){
                set.clear();
                for(int j = 1; j <= 20; j++)
                    set.add(j);
                continue;
            }
            if(command.equals("empty")){
                set.clear();
                continue;
            }
                
        }
        System.out.println(sb);
    }


}
