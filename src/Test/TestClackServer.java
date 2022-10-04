package Test;

import Main.ClackServer;

public class TestClackServer {
    public static void main(String[] args) {
        ClackServer firstserver = new ClackServer();
        ClackServer secondserver = new ClackServer(7000);

        System.out.println(secondserver.getPort());
        System.out.println(firstserver.getPort());
        System.out.println(firstserver.hashCode());

        if(firstserver.equals(secondserver)){
            System.out.println("The servers are the same");
        }
        else{
            System.out.println("The servers are not the same");
        }

        System.out.println(firstserver.toString());


    }
}