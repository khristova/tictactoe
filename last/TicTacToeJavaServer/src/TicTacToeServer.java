import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TicTacToeServer {

	public static void main(String[] args) throws Exception {
		
			String clientSentence;          
			String capitalizedSentence;     
			
			try {
				ServerSocket welcomeSocket = new ServerSocket(1234);         
			
				while(true) {
					Socket connectionSocket = welcomeSocket.accept();  
					
					BufferedReader inFromClient = new BufferedReader
							(new InputStreamReader(connectionSocket.getInputStream()));       
					
					DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());      
					clientSentence = inFromClient.readLine();          
					
					System.out.println("Received: " + clientSentence);     
					
					outToClient.writeBytes(clientSentence);  
					connectionSocket.close();
				}
			
			} catch(IOException e) {
				System.err.println("Could not listen on port: 8080.");
	            System.exit(1);
			}
	}
}
