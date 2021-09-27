package congame;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("=====RPG  Game======");
		System.out.println("1: 시작하기 2: 불러오기 3: 종료");
		System.out.println("==================");
		int start = sc1.nextInt();
		
		FirstMenu menu1 = new FirstMenu();
		Character ch1 = new Character("null");
		
		if(start == 1) {
			ch1 = new Character(menu1.Start());
			System.out.println("새로운 캐릭터가 생성되었습니다");
			ch1.gStatus();
		} else if (start == 2 ) {
			menu1.load();
		} else if (start == 3) {
			menu1.exit();
		} else {
			System.out.println("올바른 키를 입력해주세요");
		}
		

		
		int tt = 0;
		do {
			Town t1 = new Town();
			System.out.println("=======Town=======");
			System.out.println("1: 정보 2: 던전 3: 상점 4: 저장 5: 종료 ");
			System.out.print("선택>>");
			tt = sc1.nextInt();
			if(tt==3) {
				ch1.gold = t1.Shop(ch1.gold);
				t1.update(ch1);
			} else if (tt==5) {
				System.out.println("게임을 종료합니다");
			} else if (tt==1) {
				ch1.gStatus();
			} else if(tt==2) {
				Dungeon dun = new Dungeon();
				dun.dg(ch1);
			}
		}while(tt !=5);

	}

}
