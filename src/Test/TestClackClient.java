package Test;
import Main.ClackClient;

/**
 * You don't have to have a Javadoc for a test class.
 * You should test all implemented functions in the data classes,
 * whether they are in the superclass or in the subclasses.
 */
public class TestClackClient {
    public static void main(String[] args) {
        // All four constructors of ClackClient
        ClackClient clackClient1 = new ClackClient("testUser1", "hostName1", 12345);
        ClackClient clackClient2 = new ClackClient("testUser2", "hostName2", 7000);
        ClackClient clackClient3 = new ClackClient("testUser3", "localhost", 7000);
        ClackClient clackClient4 = new ClackClient("Anon", "localhost", 7000);
        ClackClient clackClient5 = new ClackClient("testUser2", "hostName2");
        ClackClient clackClient6 = new ClackClient("testUser3", "localhost");
        ClackClient clackClient7 = new ClackClient("Anon", "localhost");
        ClackClient clackClient8 = new ClackClient("testUser3");
        ClackClient clackClient9 = new ClackClient("Anon");
        ClackClient clackClient10 = new ClackClient();
        //ClackClient clackClient11 = new ClackClient(null);
        // Tests IllegalArgumentException thrown as expected from the constructors of ClackClient
        // when the username is null.
        try {
            new ClackClient(null, "hostName", 12345);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException thrown as expected from " +
                    "ClackClient(String userName, String hostName, int port) " +
                    "when the username is null.");
        }
        try {
            new ClackClient(null, "hostName");
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException thrown as expected from " +
                    "ClackClient(String userName, String hostName) " +
                    "when the username is null.");
        }
        try {
            new ClackClient(null);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException thrown as expected from " +
                    "ClackClient(String userName) " +
                    "when the username is null.");
        }
        System.out.println();

        // Tests IllegalArgumentException thrown as expected from the constructors of ClackClient
        // when the host name is null.
        try {
            new ClackClient("Anon", null, 12345);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException thrown as expected from " +
                    "ClackClient(String userName, String hostName, int port) " +
                    "when the host name is null.");
        }
        try {
            new ClackClient("Anon", null);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException thrown as expected from " +
                    "ClackClient(String userName, String hostName) " +
                    "when the host name is null.");
        }
        System.out.println();

        // Tests IllegalArgumentException thrown as expected from the constructors of ClackClient
        // when the port is a number lesser than 1024.
        try {
            new ClackClient("Anon", "localhost", -1);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException thrown as expected from " +
                    "ClackClient(String userName, String hostName, int port) " +
                    "when the port is a negative number.");
        }
        try {
            new ClackClient("Anon", "localhost", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException thrown as expected from " +
                    "ClackClient(String userName, String hostName, int port) " +
                    "when the port is zero.");
        }
        try {
            new ClackClient("Anon", "localhost", 1023);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException thrown as expected from " +
                    "ClackClient(String userName, String hostName, int port) " +
                    "when the port is a positive number lesser than 1024.");
        }
        System.out.println();

        // getUserName()
        System.out.println("clackClient1 getUserName(): " + clackClient1.getUserName());
        System.out.println("clackClient2 getUserName(): " + clackClient2.getUserName());
        System.out.println("clackClient3 getUserName(): " + clackClient3.getUserName());
        System.out.println("clackClient4 getUserName(): " + clackClient4.getUserName());
        System.out.println("clackClient5 getUserName(): " + clackClient5.getUserName());
        System.out.println("clackClient6 getUserName(): " + clackClient6.getUserName());
        System.out.println("clackClient7 getUserName(): " + clackClient7.getUserName());
        System.out.println("clackClient8 getUserName(): " + clackClient8.getUserName());
        System.out.println("clackClient9 getUserName(): " + clackClient9.getUserName());
        System.out.println("clackClient10 getUserName(): " + clackClient10.getUserName());
        //System.out.println("clackClient11 getUserName(): " + clackClient11.getUserName());
        System.out.println();

        // getHostName()
        System.out.println("clackClient1 getHostName(): " + clackClient1.getHostName());
        System.out.println("clackClient2 getHostName(): " + clackClient2.getHostName());
        System.out.println("clackClient3 getHostName(): " + clackClient3.getHostName());
        System.out.println("clackClient4 getHostName(): " + clackClient4.getHostName());
        System.out.println("clackClient5 getHostName(): " + clackClient5.getHostName());
        System.out.println("clackClient6 getHostName(): " + clackClient6.getHostName());
        System.out.println("clackClient7 getHostName(): " + clackClient7.getHostName());
        System.out.println("clackClient8 getHostName(): " + clackClient8.getHostName());
        System.out.println("clackClient9 getHostName(): " + clackClient9.getHostName());
        System.out.println("clackClient10 getHostName(): " + clackClient10.getHostName());
        //System.out.println("clackClient11 getHostName(): " + clackClient11.getHostName());
        System.out.println();

        // getPort()
        System.out.println("clackClient1 getPort(): " + clackClient1.getPort());
        System.out.println("clackClient2 getPort(): " + clackClient2.getPort());
        System.out.println("clackClient3 getPort(): " + clackClient3.getPort());
        System.out.println("clackClient4 getPort(): " + clackClient4.getPort());
        System.out.println("clackClient5 getPort(): " + clackClient5.getPort());
        System.out.println("clackClient6 getPort(): " + clackClient6.getPort());
        System.out.println("clackClient7 getPort(): " + clackClient7.getPort());
        System.out.println("clackClient8 getPort(): " + clackClient8.getPort());
        System.out.println("clackClient9 getPort(): " + clackClient9.getPort());
        System.out.println("clackClient10 getPort(): " + clackClient10.getPort());
        //System.out.println("clackClient11 getPort(): " + clackClient11.getPort());
        System.out.println();

        //readClientData()   ASK TA

