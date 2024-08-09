import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2525 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
				
				
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(br.readLine().trim());
		
		br.close();
		int totalMinutes = h * 60 + m +time;
		
		h= (totalMinutes/60)%24;
		m= totalMinutes%60;
			
		System.out.println(h + " " + m);
	}
}
