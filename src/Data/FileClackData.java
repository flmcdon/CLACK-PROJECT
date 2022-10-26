package Data;

import java.util.Objects;
import java.io.*;
import java.util.Scanner;
//Class declaration for FileClackData inheriting ClackData
/**
 * The child of ClackData, whose data is the name and contents of a file.
 *
 *
 */
public class FileClackData extends ClackData {
    //Declaration of local  variables
    private String fileName;
    private String fileContents;

    /**
     * The constructor to set up the instance variables username, fileName, and type.
     * Should call the super constructor.
     * The instance variable fileContents should be initialized to be null.
     *
     * @param userName a string representing the name of the client user
     * @param filename a string representing the name of a file
     * @param type     an int representing the data type
     */
    public FileClackData(String userName, String filename, int type) {
        super(userName, type);
        this.fileName = fileName;
        this.fileContents = null;
    }


    /**
     * The default constructor.
     * This constructor should call the super constructor.
     */
    public FileClackData() {
        super(ClackData.CONSTANT_SENDFILE);
        this.fileName = "";
        this.fileContents = null;
    }

    /**
     * Sets the file name in this object.
     *
     * @param fileName a string representing the name of a file
     */
    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    /**
     * Returns the file name.
     *
     * @return this.fileName
     */
    public String getFileName(){
        return this.fileName;
    }

    /**
     * Returns the file contents.
     *
     * @return this.fileContent
     */
    public String getData() {
        return this.fileContents;
    }

    /**
     * Overridden get Data method with String key
     */
    public String getData(String key){
        return decrypt(fileContents , key);

    }

    /**
     * Reads the file contents.
     * Does not return anything.
     * For now, it should have no code, just a declaration.
     */
    public void readFileContents() {
        try{
            File file = new File (fileName);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String nextLine;
            while ((nextLine = bufferedReader.readLine()) != null){
                fileContents += nextLine;
            }
        }catch (FileNotFoundException fnfe) {
            System.err.println("File does not exist");
        }catch (IOException ioe) {
            System.err.println("IOException Occured");
        }
    }

    /**
     * Reads file and encrypts the file contents
     * @param key
     */
    public void readFileContents(String key){
        try{
            File file = new File (fileName);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String nextLine;
            while ((nextLine = bufferedReader.readLine()) != null){
                fileContents += nextLine;
            }
            encrypt(fileContents,key);
        }catch (FileNotFoundException fnfe) {
            System.err.println("File does not exist");
        }catch (IOException ioe) {
            System.err.println("IOException Occured");
        }
    }

    /**
     * Writes the file contents.
     *
     */
    public void writeFileContents(){
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            bufferedWriter.write(fileContents);
            bufferedWriter.close();
        }catch (IOException ioe) {
            System.out.println("IO Exception");
        }
    }

    /**
     *
     * @param key
     */
    public void writeFileContents (String key) {
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            bufferedWriter.write(decrypt(fileContents, key));
            bufferedWriter.close();
        }catch (IOException ioe) {
            System.out.println("IO Exception");
        }
    }
    @Override
    public String toString() {
        // Should return a full description of the class with all instance variables,
        // including those in the super class.
        return "This instance of FileClackData has the following properties:\n"
                + "Username: " + this.username + "\n"
                + "Type: " + this.type + "\n"
                + "Date: " + this.date.toString() + "\n"
                + "File Name: " + this.fileName + "\n"
                + "File Contents: " + this.fileContents + "\n";
    }

    @Override
    public int hashCode() {
        // The following is only one of many possible implementations to generate the hash code.
        // See the hashCode() method in other classes for some different implementations.
        // It is okay to select only some of the instance variables to calculate the hash code
        // but must use the same instance variables with equals() to maintain consistency.
        return Objects.hash(this.username, this.type, this.fileName, this.fileContents);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileClackData)) {
            return false;
        }

        // Casts other to be a FileClackData to access its instance variables.
        FileClackData otherFileClackData = (FileClackData) other;

        // Compares the selected instance variables of both FileClackData objects that determine uniqueness.
        // It is okay to select only instance variables for comparison but must use the same
        // instance variables with hashCode() to maintain consistency.
        return this.username.equals(otherFileClackData.username)
                && this.type == otherFileClackData.type
                && Objects.equals(this.fileName, otherFileClackData.fileName)
                && Objects.equals(this.fileContents, otherFileClackData.fileContents);
    }
}
