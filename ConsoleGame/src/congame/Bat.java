package congame;

public class Bat extends Monster {


	static int hp = 80;
	static int attack = 10;
	static int armor = 1;
	
	static int exp = 10;
	static int gold = 50;
	static String name = "bat";
	
	public Bat() {
		super(hp, attack, armor, exp, gold, name);
	}

}
