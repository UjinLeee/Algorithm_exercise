import java.io.*;
import java.util.*;

public class App {
    static int N;
    static int[][] quest;
    static int[][] dp;
    static boolean visited[];
    public static void main(String[] args) throws IOException { // 순열 돌리기
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      quest = new int[100][3];
      dp = new int[1001][1001];
      visited = new boolean[100];
      for(int i = 0; i < N; i++){
        String[] str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);
        quest[i][0] = a;
        quest[i][1] = b;
        quest[i][2] = c;
      //  Arrays.fill(dp[i], -1);
      }
     // for(int a[]:dp)
     //   Arrays.fill(a,-1);
      System.out.println(cal(1,1));
      
    }

    static int cal(int a, int b){
      //힘이 a, 지력이 b
      if(dp[a][b] != 0) //이미 계산했던 값이면 
        return dp[a][b];
      
        int point = 0;
        dp[a][b] = 0;
        ArrayList<Integer> check = new ArrayList<>();
        for(int i = 0; i < N; i++){
          if(quest[i][0] <= a || quest[i][1] <= b){
            dp[a][b] += 1; //개수 더하기
            if(visited[i]) continue; //이전에 방문했던 퀘스트면 pass
            point += quest[i][2];
            visited[i] = true;
            check.add(i);
          }
        }

        for(int i = 0; i <= point; i++){
          dp[a][b] = Math.max(dp[a][b], cal(Math.min(100,a+i), Math.min(1000, b+(point-i))));
        }

        for(int i = 0; i < check.size(); i++){
          visited[check.get(i)] = false; //다시 원상 복귀
        }

        return dp[a][b];
    }

}
