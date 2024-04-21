import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] num_arr = new int[26];
        Arrays.fill(num_arr, 0);
        
        int n = Integer.parseInt(br.readLine()); //몇 글자가 나올지!!
       
        for(int i = 0; i < n; i++){ //n번 반복하면서 첫글자만 ++하기
            //97~122번
            //첫글자만 
            char a = br.readLine().charAt(0);
            int b = (int)a - 97;
            num_arr[b]++;
        }
        
        String str = "";
        for(int i = 0; i < 26; i++){
            if(num_arr[i] >= 5){
               // chk++;
                //출력하기
                str += Character.toString((char)(i+97));
            }
        }
        if(str.equals("")){
            //PREDAJA 출력하기
            bw.write("PREDAJA");
        }else{
            bw.write(str);
        }
        bw.flush();
        bw.close();
        br.close();
        
        return;
    }
}