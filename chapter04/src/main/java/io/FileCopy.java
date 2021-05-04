package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {

	public static void main(String[] args) {
		InputStream is=null;
		OutputStream os =null;
		
		try {
		is=new FileInputStream("다운로드.jpg");
		os=new FileOutputStream("다운로드.copy.jpg");
		
		int data=-1;
		while((is.read()) != -1) {
			os.write(data);
		}
		
		} catch (FileNotFoundException e) {
			System.out.println("file not found:"+e);
		}catch(IOException e) {
			System.out.println("error"+e);
		}finally {
			try {
				if(os !=null) {
					os.close();
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
