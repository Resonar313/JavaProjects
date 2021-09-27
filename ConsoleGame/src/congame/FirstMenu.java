package congame;

import java.util.Scanner;

public class FirstMenu {
	
	Scanner sc1 = new Scanner(System.in);
	
	
	String Start( ) {
		System.out.print("아이디를 입력하세요>>");
		String ID = sc1.next();
		System.out.print("비밀번호를 입력하세요>>");
		int password = sc1.nextInt();
		System.out.println("계정이 정상 작성되었습니다");
		
		System.out.print("새로운 캐릭터 이름을 입력해주세요>>");
		String name = sc1.next();
		return name;
		
	}
	

	
	void load() {
		
	}
	
	void exit() {
		System.out.println("게임을 종료합니다");
	}

}
