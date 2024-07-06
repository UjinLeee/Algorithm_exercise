import java.io.*;
import java.util.*;

public class App {

    static int min = Integer.MAX_VALUE;
    static int K;
    static int num = 0;
    static int[] DP;

    public static class Point{
        int idx;
        int len;
        public Point(int idx, int len){
            this.idx = idx;
            this.len = len;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]); // 수빈이 위치 
        K = Integer.parseInt(str[1]); //동생

        if(N==K){
            System.out.println(0);
            System.out.println(1);
            return;
        }
    
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(N, 0));

        while(!queue.isEmpty()){
            Point tmp = queue.poll();
            
            if(tmp.idx < 0 || tmp.idx > 100000){
                continue;
            }
            if(tmp.idx == K){
                if(min > tmp.len){
                    min = tmp.len;
                    num = 1;
                    continue;
                }
                if(min == tmp.len){
                    num ++;
                    continue;
                }
                else{
                    continue;
                }
            }
            queue.add(new Point(tmp.idx+1, tmp.len+1));
            queue.add(new Point(tmp.idx-1, tmp.len+1));
            queue.add(new Point(tmp.idx*2, tmp.len+1));
        }

        System.out.println(min);
        System.out.println(num);

    }

}
