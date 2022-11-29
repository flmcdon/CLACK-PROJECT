package Data;

import java.util.ArrayList;
import java.util.Objects;

public class ListUsersClackData extends ClackData {

    /**
     * An ArrayList consisting of users connected to server.
     */
    private ArrayList<String> userList;

    /**
     * Constructor that accepts a userName, message and type.
     *
     * @param userName userName
     * @param type     type
     */
    public ListUsersClackData(String userName, Integer type) {
        super(userName, type);
        userList = new ArrayList<String>();
    }

    /**
     * Default constructor.
     */
    public ListUsersClackData() {
        this("Anon", 0);
    }


    public String getData(String key) {
        return null;
    }

    /**
     * Adds user to userList.
     * @param username
     */
    public synchronized void addUser(String username) {
        if (!userList.contains(username))
            userList.add(username);
    }

    /**
     * Removes user from userList.
     * @param username
     */
    public synchronized void delUser(String username) {
        userList.remove(username);
    }

    /**
     * Returns the message.
     *
     * @return message
     */
    @Override
    public String getData() {
        return String.join(", ", userList);
    }

    @Override
    public String toString() {
        return "ListUsersClackData [" + getData() + "]";
    }

}