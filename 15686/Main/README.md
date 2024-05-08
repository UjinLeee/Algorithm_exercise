[[15686 문제 링크]](https://www.acmicpc.net/problem/15686)

![](https://velog.velcdn.com/images/lyj5341/post/33d3e787-585b-40e0-90d2-86bada22ed20/image.png)![](https://velog.velcdn.com/images/lyj5341/post/3c9a6174-613e-4b20-9b2e-a9f522783883/image.png)

# 문제풀이 (2024-05-02)

### 🌿 삽질 과정 🌿

맨 처음 vscode에서 예제 코드를 돌렸을 때는 되던 코드가, 실제로 돌려보니 '시간 초과'가 떴다. 
이유를 알기 위하여, 처음 부터 코드를 뜯어본 결과 '치킨집'을 탐색할 때 과정에서 '중복'이 발생하는 것을 발견하였다. 
```
//중복 발생 코드
public static int chkLen(ArrayList<Point> chicken){
			'''
            for(int i = 0; i < chicken.size(); i++){
                Point tmp = new Point(chicken.get(i).x, chicken.get(i).y);
                chicken.remove(i);
                chkLen(chicken);
                chicken.add(tmp);
            }
        }
        return 0;
    }
```
> 중복을 피하기 위하여 **조합**을 활용해야 한다.

### ✨ JAVA 조합 ✨

Java에서 조합을 사용하기 위해선 **백트래킹**을 활용해야 한다. 

크기가 N인 ArrayList에서 M개를 뽑는 알고리즘은, 

```
static void combination(int[] arr, int start, int n, int r){
	if(r == 0
}
```

### **나의 풀이**
```
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.Point;
import java.util.ArrayList;

public class Main {
    static int N;
    static int M;
    static ArrayList<Point> home = new ArrayList<>(); //어차피 계속 쓰일거니까 
    static ArrayList<Point> chicken = new ArrayList<>();
    static int chk_size;
    static int min ;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]); //max num of chicken
        min = N*N*N;
        
        //입력받아서 초기화 하기 
        for(int i = 0; i < N;i++){
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                //0: null, 1: house, 2: chicken
                switch(Integer.parseInt(str[j])){
                    case 1:
                        home.add(new Point(i,j));
                        break;
                    case 2:
                        chicken.add(new Point(i,j));
                        break;
                    case 0:
                        break;
                }
            }
        }

        chk_size = chicken.size();

        if(chk_size == M){
            Len(chicken);
            
        }else{
            ArrayList<Point> tmp_list = new ArrayList<>();
            for(int i = 0; i < chk_size; i++){
                tmp_list.add(chicken.get(i));
                search(tmp_list, i);
                tmp_list.remove(chicken.get(i));
            } //일단 다 돌아버려 
        }
        System.out.println(min);
        return;
    }

    public static void Len(ArrayList<Point> tmp_list){ //얘는 길이 구하기 
        int sum_len = 0;
            for(int i = 0; i < home.size(); i++){
                int min_len = N*N*N;
                for(int j = 0; j < tmp_list.size(); j++){
                    int len = Math.abs(home.get(i).x-tmp_list.get(j).x) + Math.abs(home.get(i).y - tmp_list.get(j).y);
                    if(min_len > len)
                        min_len = len;
                }
                sum_len += min_len;
            }
            min = Math.min(min, sum_len);
            return;     
    }

    public static void search(ArrayList<Point> arr, int idx){
        if(arr.size() == M){
            Len(arr);
            return;
        }
        if(idx >= chk_size)
            return;
        for(int i = idx + 1; i < chk_size; i++){
            Point tmp = chicken.get(i);
            arr.add(tmp);
            search(arr, i);
            arr.remove(tmp);
        }
    }

}
```
