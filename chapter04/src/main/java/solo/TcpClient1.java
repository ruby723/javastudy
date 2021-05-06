package solo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TcpClient1 {

	public static void main(String[] args) {
Socket socket=null;
		
		try {
			socket=new Socket();
			System.out.println("[연결요청]");
			socket.connect(new InetSocketAddress("localhost",4000));
			System.out.println("[연결성공]");
		}catch(Exception e) {
			System.out.println("오류");
		}finally {
			if(socket != null && socket.isClosed()==false) {
				try{
					socket.close();
				}catch(IOException e) {
					System.out.println("ioexcpetiod");
				}
			}
		}
	}

}
