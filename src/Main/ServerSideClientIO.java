package Main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.NoRouteToHostException;
import java.net.Socket;
import java.net.UnknownHostException;

import Data.ClackData;
import Data.MessageClackData;
import Data.ListUsersClackData;


public class ServerSideClientIO implements Runnable {
    private static final String DEFAULT_KEY = "TIME";
    /**
     * Boolean representing whether connection is closed or not.
     */
    private Boolean closeConnection = false;

    /**
     * ClackData object representing data received from the client.
     */
    private ClackData dataToReceiveFromClient;

    /**
     * ClackData object representing data sent to client.
     */
    private ClackData dataToSendToClient;

    /**
     * ObjectInputStream to receive infFormation from client.
     */
    private ObjectInputStream inFromClient = null;

    /**
     * ObjectOutputStream to send information to client.
     */
    private ObjectOutputStream outToClient = null;

    /**
     * ClackServer object representing the master server.
     */
    private ClackServer server;

    /**
     * Socket object representing the socket accepted from the client
     */
    private Socket clientSocket;

    /**
     * Constructor that takes ClackServer object and Socket object as parameters.
     *
     * @param server server
     * @param clientSocket clientSocket
     */
    public ServerSideClientIO(ClackServer server, Socket clientSocket) {
        this.server = server;
        this.clientSocket = clientSocket;
    }

    /**
     * Overrides the run method in the Runnable interface.
     */
    @Override
    public void run() {
        try {
            outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
            inFromClient = new ObjectInputStream(clientSocket.getInputStream());

            while (!closeConnection) {
                this.receiveData();
                if (dataToReceiveFromClient instanceof ListUsersClackData) {
                    this.server.broadcast(new MessageClackData("Server", this.server.LUClackData.getData(), DEFAULT_KEY,ClackData.CONSTANT_DEFAULT_TYPE));
                    System.out.println(this.server.LUClackData.getData(DEFAULT_KEY));
                } else {
                    this.server.LUClackData.addUser(dataToReceiveFromClient.getUserName());
                    this.server.broadcast(dataToReceiveFromClient);
                }
//                this.sendData();
            }
        } catch (UnknownHostException uhe) {
            System.err.println("unknown host");
        } catch (NoRouteToHostException nrthe) {
            System.err.println("no route to host");
        } catch (IOException ioe) {
            System.err.println("io exception");
        }
    }

    /**
     * Receives data from the client.
     */
    public void receiveData() {
        try {
            dataToReceiveFromClient = (ClackData) inFromClient.readObject();
            System.out.println(dataToReceiveFromClient);
            if (dataToReceiveFromClient.getData().equals("DONE")) {
                closeConnection = true;
                System.out.println("USERSLIST: " + this.server.LUClackData.getData());
                this.server.LUClackData.delUser(dataToReceiveFromClient.getUserName());
                server.remove(this);
            }
        } catch (UnknownHostException uhe) {
            System.err.println("unknown host");
        } catch (NoRouteToHostException nrthe) {
            System.err.println("no route to host");
        } catch (IOException ioe) {
            closeConnection = true;
            server.remove(this);
        } catch (ClassNotFoundException cnfe) {
            System.err.println("class not found exception");
        }
    }
    /**
     * Sends data to client.
     */
    public void sendData() {
        try {
            outToClient.writeObject(dataToSendToClient);
        } catch (UnknownHostException uhe) {
            System.err.println("unknown host");
        } catch (NoRouteToHostException nrthe) {
            System.err.println("no route to host");
        } catch (IOException ioe) {
            closeConnection = true;
            server.remove(this);
        }
    }

    /**
     * Mutator method to set the ClackData variable.
     *
     * @param dataToSendToClient dataToSendToClient
     */
    public void setDataToSendToClient(ClackData dataToSendToClient) {

        this.dataToSendToClient = dataToSendToClient;
    }
}