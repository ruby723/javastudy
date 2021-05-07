package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class ChatClientThread extends Thread {
	
	private Socket socket=null;
	private BufferedReader br=null;
	public ChatClientThread(Socket socket) {
		this.socket=socket;
	}
	
	@Override
	public void run() {
		try {
			br=new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));

			while(true) {
				String line=br.readLine();
				if(line==null) {
					break;
				}
				System.out.println(line);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(socket==null && socket.isClosed()==false) {
					socket.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		super.run();
	}
	
}
