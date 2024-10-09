import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.sound.sampled.SourceDataLine;

import java.util.Collections;
public class App {

	static int N = 1000000;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		//A 초기화하기 
		st = new StringTokenizer(br.readLine());
		int len_A = Integer.parseInt(st.nextToken());
		int[] A = new int[len_A];
		long[] sum_A = new long[len_A+1];
		int tmp_sum = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < len_A; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			
			tmp_sum += A[i];
			sum_A[i+1] = tmp_sum;
		}
		sum_A[0] = 0;
		
		//sub_A 구하기
		ArrayList<Long> subA = new ArrayList<>();
		for(int i = 0; i <= len_A; i++) {
			for(int j = i+1; j <= len_A; j++) {
				subA.add(sum_A[j]-sum_A[i]);
			}
		}
        Collections.sort(subA);
//		System.out.println(subA.toString());
		
		//A 초기화하기 
		st = new StringTokenizer(br.readLine());
		int len_B = Integer.parseInt(st.nextToken());//3
		int[] B = new int[len_B];
		long[] sum_B = new long[len_B+1];
		tmp_sum = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < len_B; i++) {
			B[i] = Integer.parseInt(st.nextToken());
			
			tmp_sum += B[i];
			sum_B[i+1] = tmp_sum;
		}
		sum_B[0] = 0; 
		
		//sub_A 구하기
		ArrayList<Long> subB = new ArrayList<>();
		for(int i = 0; i <= len_B; i++) {
			for(int j = i+1; j <= len_B; j++) {
				subB.add(sum_B[j]-sum_B[i]);
			}
		}
        subB.sort(Collections.reverseOrder());
	//	System.out.println(subB.toString());

        long count = 0;
        int left = 0;
        int right = 0;

        while(left < subA.size() && right < subB.size()){

            long sum = subA.get(left) + subB.get(right);
            if(sum > T){
                //줄여야하므로
                right++;
            }
            if(sum < T){
                //키워야하므로
                left++;
            }
            if(sum == T){
                long countA = 1;
                long countB = 1;
                long tmpA = subA.get(left);
                long tmpB = subB.get(right);
                
                while(true){
                    if(++left < subA.size()){
                        if(subA.get(left)==tmpA)
                            countA ++;
                        else
                            break;
                    }else{
                        break;
                    }
                }
                while(true){
                    if(++right < subB.size()){
                        if(subB.get(right)==tmpB)
                            countB ++;
                        else
                            break;
                    }else{
                        break;
                    }
                }
                count += countA*countB;
            }
        }
        System.out.println(count);
	}

}
