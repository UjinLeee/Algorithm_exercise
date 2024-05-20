import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException { // 순열 돌리기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // TestCase 받기
        int T = Integer.parseInt(br.readLine());

        for (int k = 0; k < T; k++) {

            StringBuilder builder = new StringBuilder();
            
            int N = Integer.parseInt(br.readLine());
            int[] note1 = new int[N];
            String[] str = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                note1[i] = Integer.parseInt(str[i]);
            }
            Arrays.sort(note1); // note1은 정렬하기

            int M = Integer.parseInt(br.readLine());
            int[] note2 = new int[M];
            str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                note2[j] = Integer.parseInt(str[j]);
            }

            for (int i = 0; i < M; i++) {
                int low = 0;
                int high = N - 1;
                int cmp = note2[i];
                int mid;
                boolean isTrue = false;

                while (low <= high) {
                    mid = (low + high) / 2;
                    if (note1[mid] == cmp) {
                        builder.append("1");
                        isTrue = true;
                        break;
                    }
                    if (note1[mid] > cmp) {
                        high = mid - 1;
                        continue;
                    }
                    if (note1[mid] < cmp) {
                        low = mid + 1;
                        continue;
                    }
                }
                if (isTrue == false) {
                    // System.out.println(0);
                    builder.append("0");
                }
                builder.append("\n");
            }
            System.out.print(builder.toString());
            
        }

    }

}
