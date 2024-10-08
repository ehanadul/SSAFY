import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person{
	int no;
	String name;
	int myChu;
	
	public Person(int no, String name, int cut) {
		super();
		this.no = no;
		this.name = name;
		this.myChu = cut;
	}
	
	
}



public class Queue_마이쮸 {
	public static void main(String[] args) {
		Queue<Person> queue = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		//전체 마이쮸 개수
		int N = 20;
		int pNum = 1;
		
		String name = sc.next();
		System.out.println(name + "님이 새로 줄을 섭니다.");
		queue.add(new Person(pNum++, name, 1));
		
		while (N>0) {
			//큐에서 한명이 빠져나와서 마이쮸를 가져간다
			Person p = queue.poll();
			N -= p.myChu;
			System.out.println(p.name + "님이 마이쮸를 " + p.myChu + "개 가져갔습니다." );
			if(N<=0) {
				System.out.println(p.name + "님이 마지막 마이쮸를 가져갔습니다");
				break;
			}
			p.myChu++;;
			//가져갈 수 있는 개수를 늘리고 삽입
			queue.add(p);
			String newMember = "Lee";
			queue.add(new Person(pNum++, newMember, 1));
			System.out.println(newMember);
			
		}
	}
}
