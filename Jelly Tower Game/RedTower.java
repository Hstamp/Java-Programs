import java.util.Random;
/**
* A subclass of Tower called RedTower
*/
public class RedTower extends Tower {
	//Constructor
	public RedTower(){
		super();
		this.name = "Red Tower";
	}

	/**
	*	This method is inherited from superclass Tower. RedTower has it's own implementation
	*	where Red Tower's attack different jellies with different amounts of damage.
	*	@param Jelly j to be attacked.
	*/
	public void attackJelly(Jelly j) {

		System.out.println(this.name + " at level " + this.level +  " attacks " + j.getName());

		if (j.getType() == 0) {
			redOrBlue = true;
		}
		else {
			redOrBlue = false;
		}

		if (redOrBlue) {

			for (int i = 1; i < 5; i++) {
				if (getLevel() == i){
					System.out.println("Damage done: " + (i-1));
					j.setHealth(i-1);
					System.out.println("Health: " + j.getHealth());
				}
			}
		}
		else {
			Random rnd = new Random();

				int a = getLevel();
				int x = 0;
				switch (a) {
				case 1:
					x = rnd.nextInt(5 - 2 + 1) + 2;
					System.out.println("Damage done: " + x);
					j.setHealth(x);
					System.out.println("Health: " + j.getHealth());
					break;
				case 2:
					x = rnd.nextInt(9 - 5 + 1) + 5;
					System.out.println("Damage done: " + x);
					j.setHealth(x);
					System.out.println("Health: " + j.getHealth());
					break;
				case 3:
					x = rnd.nextInt(12 - 9 + 1) + 9;
					System.out.println("Damage done: " + x);
					j.setHealth(x);
					System.out.println("Health: " + j.getHealth());
					break;
				case 4:
					x = rnd.nextInt(15 - 12 + 1) + 12;
					System.out.println("Damage done: " + x);
					j.setHealth(x);
					System.out.println("Health: " + j.getHealth());
					break;
			}
		}
	}
}
