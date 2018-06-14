import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
* A class which stores two text files into two arrays, and then allows the user to
* search for a particular name to find it's popularity.
* @author Hattie Stamp
* @version 1.0
*/
public class PopularNames {

  private ArrayList<Girls> girlsNames;
  private ArrayList<Boys> boysNames;

  //Constructor initialises the ArrayLists
  public PopularNames() {
    girlsNames = new ArrayList<Girls>(1000);
    boysNames = new ArrayList<Boys>(1000);
  }

  /**
  * This method in turn reads one file for girls names and one file for boys names
  * and adds each line to an array of Girls or Boys, using each of their constructors
  */
  public void readNames() {

    File girls = new File("girlnames.txt");
    File boys = new File("boynames.txt");

    try {
      BufferedReader br = new BufferedReader(new FileReader(girls));

      String line = null;
      while((line = br.readLine()) != null) {
        //split by whitespace only
        String girlTemp[] = line.split("\\s");

        //Call Girls constructor and add name and ranking in turn
        girlsNames.add(new Girls(girlTemp[0], girlTemp[1]));
      }
    }
    catch (FileNotFoundException e1) {System.out.println("Can't find file.");}
    catch(IOException e2) {e2.printStackTrace();}

    try {
      BufferedReader bs = new BufferedReader(new FileReader(boys));

      String line = null;
      while((line = bs.readLine()) != null) {

        String boyTemp[] = line.split("\\s");

        //Call Boys constructor and add name and ranking in turn
        boysNames.add(new Boys(boyTemp[0], boyTemp[1]));
      }
    }
    catch (FileNotFoundException e1) {System.out.println("Can't find file.");}
    catch(IOException e2) {e2.printStackTrace();}

    //Call findName() method
    findName();
  }

  /**
  * This method asks the user for a name they would like to search for and then
  * compares the input to girlsNames and boysNames array to see if either hold that
  * name.
  * The method then prints out the results to the command line.
  */
  public void findName() {

    Scanner myScanner = new Scanner(System.in);

    System.out.println("Please enter a name you would like to search for: ");

    String find = myScanner.next();

    boolean girlFound = false;
    boolean boyFound = false;

    //Check girlsNames array for a match with String find
    for (int i = 0; i < girlsNames.size(); i++) {
      if (find.equals(girlsNames.get(i).getName())) {
        System.out.println(girlsNames.get(i).getName() + " is ranked " + (i+1)
        + " in popularity among girls with " + girlsNames.get(i).getNamings() + " namings.");
        girlFound = true;
      }
    }

    //Check boysNames array for a match with String find
    for (int i = 0; i < boysNames.size(); i++) {
      if (find.equals(boysNames.get(i).getName())) {
        System.out.println(boysNames.get(i).getName() + " is ranked " + (i+1)
        + " in popularity among boys with " + boysNames.get(i).getNamings() + " namings.");
        boyFound = true;
      }
    }

    //Print out the results where there is no match
    if ((!boyFound && !girlFound)) {
      System.out.println(find + " is not in the files.");
    }
    else if (!girlFound ) {
      System.out.println(find + " is not in the top 1000 girl names.");
    }
    else if (!boyFound) {
      System.out.println(find + " is not in the top 1000 boy names.");
    }

  }

  public static void main (String [] args) {

    PopularNames test = new PopularNames();
    //Start the program
    test.readNames();

  }

}
