import java.util.*;
import java.io.*;

public class App {

  //  static char[] arr;
    static boolean chk;
    static HashSet<Character> set = new HashSet<>();
    public static void main(String[] args) throws Exception {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String str = br.readLine();
            if(str.equals("end"))
                break;
            else{
                char[] arr = str.toCharArray();
                dfs(arr, 0, false, 0, 0);
                if(chk == true){
                    sb.append('<');
                    sb.append(str);
                    sb.append("> is acceptable.\n");
                }else{
                    sb.append('<');
                    sb.append(str);
                    sb.append("> is not acceptable.\n");
                }
            }
        }
        System.out.println(sb);

    }

    public static void dfs(char[] arr, int idx, boolean isVow, int cntVow, int cntCol){
        //다 했다면 
        if(idx >= arr.length){
            if(isVow == false || cntVow == 3 || cntCol == 3)
                chk = false;
            else
                chk = true;
            return;
        }

        char tmp = arr[idx]; 
        //연속인지 확인하기 
        if(idx>=1){
            if(arr[idx-1] == tmp){
                if(tmp != 'e' && tmp!= 'o'){
                    chk = false;
                    return;
                }
            }
        }
        
        if(set.contains(tmp)){
            //모음인경우    
            if(cntVow + 1 >= 3){
                chk = false;
                return;
            }else{
                dfs(arr, idx+1, true, cntVow+1, 0);
            }
        }else{
            //자음인경우
            if(cntCol+1 >= 3){
                chk = false;
                return;
            }else{
                dfs(arr, idx+1, isVow, 0, cntCol+1);
            }
        }
    }

}