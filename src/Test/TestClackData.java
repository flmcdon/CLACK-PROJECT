package Test;

import Data.FileClackData;
import Data.MessageClackData;
import Data.ClackData;

public class TestClackData {
    public static void main (String[] args) {
        MessageClackData messagecd = new MessageClackData("username", "message", 0);
        MessageClackData defaultmessage = new MessageClackData();
        FileClackData filecd = new FileClackData("username", "filename", 0);
        FileClackData defaultfile = new FileClackData();
        messagecd.getData();
        if(messagecd.equals("message2")){
            System.out.println("The messages are equal");
        }
        else {
            System.out.println("The messages are not equal");
        }

        System.out.println(messagecd.toString());
        //System.out.println(defaultmessage);

        System.out.println();

        filecd.getData();

        filecd.setFileName("notfilename");
        System.out.println(filecd.getFileName());


        if(filecd.equals("notfilename")){
            System.out.println("The filename are the same");
        }
        else{
            System.out.println("The filenames are not the same");
        }

        System.out.println(filecd.toString());



    }
}
