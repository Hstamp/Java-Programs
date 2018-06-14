import java.util.Random;
/**
* A subclass of Tower called BlueRedTower
*/
public class BlueRedTower extends Tower {

	//Constructor
	public BlueRedTower(){
		super();
		this.name = "BlueRed Tower";
	}

	/**
	*	This method is inherited from superclass Tower. BlueRedTower has it's own implementation
	*	where BlueRed Tower's attack different jellies with different amounts of damage.
	*	@param Jelly j to be attacked.
	*/
	public void attackJelly(Jelly j) {
		System.out.println(this.name + " at level " + this.level +  " attacks " + j.getName());

			Random rnd = new Random();

				int a = getLevel();
				int x = 0;
				switch (a) {
				case 1:
					System.out.println("Damage done: " + 2);
					j.setHealth(2);
					System.out.println("Health: " + j.getHealth());
					break;
				case 2:
					x = rnd.nextInt(4 - 2 + 1) + 2;
					System.out.println("Damage done: " + x);
					j.setHealth(x);
					System.out.println("Health: " + j.getHealth());
					break;
				case 3:
					x = rnd.nextInt (6 - 4 + 1) + 4;
					System.out.println("Damage done: " + x);
					j.setHealth(x);
					System.out.println("Health: " + j.getHealth());
					break;
				case 4:
					x = rnd.nextInt(8 - 6 + 1) + 6;
					System.out.println("Damage done: " + x);
					j.setHealth(x);
					System.out.println("Health: " + j.getHealth());
					break;
		}

	}

}
