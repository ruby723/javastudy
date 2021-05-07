package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	private static final int CPORT=ChatServer.PORT;

	public static void main(String[] args) {
		Scanner scanner= null;
		Socket socket=null;
		PrintWriter pw=null;
		
		try {
			// 1. 키보드 연결
			scanner=new Scanner(System.in);
			// 2. socket 연결
			socket=new Socket();
			
			// 3. 연결
			socket.connect(new InetSocketAddress("localhost",CPORT));
			ChatServer.log("connected");
			
			// 4. reader/writer 생성
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			pw=new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true);
			
			// 5. join 프로토콜
			System.out.println("닉네임 >> ");
			String nickname=scanner.nextLine();
			pw.println("join:"+nickname);
			String ack=br.readLine();
			if("join:doll".equals(ack)) {
				System.out.println("입장했습니다. 즐거운 채팅 되세요.");
			}
			
			// 6. ChatClientReciveThread 시작
			new ChatClientThread(socket).run();
			
			// 7. 키보드 입력처리
			while(true) {
				System.out.println(" >> ");
				if(scanner.hasNextLine()==false) {
					continue;
				}
				
				String input=scanner.nextLine();
				//new ChatClientThread(socket).run();
				
				if("quit".equals(input)==true) {
					// 8. quit 프로토콜 처리
					pw.println("QUIT");
					break;
				}
				if("".equals(input)==false) {
					pw.println("message:"+input);
				}
			}
		}catch(IOException ex) {
			ChatServer.log("errer:"+ex);
		}finally {
			// 10. 자원정리
			try {
				scanner.close();
				if(socket==null && socket.isClosed()==false) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
	}
}