//        clackClient1.readClientData();
//        clackClient2.readClientData();
//        clackClient3.readClientData();
//        clackClient4.readClientData();
//        clackClient5.readClientData();
//        clackClient6.readClientData();
//        clackClient7.readClientData();
//        clackClient8.readClientData();
//        clackClient9.readClientData();
//        clackClient10.readClientData();
//        clackClient11.readClientData();

        //printData()
//        clackClient1.printData();
//        clackClient2.printData();
//        clackClient3.printData();
//        clackClient4.printData();
//        clackClient5.printData();
//        clackClient6.printData();
//        clackClient7.printData();
//        clackClient8.printData();
//        clackClient9.printData();
//        clackClient10.printData();
//        clackClient11.printData();

        //start()
        System.out.println("Command-line interaction tests");
        clackClient1.start();

        // hashCode()
        System.out.println("clackClient1 hashCode(): " + clackClient1.hashCode());
        System.out.println("clackClient2 hashCode(): " + clackClient2.hashCode());
        System.out.println("clackClient3 hashCode(): " + clackClient3.hashCode());
        System.out.println("clackClient4 hashCode(): " + clackClient4.hashCode());
        System.out.println("clackClient5 hashCode(): " + clackClient5.hashCode());
        System.out.println("clackClient6 hashCode(): " + clackClient6.hashCode());
        System.out.println("clackClient7 hashCode(): " + clackClient7.hashCode());
        System.out.println("clackClient8 hashCode(): " + clackClient8.hashCode());
        System.out.println("clackClient9 hashCode(): " + clackClient9.hashCode());
        System.out.println("clackClient10 hashCode(): " + clackClient10.hashCode());
        //System.out.println("clackClient11 hashCode(): " + clackClient11.hashCode());
        System.out.println();

        // equals()
        System.out.println("clackServer1 equals null: " + clackClient1.equals(null));
        System.out.println("clackServer1 equals clackServer1: " + clackClient1.equals(clackClient1));
        System.out.println("clackServer1 equals clackServer2: " + clackClient1.equals(clackClient2));
        System.out.println("clackServer1 equals clackServer3: " + clackClient1.equals(clackClient3));
        System.out.println("clackServer1 equals clackServer4: " + clackClient1.equals(clackClient4));
        System.out.println("clackServer1 equals clackServer5: " + clackClient1.equals(clackClient5));
        System.out.println("clackServer1 equals clackServer6: " + clackClient1.equals(clackClient6));
        System.out.println("clackServer1 equals clackServer7: " + clackClient1.equals(clackClient7));
        System.out.println("clackServer1 equals clackServer8: " + clackClient1.equals(clackClient8));
        System.out.println("clackServer1 equals clackServer9: " + clackClient1.equals(clackClient9));
        System.out.println("clackServer1 equals clackServer10: " + clackClient1.equals(clackClient10));
        System.out.println("clackServer2 equals clackServer1: " + clackClient2.equals(clackClient1));
        System.out.println("clackServer5 equals clackServer2: " + clackClient5.equals(clackClient2));
        System.out.println("clackServer5 equals clackServer6: " + clackClient5.equals(clackClient6));
        System.out.println("clackServer6 equals clackServer3: " + clackClient6.equals(clackClient3));
        System.out.println("clackServer7 equals clackServer4: " + clackClient7.equals(clackClient4));
        System.out.println("clackServer8 equals clackServer3: " + clackClient8.equals(clackClient3));
        System.out.println("clackServer8 equals clackServer6: " + clackClient8.equals(clackClient6));
        System.out.println("clackServer8 equals clackServer9: " + clackClient8.equals(clackClient9));
        System.out.println("clackServer9 equals clackServer4: " + clackClient9.equals(clackClient4));
        System.out.println("clackServer9 equals clackServer7: " + clackClient9.equals(clackClient7));
        System.out.println("clackServer10 equals clackServer4: " + clackClient10.equals(clackClient4));
        System.out.println("clackServer10 equals clackServer7: " + clackClient10.equals(clackClient7));
        System.out.println("clackServer10 equals clackServer9: " + clackClient10.equals(clackClient9));
        // System.out.println("clackServer1 equals clackServer11: " + clackClient1.equals(clackClient11));
        // System.out.println("clackServer11 equals clackServer1: " + clackClient11.equals(clackClient1));
        System.out.println();

        // toString()
        System.out.println("clackClient1:\n" + clackClient1);
        System.out.println("clackClient2:\n" + clackClient2);
        System.out.println("clackClient3:\n" + clackClient3);
        System.out.println("clackClient4:\n" + clackClient4);
        System.out.println("clackClient5:\n" + clackClient5);
        System.out.println("clackClient6:\n" + clackClient6);
        System.out.println("clackClient7:\n" + clackClient7);
        System.out.println("clackClient8:\n" + clackClient8);
        System.out.println("clackClient9:\n" + clackClient9);
        System.out.println("clackClient10:\n" + clackClient10);
        System.out.println("clackClient11:\n" + clackClient10);


        clackClient1.start();

    }
}