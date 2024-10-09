import java.util.*;
import java.io.*;

class Tower {
    int idx;
    int height;

    Tower(int idx, int height){
        this.idx = idx;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Tower [idx=" + idx + ", height=" + height + "]";
    }
    
}


public class App {

    static int curHeight;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //N 입력받기
        int N = Integer.parseInt(br.readLine());
        //string에 입력받기
        String[] str = br.readLine().split(" ");

        //StringBuilder 선언하기
        StringBuilder sb = new StringBuilder();
        //PriorityQueue 선언하서
        PriorityQueue<Tower> pq = new PriorityQueue<>(1, new Comparator<Tower>(){ 
            //양수일때 바뀐다
            public int compare(Tower t1, Tower t2){
                /* 
                if(t1.height <= curHeight && t2.height > curHeight)
                    return 1;
                else if(t1.height > curHeight && t2.height <=curHeight)
                    return -1;
                else if(t1.height <= curHeight && t2.height <= curHeight){
                    return -1;
                }else{
                    return -(t1.idx - t2.idx);
                }*/

                if(t1.height > curHeight && t2.height > curHeight){
               //     System.out.println(t1.toString());
                    return -(t1.idx-t2.idx);
                }else if(t1.height <= curHeight && t2.height > curHeight){
                    System.out.println("---"+ t1.toString());
                    return 1;
                }else{
                    return -1;
                }
            }
        });

        //0 sb에 넣기
        sb.append("0 ");
        
        //for문 돌면서
        for(int i = 1; i < N; i++){


            curHeight = Integer.parseInt(str[i]);
            
            //pq에다가 Tower(i, arr[i-1]) 넣기
            pq.add(new Tower(i,Integer.parseInt(str[i-1])));
            //pq 맨 첫번째꺼 뽑기 
            Tower tmpTower = pq.peek(); //첫번째꺼 
     //       System.out.println(tmpTower.toString());
            //pq idx가 i+1보다 작고 , arr[i]보다 높으면 sb에 넣기
            if(tmpTower.height > curHeight){
                sb.append(tmpTower.idx);
                sb.append(" ");
            }else{
                sb.append("0 ");
            }
            //아니면 0 넣기
        }
        //0 0 0 0 0 0 0 0 0 0 0 9 9 9 9 15 15 15 18 0 0 0 0 0 0 0 0 0 0 0 
        System.out.println(sb);
    }
}