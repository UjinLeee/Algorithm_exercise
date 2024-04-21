import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //아스키코드 97~122  26글자
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] num_arr = new int[26];
        Arrays.fill(num_arr,0); //0으로 초기화 해준다
        
        char arr[] = (br.readLine()).toCharArray(); //char로 받음
        
        for(int i = 0; i < arr.length; i++){
            byte num = (byte)arr[i];
            int a = num & 0xff;
            num_arr[a - 97]++;
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < 26; i++){
            bw.write(num_arr[i]+" ");
            bw.flush();
        }
        
        bw.close();
       // return;
    }
}
