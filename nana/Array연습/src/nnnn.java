import java.util.Scanner;

public class nnnn {
	

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int[] dr = {1,0,-1,0};
		int[] dc = {0,1,0,-1};
		
		for(int tc=1; tc<=T;tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N+1][N+1];
			
			
			int r=0;
			int c =0;
			int nr =0;
			int nc =0;
			int d =0;
//			int cnt=0;
			
		
			for(int cnt=1; cnt<= N*N;cnt++){
				arr[r][c] = cnt;
				nr = r + dr[d];
				nc = c + dc[d];
				
			
				if(nr <0 || nr >=N || nc <0 ||nc >=N || arr[nr][nc] != 0) {
					d = (d+1)%4;
					nr = r + dr[d];
					nc = c + dc[d];
				}
				r = nr;
				c = nc;
			}
			
			
			System.out.println("#" + tc);
			for(int i =0; i< N;i++) {
				for(int j=0;j< N;j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			
		}
	}
}
