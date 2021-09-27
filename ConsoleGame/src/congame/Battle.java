package congame;

public class Battle {
	
	boolean run = false;
	boolean chdeath = false;
	boolean mondeath = false;
	
	boolean attack(Character ch, Monster mon) {
		
		mon.hp = mon.hp - (ch.attack - mon.armor);

		System.out.println("당신은 "+mon.name+"을/를 공격했습니다!");
		System.out.println((ch.attack - mon.armor)+"의 데미지!");
		
		if(mon.hp<=0) {
			mondeath = true;
			System.out.println(mon.name+"은/는 쓰러졌다!");
		} else {
			System.out.println(mon.name+"은/는 "+mon.hp+"의 체력이 남았다!");
		}
		return mondeath;
	}
	
	boolean enemyattack(Character ch, Monster mon) {
		
		if(mon.hp<=0) {
			System.out.println("상대는 쓰러져 반격하지 못했다");
		} else {
			ch.hp = ch.hp - (mon.attackpoint - ch.armor);
			System.out.println(mon.name+"이/가 당신을 공격했다!");
			System.out.println((mon.attackpoint - ch.armor)+"의 데미지!");
		}
		
		if(ch.hp<=0) {
			chdeath = true;
			System.out.println("당신은 쓰러졌다...");
		} else {
			System.out.println("당신은 "+ch.hp+"의 체력이 남았다");
		}
		
		return chdeath;
	}
	
	boolean run() {
		int runrd = (int)(Math.random()*10);
		
		if(runrd<=4) {
			run = true;
		} else {
			run = false;
		}
		
		return run;
	}
}
