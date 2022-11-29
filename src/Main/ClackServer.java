package Main;

import Data.ClackData;

import java.io.*;
import java.net.*;
import java.security.Key;
import java.util.Objects;



/**
 * The ClackServer class is a blueprint for a ClackServer object that contains information about the
 * port number that clients connect to, a boolean representing whether the server needs to be
 * closed or not, and ClackData objects representing data sent to and received from the client. The
 * server class does not need to know the host name (as the server program runs on its own computer),
 * it just needs to know what port the clients connect to. In our application, all clients will connect
 * to a single port.
 *
 */
public class ClackServer {

    //Declaration of local variables
    private int port;
    public boolean closeConnection;
    private static final int defaultPort = 7000;

    private ClackData dataToReceiveFromClient;
    private ClackData dataToSendToClient;

    private ObjectInputStream inFromClient = null;

    private ObjectOutputStream outToClient = null;

    private static final String DEFAULT_KEY = "TIME";
    /**
     * The constructor that sets the port number.
     * Should set dataToReceiveFromClient and dataToSendToClient as null.
     *
     * @param port an int representing the port number on the server connected to
     */
    public ClackServer( int port ){
        if (port < 1024) {
            throw new IllegalArgumentException("port must be greater than 1024");
        }
        this.port = port;
        this.closeConnection = false;
        this.dataToReceiveFromClient = null;
        this.dataToSendToClient = null;
    }
    /**
     * The default constructor that sets the port to the default port number 7000.
     * The default port number should be set up as constant (e.g., DEFAULT_PORT).
     * This constructor should call another constructor.
     */
    public ClackServer(){
        this (defaultPort);
    }
    /**
     * Starts the server.
     * Does not return anything.
     * For now, it should have no code, just a declaration.
     */
    public void start() {
        try {
            System.out.println(port);
            ServerSocket sskt = new ServerSocket(port);


            Socket clientSocket = sskt.accept();
            inFromClient = new ObjectInputStream(clientSocket.getInputStream());
            outToClient = new ObjectOutputStream(clientSocket.getOutputStream());

            System.out.println("Connected!");

            while (!closeConnection) {
                receiveData();
                dataToSendToClient = dataToReceiveFromClient;
                sendData();
            }
            sskt.close();
        } catch (IOException ioe) {
            System.err.println("io exception");
        }
    }
    /**
     * Receives data from client.
     * Does not return anything.
     * For now, it should have no code, just a declaration.
     */
    public void receiveData(){


        try {
            dataToReceiveFromClient = (ClackData) inFromClient.readObject();
            System.out.println(dataToReceiveFromClient.getData(DEFAULT_KEY));
            if (dataToReceiveFromClient.getType() == ClackData.CONSTANT_LOGOUT) {
                closeConnection = true;
            }
        } catch (IOException ioe) {
            System.err.println("io exception");
        } catch (ClassNotFoundException cnfe) {
            System.err.println("class not found exception");
        }

    }
    /**
     * Sends data to client.
     * Does not return anything.
     * For now, it should have no code, just a declaration.
     */
    public void sendData(){
        try {
            outToClient.writeObject(dataToSendToClient);
        } catch (IOException ioe) {
            System.err.println("io exception");
        }
    }


    /**
     * Returns the port.
     *
     * @return this.port.
     */
    public int getPort(){
        return this.port;
    }

    @Override
    public int hashCode() {
        // The following is only one of many possible implementations to generate the hash code.
        // See the hashCode() method in other classes for some different implementations.
        // It is okay to select only instance variables to calculate the hash code
        // but must use the same instance variables with equals() to maintain consistency.
        return Objects.hash(this.port, this.closeConnection, this.dataToReceiveFromClient, this.dataToSendToClient);
    }
    //Overwritten equals method
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClackServer)) {
            return false;
        }

        // Casts other to be a ClackServer to access its instance variables.
        ClackServer otherClackServer = (ClackServer) other;

        // Compares the selected instance variables of both ClackServer objects that determine uniqueness.
        // It is okay to select only instance variables for comparison but must use the same
        // instance variables with hashCode() to maintain consistency.
        return this.port == otherClackServer.port
                && this.closeConnection == otherClackServer.closeConnection
                && Objects.equals(this.dataToReceiveFromClient, otherClackServer.dataToReceiveFromClient)
                && Objects.equals(this.dataToSendToClient, otherClackServer.dataToSendToClient);
    }

    //Overwritten toString method
    @Override
    public String toString() {
        // Should return a full description of the class with all instance variables.
        return "This instance of ClackServer has the following properties:\n"
                + "Port number: " + this.port + "\n"
                + "Connection status: " + (this.closeConnection ? "Closed" : "Open") + "\n"
                + "Data to receive from the client: " + this.dataToReceiveFromClient + "\n"
                + "Data to send to the client: " + this.dataToSendToClient + "\n";
    }

    public static void main(String args[]) {
            ClackServer server;
            //input length is > 0
            if (args.length > 0) {
                //first character
                final String input = args[0];
                server = new ClackServer(Integer.parseInt(input));
            } else {
                server = new ClackServer();
            }
            server.start();
    }
}
