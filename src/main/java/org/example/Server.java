package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    private static final int PORT = 12345;
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket (PORT)) {
            System.out.println("Сервер запущено. Очікування на з'єднання на порту " + PORT + "...");
            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("Клієнт підключився: " + clientSocket.getInetAddress());
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Отримано від клієнта: " + clientMessage);
                    if (clientMessage.equalsIgnoreCase("exit")) {
                        System.out.println("Клієнт надіслав 'exit'. Завершення з'єднання.");
                        break;
                    }
                    out.println("Сервер отримав: " + clientMessage);
                }
            } catch (IOException e) {
                System.err.println("Помилка при роботі з клієнтським сокетом: " + e.getMessage());
            }
        }catch (IOException e){
            System.err.println("Не вдалося запустити сервер на порту " + PORT + ":" + e.getMessage());
        }
    }
}