
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class socket {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        Socket socket = new Socket("localhost",6666);
        System.out.println("sending");


        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);


        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("pruthvi","JAdeja");
        hashMap.put("jsj","jdsj");

        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(hashMap);
        out.flush();
        out.close();


        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.write(byteOut.toByteArray());
        dataOutputStream.flush();
        dataOutputStream.close();


        InputStream inputStream = new DataInputStream(socket.getInputStream());

        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(inputStream.readAllBytes()));

        Map<Integer, String> data2 = (Map<Integer, String>) objectInputStream.readObject();
        System.out.println("data = " + data2.toString());

        }
}
