package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import echo.EchoServer;

public class ChatServerThread extends Thread {
	
	private String nickname;
	private Socket socket;
	List<PrintWriter> listWriters;
	
	public ChatServerThread(Socket socket, List<PrintWriter> listWriters) {
		this.socket=socket;
		this.listWriters=listWriters;
	}
	BufferedReader bufferedReader=null;
	PrintWriter printWriter=null;
	
	@Override
	public void run() {
		List<PrintWriter> listWriters=new ArrayList<PrintWriter>();
		
		// 1. Remote Host Information
		InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
		
		String remoteHostAddress=inetRemoteSocketAddress.getAddress().getHostAddress();
		int remoteHostPort=inetRemoteSocketAddress.getPort();
		ChatServer.log("connected by client["+remoteHostAddress+":"+remoteHostPort+"]");
		
		// 2. 스트림 열기
		try {
			bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));
			printWriter =  new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8),true);
			
			// 3. 요청처리
			while(true) {
				String request=bufferedReader.readLine();
				if(request==null) {
					ChatServer.log("클라이언트로부터 연결 끊김");
					doQuit(printWriter);
					break;
				}

				// 4. 프로토콜 분석
				String[] tokens=request.split(":");
				
				if("join".equals(tokens[0])) {
					doJoin(tokens[1],printWriter);
				}else if("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				}else if("quit".equals(tokens[0])){
					doQuit(printWriter);
					break;
				}else {
					ChatServer.log("에러: 알 수 없는 요청("+tokens[0]+")");
				}
				
				super.run();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void broadcast(String data) {
		synchronized(listWriters) {
			
			for(PrintWriter printWriter:listWriters) {
				printWriter.println(data);
			}
		}
	}
	
	private void doQuit(PrintWriter printWriter) {
		removeWriter(printWriter);
		
		String data=nickname+"님이 퇴장하였습니다.";
		broadcast(data);
	}
	
	private void removeWriter(PrintWriter printWriter) {
		synchronized(listWriters) {
			listWriters.remove(printWriter);
		}
	}
	
	private void doMessage(String string) {
		String message=string;
		broadcast(nickname+" : "+message);
	}
	
	private void doJoin(String nickName, PrintWriter printWriter) {
		this.nickname=nickName;
		
		String data=nickName + "님이 참여하였습니다.";
		broadcast(data);
		
		// writer pool에 저장
		addWriter(printWriter);
		
		//ack
		printWriter.println("join:ok");
	}
	
	private void addWriter(PrintWriter printWriter) {
		synchronized(listWriters) {
			listWriters.add(printWriter);
		}
	}
}
