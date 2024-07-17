import java.io.*;
import java.util.*;

class Pair{
    int M;
    int V;

    public Pair(int M, int V){
        this.M = M; //M:무게
        this.V = V; //V: 가격
    }
}

class PairComparator implements Comparator<Pair>{
    public int compare(Pair o1, Pair o2){ //M이 무게, 무게에 대한 오름차순 
        if(o1.M == o2.M){
            return -(o1.V-o2.V);
        }else
            return o1.M-o2.M;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]); //N; 보석 개수 
        int K = Integer.parseInt(str[1]); //가방 개수
        PriorityQueue<Pair> pq_pair = new PriorityQueue<>(1, new PairComparator());
        PriorityQueue<Integer> pq_bag = new PriorityQueue<>(); //무게가 낮은 순서대로 


        for(int i = 0; i < N; i++){
            str = br.readLine().split(" ");
            int tmp_M = Integer.parseInt(str[0]);
            int tmp_N = Integer.parseInt(str[1]);
            pq_pair.add(new Pair(tmp_M, tmp_N));
        }

        for(int i = 0; i < K; i++){
            int tmp_bag = Integer.parseInt(br.readLine());
            pq_bag.add(tmp_bag);
        }

        long ans = 0;

        PriorityQueue<Pair> pair_list = new PriorityQueue<>(1, new Comparator<Pair>(){
            public int compare(Pair o1, Pair o2){ //무게 내림차순 
                if(o1.V==o2.V){
                    return o1.M-o2.M;
                }
                return -(o1.V-o2.V);
            }
        });

        while(!pq_bag.isEmpty()){
            int tmp_bag = pq_bag.poll();
            while(!pq_pair.isEmpty()){
                Pair tmp_pair = pq_pair.peek();
                if(tmp_pair.M <= tmp_bag){
                    pair_list.add(pq_pair.poll());
                }else{
                    break;
                }
            }
            if(!pair_list.isEmpty())
                ans += pair_list.poll().V;
        }

        System.out.println(ans);

    }
}

