import java.io.*;
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = new int[N];
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(str[i]);
            set.add(Integer.parseInt(str[i]));
        }
        int x = Integer.parseInt(br.readLine()); // 13
      //  Arrays.sort(arr); //오름차순 정렬
        int count = 0;

        for(int i = 0; i < arr.length; i++){
            if(set.isEmpty())
                break;
            int tmp = arr[i];
            
            if(set.contains(x-tmp) && (tmp != x - tmp)){
                if(x != x-tmp){
                    count++;
                    set.remove(x-tmp);
                }
            }
            set.remove(tmp);
            
        }
        
        System.out.println(count);
    }

}
