package com.company.oop;

import netscape.javascript.JSObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Scanner;

public class Serversocket {


    public static void main(String[] args) throws IOException {
        ServerSocket serversocket= new ServerSocket(6666);
        System.out.println("accepting...");
        Socket s = serversocket.accept();
        System.out.println("accepted");

        InputStreamReader inputStreamReader = new InputStreamReader(s.getInputStream());
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(s.getOutputStream());

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);




        while (true) {
            Scanner scanner = new Scanner(System.in);
            bufferedWriter.write(scanner.nextLine());
            bufferedWriter.newLine();
            bufferedWriter.flush();

            String output = bufferedReader.readLine();

            System.out.println("client = " );
        }


    }
}
