//package DAY09.P5719;
//1차코드 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Node implements Comparable<Node>{
	int from;
	int to;
	int cost;
	

	public Node(int from, int to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}


	@Override
	public int compareTo(Node o1) {
		// TODO Auto-generated method stub
		return cost - o1.cost;
	}


	@Override
	public String toString() {
		return "Node [from=" + from + ", to=" + to + ", cost=" + cost + "]";
	}
	
}
public class App{
	
//	static ArrayList<Integer>[] edges;
	static int[][] map;
	static int S, D, N, M;
	static Node[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//N (장소의 수), M (도로의 수)를 입력받는다. 
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]); //장소의 수 
		M = Integer.parseInt(str[1]); //도로의 수
		
		//S (시작점), D (도착점)을 입력받는다. 
		str = br.readLine().split(" ");
		S = Integer.parseInt(str[0]);
		D = Integer.parseInt(str[1]);
		
		//ArrayList배열에, edge를 초기화시킨다.  map으로 한다
//		edges = new ArrayList[N];
		map = new int[N][N];
		//M개가 있을 것이다.
		for(int i = 0; i < M; i++) {
			str = br.readLine().split(" ");
			int u = Integer.parseInt(str[0]);
			int v = Integer.parseInt(str[1]);
			int p = Integer.parseInt(str[2]);
			map[u][v] = p;
			map[v][u] = p;
		}
		//먼저 다익스트라로 최단거리를 뽑는다. 그리고 이때의 min값을 담는다
		arr = new Node[N];
	//	Arrays.fill(arr, Integer.MAX_VALUE);
		for(int i = 0; i < N; i++)
			arr[i] = new Node(i, i, Integer.MAX_VALUE);
		visited = new boolean[N];
		int OriginMin = dijkstra(S);
		delete();
		System.out.println(OriginMin);
		while(true) {
			arr = new Node[N];
			for(int i = 0; i < N; i++)
				arr[i] = new Node(i, i, Integer.MAX_VALUE);
			visited = new boolean[N];
			int tmpMin = dijkstra(S);
			/*for(int i = 0; i < N; i++) {
				System.out.println(arr[i].toString());
			}*/
			if(tmpMin > OriginMin) {
				System.out.println(tmpMin);
				break;
			}
			if(tmpMin == -1) {
				System.out.println(-1);
				break;
			}else {
				delete();
			}
		}
		//혹시라도, 아직 못 찾았는데 가는 경로가 막힌다면 break해준다(-1을 담고난 후) 
		//값 삭제를 어케하쥐,,,??흠 => 경로를 어케 담을지에 대하여 생각 해보아야 할 것 같다
 	}
	
	public static int dijkstra(int root) {
		//root부터 시작하려한다
		//root를 priorityqueue에다가 넣는다. 
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(-1, root, 0));
		arr[root] = new Node(-1, root, 0);
		int selectedCount = 0;
		while(!pq.isEmpty()) {
			//pq를 돌면서, 하나 poll한다(Integer)
			
			Node curNode = pq.poll();
			int curIdx = curNode.to; //자기 자신 
			visited[curIdx] = true;
			selectedCount++;
			//visited[] = true를 처리해준다.
			//map을 돌면서, 인접해있는거 찾는다
			//map돌면서, curNode.from과 인접한 next를 해준다.
			for(int next = 0; next < N; next++) {
				if(map[curIdx][next] == 0)
					continue;
				if(visited[next] == true)
					continue;
				if(arr[next].cost > arr[curIdx].cost + map[curIdx][next]) {
					arr[next].cost = arr[curIdx].cost + map[curIdx][next];
					arr[next].from = curIdx;
					arr[next].to = next;
					pq.add(arr[next]);
				}
			}
			//인접해있는게 visited가 true면 continue해준다.
			//visited가 false면 , arr를 비교해주고, 더 값이 작으면 넣어주고, pq에다가도 넣어준다. 
		}
	/*	for(int i = 0; i < N; i++) {
			System.out.println(arr[i].toString());
		}*/
		for(int i = 0; i < N; i++)
			if(visited[i]==false)
				return -1;
		return arr[D].cost;
		//맨 마지막에는 6에 있는 값을 return 해준다. 
	}
	
	public static void delete() {
		//6부터 시작해서 거슬러 올라가면서, map에 있는 값을 지워준다. 
		Node curNode = arr[D];
		while(curNode.from != -1) {
			int from = curNode.from;
			int to = curNode.to;
			map[from][to] = 0;
			map[to][from] = 0;
			curNode = arr[from];	
		}
	}

}
