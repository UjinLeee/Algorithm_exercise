import java.io.*;
import java.util.*;

public class App {
    static ArrayList<Long> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            char[] arr = br.readLine().toCharArray();
            dfs(arr, 0, "");
        }
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    public static void dfs(char[] arr, int idx, String tmp){
        if(idx >= arr.length){
            if(!tmp.equals(""))
                list.add(Long.valueOf(tmp));
            return;
        }
        if(Character.isLetter(arr[idx])){
            //문자면 그냥 넘어가야 한다 
            if(tmp.equals("")){
                dfs(arr, idx+1, "");
            }else{
                list.add(Long.valueOf(tmp));
                dfs(arr, idx+1, "");
            }
        }else{
            //숫자면 
            tmp += arr[idx];
            dfs(arr, idx+1, tmp);
        }
    }
}
