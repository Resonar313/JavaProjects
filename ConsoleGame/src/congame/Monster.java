package congame;

public class Monster {
	
	int hp;
	int attackpoint;
	int armor;
	
	int gold;
	int exp;
	String name;
	
	public Monster(int a, int b, int c, int d, int f, String n) {
		this.hp = a;
		this.attackpoint = b;
		this.armor = c;
		this.gold = d;
		this.exp = f;
		this.name = n;
	}
	
	String gName() {
		return name;
	}

		
}
