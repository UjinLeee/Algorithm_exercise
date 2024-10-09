import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Node{
    int start;
    int to;
    int time;
    public Node(int start, int to, int time) {
        this.start = start;
        this.to = to;
        this.time = time;
    }
    
    
}
public class App {

    static long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        //N(도시의 개수), M (버스 노선의 개수)를 입력받는다 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        //ArrayList<Integer> edges[]를 선언한다
        ArrayList<Node> edges = new ArrayList<>(); //1부터 시작하므로

        //M줄 동안, edge를 입력받는다
        for(int i = 0; i < M; i++){
            str = br.readLine().split(" ");
            int A = Integer.parseInt(str[0]); //start city
            int B = Integer.parseInt(str[1]); //end city
            int T = Integer.parseInt(str[2]); //time
            edges.add(new Node(A, B, T));
        }

        //long arr 각각을 INF로 초기화한다. 이때, INF = Long.MAX_VALUE로 한다
        long[] arr = new long[N+1];

        for(int i = 1; i <= N; i++)
            arr[i] = INF;

        arr[0] = 0;
        arr[1] = 0;
        //N-1번동안, 초기화를 진행한다
        for(int i = 0; i < N-1; i++){
            for(Node curEdge:edges){
                int prev = curEdge.start;
                int next = curEdge.to;
                int cost = curEdge.time;
                if(arr[prev] != INF){
                    arr[next] = Math.min(arr[next], arr[prev]+cost);
                }
            }
        }

        boolean isCycle = false;
        for(Node curEdge:edges){
            int prev = curEdge.start;
            int next = curEdge.to;
            int cost = curEdge.time; 
            if(arr[prev] != INF){
                if(arr[next] > arr[prev]+cost){
                    isCycle = true;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if(isCycle == true){
            sb.append(-1);
        }else{
            for(int i = 2; i <= N; i++){
                if(arr[i] == INF)
                    sb.append("-1");
                else
                    sb.append(arr[i]);
                sb.append("\n");
            }
        }

        System.out.print(sb);

        //한번더 초기화 진행 후, Cycle이 발생하는지 확인한다.
    }
}
