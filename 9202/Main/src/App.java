import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Node{
    //node class 
    boolean isWord = false; //단어인가?
    boolean isHit = false; //체크가 되어있는건가?
    Node[] leaf = new Node[26]; //단어 체크용 노드 
    @Override
    public String toString() {
        return "Node [isWord=" + isWord + ", isHit=" + isHit + ", leaf=" + Arrays.toString(leaf) + "]\n";
    }
}



public class App {
    static Node rootNode = new Node();
    static char[][] map;
    static boolean[][] visited;
    static StringBuilder sb;
    static int totalScore;
    static String maxWord;
    static int totalNum;
    static int[] dx = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    static int[] dy = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //먼저 input 받아보자! 
         //w입력받기 -> 단어의 개수 
        int w = Integer.parseInt(br.readLine());

        for(int i = 0; i < w; i++){
            String word = br.readLine();
            Node curNode = rootNode;
            //rootNode부터 시작! 
            for(int j = 0; j < word.length(); j++){
                //먼저 있는지 체크한다
                if(curNode.leaf[word.charAt(j)-'A'] != null){
                    //null이 아니면 curNode를 바꿔주기!
                    curNode = curNode.leaf[word.charAt(j)-'A'];
                }else{
                    //null이면 
                    curNode.leaf[word.charAt(j)-'A'] = new Node();
                    curNode = curNode.leaf[word.charAt(j)-'A'];
                }
            }

            curNode.isWord = true;
        }


        //Map input을 받아야 한다
        br.readLine();
        
        int N = Integer.parseInt(br.readLine()); //N번동안 돈다는 뜻 
        
        for(int i = 0; i < N; i++){
            map = new char[4][4];
            visited = new boolean[4][4];
            sb = new StringBuilder();

            for(int j = 0; j < 4; j++){ //input 받기
                char[] arr = br.readLine().toCharArray();
                for(int k = 0; k < 4; k++){
                    map[j][k] = arr[k];
                }
            }

            //이제 dfs을 돌아야 한다.
            totalScore = 0;
            maxWord = "";
            totalNum = 0;
            clear(rootNode);
            for(int x = 0; x < 4; x++){
                for(int y = 0; y < 4; y++){
                 //   if(rootNode.leaf[map[x][y]-'A'] != null)
                 //   dfs(x, y, rootNode.leaf[map[x][y]-'A']);
                 dfs2(x, y, rootNode);
                }
                    
            }

            System.out.println(totalScore);
            System.out.println(maxWord);
            System.out.println(totalNum);
            br.readLine();
        }
        
    }

    static void dfs(int x, int y, Node curNode){
     //   System.out.println(sb + " " + curNode.isWord);
        //x좌표와 y좌표 
        //1. 체크인
        visited[x][y] = true;
        sb.append(map[x][y]);
        curNode = curNode.leaf[map[x][y]-'A']; //null인지 체크해야한다 
        if(curNode != null){
            //2.목적지인가??
        if(curNode.isWord == true){
            if(curNode.isHit == false){
                //목적지이다 
                /*static int totalScore;
                    static String maxWord;
                static int totalNum; */
                totalScore += score(sb.toString());
                if(compareWords(sb.toString(), maxWord)){
                    //true이면 바꿔야한다
                    maxWord = sb.toString();
                }
                totalNum++;
                curNode.isHit = true;
            }
        }

        //3. 연결된 곳을 순회 
        for(int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            //범위 안이어야 한다
            if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4){
                //방문한적 없어야 한다
                if(visited[nx][ny] == false){
                    if(curNode.leaf[map[nx][ny] - 'A'] != null){
                        dfs(nx, ny, curNode.leaf[map[nx][ny]-'A']);
                    }
                }
            }
        }
        }
        
        //6. 체크아웃
        visited[x][y] = false;
        sb.deleteCharAt(sb.length()-1);
    }

    static void dfs2(int x, int y, Node curNode){
     //   System.out.println(sb + " " + curNode.isWord);
        //x좌표와 y좌표 
        //1. 체크인
        visited[x][y] = true;
        sb.append(map[x][y]);

        //2.목적지인가??
        Node nextNode = curNode.leaf[map[x][y]-'A'];
        if(nextNode != null){
            if(nextNode.isWord == true){
                if(nextNode.isHit == false){
                    //목적지이다 
                    /*static int totalScore;
                        static String maxWord;
                    static int totalNum; */
                    totalScore += score(sb.toString());
                    if(compareWords(sb.toString(), maxWord)){
                        //true이면 바꿔야한다
                        maxWord = sb.toString();
                    }
                    totalNum++;
                    curNode.isHit = true;
                }
            }//3. 연결된 곳을 순회 
            for(int i = 0; i < 8; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                //범위 안이어야 한다
             if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4){
                 //방문한적 없어야 한다
                if(visited[nx][ny] == false){
                    if(nextNode.leaf[map[nx][ny]-'A'] != null)
                        dfs2(nx, ny, nextNode);
                }
            }
            }
        }
        //6. 체크아웃
        visited[x][y] = false;
        sb.deleteCharAt(sb.length()-1);
  //      curNode.isHit = false;
    }

    static int score(String o1){
        int len = o1.length();
        int ans = 0;
        if(len == 1 || len == 2)
            ans = 0;
        else if(len == 3 || len == 4)
            ans = 1;
        else if(len == 5)
            ans = 2;
        else if(len == 6)
            ans = 3;
        else if(len == 7)
            ans = 5;
        else if(len == 8)
            ans = 11;
    
        return ans;
    }

    static boolean compareWords(String o1, String o2){
        boolean result = false;
        if(o1.length() > o2.length())
            result = true;
        else if(o1.length() == o2.length()){
            if(o1.compareTo(o2) < 0) 
                result = true;
        }
        return result;
    }

    static void clear(Node node){
        node.isHit = false;
        for(Node tmpNode : node.leaf){
            if(tmpNode != null){
                tmpNode.isHit = false;
                clear(tmpNode);
            }       
        }
    }

    
}
