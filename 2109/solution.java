import java.io.*;
import java.util.*;

class Pair{
    int p;
    int d;
    
    public Pair(int p, int d){
        this.p = p; //p:pay
        this.d = d; //d: day
    }
}

class PairComparator implements Comparator<Pair>{
    public int compare(Pair o1, Pair o2){
        if(o1.p == o2.p)
            return o2.d - o1.d;
        else
            return o2.p - o1.p;
    }
}

public class solution {
  
    public static void main(String[] args) throws IOException { //순열 돌리기
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Pair> pq = new PriorityQueue<>(1, new PairComparator());

        int max = 0;

        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split(" ");
            int p = Integer.parseInt(str[0]);
            int d = Integer.parseInt(str[1]);
            pq.offer(new Pair(p,d));
            max = Math.max(max, d);
        }

        boolean[] check = new boolean[max+1]; //날짜 
        int min = 0; 
      
        while(!pq.isEmpty()){
            Pair tmp_pair = pq.poll();
            for(int i = tmp_pair.d; i > 0; i--){
                if(!check[i]){
                    check[i] = true;
                    min += tmp_pair.p;
                    break;
                }
            }
        }

        System.out.println(min);

    }


}
