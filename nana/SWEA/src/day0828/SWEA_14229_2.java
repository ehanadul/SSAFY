package day0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_14229_2 {
	//백만 개의 정수 정렬[D2] - 퀵정렬
	static int N = 1000000;
	static int[] arr = new int[N];
	static int[] tmp = new int[N];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for(int i =0; i<N;i++) {
		arr[i] = Integer.parseInt(st.nextToken());
		}
		quickSort(0,N-1);
		System.out.println(arr[500000]);
	}
	
	static void quickSort(int left, int right) {
		if (left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot - 1);
			quickSort(pivot + 1, right);
		}
	}
	
	private static int partition(int left, int right) {
		int pivot = arr[left];

		int L = left + 1, R = right;

		while (L <= R) {
			
			while (L <= R && arr[L] <= pivot) {
				L++;
			}
			while (arr[R] > pivot) {
				R--;
			}
			if (L < R) {
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}
		// R의 위치는 현재 피봇이 정렬된 위치
		int tmp = arr[left];
		arr[left] = arr[R];
		arr[R] = tmp;

		return R; 
	}
	
}
