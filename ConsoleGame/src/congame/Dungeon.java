package congame;

import java.util.Scanner;

public class Dungeon {
	
	Scanner sc = new Scanner(System.in);

	void dg(Character n) {
		int a = 0;
		
		do {
			System.out.println("==============Dungeon==============");
			System.out.println("1: 동굴 2: 숲 속 폐허 3: 버려진 마을 4: 숨겨진 지하 5: 나가기");
			System.out.println("================================= ");
			System.out.print("선택>>");
			a = sc.nextInt();
			if(a==1) {
				cave(n);
			}
		} while(a!=5);

	}
	
	int b = 0;
	void cave(Character n) {
		System.out.println("==============================");
		System.out.println("==============동굴==============");
		System.out.println("==============================");
		Monster m1[] = new Monster[3];
		m1[0] = new Bat();
		
		do {
			System.out.println("당신은 어두운 동굴 속으로 발을 내딛습니다...");
			System.out.println("행동을 선택하여 주십시오");
			System.out.println("1. 더 깊은 곳으로 전진 2. 돌아가기");
			b = sc.nextInt();
			if(b==1) {
				System.out.println("무언가 나타나 당신의 앞을 가로막았다!");
				System.out.println("앞에 나타난 것은: "+m1[0].name);
				Battle bt = new Battle();
				boolean run = false;
				boolean chdeath = false;
				boolean mondeath = false;
				do { 
					System.out.println("어떻게 하시겠습니까?");
					System.out.println("1. 공격 2. 도망");
					int c = sc.nextInt();
				
					if (c==1) {
						mondeath = bt.attack(n, m1[0]);
						chdeath =bt.enemyattack(n, m1[0]);
						
					} else if (c==2) {
						
						run = bt.run();
						
						if(run==false) {
							System.out.println("도망치는데 실패했다!");
							chdeath = bt.enemyattack(n, m1[0]);
						} else {
							System.out.println("도망치는데 성공했다!");
						}
						
					} else {
						System.out.println("올바른 키를 입력해주세요");
					}
					
				}while(run==false && chdeath==false && mondeath==false);
				
				if(chdeath) {
					System.out.println("마을로 돌아갑니다..");
					n.hp = 10;
					break;
				}
				if(mondeath) {
					n.exp += m1[0].exp;
					System.out.println(m1[0].exp+"만큼 경험치를 획득합니다");
					n.gold += m1[0].gold;
					System.out.println(m1[0].gold+"만큼 골드를 획득합니다");
					m1[0].hp = 80;
				}

			}else if(b==2) {
				System.out.println("동굴 밖으로 나갑니다");
			} else {
				System.out.println("올바른 키를 입력해주세요");
			}
		}while(b!=2);
	}
	

	
}
