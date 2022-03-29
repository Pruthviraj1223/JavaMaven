
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Serversocket {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serversocket = new ServerSocket(6666);
        System.out.println("accepting...");
        Socket s = serversocket.accept();
        System.out.println("accepted");


        InputStream inputStream = new DataInputStream(s.getInputStream());

        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(inputStream.readAllBytes()));

        Map<Integer, String> data2 = (Map<Integer, String>) objectInputStream.readObject();
        System.out.println("data = " + data2.toString());

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("pruthvi","JAdeja");
        hashMap.put("jsj","jdsj");

        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(hashMap);
        out.flush();

        DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());
        dataOutputStream.write(byteOut.toByteArray());
        dataOutputStream.flush();



    }
}