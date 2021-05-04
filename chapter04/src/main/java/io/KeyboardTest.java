package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class KeyboardTest {

	public static void main(String[] args) {
		BufferedReader br=null;
		/// 1. 기반 스트림(표준입력,stdin,System.in)
		
		// 2. 보조스트림 1 (byte|byte|byte -> char)
		try {
			InputStreamReader isr = new InputStreamReader(System.in,"utf-8");
			
			//3. 보조스트림 2 (char|char|char|\n -> "char1char2char3")
			br = new BufferedReader(isr);
			String line=null;
			
			while((line=br.readLine())!=null) {
				if("quit".equals(line)) {
					break;
				}
			}
			
		}catch(UnsupportedEncodingException e) {
			System.out.println("error:"+e);
		}catch(IOException e) {
			System.out.println("error:"+e);
		}finally {
			try {
				if(br != null) {
				br.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
		}
	}
	}
}
