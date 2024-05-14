import java.io.*;
import java.util.*;

public class solution1 {
    static int N;
    static int mp; //초기화 할 것들 
    static int mf; 
    static int ms;
    static int mv;

    static int[][] map; //표 
    static int min_price;
    static boolean[] visited;
    static String result_string;
    public static void main(String[] args) throws IOException { //순열 돌리기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][5];
        visited = new boolean[N];
        min_price = Integer.MAX_VALUE;
        String[] str = br.readLine().split(" ");
        mp = Integer.parseInt(str[0]);
        mf = Integer.parseInt(str[1]);
        ms = Integer.parseInt(str[2]);
        mv = Integer.parseInt(str[3]);

        for(int i = 0; i < N; i++){
            str = br.readLine().split(" ");
            for(int j = 0; j < 5; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        for(int i = 0; i < N; i++){
            boolean[] tmp_visited = new boolean[N];
            Arrays.fill(tmp_visited,false);
            
            dfs(0, 0, 0, 0, 0, i, tmp_visited, "");
            
        }

        if(min_price == Integer.MAX_VALUE)
            System.out.println("-1");
        else{
            System.out.println(min_price);
            // for(int i = 0; i < N; i++){
            //     if(visited[i]){
            //         System.out.print(i+1);
            //         System.out.print(" ");
            //     }
            // }
            System.out.println(result_string);
        }

    }

    public static void dfs(int p, int f, int s, int v, int price, int idx, boolean[] tmp_visited, String tmp_str){
        //1. 더하기
        p += map[idx][0];
        f += map[idx][1];
        s += map[idx][2];
        v += map[idx][3];
        price += map[idx][4];
        tmp_visited[idx] = true; //idx를 방문했다는것! 
        if(tmp_str.equals(""))
            tmp_str+=idx+1;
        else{
            tmp_str += " ";
            tmp_str += idx+1;
        }
            
        //2. 가능할때
        if(isPossible(p, f, s, v)){

            if(price>min_price){ //min_price보다 큰 경우는 끝내기 
                return; //끝내기 
            }

            if(price == min_price){ //사전순 출력하기 
                if(chk(tmp_visited)){
                    //true ->바꿔치기 해야한다.
                    // min_start = start;
                    for(int i = 0; i < N; i++){
                        visited[i] = tmp_visited[i];
                    }
                    result_string = tmp_str;
                    return; 
                }else{
                    return;
                }
            }

            if(price < min_price){

                Arrays.fill(visited,false);
                min_price = price;
                for(int i = 0; i < N; i++){
                    visited[i] = tmp_visited[i];
                }
                result_string = tmp_str;

                return;
            }
        }

        //3. 불가능할 때 
        else{
            //idx가 N이면 걍 끝내기
            if(idx == N-1)
                return;
            else{//idx가 N보다 작으면 dfs다시 돌리기 
                for(int i = idx+1; i<N; i++){
                    dfs(p, f,s,v,price,i,tmp_visited,tmp_str);
                }
            }
        }

    }

    public static boolean chk(boolean[] tmp_visited){
        for(int i = 0; i < N; i++){
            if(tmp_visited[i] == visited[i])
                continue;
            if(tmp_visited[i] == true && visited[i] == false)
                return true;
            if(tmp_visited[i] == false && visited[i] == true)
                return false;
        }
        return false;//true:tmp_visited로 바꿔치기 해야한다.
    }
    public static boolean isPossible(int p, int f, int s, int v){
        if(p >= mp && f >=mf && s >=ms && v>= mv)
            return true;
        else
            return false;
    }

}
