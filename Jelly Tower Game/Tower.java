import java.util.Random;
/**
* A superclass Tower. This is an abstract superclass and cannot be instantiated.
*/
public abstract class Tower {

	//Constants
	public static final int LEVEL_1 = 1;
	public static final int LEVEL_2 = 2;
	public static final int LEVEL_3 = 3;
	public static final int LEVEL_4 = 4;

	//protected means that they can only be accessed by classes in the same package or subclasses.
	protected int level;
	protected String name;
	protected boolean redOrBlue;//false means red, true means blue.

	//Tower constructor
	public Tower(){
		this.level = LEVEL_1;
		name = "Generic Tower";
	}

	public int getLevel() {
		return this.level;
	}

	public void increaseLevel(){
		if (this.level != LEVEL_4) this.level++;
		else System.out.println("Tower at maximum level");
	}
	/**
	*		This method does not have it's own implementation. All subclasses of Tower must
	*		include attackJelly() and provide their own implementation.
	*/
	public abstract void attackJelly(Jelly j);


}
