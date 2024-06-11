import java.io.*;
import java.util.*;

public class App {
    static char[] arr;
    static int idx = 0;
    static int len;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray(); //arr
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '*'){
                idx = i;
                break;
            }
        }
        len = arr.length - idx-1;
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            char[] tmp_arr = br.readLine().toCharArray(); //a,b,c,d
            if(tmp_arr.length < idx+len){
                sb.append("NE");
                sb.append("\n");
                continue; 
            }
            if(chk_first(tmp_arr) && chk_second(tmp_arr)){
                sb.append("DA");
                sb.append("\n");
            }else{
                sb.append("NE");
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }

    static boolean chk_first(char[] tmp_arr){
        boolean chk = true;
        for(int i = 0; i < idx; i++){
            if(tmp_arr[i] != arr[i]){
                chk = false;
                break;
            }
        }
        return chk;
    }

    static boolean chk_second(char[] tmp_arr){
        boolean chk = true;
        for(int i = len; i > 0; i--){
            if(tmp_arr[tmp_arr.length - i] != arr[arr.length-i]){
                chk = false;
                break;
            }
        }
        return chk;
    }
}
