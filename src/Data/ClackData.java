package Data;

//import date function
import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;

/**
 * Class ClackData is a superclass that represents the data sent between the client and the
 * server. An object of type ClackData consists of the username of the client user, the date
 * and time at which the data was sent and the data itself, which can either be a message
 * (MessageClackData) or the name and contents of a file (FileClackData). Note that ClackData
 * should not be instantiable.
 *
 */
public abstract class ClackData  implements Serializable {

    /**
     * For giving a listing of all users connected to this session.
     */
    public static final int CONSTANT_LISTUSERS = 0;

    /**
     * For logging out, i.e., close this client's connection.
     */
    public static final int CONSTANT_LOGOUT = 1;

    /**
     * For sending a message.
     */
    public static final int CONSTANT_SENDMESSAGE = 2;

    /**
     * For sending a file.
     */
    public static final int CONSTANT_SENDFILE = 3;


    /**
     * A string representing the name of the client user.
     */
    protected String username;

    /**
     * An integer representing the kind of data exchanged between the client and the server.
     */
    protected int type;

    /**
     * A Date object representing the date and time when ClackData object is created.
     */
    protected Date date;

    /**
     * The constructor to set up the instance variable username and type.
     * The instance variable date should be created automatically here.
     *
     * @param userName a string representing the name of the client user
     * @param type     an int representing the data type
     */
    public ClackData(String userName, int type) {
        this.username = userName;
        this.type = type;
        this.date = new Date();
    }

    /**
     * The constructor to create an anonymous user, whose name should be "Anon".
     * This constructor should call another constructor.
     *
     * @param type an int representing the data type
     */
    public ClackData(int type) {
        this("userName", type);
    }

    /**
     * The default constructor.
     * This constructor should call another constructor.
     * type should get defaulted to CONSTANT_LOGOUT.
     */
    public ClackData() {
        this(CONSTANT_LOGOUT);
    }

    /**
     * Returns the type.
     *
     * @return this.type
     */
    public int getType() {
        return this.type;
    }

    /**
     * Returns the username.
     *
     * @return this.userName
     */
    public String getUserName() {
        return this.username;
    }

    /**
     * Returns the date.
     *
     * @return this.date
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * The abstract method to return the data contained in this class
     * (contents of instant message or contents of a file).
     *
     * @return data
     */

    public String encrypt(String inputStringToEncrypt, String key) {

        char msg[] = inputStringToEncrypt.toCharArray();
        int msgLen = msg.length;

        char keyword[] = new char[msgLen];
        char encryptMsg[] = new char[msgLen];

//        for (int i = 0, j = 0; i < msgLen; ++i, ++j) {
//            if (j == key.length()) {
//                j = 0;
//            }
//            keyword[i] = key.charAt(j);
//        }
        int keyCounter = 0;
        for (int i = 0; i < msgLen; ++i) {
//            encryptMsg[i] = (char) (((msg[i] - 'a' + keyword[i] - 'a') % 26) + 'A');

            if (Character.isLowerCase(msg[i])) {
                encryptMsg[i] = (char) (((msg[i] - 'a' + Character.toLowerCase(keyword[keyCounter]) - 'a') % 26) + 'A');
                keyCounter = (keyCounter + 1) % 26;
            } else if (Character.isUpperCase(msg[i])) {
                encryptMsg[i] = (char) (((msg[i] - 'A' + Character.toUpperCase(keyword[keyCounter]) - 'A') % 26) + 'A');
                keyCounter = (keyCounter + 1) % 26;
            }else {
                encryptMsg[i] = (char) (msg[i]);
            }


        }

        String encryptString = new String(encryptMsg);
        return encryptString;
    }

    /**
     * The protected method the take an input string and decrypt using a key
     */

    protected String decrypt(String inputStringToDecrypt, String key) {
        char msg[] = inputStringToDecrypt.toCharArray();
        int msgLen = msg.length;

        char keyword[] = new char[msgLen];
        char decryptMsg[] = new char[msgLen];

        for (int i = 0; i < msgLen; ++i) {
            //decryptMsg[i] = (char) ((((msg[i] - keyword[i]) + 26) % 26) + 'A');
            if (Character.isLowerCase(msg[i])) {
                decryptMsg[i] = (char) ((((msg[i] - Character.toLowerCase(keyword[i])) + 26) % 26) + 'A');
                //keyCounter = (keyCounter + 1) % 26;
            }else if (Character.isUpperCase(msg[i])) {
                decryptMsg[i] = (char) ((((msg[i] - Character.toUpperCase(keyword[i])) + 26) % 26) + 'A');
            }
        }
        String decryptString = new String(decryptMsg);
        return decryptString;
    }


    public abstract String getData();

    /**
     * Overloaded abstract getData
     */

    public abstract String getData(String key);
    }

    /**
     * The protected method to take a string and encrypt it. It outputs the encrypted string
     *
     *
     */


