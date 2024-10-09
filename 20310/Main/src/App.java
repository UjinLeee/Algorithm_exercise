import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //string array로 입력받기
        String[] str = br.readLine().split("");
        int[] arr = new int[str.length];
        //int count0, int count1 입력받기
        int count0 = 0;
        int count1 = 0;

        for(int i = 0; i < str.length; i++){
            int tmpNumber = Integer.parseInt(str[i]);
            if(tmpNumber == 1)
                count1++;
            else
                count0 ++; 
            arr[i] = tmpNumber;
        }

        count0 /= 2;
        count1 /= 2;
        //반으로 나누기
        //stringbuilder에 넣기
        StringBuilder sb = new StringBuilder();
        boolean[] chk = new boolean[str.length];    
        Arrays.fill(chk, true);

        int i = 0; //i는 1이면 없애기
        int j = str.length-1; //j는 0이면 없애기

        while(count0 >= 0 || count1 >= 0){

            if(i >= str.length || j < 0)
                break;
                
            if(arr[i] == 1 && count1>0){
                chk[i] = false;
                count1--;
            }

            if(arr[j]==0 && count0>0){
                chk[j] = false;
                count0--;
            }
            i++;
            j--;
        }

        for(int k = 0; k < str.length; k++){
            if(chk[k] == true)
                sb.append(arr[k]);
        }



        System.out.println(sb);
    }
}
