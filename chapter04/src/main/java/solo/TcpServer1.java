package solo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer1{
	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		
		try {
			serverSocket=new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost",4000));
			
			while(true) {
				System.out.println("연결기다림");
				Socket socket=serverSocket.accept();
				InetSocketAddress inetSocketAddress=(InetSocketAddress)socket.getRemoteSocketAddress();//?????
				
				System.out.println("연결 수락함"+inetSocketAddress.getHostName());
				
			}
			
		}catch(IOException e) {
			System.out.println("오류");
		}finally {
			if(serverSocket !=null && serverSocket.isClosed()==false) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}