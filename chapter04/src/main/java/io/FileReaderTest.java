package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class FileReaderTest {

	public static void main(String[] args) {
		Reader in=null;
		InputStream is=null;

		try {
			new FileReader("1234.txt");
			int data=-1;
			int count=0;
			
			while((data=in.read())!= -1) {
				System.out.println((char)data);
				count++;
			}
			
			System.out.println("");
			System.out.println("count:"+count);
			
			is=new FileInputStream("1234.txt");
			while((data=in.read())!= -1) {
				System.out.println((char)data);
				count++;
			}
			
		}catch(FileNotFoundException e) {
			System.out.println("file not found:" +e);
		}catch(IOException e){
			System.out.println("error:"+e);
		}finally {
			try {
				if(in !=null) {
					in.close();
				}
				if(is!=null) {
					is.close();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
