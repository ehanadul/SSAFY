package day0730_Array;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SWEA_2063 {
	
	public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
          
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
	
	
	
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
    
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        

        String[] scoreString = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(scoreString[i]); 
        }

        selectionSort(scores);
        
 
        int median = scores[N / 2];
  
        System.out.println(median);
        br.close();
        
	}
}
