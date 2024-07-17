import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
      //  double X = Double.parseDouble(str[0]); //53
      //  double Y = Double.parseDouble(str[1]); //47
        int X = Integer.parseInt(str[0]); //10
        int Y = Integer.parseInt(str[1]); //8

        int cur_Z = Percent(X, Y);

        if(cur_Z >= 99 || (X==Y)){ //100%이므로 
            System.out.println(-1);
            return;
        }
        int start = 0;
        int end = Integer.MAX_VALUE; 
        int mid = 0;
        int ans = -1;
        while(start<=end){
            mid = (start+end)/2;
            if(Percent(X+mid, Y+mid) != cur_Z){
                //cur_Z가 크다면, 
                ans = mid;
                end = mid-1;
                continue;
            }
            else{
                start = mid+1;
                continue;
            }
        }
        System.out.println(ans);
    }

    public static int Percent(double x, double y){
        return (int)(((long)y*100/x));
    }
}
