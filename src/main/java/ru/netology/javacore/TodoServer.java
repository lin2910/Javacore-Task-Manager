package ru.netology.javacore;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    private int port;
    private Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {

        System.out.println("Starting server at " + port + "...");
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            while (true) {
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                ) {
                    String inputJsonTask = in.readLine();

                    JsonObject root = JsonParser.parseString(inputJsonTask).getAsJsonObject();

                    String type = root.get("type").toString().replaceAll("\"", "");
                    String task = root.get("task").toString().replaceAll("\"", "");

                    switch (type) {
                        case "ADD":
                            todos.addTask(task);
                            break;
                        case "REMOVE":
                            todos.removeTask(task);
                            break;
                    }
                    System.out.println(todos.getAllTasks());
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}
