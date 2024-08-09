package 일타싸피;

public class test {
public static void main(String[] args) {
	double WIDTH = 254;
	double HEIGHT =127;
	
	double R = 5.73 /2;
	
	
	// 공은 좌표로 주어짐 배열 형태
	double x1 = 70;
	double y1 = 60;
	
	double x2 = 70;
	double y2 = 60;
	
	
	double angle = Math.atan(y2-y1)/(x2-x1);
	System.out.println(angle); //radian(실수)

	double degree = Math.toDegrees(angle);
	System.out.println(degree);

}
}
