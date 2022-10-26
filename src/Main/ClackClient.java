package Main;

import Data.ClackData;
import Data.FileClackData;
import Data.MessageClackData;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

/**
 * The ClackClient class represents the client user. A ClackClient object contains the username,
 * host name of the server connected to, port number connected to, and a boolean designating
 * whether the connection is open or not. The ClackClient object will also have two ClackData
 * objects representing data sent to the server and data received from the server.
 *
 *
 */
public class ClackClient {
    private static final int DEFAULT_PORT = 7000;  // The default port number

    private String userName;  // A string representing the name of the client
    private String hostName;  // A string representing the name of the computer representing the server
    private int port; // An integer representing the port number on the server connected to
    private boolean closeConnection; // A boolean representing whether the connection is closed or not
    private ClackData dataToSendToServer; // A ClackData object representing the data sent to the server
    private ClackData dataToReceiveFromServer; // A ClackData object representing the data received from the server

    /**
     * The constructor to set up the username, host name, and port.
     * The connection should be set to be open (closeConnection = false).
     * Should set dataToSendToServer and dataToReceiveFromServer as null.
     *
     * @param userName a string representing the username of the client
     * @param hostName a string representing the host name of the server
     * @param port     an int representing the port number on the server connected to
     */
    public ClackClient(String userName, String hostName, int port) {
        this.userName = userName;
        this.hostName = hostName;
        this.port = port;
        this.closeConnection = false;
        this.dataToSendToServer = null;
        this.dataToReceiveFromServer = null;
        if (port < 1024) {
            throw new IllegalArgumentException("Port cannot be less than 1024");
        }
        if (userName == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }
        if (hostName == null) {
            throw new IllegalArgumentException("Hostname cannot be null");
        }
    }

    /**
     * The constructor to set up the port to the default port number 7000.
     * The default port number should be set up as constant (e.g., DEFAULT_PORT).
     * This constructor should call another constructor.
     *
     * @param userName a string representing the username of the client
     * @param hostName a string representing the host name of the server
     */
    public ClackClient(String userName, String hostName) {
        this(userName, hostName, DEFAULT_PORT);
        if (userName == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }
        if (hostName == null) {
            throw new IllegalArgumentException("Hostname cannot be null");
        }
    }

    /**
     * The constructor that sets the host name to be "localhost"
     * (i.e., the server and the client programs run on the same computer).
     * This constructor should call another constructor.
     *
     * @param userName a string representing the username of the client
     */
    public ClackClient(String userName) {
        this(userName, "localhost");
        if (userName == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }
    }

    /**
     * The default constructor that sets the anonymous user.
     * This constructor should call another constructor.
     */
    public ClackClient() {
        this("Anon");
    }

    /**
     * Starts the client.
     * Does not return anything.
     * For now, it should have no code, just a declaration.
     */
    public void start() {
        //readClientData();
        dataToSendToServer = dataToReceiveFromServer;
        printData();
    }

    /**
     * Reads the data from the client.
     * This takes data from a client and depending on their input,
     * closes the connection,
     * attempts to read the file,
     * sends a message,
     * or nothing.
     */
     public void readClientData() {
        Scanner inFromStd = new Scanner(System.in);
        while (inFromStd.hasNext()){
            String userInput = inFromStd.next();
            if (userInput == "Done"){
                closeConnection = true;
            }else if(userInput == ("SENDFILE" + fileName)){                //not sure how to implement file name
                FileClackData(dataToSendToServer,fileName);
            }else if (userInput == "LISTUSERS"){

            }else{

            }
        }
        }



    /**
     * Sends data to server.
     * Does not return anything.
     * For now, it should have no code, just a declaration.
     */
    public void sendData() {
    }

    /**
     * Receives data from the server.
     * Does not return anything.
     * For now, it should have no code, just a declaration.
     */
    public void receiveData() {
    }

    /**
     * Prints the received data to the standard output.
     * For now, it should have no code, just a declaration.
     */
    public void printData() {
    }

    /**
     * Returns the username.
     *
     * @return this.userName
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * Returns the host name.
     *
     * @return this.hostName
     */
    public String getHostName() {
        return this.hostName;
    }

    /**
     * Returns the port.
     *
     * @return this.port
     */
    public int getPort() {
        return this.port;
    }

    @Override
    public int hashCode() {
        // The following is only one of many possible implementations to generate the hash code.
        // See the hashCode() method in other classes for some different implementations.

        int result = 23;

        // It is okay to select only  instance variables to calculate the hash code
        // but must use the same instance variables with equals() to maintain consistency.
        result = 31 * result + Objects.hashCode(this.userName);
        result = 31 * result + Objects.hashCode(this.hostName);
        result = 31 * result + this.port;
        result = 31 * result + Objects.hashCode(this.closeConnection);
        result = 31 * result + Objects.hashCode(this.dataToSendToServer);
        result = 31 * result + Objects.hashCode(this.dataToReceiveFromServer);

        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClackClient)) {
            return false;
        }

        // Casts other to be a ClackClient to access its instance variables.
        ClackClient otherClackClient = (ClackClient) other;

        // Compares all comparable instance variables of both ClackClient objects that determine uniqueness.
        // It is okay to select only instance variables for comparison but must use the same
        // instance variables with hashCode() to maintain consistency.
        return this.userName.equals(otherClackClient.userName) &&
                this.hostName.equals(otherClackClient.hostName) &&
                this.port == otherClackClient.port &&
                this.closeConnection == otherClackClient.closeConnection &&
                Objects.equals(this.dataToSendToServer, otherClackClient.dataToSendToServer) &&
                Objects.equals(this.dataToReceiveFromServer, otherClackClient.dataToReceiveFromServer);
    }

    @Override
    public String toString() {
        // Should return a full description of the class with all instance variables.
        return "This instance of ClackClient has the following properties:\n"
                + "Username: " + this.userName + "\n"
                + "Host name: " + this.hostName + "\n"
                + "Port number: " + this.port + "\n"
                + "Connection status: " + (this.closeConnection ? "Closed" : "Open") + "\n"
                + "Data to send to the server: " + this.dataToSendToServer + "\n"
                + "Data to receive from the server: " + this.dataToReceiveFromServer + "\n";
    }
}
