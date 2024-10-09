//package DAY08.P11438;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class App {

    static int N;
    static int LOG = 17;
    static int[] depth;
    static ArrayList<Integer>[] adJust;
    static boolean[] visited;
    static int[][] parent;
	public static void main(String[] args) throws IOException {
	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		///먼저 N을 입력받기
        N = Integer.parseInt(br.readLine());
        //이때, 최대 depth인 LOG = 17 (10만 까지니까)
        depth = new int[N+1]; //실제 node의 depth를 입력받는 ! 

        //이때, 인접한 것은 arraylist로 입력받는다
        adJust = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            adJust[i] = new ArrayList<>();
        }

        String[] str;
        visited = new boolean[N+1];
        parent = new int[LOG+1][N+1];

        for(int i = 1; i < N; i++){
            str = br.readLine().split(" ");
            int first = Integer.parseInt(str[0]);
            int second = Integer.parseInt(str[1]);
            adJust[first].add(second);
            adJust[second].add(first);
        }

        //bfs로, 일단 바로 직전, parent[0][어쩌구] 입력받기 (1부터 시작하기)
        bfs(1);
        //그다음에, 조상들 찾기 (점화식으로)

        findAncestors();

        //그다음에 lca하기
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++){
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            sb.append(lca(a, b));
            sb.append("\n");
        }

        System.out.println(sb);
	}

    public static void findAncestors(){
        for(int k = 1; k <= LOG; k++){
            for(int v = 1; v <= N; v++){
                parent[k][v] = parent[k-1][parent[k-1][v]];
            }
        }
    }

    public static void bfs(int root){
        //root은 0이다
        depth[root] = 0;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            visited[tmp] = true;
            for(int chk : adJust[tmp]){
                if(visited[chk]==false){
                    depth[chk] = depth[tmp]+1;
                    queue.add(chk);
                    parent[0][chk] = tmp;
                }
            }
        }
    }

    public static int lca(int a, int b){

        //기저 사례 => a와 b가 같으면 . 걍return해버리기

        if(a==b)
            return a;
        //일단, depth가 깊은걸 무조건 b로 할거라서, depth가 a가 더 크면, swap해주기

        if(depth[a] > depth[b]){
            int tmp = a;
            a = b;
            b = tmp;
        }


        //k = LOG 부터 0까지(2^0승), depth[b]-depth[a] >= (1<<k)이면, 
        //그만큼 빼줘야하므로, b = parent[k][b];

        for(int k =LOG; k>=0; k--){
            if(depth[b]-depth[a] >= (1<<k)){
                b = parent[k][b];
            }
        }
        
        if(a == b)
            return a;

        //이때 a와 b의 깊이는 같다
        //같이 올라간다 (찾을때까지) (이 부분을 이해를 못하겠다 ㅠㅠ )

        for(int k = LOG; k >= 0; k--){
            if(parent[k][a] != parent[k][b]){
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        return parent[0][a];
    }

}
