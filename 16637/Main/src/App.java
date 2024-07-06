import java.io.*;
import java.util.*;

public class App {
    static int max = Integer.MIN_VALUE;
    static char[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();
        if(N==1){
            System.out.println(arr[0]);
            return;
        }

        search(1, arr[0]-'0');
        
        System.out.println(max);

    }

    public static void search(int idx, int sum){
        //isPair는 괄호 안에 있는지 없는지를 확인하는 배열
        if(idx >= arr.length){
            //이제 계산해야 한다.
            max = Math.max(max, sum);
            return;
        }

        //Case 1: 괄호 없는 것. 
        int tmp_result = Calculate(idx, sum, arr[idx+1]-'0');
        search(idx+2, tmp_result);

        //Case 2: 괄호 있는 것
        if(idx+2 < arr.length){
            tmp_result = Calculate(idx+2, arr[idx+1]-'0', arr[idx+3]-'0');
            int tmp_result_2 = Calculate(idx, sum, tmp_result);
            search(idx+4, tmp_result_2);
        }
    }

    public static int Calculate(int idx, int num1, int num2){
        //idx: num1이 있는 곳
        int result = 0;
        switch(arr[idx]){
            case '+':
                result = num1 + num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '-':
                result = num1 - num2;
                break;
        }
        return result;
    }

    


}
