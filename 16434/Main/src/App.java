import java.io.BufferedReader;
import java.io.InputStreamReader;

class Pair {
    int t;
    int a;
    int h;
    Pair(int t, int a, int h){
        this.t = t;
        this.a = a;
        this.h = h;
    }
}

public class App {
    public static Pair[] pair_list;
    public static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]); // 방의 개수  
        int H_ATK = Integer.parseInt(str[1]); //용사의 공격력 
        pair_list = new Pair[N];
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            int t = Integer.parseInt(str[0]);
            int a = Integer.parseInt(str[1]);
            int h = Integer.parseInt(str[2]);
            pair_list[i] = new Pair(t, a, h);
        }

        long L = 1;
        long R = Long.MAX_VALUE;
        long ans = Long.MAX_VALUE;

        while (L <= R) {
            long mid = (L + R) / 2;
            if (fight(mid, H_ATK)) { // 가능하다면
                ans = Math.min(ans, mid);
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        System.out.println(ans);
    }

    public static boolean fight(long HP, int atk) {
        long cur_HP = HP;
        long cur_atk = atk;

        for (int i = 0; i < N; i++) {
            Pair cur_pair = pair_list[i];
            if (cur_pair.t == 1) {
                // 몬스터와 전투
                long num_attacks_to_kill_monster = (cur_pair.h + cur_atk - 1) / cur_atk;
                long num_attacks_to_kill_hero = (cur_HP + cur_pair.a - 1) / cur_pair.a;

                if (num_attacks_to_kill_hero < num_attacks_to_kill_monster) {
                    return false;
                }

                cur_HP -= cur_pair.a * (num_attacks_to_kill_monster - 1);
            } else {
                // 포션
                cur_atk += cur_pair.a;
                cur_HP = Math.min(HP, cur_HP + cur_pair.h);
            }
        }
        return true;
    }
}
