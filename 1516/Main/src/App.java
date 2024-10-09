import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class App {
    public static void main(String[] args) throws Exception {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N 입력받기 : 건물의 종류 . 
        int N = Integer.parseInt(br.readLine()); //N = 5
    
        //초기값과 인접 list 받기 
        int[] value = new int[N+1]; //N=1부터 시작하니까!
        ArrayList<Integer>[] nextNodes = new ArrayList[N+1];

        for(int i = 1; i <= N; i++){
            nextNodes[i] = new ArrayList<>();
        }

        int[] sum = new int[N+1];

        //초기화하기
        for(int i = 1; i <= N; i++){
            String[] str = br.readLine().split(" ");
            int curValue = Integer.parseInt(str[0]);
            value[i] = curValue;
            sum[i] = curValue;
            for(int j = 1; j < str.length; j++){
                int prev = Integer.parseInt(str[j]);
                if(prev == -1)
                    break;
                nextNodes[prev].add(i);
            }
        }

        //sum 입력받기 
        for(int i = 1; i <= N; i++){
            for(int tmp : nextNodes[i]){
                //2니까 
                sum[tmp] = Math.max(sum[tmp], sum[i]+value[tmp]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            sb.append(sum[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
