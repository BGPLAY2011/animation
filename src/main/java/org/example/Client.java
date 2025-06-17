package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_ADDRESS = "local_host";
    private static final int PORT = 12345;
    public static void main(String[] args){
        try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
//            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in)){
            System.out.println("Пiдключено до сервера " + SERVER_ADDRESS + ":" + PORT);
//            System.out.println("Введіть повідомлення для сервера (або 'exit' для виходу):");
//            String userInput;
//            while (true) {
//                System.out.print("Bи: ");
//                userInput = scanner.nextLine();
//                out.println(userInput);
//                if (userInput.equalsIgnoreCase("exit")) {
//                System.out.println("Надіслано 'exit'. Завершення клієнта.");
//                break;
//                }
//                String serverResponse = in.readLine();
//                if (serverResponse != null) {
//                    System.out.println("Cepвep: " + serverResponse);
//                }else{
//                    System.out.println("Сервер закрив з'єднання.");
//                    break;
//                }
//            }

        } catch (IOException e) {
            System.err.println("Помилка клієнта: " + e.getMessage());
        }
    }
}
