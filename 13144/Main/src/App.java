import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] str = br.readLine().split(" ");
        
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(str[i]);
        
        int count = 0;
        int start = 0;
        int end = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < N; i++){
            if(set.contains(arr[i])){
                for(int j = start; j < i; j++){
                    count += i-j;
                    start++;
                    if(arr[i] == arr[j])
                        break;
                    set.remove(arr[j]);
                }
            }else{
                set.add(arr[i]);
            }
        }

        for(int i = start; i < N; i++)
            count += N-i;


        System.out.println(count);
        
    }
}
