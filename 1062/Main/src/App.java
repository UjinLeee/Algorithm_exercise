import java.io.*;
import java.util.*;

public class App {
    static int N, K;
    static int flag;
    static int max = 0;
    static String[] words;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]); //3
        K = Integer.parseInt(str[1]); //K
        words = new String[N]; //단어 담을 것들 

        //a, n, t, i, c 
        if(K < 5){
            System.out.println(0);
            return;
        }

        else if(K == 26){ //다 되는 거니까 
            System.out.println(N);
            return;
        }

        for(int i = 0; i < N; i++){
            String word = br.readLine();
            words[i] = word.substring(4, word.length() - 4); //"anta","tica"제외한 단어
        }

        flag = 0; //어떤 단어 있는지 
        max = 0;

        //a, n, t, i, c는 무조건 있으므로 방문 체크
        flag |= 1 << ('a' - 'a'); //아스키코드 활용
        flag |= 1 << ('n' - 'a'); 
        flag |= 1 << ('t' - 'a');
        flag |= 1 << ('i' - 'a'); 
        flag |= 1 << ('c' - 'a');

        combination(0, 0, flag);
        System.out.println(max);
    }

    public static void combination(int idx, int start, int flag){
        if(idx == K-5){
            //이미 다 찼다면
            int count = 0;
            for(int i = 0; i < N; i++){
                boolean isValid = true;
                for(int j = 0; j < words[i].length(); j++){
                    //직접 찾기
                    if((flag&1<<(words[i].charAt(j)-'a'))==0){
                        isValid = false;
                        break;
                    }
                }
                if(isValid)
                    count++;
            }
            max = Math.max(max, count);
            return;
        }
        for(int i = start; i < 26; i++){
            //맨 첨에는 0부터 시작 
            if((flag&1<<i)!=0) //포함하고 있는거니까
                continue;
            combination(idx+1, i+1, flag | 1<<i);
        }
    }
}
