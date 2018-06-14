import java.util.ArrayList;
/**
* A class where the Towers attack Jellies until all the Jellies are dead.
* @author Hattie Stamp
* @version 1.0
*/
public class TowerAttack {


    public static void main (String [] args) {

    //Create an ArrayList of Jellies
    ArrayList <Jelly> jellyList = new ArrayList<Jelly>();

    jellyList.add(new RedJelly());
    jellyList.add(new BlueJelly());
    jellyList.add(new RedJelly());
    jellyList.add(new RedJelly());
    jellyList.add(new BlueJelly());
    jellyList.add(new RedJelly());
    jellyList.add(new BlueJelly());
    jellyList.add(new RedJelly());
    jellyList.add(new RedJelly());
    jellyList.add(new BlueJelly());

    System.out.println(jellyList.size());

    //Create an Array of Towers
    ArrayList<Tower> finalTowerList = new ArrayList<Tower>();

    Tower red = new RedTower();
    red.increaseLevel();

    Tower red2 = new RedTower();
    red2.increaseLevel();
    red2.increaseLevel();

    Tower blue = new BlueTower();

    Tower blue2 = new BlueTower();
    blue2.increaseLevel();
    blue2.increaseLevel();
    blue2.increaseLevel();

    Tower bluered = new BlueRedTower();

    finalTowerList.add(red);
    finalTowerList.add(blue2);
    finalTowerList.add(red2);
    finalTowerList.add(bluered);
    finalTowerList.add(blue);

   //A while loop to make all of the towers attack the jellies until the jellies are dead
   while (jellyList.size() > 0 ) {
    for (int i = 0; i < jellyList.size(); i++) {

      for (int j = 0; j < finalTowerList.size() ; j++ ) {
          //If Jelly's health is 0, remove jelly from array and skip rest of nested for loop.
          if (!(jellyList.get(i)).isAlive()) {
            jellyList.remove(i);
            System.out.println("Jelly died!");
            System.out.println("**How many Jellies are left: " + jellyList.size()+"**");
            break;
          }
          finalTowerList.get(j).attackJelly(jellyList.get(i));
       }

     }
    }

  }
}
