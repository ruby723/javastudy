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
		Scanner scanner =null;
		Socket socket=null;
		PrintWriter printWriter=null;
		
		try {
			// 1. 키보드 연결
			scanner=new Scanner(System.in);
			
			// 2. socket 연결
			socket=new Socket();
			
			// 3. 연결
			socket.connect(new InetSocketAddress("0.0.0.0",CPORT));
			
			// 4. reader/writer 생성
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			PrintWriter pw=new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true);
			
			// 5. join 프로토콜
			System.out.println("닉네임 >> ");
			String nickname=scanner.nextLine();
			printWriter.println("join : "+nickname);
			printWriter.flush();
			
			String line=br.readLine();
			
			// 6. ChatClientReciveThread 시작
			
			// 7. 키보드 입력처리
			while(true) {
				System.out.println(" >> ");
				String input=scanner.nextLine();
				
				if("quit".equals(input)==true) {
					// 8. quit 프로토콜 처리
					break;
				}else {
					// 9. 메세지 처리
				}
			}
		}catch(IOException ex) {
			log("errer:"+ex);
		}finally {
			// 10. 자원정리
			scanner.close();
			
		}
	}
	
	private BufferedReader bufferedReader;
	
	@Override
	public void run() {
		//reader를 통해 읽은 데이터를 콘솔에 출력하기(message처리)
	}

}
