package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ChatServerThread extends Thread {
	
	private String nickname;
	private Socket socket;
	List<Writer> listWriters;
	
	public  ChatServerThread(Socket socket) {
		this.socket=socket;
	}
	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket=socket;
		this.listWriters=listWriters;
	}
	BufferedReader bufferedReader=null;
	PrintWriter printWriter=null;
	
	@Override
	public void run() {
		// 1. Remote Host Information
		
		
		// 2. 스트림 열기
		
		 bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));
		printWriter =  new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8),true);
		
		// 3. 요청처리
		while(true) {
			String request=bufferedReader.readLine();
			if(request==null) {
				log("클라이언트로부터 연결 끊김");
				break;
			}
			
			// 4. 프로토콜 분석
			String[] tokens=request.split(":");
			
			if("join".equals(tokens[0])) {
				doJoin(tokens[1],printWriter);
			}else if("message".equals(tokens[0])) {
				doMessage(tokens[1]);
			}else if("quit".equals(tokens[0])){
				doQuit();
			}else {
				ChatServer.log("에러: 알 수 없는 요청("+tokens[0]+")");
			}
			
			super.run();
			
			if(request == null) {
				ChatServer.log("클라이언트로부터 연결 끊김");
				doQuit(printWriter);
				break;
			}
		}
	}
	
	private void log(String string) {
		System.out.println(string+"\r\n");
	}
	private void broadcast(String data) {
		synchronized(listWriters) {
			
			for(Writer writer:listWriters) {
				PrintWriter printWriter=(PrintWriter)writer;
				printWriter.println(data);
				printWriter.flush();
			}
		}
	}
	
	private void doQuit() {
		Writer writer=
		removeWriter(writer);
		
		String data=nickname+"님이 퇴장하였습니다.";
		broadcast(data);
	}
	
	private void removeWriter(Writer writer) {
		synchronized(listWriters) {
			listWriters.remove(writer);
		}
	}
	
	private void doMessage(String string) {
		String message=string;
		broadcast(nickname+" : "+message);
	}
	
	private void doJoin(String nickName, Writer writer) {
		this.nickname=nickName;
		
		String data=nickName + "님이 참여하였습니다.";
		broadcast(data);
		
		// writer pool에 저장
		addWriter(writer);
		
		//ack
		printWriter.println("join:ok");
		printWriter.flush();
	}
	
	private void addWriter(Writer writer) {
		synchronized(listWriters) {
			listWriters.add(writer);
		}
	}
}
