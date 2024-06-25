package com.mycompany.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerSocketThread extends Thread {
    private Socket socket;

    public ServerSocketThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Đọc dữ liệu từ client
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = input.readLine(); // Đọc yêu cầu từ client
            String userEmail = input.readLine(); // Đọc email từ client
            System.out.println("Received request from client: " + request);
            System.out.println("User email: " + userEmail);

            // Xử lý yêu cầu và chuyển đến class khác để điều khiển
            if (request.startsWith("Update request from user")) {
                // Gọi class hoặc phương thức để xử lý yêu cầu
                handleUpdateRequest(userEmail);
            }

            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            output.println("Request processed successfully.");

            socket.close();
            System.out.println("Disconnected from client.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleUpdateRequest(String userEmail) {
        // Điều khiển yêu cầu và xử lý dữ liệu dựa trên userEmail
        // Ví dụ: gọi class hoặc phương thức để xử lý yêu cầu cập nhật
        UpdateHandler updateHandler = new UpdateHandler();
        updateHandler.processUpdateRequest(userEmail);
    }
    
    public class UpdateHandler {
    public void processUpdateRequest(String userEmail) {
        System.out.println("Processing update request for user email: " + userEmail);
    }
}
}
