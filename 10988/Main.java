import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //br.readLine()
        char[] arr = (br.readLine()).toCharArray();
        int len = arr.length; //length: 길이 
        
        int chk = 1;
        for(int i = 0; i < len; i++){
            if(arr[i]!=arr[len-i-1]){
                chk = 0;
                break;
            }else{
                continue;
            }
        }
        System.out.println(chk);
        return;
    }
}