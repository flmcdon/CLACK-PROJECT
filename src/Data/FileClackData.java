package Data;

//Class declaration for FileClackData inheriting ClackData
public class FileClackData extends ClackData {
    //Declaration of local  variables
    private String fileName;
    private String fileContents;

    //Constructor for FileClackData that takes userName, fileName, and type
    public void FileClackData (String userName, String fileName, int type){
        super.ClackData(userName, type);
        this.fileName = fileName;
    }

    //Default constructor for FileClackData
    public void FileClackData() {
        super.ClackData();
        this.fileName = fileName;
    }

    //Method to set file name
    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    //Method to return file name
    public String getFileName(){
        return this.fileName;
    }

    //Method to return the contents of get data, overrides a previous getData method.
    public String getData() {
        return this.fileContents;
    }

    //Temporarily empty method to read file contents
    public void readFileContents() {

    }

    //Temporarily empty method to write the file contents
    public void writeFileContents(){

    }

    //Overwritten toString function
    public String toString() {
        return "This class is called the FileClackData class." + "\n " +
                " It is responsible for overwriting," + "\n" +
                " Hashcode(), equals() and this toString() method. " +"\n" +
                "This class also sets up constructors for" + "FileClackData." + "\n" +
                "It also inherits from Clack Data." + "\n" +
                "Both classes use the instance variables username and type";
    }

    //Overwritten hashcode function
    public int hashCode() {
        String.str;
        str.hashCode();
    }

    //Overwritten equals code
    public boolean equals(FileClackData other){
        return this.fileName == other.fileName && this.fileContents == other.fileContents;
    }

}
