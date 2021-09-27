package congame;

import java.util.Scanner;

public class Town {
	
	Scanner sc1 = new Scanner(System.in);
	int hpcount = 0;
	int armorcount = 0;
	int attackcount = 0;
	int potioncount = 0;

	int Shop(int gold) {
		int a=gold;
		int b=0;
		do {
			System.out.println("=======Shop=======");
			System.out.println("1: 체력강화 2: 공격강화 3: 방어강화 4: 물약사기 5: 나가기");
			System.out.println("===100w===100w===100w===50w======");
			System.out.print("선택>>");
			b = sc1.nextInt();
			if(b == 1 || b == 2 || b==3) {
				if(a>=100) {
					a -= 100;
					if(b==1) {
						hpcount += 10;
					}else if(b==2) {
						attackcount += 1;
					}else if(b==3) {
						armorcount += 1;
					}
				} else {
					System.out.println("잔액이 부족합니다");
				}
			} else if(b==4) {
				if(a>=50) {
					a -= 50;
					potioncount += 1;
				} else {
					System.out.println("잔액이 부족합니다");
				}
			} else if (b==5) {
				System.out.println("마을로 돌아갑니다");
			} else {
				System.out.println("올바른 키를  입력하세요");
			}
			
		} while(b!=5);

		return a;
	}
	void update(Character n) {
		n.hp += hpcount;
		n.armor += attackcount;
		n.attack += armorcount;
		n.potion += potioncount;
	}

}
