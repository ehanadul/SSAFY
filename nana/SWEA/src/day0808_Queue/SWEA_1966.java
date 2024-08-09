package day0808_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1966 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int[] num = new int[N];
			for(int i = 0; i <N;i++) {
					num[i] = Integer.parseInt(st.nextToken());
			}
		
			insertionSort(num);
		
			sb.append("#").append(tc).append(" ");
            for (int i = 0; i < N; i++) {
                sb.append(num[i]).append(" ");
//                if (i < N - 1) {
//                    sb.append(" "); 
//                }
            }
            sb.append("\n");
        }

   
        System.out.print(sb.toString());
        br.close();
		}
	
	
	
	public static void insertionSort(int[] arr) {
		for(int i = 1; i < arr.length;i++) {
			int data = arr[i];
			
			int j;
			for(j = i-1;j>=0 && arr[j] > data;j--) {
				arr[j+1] = arr[j];
			}
				arr[j+1] = data;
		}
		
		
	}
	
	
	
}
