import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.Point;
import java.util.ArrayList;

public class App {
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
                    case 3:
                        break;
                }
            }
        }

        chk_size = chicken.size();

        if(chk_size == M){
            Len(chicken);
            // return; -> 얘 때문에 계속 오류났었음 
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
                int min_len = 10000;
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
        if(idx == chk_size-1)
            return;
        for(int i = idx + 1; i < chk_size; i++){
            arr.add(chicken.get(i));
            search(arr, i);
            arr.remove(chicken.get(i));
        }
    }

}