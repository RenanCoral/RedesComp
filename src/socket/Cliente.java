package socket;

import java.io.*;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) throws IOException {
        
		String newMessage;
		
        Socket socket = new Socket("127.0.0.1", 12345);
        
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        output.writeUTF("FrasE qUE volTArA EM MaiUSCUlo"); 

        DataInputStream input = new DataInputStream(socket.getInputStream());
        newMessage = input.readUTF();
        System.out.println(newMessage);

        input.close();
        output.close();
        socket.close();
    }
}