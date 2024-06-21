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
        
        
        ArrayList<Number> list = new ArrayList();
        HashSet<Integer> map = new HashSet(); //num이 있는지를 확인하고자 하는 자료구조
         
        str = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            boolean toggle = false;
            int tmp = Integer.parseInt(str[i]);

            if(i == 0){
                list.add(new Number(tmp,1,i));
                continue;
            }
            
            for(int j = 0; j < list.size(); j++){
                if(list.get(j).num == tmp){
                    //있으면 
                    list.get(j).cnt ++;
                    toggle = true;
                    break;
                }
            }
            if(toggle == false){
                list.add(new Number(tmp,1,i));
            }
        }

        Collections.sort(list, new NumberComparator());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            int n = list.get(i).cnt;
            int num = list.get(i).num;
            for(int j = 0; j < n; j++){
                sb.append(num);
                sb.append(" ");
            }
        }

        System.out.println(sb);
    }
}
