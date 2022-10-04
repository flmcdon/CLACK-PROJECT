package Main;

import Data.ClackData;

//Class declaration for ClackServer
public class ClackServer {

    //Declaration of local variables
    public int port;
    public boolean closeConnection;
    public final int defPort = 7000;

    ClackData dataToReceiveFromClient = new ClackData() {

        //Allows for instantiation of ClackData
        public String getData() {
            return null;
        }
    };
    ClackData dataToSendToClient = new ClackData() {
        //Allows for instantiation of ClackData
        public String getData() {
            return null;
        }
    };

    //Constructor for ClackServer that takes a port variable
    public ClackServer( int port ){
        this.port = port;
        this.dataToReceiveFromClient = null;
        this.dataToSendToClient = null;
    }
    //Default Constructor for ClackServer that set port default to 7000
    public ClackServer(){
        this.port = defPort;
    }

    //Method for start - temporarily empty
    public void start(){

    }
    //Method for receiveData - temporarily empty
    public void receiveData(){

    }
    //Method for sendData - temporarily empty
    public void sendData(){

    }

    //Method for getPort - returns the port
    public int getPort(){
        return this.port;
    }

    //Overwritten hashCode method
    public int hashCode(){
        return 0x400;
    }
    //Overwritten equals method
    public boolean equals(ClackServer other){
        return
                this.port == other.port &&
                        this.dataToSendToClient == other.dataToSendToClient &&
                        this.dataToReceiveFromClient == other.dataToReceiveFromClient;
    }

    //Overwritten toString method
    public String toString(){
        return "This class is called the ClackServer class." + "\n " +
                " It is responsible for overwriting," + "\n" +
                " Hashcode(), equals() and this toString() method. " +"\n" +
                "This class also sets up constructors for" + "ClackServer, start, receiveData, sendData, and getPort" + "\n" +
                "It also inherits from Clack Data." + "\n" +
                "This class uses instance variables port, closeConnection, dataToReceiveFromClient, and dataToSendToClient";
    }


}
