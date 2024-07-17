import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        
        int N = Integer.parseInt(str[0]); // 방의 개수  
        int H_ATK = Integer.parseInt(str[1]); //용사의 공격력 
        int tmp_HP = 0;
        for(int i = 0; i < N; i++){
            str = br.readLine().split(" ");
            if(str[0].equals("1")){
                //1인 경우 몬스터와 싸운다. 
                int M_ATK = Integer.parseInt(str[1]); // 몬스터의 공격력
                int M_HP = Integer.parseInt(str[2]); //몬스터의 상태
                int num = (int)Math.ceil(M_HP/H_ATK); //최소 공격 횟수 
                tmp_HP -= (M_ATK)*(num-1);
            }
        }
    }
}
