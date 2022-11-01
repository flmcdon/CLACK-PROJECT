package Main;

import Data.ClackData;
import Data.FileClackData;
import Data.MessageClackData;

import java.io.*;
import java.net.ServerSocket;
import java.util.Objects;
import java.util.Scanner;

/**
 * The ClackClient class represents the client user. A ClackClient object contains the username,
 * host name of the server connected to, port number connected to, and a boolean designating
 * whether the connection is open or not. The ClackClient object will also have two ClackData
 * objects representing data sent to the server and data received from the server.
 */
public class ClackClient {
    private static final int DEFAULT_PORT = 7000;  // The default port number

    private String userName;  // A string representing the name of the client
    private String hostName;  // A string representing the name of the computer representing the server
    private int port; // An integer representing the port number on the server connected to
    private boolean closeConnection; // A boolean representing whether the connection is closed or not
    private ClackData dataToSendToServer; // A ClackData object representing the data sent to the server
    private ClackData dataToReceiveFromServer; // A ClackData object representing the data received from the server
    private Scanner inFromStd;

    private ObjectInputStream inFromServer;

    private ObjectOutputStream outToServer;


    /**
     * The constructor to set up the username, host name, and port.
     * The connection should be set to be open (closeConnection = false).
     * Should set dataToSendToServer and dataToReceiveFromServer as null.
     *
     * @param userName a string representing the username of the client
     * @param hostName a string representing the host name of the server
     * @param port     an int representing the port number on the server connected to
     */
    public ClackClient(String userName, String hostName, int port) throws IllegalArgumentException {
        if (port < 1024) {
            throw new IllegalArgumentException("Port cannot be less than 1024");
        }
        if (userName == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }
        if (hostName == null) {
            throw new IllegalArgumentException("Hostname cannot be null");
        }

        this.userName = userName;
        this.hostName = hostName;
        this.port = port;
        this.closeConnection = false;
        this.dataToSendToServer = null;
        this.dataToReceiveFromServer = null;
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
        inFromStd = new Scanner(System.in);
        while (!closeConnection) {
            try {
                ServerSocket skt = new ServerSocket(port);
                readClientData();
                dataToSendToServer = dataToReceiveFromServer;
                printData();
            }catch (Exception e) {
                System.err.println("Temp");
            }
        }

        inFromStd.close();
    }

    /**
     * Reads the data from the client.
     * This takes data from a client and depending on their input,
     * closes the connection,
     * attempts to read the file,
     * sends a message,
     * or nothing.
     */
    public void readClientData()  {
        String userInput = inFromStd.next();

        if (userInput.equals("DONE")) {
            closeConnection = true;
        } else if (userInput.equals("SENDFILE")) {                //not sure how to implement file name
            String fileName = inFromStd.next();

            dataToSendToServer = new FileClackData(userName, fileName,ClackData.CONSTANT_SENDFILE);
            try {
                ((FileClackData) dataToSendToServer).readFileContents();
            }catch (IOException ioe) {
                System.err.println("IO Exception");
            }

        } else if (userInput.equals("LISTUSERS")) {

        } else {
            String message = userInput + inFromStd.nextLine();
            dataToSendToServer = new MessageClackData();
        }

    }


    /**
     * Sends data to server.
     * Does not return anything.
     */
    public void sendData() {
        BufferedReader dataToSendToServer = new BufferedReader(new InputStreamReader(skt.getInputStream()));
    }

    /**
     * Receives data from the server.
     * Does not return anything.
     */
    public void receiveData() {

    }

    /**
     * Prints the received data to the standard output.
     * For now, it should have no code, just a declaration.
     */
    public void printData() {
        System.out.println(dataToReceiveFromServer);
    }5676

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
