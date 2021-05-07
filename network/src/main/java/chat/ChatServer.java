package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

	public static final int PORT = 8088;

	public static void main(String [] args) {
		List<PrintWriter> listPrintWriter=new ArrayList<PrintWriter>();
		ServerSocket serverSocket=null;
		
		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();
			
			// 2. 바인딩
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress("0.0.0.0",PORT));
			log("연결 기다림"+hostAddress+":"+PORT);
			
			// 3. 요청대기
			while(true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket,listPrintWriter).start();
			}
		}catch(IOException e) {
			System.out.println("error : "+e);
		}finally {
			try {
				if(serverSocket==null && serverSocket.isClosed()==false) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void log(String string) {
		System.out.print(string+"\r\n");
	}
}
