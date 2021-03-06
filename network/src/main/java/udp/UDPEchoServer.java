package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchoServer {
	public static final int PORT=7000;
	public static final int BUFFER_SIZE	=1024;
	
	public static void main(String[] args) {
		
		DatagramSocket socket=null;
		
		try {
			// 1. 소켓생성
			socket = new DatagramSocket(PORT);
			
			// 2. 데이터 수신
			while(true) {
				DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE],BUFFER_SIZE);
				socket.receive(receivePacket);//blocking
				
				byte[] data=receivePacket.getData();
				int length = receivePacket.getLength();
				String message=new String(new String(data,0,length,"utf-8"));
				
				System.out.println("[server] receive: "+message);
				
				// 3. 데이터 송신
				byte[] sendData = message.getBytes("utf-8");
				DatagramPacket sendPacket=new DatagramPacket(sendData, sendData.length,
						receivePacket.getAddress(),receivePacket.getPort());
				
				socket.send(sendPacket);
			}
			
		} catch (SocketException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			if(socket != null && socket.isClosed() == false) {
				socket.close();
			}
		}
	}

}
