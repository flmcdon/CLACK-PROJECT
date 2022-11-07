package Test;

import Data.FileClackData;
import Data.MessageClackData;
import Data.ClackData;

import java.io.IOException;

public class TestClackData {
    public static void main(String[] args) {
        //The key got encryption and decryption
        final String key = "clack";

        // MessageClackData (all three constructors)
        MessageClackData messageClackData1 = new MessageClackData();
        MessageClackData messageClackData2 = new MessageClackData("testUser1", "testMessage", ClackData.CONSTANT_SENDMESSAGE);
        MessageClackData messageClackData3 = new MessageClackData("testUser3","Hello World", "clack", ClackData.CONSTANT_SENDFILE);

        // FileClackData (both constructors)
        FileClackData fileClackData1 = new FileClackData();
        FileClackData fileClackData2 = new FileClackData("testUser2", "filename0", ClackData.CONSTANT_SENDFILE);

        // encrypt
        //messageClackData1.encrypt("Hello World", "clack");

        //decrypt
        MessageClackData messageClackData4 = new MessageClackData("testUser3","Hello World", "clack", ClackData.CONSTANT_SENDFILE);
        System.out.println(messageClackData4.getData("clack"));



        // getType()
        System.out.println("messageClackData1 getType(): " + messageClackData1.getType());
        System.out.println("messageClackData2 getType(): " + messageClackData2.getType());
        System.out.println("messageClackData3 getType(): " + messageClackData3.getType());
        System.out.println("fileClackData1 getType(): " + fileClackData1.getType());
        System.out.println("fileClackData2 getType(): " + fileClackData2.getType());
        System.out.println();

        // getUserName()
        System.out.println("messageClackData1 getUserName(): " + messageClackData1.getUserName());
        System.out.println("messageClackData2 getUserName(): " + messageClackData2.getUserName());
        System.out.println("messageClackData3 getUserName(): " + messageClackData3.getUserName());
        System.out.println("fileClackData1 getUserName(): " + fileClackData1.getUserName());
        System.out.println("fileClackData2 getUserName(): " + fileClackData2.getUserName());
        System.out.println();

        // getDate()
        System.out.println("messageClackData1 getDate(): " + messageClackData1.getDate());
        System.out.println("messageClackData2 getDate(): " + messageClackData2.getDate());
        System.out.println("messageClackData3 getType(): " + messageClackData3.getDate());
        System.out.println("fileClackData1 getDate(): " + fileClackData1.getDate());
        System.out.println("fileClackData2 getDate(): " + fileClackData2.getDate());
        System.out.println();

        // getData()
        System.out.println("messageClackData1 getData(): " + messageClackData1.getData());
        System.out.println("messageClackData2 getData(): " + messageClackData2.getData());
        System.out.println("messageClackData3 getData(): " + messageClackData3.getData());
        System.out.println("fileClackData1 getData(): " + fileClackData1.getData());
        System.out.println("fileClackData2 getData(): " + fileClackData2.getData());
        System.out.println();

        //getData(String key)
        System.out.println("messageClackData3 getData(key): " + messageClackData3.getData("clack")); // need to reference key here
        System.out.println("fileClackData1 getData(key): " + fileClackData1.getData("clack"));            //double check with TA
        System.out.println("fileClackData2 getData(key): " + fileClackData2.getData("clack"));

        //readFileContents
        try {
            System.out.println("fileClackData1 readFileContents():");
            fileClackData1.setFileName("Part2_document.txt");
            System.out.println("Reading from the file: " + fileClackData1.getFileName());
            fileClackData1.readFileContents();
            System.out.println("fileClackData1 getData(): " + fileClackData1.getData());
            System.out.println();

            System.out.println("fileClackData2 readFileContents():");
            fileClackData2.setFileName("wrong_file");
            System.out.println("Error should be printed out when reading from the file: "
                    + fileClackData2.getFileName());
            fileClackData2.readFileContents();
            System.out.println();

        } catch (Exception ioe) {
            System.err.println("Exception should not be thrown.");
        }

        //readFileContents(String Key)
        try {
            System.out.println("fileClackData1 readFileContents(key):");
            System.out.println("Using the key: " + key);
            fileClackData1.setFileName("Part2_document.txt");
            System.out.println("Reading from the file: " + fileClackData1.getFileName());
            fileClackData1.readFileContents(key);
            System.out.println("fileClackData1 getData(): " + fileClackData1.getData());
            System.out.println("fileClackData1 getData(key): " + fileClackData1.getData(key));
            System.out.println();

            System.out.println("fileClackData2 readFileContents(key):");
            System.out.println("Using the key: " + key);
            fileClackData2.setFileName("wrong_file");
            System.out.println("Error should be printed out when reading from the file: "
                    + fileClackData2.getFileName());
            fileClackData2.readFileContents(key);
            System.out.println();

        } catch (Exception ioe) {
            System.err.println("Exception should not be thrown.");
        }

        //writeFileContents
        System.out.println("fileClackData1 writeFileContents():");
        fileClackData1.setFileName("test_file_write.txt");
        System.out.println("Writing to the file: " + fileClackData1.getFileName());
        fileClackData1.writeFileContents();
        System.out.println();

        System.out.println("fileClackData2 writeFileContents():");
        fileClackData2.setFileName("./wrong_path/wrong_file");
        System.out.println("Error should be printed out when writing to the file: "
                + fileClackData2.getFileName());
        fileClackData2.writeFileContents();
        System.out.println();

        //writeFileContents(String key)
        System.out.println("fileClackData1 writeFileContents() for encrypted file contents:");
        fileClackData1.setFileName("test_file_write_encrypted.txt");
        System.out.println("Writing to the file: " + fileClackData1.getFileName());
        fileClackData1.writeFileContents();
        System.out.println();

        System.out.println("fileClackData1 writeFileContents(key) for encrypted file contents:");
        System.out.println("Using the key: " + key);
        fileClackData1.setFileName("test_file_write_decrypted.txt");
        System.out.println("Writing to the file: " + fileClackData1.getFileName());
        fileClackData1.writeFileContents(key);
        System.out.println();

        System.out.println("fileClackData2 writeFileContents(key):");
        System.out.println("Using the key: " + key);
        fileClackData2.setFileName("./wrong_path/wrong_file");
        System.out.println("Error should be printed out when writing to the file: "
                + fileClackData2.getFileName());
        fileClackData2.writeFileContents(key);

        // hashCode()
        System.out.println("messageClackData1 hashCode(): " + messageClackData1.hashCode());
        System.out.println("messageClackData2 hashCode(): " + messageClackData2.hashCode());
        System.out.println("messageClackData3 hashCode(): " + messageClackData3.hashCode());
        System.out.println("fileClackData1 hashCode(): " + fileClackData1.hashCode());
        System.out.println("fileClackData2 hashCode(): " + fileClackData2.hashCode());
        System.out.println();

        // equals()
        System.out.println("messageClackData1 equals null: "
                + messageClackData1.equals(null));
        System.out.println("messageClackData1 equals messageClackData1: "
                + messageClackData1.equals(messageClackData1));
        System.out.println("messageClackData1 equals messageClackData2: "
                + messageClackData1.equals(messageClackData2));
        System.out.println("messageClackData2 equals messageClackData1: "
                + messageClackData2.equals(messageClackData1));
        System.out.println("messageClackData1 equals fileClackData1: "
                + messageClackData1.equals(fileClackData1));
        System.out.println("messageClackData3 equals messageClackData1: " + messageClackData3.equals(messageClackData1));
        System.out.println("messageClackData3 equals messageClackData2: " + messageClackData3.equals(messageClackData2));
        System.out.println("messageClackData3 equals null: " + messageClackData3.equals(null));


        System.out.println("fileClackData1 equals null: "
                + fileClackData1.equals(null));
        System.out.println("fileClackData1 equals fileClackData1: "
                + fileClackData1.equals(fileClackData1));
        System.out.println("fileClackData1 equals fileClackData2: "
                + fileClackData1.equals(fileClackData2));
        System.out.println("fileClackData2 equals fileClackData1: "
                + fileClackData2.equals(fileClackData1));
        System.out.println("fileClackData1 equals messageClackData1: "
                + fileClackData1.equals(messageClackData1));
        System.out.println();

        // toString()
        System.out.println("messageClackData1:\n" + messageClackData1);
        System.out.println("messageClackData2:\n" + messageClackData2);
        System.out.println("messageClackData3:\n" + messageClackData3);
        System.out.println("fileClackData1:\n" + fileClackData1);
        System.out.println("fileClackData2:\n" + fileClackData2);
        System.out.println();

        // getFileName
        System.out.println("fileClackData1 getFileName(): " + fileClackData1.getFileName());
        System.out.println("fileClackData2 getFileName(): " + fileClackData2.getFileName());
        System.out.println();

        // setFileName
        String filename1 = "filename1";
        System.out.println("Sets the filename of fileClackData1 to be " + filename1);
        fileClackData1.setFileName(filename1);
        System.out.println("fileClackData1 getFileName(): " + fileClackData1.getFileName());
        System.out.println("fileClackData1 hashCode(): " + fileClackData1.hashCode());
        System.out.println("fileClackData1 equals fileClackData1: " + fileClackData1.equals(fileClackData1));
        System.out.println("fileClackData1 equals fileClackData2: " + fileClackData1.equals(fileClackData2));
        System.out.println("fileClackData1:\n" + fileClackData1);
        System.out.println();

        String filename2 = "filename2";
        System.out.println("Sets the filename of fileClackData2 to be " + filename2);
        fileClackData2.setFileName(filename2);
        System.out.println("fileClackData2 getFileName(): " + fileClackData2.getFileName());
        System.out.println("fileClackData2 hashCode(): " + fileClackData2.hashCode());
        System.out.println("fileClackData2 equals fileClackData2: " + fileClackData2.equals(fileClackData2));
        System.out.println("fileClackData2 equals fileClackData1: " + fileClackData2.equals(fileClackData1));
        System.out.println("fileClackData2:\n" + fileClackData2);
    }
}



