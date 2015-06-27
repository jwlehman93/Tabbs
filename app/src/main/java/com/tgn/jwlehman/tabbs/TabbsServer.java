package com.tgn.jwlehman.tabbs;

/**
 * Created by jwlehman(Jeremy Lehman), jwlehman@purdue.edu on 6/27/15.
 * Server for Tabbs app to handle usernames/passwords and any data
 */

import java.io.*;
import java.net.*;

public class TabbsServer extends Thread {

    private ServerSocket serverSocket;
    /*
    author: jwlehman, jwlehman@purdue.edu
    param: port where socket will be created
    Desc: constructor that takes a port to create a new server
     */
    public TabbsServer(int port) throws SocketException, IOException{
        serverSocket = new ServerSocket(port);
        System.out.println("Server is bound to port " + port);
        serverSocket.setReuseAddress(true);
    }

    /*
    author: jwlehman, jwlehman@purdue.edu
    param: none
    Desc: constructor that assigns port for new server
     */
    public TabbsServer() throws SocketException, IOException {
        serverSocket = new ServerSocket(0);
        System.out.println("Server is boud to port " + serverSocket.getLocalPort());
        serverSocket.setReuseAddress(true);
    }

    public void run() {
        while(true) {
            try {
                System.out.println("Waiting for client...");
                Socket server = new serverSocket.accept();
                System.out.println("Connected to server " + server.getLocalSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("Welcome to the SafeWalk Server...");
                server.close();
            }
            catch(SocketTimeoutException ste) {
                ste.printStackTrace();
                break;
            }
            catch(IOException ie) {
                ie.printStackTrace();
                break;
            }

        }
    }




}