import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //9명의 난쟁이, 합은 100이 된다.  9개의 줄에 걸쳐 난쟁이들의 키가 주어진다.
        //정답이 여러가지인 경우에는 아무거나 출력한다.
        int[] arr = new int[9];
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;//9명 키의 합

        for(int i = 0; i < 9; i++){
            arr[i] = Integer.parseInt(buffer.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr); //정렬

        int remain = sum - 100;  //Ex. 130 - 100 = 30
        int chk_i = -1;
        int chk_j = -1;
        for(int i = 0; i < 9; i++){
            int find = remain - arr[i]; //30-20
            for(int j = i+1; j < 9; j++){
                if(arr[j] == find){
                    chk_i = i;
                    chk_j = j;
                    break;
                }
            }
            if(chk_i != -1)
                break;
        }

        arr[chk_i] = -1;
        arr[chk_j] = -1;

        for(int i = 0; i < 9; i++){
            if(arr[i] != -1){
                System.out.println(arr[i]);
            }
        }
        buffer.close();
        return;
    }
}