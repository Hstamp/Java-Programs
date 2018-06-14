import java.io.*;
import java.util.Arrays;
import java.nio.file.*;
/**
* A class that searches multiple file paths taken from the command line for a keyword
* and prints out all of the lines which contain that word.
* Optionally, the user can save the results to a new file
* @author Hattie Stamp  @version 1.0
*/
public class Find {

    private String keyword;
    String[] fileArgs;
    File f;
    private BufferedWriter bw;
    private BufferedReader br;
    private File temp;
    private String tempFile;

    public Find() {
      tempFile = "temp.java";
      temp = new File(tempFile);
    }

    /**
    * This method searches given files specified by the String fileArgs and prints
    * any line of it which contains a particular keyword
    * @param String keyword to search for, Array of filename paths
    */
    public void searchFile(String keyword, String[] fileArgs) {

        int j = 0;

        while (j < fileArgs.length) {

          //Convert String file path to File object
          f = new File(fileArgs[j]);

          //Search each line of File
          try {
            br = new BufferedReader(new FileReader(f));
            //Create a temporary file
            bw = new BufferedWriter(new FileWriter(temp, true));

            String line = null;
            while ((line = br.readLine()) != null) {
              String lineArray[] = line.split("\\s|\\p{Punct}");

              for (int i = 0; i < lineArray.length; i++) {
                  if (keyword.equals(lineArray[i])) {
                    System.out.println(fileArgs[j] + ": " + line.trim());

                    //Write to test.java
                    bw.write(line.trim());
                    bw.newLine();
                  }
              }
            }
          } //If a new file is at element in array, then call method saveFile()
          catch (FileNotFoundException ex) {
            saveFile(fileArgs[j]);
          }
          catch (IOException ex) {
            ex.printStackTrace();
          }
          finally {
            try {
              bw.close();
              br.close();
            }
            catch (IOException e1) {
              e1.printStackTrace();
            }
          }
          //Increase while loop by 1 if no catch exceptions are executed
          j++;
      }
    }

    /**
    * This method saves the results of the keyword search to a new file defined by
    * command line arguments.
    */
    public void saveFile(String file) {

        try { //Define two Path instances
          Path sourcePath = Paths.get(tempFile);
          Path destinationPath = Paths.get(file);

          //Use Files.copy to copy contents of test.java to file
          Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
          temp.delete();

        }catch (IOException e3) {e3.getMessage();}
    }

    public static void main (String [] args) {

      //Make a fileArgs array which has a range of args[1] - args.length
      String [] fileArgs = Arrays.copyOfRange(args, 1, args.length);

      Find find = new Find();

      //Call SearchFile method using args[0] for keyword and fileArgs for array of file paths
      find.searchFile(args[0], fileArgs);
  }
}
