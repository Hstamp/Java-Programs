/**
* A class to hold instances of Girls
* @author Hattie Stamp
* @version 1.0
*/
public class Girls {

  protected String name;
  protected String namings;

  //Constructor will be used when adding instances to the ArrayList
  public Girls(String name, String namings) {
    this.name = name;
    this.namings = namings;
  }

  public String getName() {
    return this.name;
  }

  public String getNamings() {
    return this.namings;
  }
}
