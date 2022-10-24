package Main;

import Data.ClackData;

//Class declaration for ClackServer
public class ClackServer {

    private static final int DEFAULT_PORT = 7000;

    //Declaration of local variables
    public int port;
    public boolean closeConnection;

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
        this.port = DEFAULT_PORT;
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
    public boolean equals(Object other){
        ClackServer otherClackServer = (ClackServer)other;
        return this.port == otherClackServer.port
                && this.dataToSendToClient == otherClackServer.dataToSendToClient
                && this.dataToReceiveFromClient == otherClackServer.dataToReceiveFromClient;
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
