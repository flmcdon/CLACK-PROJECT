package Data;

import Main.ClackServer;
//Class declaration for MessageClackData that inherits from ClackData
public class MessageClackData extends ClackData {

    //Local variable declaration
    public String message;

    //Constructor for MessageClackData that takes userName, message, and type
    public void MessageClackData(String userName, String message, int type) {
        super.ClackData(userName,type);
        this.message = message;
    }

    public void MessageClackData (){
        super.ClackData();
        this.message = message;
    }

    //Method to return Data that is a message
    public String getData() {
        return this.message;
    }
    //Overwritten hashcode method
    public int hashCode(){
        String.str;
        str.hashCode();
    }

    //Overwritten equals method
    public boolean equals(MessageClackData other){
        return
                this.message == other.message;
    }
    //Overwritten toString method
    public String toString(){
        return "This class is called the MessageClackData class." + "\n " +
                " It is responsible for overwriting," + "\n" +
                " Hashcode(), equals() and this toString() method. " +"\n" +
                "This class also sets up constructors for" + "MessageClackData." + "\n" +
                "It also inherits from Clack Data." + "\n" +
                "Both classes use the instance variables username, message, and type";



    }
}
