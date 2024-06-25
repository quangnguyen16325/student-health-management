package com.mycompany.network;

import com.mycompany.ui.InformationSystemForUser;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class Client {
    private Socket socket;
    private boolean connected;
    private String roomName;
    private InformationSystemForUser informationSystemForUser;
    private ObjectOutputStream outputStream;
    private BufferedReader reader;
    private ObjectInputStream inputStream;

    public Client(Socket socket) {
        this.socket = socket;
        this.connected = false;
        this.informationSystemForUser = informationSystemForUser;

        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connect(String user) {
        try {
            connected = true;
            System.out.println(user + " Connected to server");
            outputStream.writeObject(user);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (socket != null) {
                socket.close();
            }
            connected = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String receiveMessage() {
        try {
            return (String) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isConnected() {
        return connected;
    }

    public void sendMessage(String message) throws IOException {
        outputStream.writeObject(message);
        outputStream.flush();
    }

    public void start(String user) {
        new Thread(() -> {
            connect(user);
            while (connected) {
                try {
                    System.out.println(user + " still connected to the server");
                    // Đọc tin nhắn từ server
                    String message = "User: " + user + " " + receiveMessage();

                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(informationSystemForUser, message);
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
