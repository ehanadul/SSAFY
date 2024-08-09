import java.net.MulticastSocket;
import java.nio.file.spi.FileSystemProvider;
import java.util.Scanner;

public class Array03_델타배열 {
	
	//상하좌우
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static int[][] map = new int[5][5];
	
	static int r = 2;
	static int c = 2;
	
	static void printMap() {
		for (int i = 0; i<map.length;i++) {
			for(int j =0;j<map[0].length;j++) {
				if(r==i && c ==j) {
					System.out.print("X");
				}else {
					System.out.print("O");
				}
				
			}System.out.println();
			
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		printMap();
		
		while (true) {
			System.out.println("어디로갈까요?");
			int d = sc.nextInt();
			
			int nr=r+dr[d];
			int nc=c+dc[c];
			
			// r, c를 바꾸기 전에 경계 체크 로직 필요
			if(0<=nr && nr < map.length && 0 <= nc && nc < map[0].length) {
				r=nr;
				c=nc;
			}else {
				System.out.println("배열 밖으로 벗어났습니다.");
			}
			printMap();
		}		
	}
}
