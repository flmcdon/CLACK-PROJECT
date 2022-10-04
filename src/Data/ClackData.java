package Data;

//import date function
import java.util.Date;

//Declare abstract class ClackData
public abstract class ClackData {

    //Declare final constant ints
    public final int CONSTANT_LISTUSERS = 0;
    public final int CONSTANT_LOGOUT = 1;
    public final int CONSTANT_SENDMESSAGE = 2;
    public final int CONSTANT_SENDFILE = 3;


    //Declare local variables
    private String username;
    private int type;
    private Date date;

    //Constructor for ClackData with username and type provided
    public ClackData(String userName, int myType){

        this.username = userName;
        this.type = myType;
        this.date = new Date();

    }
    //Constructor for ClackData with type provided
    public ClackData (int myType) {
        this("Anon" , 0);
    }

    //Default Constructor for ClackData
    public ClackData() {
        this("Anon", 0);
    }

    //Method to return type
    public int getType() {
        return type;
    }

    //Method to return Username
    public String getUserName() {
        return this.username;
    }

    //Method to return date
    public Date getDate() {
        return this.date;
    }

    //Method to return Data
    public abstract String getData();


}

