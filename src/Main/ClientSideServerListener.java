package Main;

public class ClientSideServerListener implements Runnable {
    /**
     * a clackClient object for the recieving and printing of data
     */
    private ClackClient client = null;

    /**
     * constructor taking a clackclinet object
     * @param client
     */
    public ClientSideServerListener(ClackClient client) {
        this.client = client;
    }

    /**
     * run method for the runnable interfase runs the thread. recieves data from the server and prints it
     */
    @Override
    public void run() {
        while(!client.getCloseConnection()) {
            client.receiveData();
            client.printData();
        }
    }
}