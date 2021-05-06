package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

	public static final int PORT = 8088;

	private static void main(String [] args) {
		
		try {
			List<Writer> listWriters=new ArrayList<Writer>();
			
			// 1. 서버소켓 생성
			ServerSocket serverSocket = new ServerSocket();
			
			// 2. 바인딩
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(hostAddress,PORT));
			log("연결 기다림"+hostAddress+":"+PORT);
			
			// 3. 요청대기
			while(true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket).start();
			}
	}catch(IOException e) {
		System.out.println("error : "+e);
	}

	public static void log(String string) {
		System.out.print(string+"\r\n");
	}
}
