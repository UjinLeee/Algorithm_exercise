import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//그냥 two pointer로 하기 
		//int N 담기
		int N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		
		//int array 담기, array는 N+1칸으로 남기고 마지막 칸은 N번째와 같게 하기 
		int[] arr = new int[N+1];
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(str[i]);
		arr[N] = arr[N-1];
		
		//long count = 0;
		long count = 0;
			
		//이중 for문 돌면서, 같은게 나올때까지 찾기
		//하나라도 같은게 나오면, j=3이면, j-i를 더한다 (count에)
		//그리고 i++한다. 

		boolean[] chk = new boolean[100001];
		int i = 0;
        int j = 0;
        chk[arr[i]]=true;

        while(i <= N && j <= N){
            if(chk[arr[j]]==true){
                if(i==j)
                    j++;
                else{
                    count += j-i;
                    chk[arr[i]]=false;
                    i++;
                }
            }else{
                chk[arr[j]] = true;
                j++;
            }
        }
		System.out.println(count);
    }
}
