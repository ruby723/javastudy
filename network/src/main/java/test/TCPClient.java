package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TCPClient {

	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 5000;
	
	public static void main(String[] args) {
		Socket socket=null;
		
		try {
			// 1. 소켓 생성
			socket = new Socket();

			// 1-1. 소켓버퍼사이즈 확인
			int receiveBufferSize = socket.getReceiveBufferSize();
			int sendBufferSize=socket.getSendBufferSize();
			System.out.println("[client]"+receiveBufferSize+":"+sendBufferSize);
			
			// 1-2. 소켓 버퍼사이즈 변경
			socket.setReceiveBufferSize(1024*10);
			socket.setSendBufferSize(1024*10);
			receiveBufferSize=socket.getSendBufferSize();
			System.out.println("[client]"+receiveBufferSize);
			
			// 1-3.  SO_NODELAY(Nagle Algorithm off)
			socket.setTcpNoDelay(true); // 파일을 더 빨리 보내고싶을때 사용
			
			// 1-4. SO_TIMEOUT
			socket.setSoTimeout(10);//데이터받기를 대기중인 소켓이 일정시간이상 데이터를 못받으면 타임아웃
			//catch(SocketTimeout으로 예외처리)
			
			// 2. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP,SERVER_PORT));
			System.out.println("[client] connected");
			
			// 3. IO Stream 받아오기
			InputStream is=socket.getInputStream();
			OutputStream os=socket.getOutputStream();
			
			// 4. 쓰기
			String data="Hello world\n";
			os.write(data.getBytes("utf-8"));
			
			// 5. 읽기
			byte[] buffer = new byte[255];
			int readByteCount = is.read(buffer); // blocking
			if(readByteCount == -1) {
				System.out.println("[client] closed by server");
				return;
			}
			
			data=new String(buffer,0,readByteCount,"utf-8");
			System.out.println("[client] received:"+data);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(socket != null && socket.isClosed()==false) {
					socket.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
