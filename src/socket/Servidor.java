package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
		
		String newMessage;
		String message;
		
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Porta 12345 foi aberta!\nServidor esperando contato...");
        
        Socket socket = serverSocket.accept();
        System.out.println("Cliente " + socket.getInetAddress().getHostAddress() + " conectado");

        DataInputStream input = new DataInputStream(socket.getInputStream());
        message = input.readUTF();
        newMessage = message.toUpperCase();

        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        output.writeUTF(newMessage); 

        input.close();
        output.close();
        socket.close();
        serverSocket.close();
    }
}