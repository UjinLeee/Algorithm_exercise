import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < arr.length; i++){
            int tmp = (int)arr[i];
            //대문자: 65~90
            if(tmp>=65 && tmp <= 90){
                tmp = (tmp-65+13)%26 + 65;
                sb.append((char)tmp);
                continue;
            }else if(tmp>=97 && tmp<=122){
                tmp = (tmp-97+13)%26 + 97;
                sb.append((char)tmp);
                continue;
            }else{
                sb.append(arr[i]);
                continue;
            }
        }

        System.out.println(sb.toString());
    }
}
