/**
* A superclass called Jelly.
*/
public abstract class Jelly {

	//protected means that they can only be accessed by classes in the same package or subclasses.
	protected int type; // to indicate which colour the Jelly is.
	protected int health; // health of the Jelly (max health is 100, minimum health is 0).
	protected String name;

	//Default constructor sets all Jelly health to 100 when an instance is created
	public Jelly(){
		this.health = 100;
	}

	public int getType () {
		return type;
	}

	public int getHealth() {
		return health;
	}

	public String getName() {
		return name;
	}

	protected void setHealth(int health) {

		this.health -= health;

		if ((this.health < 0) || (this.health == 0)) {
			this.health = 0;
		}
	}

	/**
	*	This method checks to see whether a Jelly is alive (health 1 - 100) or dead (health of 0).
	*	@return boolean value, alive is true or false.
	*/
	public boolean isAlive() {

		boolean alive = true;

		if (getHealth() <= 0) {
			alive = false;
		}

		return alive;
	}

}
