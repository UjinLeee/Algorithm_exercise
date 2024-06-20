import java.util.*;
import java.io.*;

public class App {

    static class Number{
        int num;
        int cnt;
        int prev;

        public Number(int num, int cnt, int prev){
            this.num = num;
            this.cnt = cnt;
            this.prev = prev;
        }
    }

    static class NumberComparator implements Comparator<Number>{
        public int compare(Number o1, Number o2){
            if(o1.cnt == o2.cnt)
                return o1.prev - o2.prev;
            else    
                return -(o1.cnt - o2.cnt);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);

        PriorityQueue<Number> pq = new PriorityQueue<>(1, new NumberComparator());
        HashSet<Integer> map = new HashSet(); //num이 있는지를 확인하고자 하는 자료구조
        
        str = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            int tmp = Integer.parseInt(str[i]);
            if(map.contains(tmp)){
                

            }else{ 
                //tmp를 포함하지 않으면
                map.add(tmp);
                pq.add(new Number(tmp, 1, i)); //i는 index
            }
        }
    }
}
