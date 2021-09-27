package congame;

public class Character {
	
	int level;
	int hp;
	int attack ;
	int armor;
	int exp ;
	int gold ;
	int potion;
	String name;
	
	public Character(String n) {
		name = n;
		level = 1;
		hp = 100;
		attack = 10;
		armor = 5;
		exp = 0;
		gold = 1000;
	}
	
	void gStatus() {
		System.out.println("=====Status=====");
		System.out.println("Name :" + name);
		System.out.println("Hp :" + hp);
		System.out.println("Attack :" + attack);
		System.out.println("Armor :" + armor);
		System.out.println("Potion:" + potion);
		System.out.println("Exp :" + exp);
		System.out.println("Gold:" + gold);
	}
	
	

	
}
