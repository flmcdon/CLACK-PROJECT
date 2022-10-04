package Test;

import Main.ClackClient;

public class TestClackClient {
    public static void main(String[] args) {
        ClackClient defaultclient = new ClackClient();
        ClackClient firstclient = new ClackClient("Username", "hostname", 1);
        ClackClient secondclient = new ClackClient("username");
        ClackClient thirdclient = new ClackClient("username", "hostname");
        ClackClient fourthclient = new ClackClient("Username", "hostname", 1);

         System.out.println(firstclient.getUserName());
         System.out.println(firstclient.getHostName());
         System.out.println(firstclient.getPort());
         System.out.println(firstclient.hashCode());

         if(firstclient.equals(fourthclient)){
             System.out.println("The clients are the same");
         }
         else{
             System.out.println("The clients are not the same");
         }

         System.out.println(firstclient.toString());

    }
}
